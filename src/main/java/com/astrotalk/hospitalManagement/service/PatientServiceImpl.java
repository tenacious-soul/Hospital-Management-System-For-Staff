package com.astrotalk.hospitalManagement.service;

import com.astrotalk.hospitalManagement.entity.Patient;
import com.astrotalk.hospitalManagement.model.requestDTO.AdmitPatientRequest;
import com.astrotalk.hospitalManagement.model.requestDTO.FetchAllPatientsRequest;
import com.astrotalk.hospitalManagement.model.responseDTO.PatientsList;
import com.astrotalk.hospitalManagement.model.responseDTO.ResponseModel;
import com.astrotalk.hospitalManagement.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.astrotalk.hospitalManagement.constants.Constants.*;

@Service
@Slf4j
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
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
                .admissionDate(admissionDate)
                .expenses(admitPatientRequest.getExpenses()).patientStatus(admitPatientRequest.getPatientStatus()).build();

        patientRepository.save(patient);
        return ResponseModel.builder().message(DATA_SAVED_SUCCESSFULLY).build();
    }

    @Override
    public PatientsList getPatientsList(FetchAllPatientsRequest fetchAllPatientsRequest) {
        LocalDate dateTime = null;
        if (fetchAllPatientsRequest.getAdmissionDate() != null) {
            dateTime = LocalDate.parse(fetchAllPatientsRequest.getAdmissionDate(), formatter);
        }

        List<Patient> allPatients = patientRepository.getAllPatients(fetchAllPatientsRequest.getPatientId(), fetchAllPatientsRequest.getPatientName(),
                fetchAllPatientsRequest.getPatientStatus() == null ? PATIENT_ADMITTED : fetchAllPatientsRequest.getPatientStatus(),
                fetchAllPatientsRequest.getMobileNumber(), fetchAllPatientsRequest.getRoomNumber(), dateTime);

        if (allPatients.isEmpty())
            return PatientsList.builder().patientList(allPatients).message(PATIENTS_NOT_FOUND).build();

        return PatientsList.builder().patientList(allPatients).message(PATIENTS_FETCHED_SUCCESSFULLY).build();
    }

    @Override
    public ResponseModel dischargePatient(Long patientId) {
        Integer updateStatus = patientRepository.dischargePatient(patientId, PATIENT_DISCHARGED);

        if (updateStatus == 1)
            return ResponseModel.builder().message(PATIENT_DISCHARGED_SUCCESSFULLY).build();

        return ResponseModel.builder().message(DISCHARGE_PROCESS_FAILED).build();
    }


}
