package online.luffyk.studentsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("online.luffyk.studentsystem.dao")
@SpringBootApplication
public class StudentsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentsystemApplication.class, args);
    }

}
