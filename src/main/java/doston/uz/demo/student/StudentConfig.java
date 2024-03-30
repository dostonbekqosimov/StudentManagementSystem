package doston.uz.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student Asal = new Student(
                    "Asal",
                    "asal@com18",
                    LocalDate.of(2000, Month.APRIL, 12));
            Student Sardor = new Student(
                    "Sardor",
                    "sardor@com18",
                    LocalDate.of(2008, Month.JANUARY, 12));

            repository.saveAll(List.of(Asal, Sardor));
        };


    }


}

