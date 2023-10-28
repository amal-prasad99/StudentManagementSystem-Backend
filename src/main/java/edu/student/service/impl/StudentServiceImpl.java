package edu.student.service.impl;

import edu.student.dao.StudentEntity;
import edu.student.dto.Student;
import edu.student.repository.StudentRepository;
import edu.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Primary
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    // Register a new student
    public void registerStudent(Student student){

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setStudentName(student.getStudentName());
        studentEntity.setStudentAge(student.getStudentAge());
        studentEntity.setStudentContact(student.getStudentContact());
        studentEntity.setGuardianName(student.getGuardianName());
        studentEntity.setGuardianAddress(student.getGuardianAddress());
        studentEntity.setGuardianContact(student.getGuardianContact());

        studentRepository.save(studentEntity);
    }

    // Retrieve all students
    public Iterable<StudentEntity> retrieveAllStudents(){
        return studentRepository.findAll();
    }

    // Delete student by ID
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    // Update student details
    public void updateStudent(Long studentId,Student updatedStudent) {
        Optional<StudentEntity> optionalStudent = studentRepository.findById(studentId);

        if (optionalStudent.isPresent()) {

            StudentEntity existingStudent = optionalStudent.get();
            existingStudent.setStudentName(updatedStudent.getStudentName());
            existingStudent.setStudentAge(updatedStudent.getStudentAge());
            existingStudent.setStudentContact(updatedStudent.getStudentContact());
            existingStudent.setGuardianName(updatedStudent.getGuardianName());
            existingStudent.setGuardianAddress(updatedStudent.getGuardianAddress());
            existingStudent.setGuardianContact(updatedStudent.getGuardianContact());

            studentRepository.save(existingStudent);
        }
    }

}
