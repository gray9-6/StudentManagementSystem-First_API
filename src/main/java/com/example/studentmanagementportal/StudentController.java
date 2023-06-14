package com.example.studentmanagementportal;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    Map<Integer,Student> studentMap = new HashMap<>();


    // get the student , GET API
    @GetMapping("/get_info")
    public Student getStudent(@RequestParam("id") int admissionNo){
        return studentMap.get(admissionNo) ;
    }

    @GetMapping("/get/{id}")
    public Student getStudentByPathVariable(@PathVariable("id") int admissionNo){
        return studentMap.get(admissionNo) ;
    }


    // Adding the Students, POST API
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        studentMap.put(student.getAdmissionNo(),student);
        return "Student Added Successfully";
    }


    // update
    @PutMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") int admissionNo){
        Student s = studentMap.get(admissionNo);
        s.setCourse("IT");
        return s.getName() + " course changed to " + s.getCourse();
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public String deleteRecord(@PathVariable("id") int admissionNo){
        studentMap.remove(admissionNo);
        return "Student record deleted successfully";
    }

    // total number of students whose age is greater than 25
    @GetMapping("/count/{age}")
    public String getStudentNumberByAge(@PathVariable("age") int age){

        int count =0;
        for(Student student : studentMap.values()){
            if(student.getAge() > age){
                count++;
            }
        }
        return "total students whose age is greater than " + age + " is " + count;
    }

}
