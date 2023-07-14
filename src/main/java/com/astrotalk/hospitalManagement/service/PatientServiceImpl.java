package com.astrotalk.hospitalManagement.service;

import com.astrotalk.hospitalManagement.entity.Expenses;
import com.astrotalk.hospitalManagement.entity.Patient;
import com.astrotalk.hospitalManagement.model.requestDTO.AdmitPatientRequest;
import com.astrotalk.hospitalManagement.model.requestDTO.FetchAllPatientsRequest;
import com.astrotalk.hospitalManagement.model.responseDTO.PatientDetail;
import com.astrotalk.hospitalManagement.model.responseDTO.PatientsList;
import com.astrotalk.hospitalManagement.model.responseDTO.ResponseModel;
import com.astrotalk.hospitalManagement.repository.ExpenseRepository;
import com.astrotalk.hospitalManagement.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.astrotalk.hospitalManagement.constants.Constants.*;

/**
 * The type Patient service.
 */
@Service
@Slf4j
public class PatientServiceImpl implements PatientService {

    /**
     * The Patient repository.
     */
    @Autowired
    PatientRepository patientRepository;

    /**
     * The Expense repository.
     */
    @Autowired
    ExpenseRepository expenseRepository;

    /**
     * The Formatter.
     */
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    @Transactional
    public ResponseModel savePatient(AdmitPatientRequest admitPatientRequest) {
        log.info("Patient name: " + admitPatientRequest.getPatientName() + " Mobile number: " + admitPatientRequest.getMobileNumber());
        LocalDate admissionDate = null;
        if (admitPatientRequest.getAdmissionDate() != null) {
            admissionDate = LocalDate.parse(admitPatientRequest.getAdmissionDate(), formatter);
        } else {
            admissionDate = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        }
        Patient patient = Patient.builder().patientName(admitPatientRequest.getPatientName())
                .mobileNumber(admitPatientRequest.getMobileNumber()).age(admitPatientRequest.getAge())
                .roomNumber(admitPatientRequest.getRoomNumber()).doctorName(admitPatientRequest.getDoctorName())
                .admissionDate(admissionDate).gender(admitPatientRequest.getGender())
                .patientStatus(admitPatientRequest.getPatientStatus()).build();
        if (admitPatientRequest.getExpenses() != null) {
            patient.setExpenses(admitPatientRequest.getExpenses().stream()
                    .map(expenseDetail -> Expenses.builder().amount(expenseDetail.getAmount())
                            .remarks(expenseDetail.getRemarks()).build()).collect(Collectors.toList()));
            patient.getExpenses().forEach(i -> i.setPatient(patient));
        }
        patientRepository.save(patient);
        return ResponseModel.builder().message(DATA_SAVED_SUCCESSFULLY).build();
    }

    @Override
    public PatientsList getPatientsList(FetchAllPatientsRequest fetchAllPatientsRequest) {
        LocalDate dateTime = null;
        if (fetchAllPatientsRequest.getAdmissionDate() != null) {
            dateTime = LocalDate.parse(fetchAllPatientsRequest.getAdmissionDate(), formatter);
        }

        List<Object[]> allPatients = patientRepository.getAllPatients(fetchAllPatientsRequest.getPatientId(), fetchAllPatientsRequest.getPatientName(),
                fetchAllPatientsRequest.getPatientStatus() == null ? PATIENT_ADMITTED : fetchAllPatientsRequest.getPatientStatus(),
                fetchAllPatientsRequest.getMobileNumber(), fetchAllPatientsRequest.getRoomNumber(), dateTime);
        List<PatientDetail> patientDetailList = new ArrayList<>();
        allPatients.forEach(k -> patientDetailList.add(
                PatientDetail.builder().patientId((long) k[0])
                        .patientName((String) k[1])
                        .mobileNumber((long) k[2])
                        .age((int) k[3]).roomNumber((int) k[4])
                        .doctorName((String) k[5])
                        .admissionDate((Date) k[6])
                        .patientStatus((int) k[7])
                        .gender((String) k[8])
                        .build()));
        if (allPatients.isEmpty())
            return PatientsList.builder().patientList(patientDetailList).message(PATIENTS_NOT_FOUND).build();

        return PatientsList.builder().patientList(patientDetailList).message(PATIENTS_FETCHED_SUCCESSFULLY).build();
    }

    @Override
    @Transactional
    public ResponseModel dischargePatient(Long patientId) {
        Long fetchedPatientId = patientRepository.findByPatientId(patientId);
        if (fetchedPatientId == null)
            return ResponseModel.builder().message(DISCHARGE_PROCESS_FAILED).build();
        patientRepository.dischargePatient(patientId, PATIENT_DISCHARGED);
        expenseRepository.clearExpenses(patientId);
        return ResponseModel.builder().message(PATIENT_DISCHARGED_SUCCESSFULLY).build();
    }


}
