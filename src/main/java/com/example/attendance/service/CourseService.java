package com.example.attendance.service;

import com.example.attendance.models.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course save(Course course);
    List<Course> findByCourseId(String courseId);
    List<Course> findByDate(String date);
    List<Course> findByCourseNameAndDate(String courseName, String date);
}
