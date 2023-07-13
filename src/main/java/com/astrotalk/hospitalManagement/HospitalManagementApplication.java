package com.astrotalk.hospitalManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * The type Hospital management application.
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class HospitalManagementApplication {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(HospitalManagementApplication.class, args);
    }

}
