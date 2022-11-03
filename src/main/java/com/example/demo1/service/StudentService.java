package com.example.demo1.service;

import com.example.demo1.domain.Student;
import com.example.demo1.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }


    public Optional<Student> getAllStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public boolean existById(Long id) {
        return studentRepository.existsById(id);
    }
}
