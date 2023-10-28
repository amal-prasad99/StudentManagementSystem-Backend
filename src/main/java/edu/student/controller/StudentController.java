package edu.student.controller;

import edu.student.dao.StudentEntity;
import edu.student.dto.Student;
import edu.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService service;
    @PostMapping
    public void registerStudent(@RequestBody Student student){
        service.registerStudent(student);
    }

    @GetMapping
    public Iterable<StudentEntity> retrieveAllStudents(){
        return service.retrieveAllStudents();
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        service.deleteStudentById(studentId);
    }

    @PatchMapping("/{studentId}")
    public void updateStudent(@PathVariable Long studentId, @RequestBody Student updatedStudent) {
        service.updateStudent(studentId, updatedStudent);
    }

}
