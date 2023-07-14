# Hospital-Management-System-For-Staff
To run the project, clone the project and import it in some IDE(let's say IntelliJ), set up JDK version 18 or above, and run the project. All API endpoints, requests, etc have been attached. For the database, in-memory database H2 is used. (For local use: http://localhost:8080/h2-console/)

## **Problem Statement:**

Implement a web-app using java spring-boot for Hospital management staff.
Create REST APIs to implement below functionalities:
1. Hospital staff to signup/login into the portal.
2. Admit new patient with at least below details:
a. name, age, room, doctor name, admit date, expenses, status(admitted, discharged)
3. Fetch all patients admitted in hospital.
4. Discharge patient from hospital.

## **Solution:**

### **1) Hospital staff to signup/login into the portal.**
#### **For SignUp Functionality:**
   
API URL: localhost:8080/auth/register (POST)

#### API Functioning: 
  If the account already exists with the same email address, an "Account already exists" message is shown to the user. 
   Else, details are saved in the database with the "Account registered successfully" message.

   
#### API Request: (All request params are required)
   
   {
   
    "employee_name": "Candy",
    "email": "candy123@gmail.com",
    "password": 12345
    
   }


#### API Response:
   
   {
   
    "message": "Account registered successfully"
    
   }


####  For Login Functionality: 
  
API URL: localhost:8080/auth/login

####  API Functioning: 
  
  First, the email address is searched in the database. If it does not match "Email does not exists. SignUp First!" message is returned. 
  Then, the password is matched, if the password does not matches, "Password does not match. Please enter correct password!" message is returned.
  If both email and password are correct, account is searched in database. If the record is found, "Logged In successfully!" message is returned, else 
  "LogIn failed, please try again later!" message is returned.

  
####  API Request: (All request params are required)
  
  {
  
    "email": "candy123@gmail.com",
    "password": 12345
    
  }


####  API Response:

  {
  
    "message": "Logged In successfully!"
    
  }


### **2) Admit new patient.**

API URL: localhost:8080/hospital-management/admitPatient (POST)

####  API Functioning: 
All fields of the request are persisted in the database after the required validations are applied.

####  API Request: (Params are mandatory/optional as per use case; In case of required param if the param is missing/null, 400 status code and an exception is thrown. )

{
    
    "patient_name": "Jacob",
    "mobile_number": 9002299822,
    "age": 100,
    "room_number": 104,
    "gender":"Male",
    "admission_date": "2023-06-17",
    "doctor_name": "Dr Riddhi Sudha",
    "expenses": [{
        "amount": 3000,
        "remarks": "Bed Charges"
    },{
        "amount": 2000,
        "remarks": "Doctor visit charges"
    }]
}

####  API Response:

{

    "message": "Data saved successfully"
    
}

### **3) Fetch all patients admitted in hospital.**
   
API URL: localhost:8080/hospital-management/fetchAllPatients (GET)

####  API Functioning: 
Search Functionality. Patients can be searched on the basis of different fields. 
For ex: patient_id, patient_name (Smart search enabled; User can enter anything and system will match pattern itself), mobile_number, room_number, admission_date. 
If {} is passed in the request, by default all admitted patient lists will be returned. 

#### API Request:

{

    "admission_date" : "2023-06-17"
    
}

####  API Response:

{

    "message": "Patients fetched successfully",
    "patients_list": [
        {
            "age": 68,
            "expenses": 12000,
            "gender": "Female",
            "patient_id": 1,
            "patient_name": "Mary",
            "mobile_number": 9999999990,
            "room_number": 1,
            "doctor_name": "Dr. Mukesh Agrawal",
            "admission_date": "2023-01-05",
            "patient_status": 1
        },
        {
            "age": 98,
            "expenses": 119000,
            "gender": "Male",
            "patient_id": 2,
            "patient_name": "John",
            "mobile_number": 9999999991,
            "room_number": 2,
            "doctor_name": "Dr. Ashok Agrawal",
            "admission_date": "2023-03-27",
            "patient_status": 1
        }
    ]
    
}


### **4) Discharge patient from hospital.**
   
API URL: localhost:8080/hospital-management/dischargePatient (PUT)

####  API Functioning: 
Patients are searched based on patient_id. patient_status = 1 denotes admitted patients, while patient_status = 0 denotes discharged patients. So, Once a patient is fetched its patient_status is updated from 1 to 0 denoting the patient is now discharged. All expenses are also cleared from the expenses table i.e. record is made inactive(record_status = 1 denotes active admission, while 5 denotes inactive record, i.e. patient discharged). All functionality is kind of soft delete from the system.On successful discharge, the "Patient discharged successfully" message is returned otherwise, the "Patient not found/cannot be discharged" message is returned.

#### API Request:

Pass patient_id in request_param. It's a required field.

#### API Response:

{

    "message": "Patient discharged successfully"
}
