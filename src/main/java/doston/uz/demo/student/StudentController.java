package doston.uz.demo.student;

import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")

public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public String registerNewStudent(@RequestBody Student student) {
        return studentService.addNewStudent(student);
//        return "Student has been added";

    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public String updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestBody(required = false) Student updateStudentDto
          ) throws BadRequestException {
        System.out.printf("Student %s",updateStudentDto);
      return studentService.updateStudent(studentId, updateStudentDto);
    }


}
