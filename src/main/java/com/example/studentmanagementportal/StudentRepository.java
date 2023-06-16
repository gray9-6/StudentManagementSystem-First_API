package com.example.studentmanagementportal;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
    Map<Integer,Student> studentMap = new HashMap<>();
    static int count = 0;

    public Student getStudent(int admissionNo) {
        if(studentMap.containsKey(admissionNo) == true){
            return studentMap.get(admissionNo) ;
        }
        return  null;
    }

    public Student getStudentByPathVariable(int admissionNo){
        if(studentMap.containsKey(admissionNo)){
            return studentMap.get(admissionNo) ;
        }
        return null;
    }

    public String addStudent(Student student) {
        // jis student ka object aaya hai , uska admission no. nikalao
        int id =  student.getAdmissionNo();
        // agar toh uss admission no. ka student , database(student map) mein phele se nahi hai toh add kar lo
        if(getStudent(id) == null){
            this.count ++;
            studentMap.put(student.getAdmissionNo(),student);
            return " Student Added Successfully." + "Total students are :- " + this.count;
        }
        return null;
    }

    public String updateStudentCourse(int admissionNo, String course) {
        // check karo kya wo student enrolled hai ya nahi
        if(studentMap.containsKey(admissionNo)){
            // uss roll no. ke base pe student ka object bana lo jisme uski saari info hogi
            Student s = studentMap.get(admissionNo);
            String oldCourse = s.getCourse();
            if(oldCourse.equals(course)){
                return "Please choose different course. Student is already enrolled for this course";
            } else{
                s.setCourse(course);
            }
            return s.getName() + " course changed from " + oldCourse +  " to " + s.getCourse();
        }
        return null;
    }

    public String updateStudentSemester(int admissionNo, String semester) {
        // check karo kya wo student enrolled hai ya nahi
        if(studentMap.containsKey(admissionNo)){
            // uss roll no. ke base pe student ka object bana lo jisme uski saari info hogi
            Student s = studentMap.get(admissionNo);
            String oldSem = s.getSemester();
            if(oldSem.equals(semester)){
                return "Please choose different course. Student is already enrolled for this course";
            } else{
                // uska semester set kar do
                s.setSemester(semester);
            }
            return s.getName() + " semester  changed to " + s.getSemester();
        }
        return null;
    }

    public String deleteRecord(int admissionNo) {
        if(studentMap.containsKey(admissionNo)){
            this.count--;
            studentMap.remove(admissionNo);
            return "Student record deleted successfully." + "Remaining Students are :- " + this.count  ;
        }
        return null;
    }

    public String getStudentNumberByAge(int age) {
        int ageCount =0;
        boolean ans = studentMap.isEmpty();
        System.out.println("isEmpty" + ans );
        if(ans == false){
            for(Student student : studentMap.values()){
                if(student.getAge() > age){
                    ageCount++;
                }
            }
            return "total students whose age is greater than " + age + " is :- " + ageCount;
        }
        return "The database is empty";
    }

    public List<String> getAllCourses() {
        String msg = "Here are all the courses";
        List<String> course = new ArrayList<>();
        for(Student student : studentMap.values()){
            course.add(student.getName() + " --> " + student.getCourse());
        }
        return course;
    }

    public Set<String> getAllUniqueCourses() {
        String msg = "Here are all the courses";
        Set<String> map = new HashSet<>();
        for(Student student : studentMap.values()){
            map.add(student.getCourse());
        }
        return map;
    }

    public String updateStudentInfo(int admissionNo, int option, String course, String semester) {
        // Check if the student exists
        if (studentMap.containsKey(admissionNo)) {
            // Get the student object
            Student s = studentMap.get(admissionNo);

            // Update the student's information based on the selected option
            switch (option) {
                case 1:
                    if (course == null) {
                        return "Course parameter is required for option 1";
                    }
                    s.setCourse(course);
                    return s.getName() + " course changed to " + s.getCourse();


                case 2:
                    if (semester == null) {
                        return "Semester parameter is required for option 2";
                    }
                    s.setSemester(semester);
                    return s.getName() + " semester changed to " + s.getSemester();

                default:
                    return "Invalid option";
            }
        }

        return "Admission No. " + admissionNo + " not found";
    }
}
