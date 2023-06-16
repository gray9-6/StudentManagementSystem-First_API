package com.example.studentmanagementportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public Student getStudent(int admissionNo) {

        return studentRepository.getStudent(admissionNo);
    }

    public String getStudentByPathVariable(int admissionNo, String message) {
        Student s =  studentRepository.getStudentByPathVariable(admissionNo);
        if( s == null){
            return  "Student not found";
        }
        return  message + " " + s;
    }

    public String addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public String updateStudentCourse(int admissionNo, String course) {
        return studentRepository.updateStudentCourse(admissionNo,course);
    }

    public String updateStudentSemester(int admissionNo, int semester) {
        return  studentRepository.updateStudentSemester(admissionNo,semester);
    }

    public String deleteRecord(int admissionNo) {
       return studentRepository.deleteRecord(admissionNo);
    }

    public String getStudentNumberByAge(int age) {
       return studentRepository.getStudentNumberByAge(age);
    }

    public List<String> getAllCourses() {
        return  studentRepository.getAllCourses();
    }

    public Set<String> getAllUniqueCourses() {
        return  studentRepository.getAllUniqueCourses();
    }

    public String updateStudentInfo(int admissionNo, int option, String course, int semester) {
        return studentRepository.updateStudentInfo(admissionNo,option,course,semester);
    }

    public List<Student> getStudentInfoByCourse(String course) {
        return  studentRepository.getStudentInfoByCourse(course);
    }

    public List<Student> getStudentInfoBySemester(int semester) {
        return studentRepository.getStudentInfoBySemester(semester);
    }
}
