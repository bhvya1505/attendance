package com.example.attendance.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttendanceDTO {
    private String studentId;
    private String studentName;
    private String courseId;
    private String courseName;
    private String date;
}
