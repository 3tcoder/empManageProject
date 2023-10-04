package com.practice.empmanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class EmpManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmpManageApplication.class, args);
    }

}
