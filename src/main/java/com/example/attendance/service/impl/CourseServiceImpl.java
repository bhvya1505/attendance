package com.example.attendance.service.impl;

import com.example.attendance.models.Course;
import com.example.attendance.repositories.CourseRepository;
import com.example.attendance.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        if(!(course.getCourseName() == null || course.getCourseName().isBlank() || course.getDate() == null || !course.validDate())) {
            return courseRepository.save(course);
        }
        return null;
    }

    @Override
    public List<Course> findByCourseId(String courseId) {
        return courseRepository.findAllByCourseId(courseId);
    }

    @Override
    public List<Course> findByDate(String date) {
        return courseRepository.findAllByDate(date);

    }

    @Override
    public List<Course> findByCourseNameAndDate(String courseName, String date) {
        return courseRepository.findAllByCourseNameAndDate(courseName, date);
    }
}
