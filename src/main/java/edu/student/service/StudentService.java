package edu.student.service;

import edu.student.dao.StudentEntity;
import edu.student.dto.Student;

public interface StudentService {

    void registerStudent(Student student);
    Iterable<StudentEntity> retrieveAllStudents();
    void deleteStudentById(Long studentId);
    void updateStudent(Long studentId,Student updatedStudent);
}
