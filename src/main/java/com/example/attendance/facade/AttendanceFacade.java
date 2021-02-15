package com.example.attendance.facade;

import com.example.attendance.dto.AttendanceDTO;
import com.example.attendance.mapper.AttendanceMapper;
import com.example.attendance.models.Course;
import com.example.attendance.models.Student;
import com.example.attendance.service.CourseService;
import com.example.attendance.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AttendanceFacade {
    @Autowired
    StudentService ssi;
    @Autowired
    CourseService csi;

    public List<AttendanceDTO> findNameByCourseAndDate(String courseName, String date) {
        List<Course> listOfCourses = csi.findByCourseNameAndDate(courseName, date);
        List<String> listOfStudentIds = new ArrayList<>();
        for(Course course : listOfCourses){
            listOfStudentIds.add(course.getStudentId());
        }
        List<Student> listOfStudents = ssi.findByList(listOfStudentIds);
        Map<String, Student> mapOfStudent = new HashMap<>();
        List<AttendanceDTO> listOfDto = new ArrayList<>();
        for(Student student : listOfStudents) {
            mapOfStudent.put(student.getId(), student);
        }
        for(Course course : listOfCourses){
            if(mapOfStudent.containsKey(course.getStudentId())){
                listOfDto.add(AttendanceMapper.mapFn(course, mapOfStudent.get(course.getStudentId())));
            }

        }
        return listOfDto;
    }
}
