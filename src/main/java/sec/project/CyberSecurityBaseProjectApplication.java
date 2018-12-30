package sec.project;

import database.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;
import sec.project.domain.Signup;

@SpringBootApplication
public class CyberSecurityBaseProjectApplication {

    public static void main(String[] args) throws Throwable//, Exception 
    {
        SpringApplication.run(CyberSecurityBaseProjectApplication.class);

    }

}
