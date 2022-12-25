package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {

        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email is already taken");
        }else {
            studentRepository.save(student);
        }

        System.out.println(student);
    }

    public void deleteStudent(Long studentId) {

        boolean existsById = studentRepository.existsById(studentId);

        if(!existsById){
            throw new IllegalStateException("student id - "+studentId+" does not exists");
        }else {
            studentRepository.deleteById(studentId);
        }

    }
}
