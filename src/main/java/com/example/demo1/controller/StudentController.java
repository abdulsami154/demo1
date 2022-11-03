package com.example.demo1.controller;

import com.example.demo1.domain.Student;
import com.example.demo1.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/get/student")
    public List<Student> getAllStudents(){
        return studentService.getStudent();
    }

    @PostMapping("/post/student")
    public ResponseEntity<Student> save(@RequestBody Student student){
        return ResponseEntity.ok(studentService.save(student));
    }

    @DeleteMapping("/delete/student/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteById(id);
    }
    @PutMapping("/update/student/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody Student student,@PathVariable Long id){
        if (studentService.existById(id)){
            Student studentUpdated=studentService.getAllStudentById(id).orElse(null);
            studentUpdated.setName(student.getName());
            studentUpdated.setAge(student.getAge());
            studentUpdated.setGender(student.getGender());
            return ResponseEntity.ok(studentService.save(studentUpdated));
        }
        else {
            HashMap<String,String> message=new HashMap<>();
            message.put("message",id+"cart not Found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
}

