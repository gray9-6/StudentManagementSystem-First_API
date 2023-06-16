package com.example.studentmanagementportal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class StudentController {


    @Autowired
    StudentService studentService;


    // get the student , GET API

    // /get_info?id=type you admission id here, for which student you want to get the record
    @GetMapping("/get_info")
    public Student getStudent(@RequestParam("id") int admissionNo){
        return studentService.getStudent(admissionNo);
    }

    // /get/type you admission id here, for which student you want to get the record
    @GetMapping("/get/{id}/{message}")
    public String getStudentByPathVariable(@PathVariable("id") int admissionNo, @PathVariable("message") String message){
        return studentService.getStudentByPathVariable(admissionNo,message);
    }


    // Adding the Students, POST API
    // /add
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }


    // update
    // /update/type the student whose course you want to update
    @PutMapping("/updateCourse/{id}/{course}")
    public String updateStudentCourse(@PathVariable("id") int admissionNo,@PathVariable("course") String course){
        return studentService.updateStudentCourse(admissionNo,course);
    }

    @PutMapping("/updateSemester")
    public String updateStudentSemester(@RequestParam("id") int admissionNo,@RequestParam("semester") String semester){
         return  studentService.updateStudentSemester(admissionNo,semester);
    }


    //delete
    // /delete/student admission no.
    @DeleteMapping("/delete/{id}")
    public String deleteRecord(@PathVariable("id") int admissionNo){
      return studentService.deleteRecord(admissionNo);
    }


    // total number of students whose age is greater than 25
    @GetMapping("/count")
    public String getStudentNumberByAge(@RequestParam("age") int age){
       return studentService.getStudentNumberByAge(age);
    }


    // Get All the courses
    @GetMapping("/course")
    public List<String> getAllCourses(){
         return studentService.getAllCourses();
    }


    // Get All the unique courses
    @GetMapping("/uniqueCourse")
    public Set<String> getAllUniqueCourses(){
        return studentService.getAllUniqueCourses();
    }

    @PutMapping("/updateStudentRecord/{id}/{option}")
    public String updateStudentInfo(
            @PathVariable("id") int admissionNo,
            @PathVariable("option") int option,
            @PathVariable(value = "course", required = false) String course,
            @PathVariable(value = "semester", required = false) String semester
    ) {
        return  studentService.updateStudentInfo(admissionNo,option,course,semester);
    }

}
