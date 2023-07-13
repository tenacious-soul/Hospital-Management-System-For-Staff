# Hospital-Mangaement-System-For-Staff

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


#### API Functioning: 
  If the account already exists with the same email address, an "Account already exists" message is shown to the user. 
   Else, details are saved in the database with the "Account registered successfully" message.

####  For Login Functionality: 
  
API URL: localhost:8080/auth/login
  
####  API Request: (All request params are required)
  
  {
  
    "email": "candy123@gmail.com",
    "password": 12345
    
  }


####  API Response:

  {
  
    "message": "Logged In successfully!"
    
  }


####  API Functioning: 
  
  First, the email address is searched in the database. If it does not match "Email does not exists. SignUp First!" message is returned. 
  Then, the password is matched, if the password does not matches, "Password does not match. Please enter correct password!" message is returned.
  If both email and password are correct, account is searched in database. If the record is found, "Logged In successfully!" message is returned, else 
  "LogIn failed, please try again later!" message is returned.


### **2) Admit new patient.**

API URL: localhost:8080/hospital-management/admitPatient (POST)

####  API Request: 

{
    
    "patient_name": "Christopher",
    "mobile_number": 9007699822,
    "age": 81,
    "room_number": 104,
    "gender": "Male",
    "admission_date": "2023-06-17"
}

####  API Response:

{

    "message": "Data saved successfully"
    
}

####  API Functioning: 
All fields are persisted in the database after the required validations are applied.
