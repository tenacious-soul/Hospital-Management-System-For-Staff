package com.astrotalk.hospitalManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class HospitalManagementApplication {
    //http://localhost:8080/h2-console/
    public static void main(String[] args) {
        SpringApplication.run(HospitalManagementApplication.class, args);
    }

}
