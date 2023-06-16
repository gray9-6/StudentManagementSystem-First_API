package com.example.studentmanagementportal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;


    // get the student , GET API
    // /get_info?id=type you admission id here, for which student you want to get the record
    @GetMapping("/get_info")
    public ResponseEntity getStudent(@RequestParam("id") int admissionNo){
        Student s = studentService.getStudent(admissionNo);
        if(s != null){
            return new ResponseEntity(s, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("Student Not found",HttpStatus.NOT_FOUND);
    }

    // /get/type you admission id here, for which student you want to get the record
    @GetMapping("/get/{id}/{message}")
    public ResponseEntity getStudentByPathVariable(@PathVariable("id") int admissionNo, @PathVariable("message") String message){
        String s = studentService.getStudentByPathVariable(admissionNo,message);
        return new ResponseEntity(s,HttpStatus.ACCEPTED);

    }


    // Adding the Students, POST API
    // /add
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student){
        String s = studentService.addStudent(student);
        if(s != null){
            return new ResponseEntity<>(s,HttpStatus.CREATED);
        }
        return  new ResponseEntity("Already enrolled",HttpStatus.BAD_REQUEST);
    }


    // update
    // /update/type the student whose course you want to update
    @PutMapping("/updateCourse/{id}/{course}")
    public ResponseEntity updateStudentCourse(@PathVariable("id") int admissionNo,@PathVariable("course") String course){
        String s =  studentService.updateStudentCourse(admissionNo,course);
        if(s != null){
            return  new ResponseEntity(s,HttpStatus.OK);
        }
        return  new ResponseEntity("Admission No. " + admissionNo + " not found",HttpStatus.FORBIDDEN);
    }

    @PutMapping("/updateSemester")
    public ResponseEntity updateStudentSemester(@RequestParam("id") int admissionNo,@RequestParam("semester") int semester){
         String s = studentService.updateStudentSemester(admissionNo,semester);
         if(s != null){
             return  new ResponseEntity(s,HttpStatus.OK);
         }
         return  new ResponseEntity("Admission No. " + admissionNo + " not found",HttpStatus.FORBIDDEN);
    }


    //delete
    // /delete/student admission no.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRecord(@PathVariable("id") int admissionNo){
      String s = studentService.deleteRecord(admissionNo);
      if(s != null){
            return new ResponseEntity<>(s,HttpStatus.ACCEPTED);
        }
      return new ResponseEntity("Student not found",HttpStatus.NOT_FOUND);
    }


    // total number of students whose age is greater than 25
    @GetMapping("/count")
    public String getStudentNumberByAge(@RequestParam("age") int age){
       return studentService.getStudentNumberByAge(age);
    }


    // Get All the courses
    @GetMapping("/course")
    public ResponseEntity getAllCourses(){
        List<String> list  = studentService.getAllCourses();
        if(list.isEmpty()){
            return  new ResponseEntity("NO Record Found",HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity(list,HttpStatus.FOUND);
    }


    // Get All the unique courses
    @GetMapping("/uniqueCourse")
    public ResponseEntity getAllUniqueCourses(){
        Set<String> list = studentService.getAllUniqueCourses();
        if(list.isEmpty()){
            return  new ResponseEntity("NO Record Found",HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity(list,HttpStatus.FOUND);
    }

    // Get Student Info By Course
    @GetMapping("/getStudentBy_Course")
    public ResponseEntity getStudentInfoByCourse(@RequestParam("course") String course){
         List<Student> list =  studentService.getStudentInfoByCourse(course);
         if(list.isEmpty()){
             return  new ResponseEntity("No student found in this course",HttpStatus.NOT_FOUND);
         }
         return  new ResponseEntity(list,HttpStatus.FOUND);
    }


    // Get Student Info By Semester
    @GetMapping("/getStudentBy_Semester/{semester}")
    public ResponseEntity getStudentInfoBySemester(@PathVariable("semester") int semester){
        List<Student> list = studentService.getStudentInfoBySemester(semester);
        if(list.isEmpty()){
            return new ResponseEntity("No Student found in this Semester" ,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(list,HttpStatus.FOUND);
    }


    @PutMapping("/updateStudentRecord/{id}/{option}")
    public String updateStudentInfo(
            @PathVariable("id") int admissionNo,
            @PathVariable("option") int option,
            @PathVariable(value = "course", required = false) String course,
            @PathVariable(value = "semester", required = false) int semester
    ) {
        return  studentService.updateStudentInfo(admissionNo,option,course,semester);
    }

}
