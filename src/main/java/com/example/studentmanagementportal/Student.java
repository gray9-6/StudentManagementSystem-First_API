package com.example.studentmanagementportal;

public class Student {
    private String name;
    private int admissionNo;
    private int age;
    private int Semester;
    private String course;


    // Constructor
    public Student() {
    }

    public Student(String name, int admissionNo, int age, int semester, String course) {
        this.name = name;
        this.admissionNo = admissionNo;
        this.age = age;
        Semester = semester;
        this.course = course;
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAdmissionNo() {
        return admissionNo;
    }

    public void setAdmissionNo(int admissionNo) {
        this.admissionNo = admissionNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getSemester() {
        return Semester;
    }

    public void setSemester(int semester) {
        Semester = semester;
    }

    @Override
    public String toString() {
        return "Student{" +
                "admnNo=" + admissionNo +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                ", semester='" + Semester + '\'' +
                '}';
    }
}
