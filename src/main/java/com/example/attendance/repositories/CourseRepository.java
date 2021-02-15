package com.example.attendance.repositories;

import com.example.attendance.models.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CourseRepository extends MongoRepository<Course, String> {
    List<Course> findAllByDate(String date);
    List<Course> findAllByCourseId(String courseId);
    List<Course> findAllByCourseNameAndDate(String courseName, String date);

}
