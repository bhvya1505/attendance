package com.example.attendance.mapper;

import com.example.attendance.dto.AttendanceDTO;
import com.example.attendance.models.Course;
import com.example.attendance.models.Student;

public class AttendanceMapper {
    public static AttendanceDTO mapFn(Course course, Student student){
        AttendanceDTO ad = new AttendanceDTO();
        if(course.getStudentId().equals(student.getId())){
            ad.setCourseId(course.getId());
            ad.setCourseName(course.getCourseName());
            ad.setDate(course.getDate());
            ad.setStudentId(student.getId());
            ad.setStudentName(student.getName());
            return ad;
        }
        return null;
    }
}
