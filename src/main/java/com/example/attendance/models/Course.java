package com.example.attendance.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Document(collection="courses")
@Getter
@Setter
public class Course {
    @Id private String courseId;
    private String courseName;
    private String date;
    private String studentId;

    public Course(){

    }

    public Course(String courseName, String date){
        this.courseName = courseName;
        this.date = date;
    }

    public String getId() {
        return courseId;
    }

    public void setId(String id) {
        this.courseId = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean validDate(){
        Pattern pattern = Pattern.compile("\\d{2}-\\d{2}-\\d{4}");
        Matcher matcher = pattern.matcher(this.date);
        return matcher.find();
    }

}
