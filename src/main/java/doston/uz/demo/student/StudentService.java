package doston.uz.demo.student;

import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();

    }

    public String addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email is taken");
        }

        studentRepository.save(student);

        System.out.println(student);
        return "Student has been added";
    }

    public String deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("student with id" + studentId + " doesn't exist");
        }
        studentRepository.deleteById(studentId);
        return "Student deleted";

    }

    @Transactional
    public String updateStudent(Long studentId, Student updateStudentDto) throws BadRequestException {
        // Retrieve the student entity by ID
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exist"));
        System.out.printf("email %s\n", updateStudentDto.getEmail());
        System.out.printf("name %s\n", updateStudentDto.getName());
        // Update the student's name if provided
        if (updateStudentDto.getName().isEmpty() || updateStudentDto.getEmail() == null || updateStudentDto.getEmail().isEmpty()) {
            throw new BadRequestException("Name and Email are required! ");
        }
        student.setName(updateStudentDto.getName());


        // Update the student's email if provided

        // Check if the new email is already associated with another student
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(updateStudentDto.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email is already taken");
        }
        student.setEmail(updateStudentDto.getEmail());
//
//
//        // Save the updated student entity
        studentRepository.save(student);
//        System.out.println("Oldingi student: " + student);
//
//        System.out.println("Student changed " + student);
        return "Student has been changed";

    }


}
