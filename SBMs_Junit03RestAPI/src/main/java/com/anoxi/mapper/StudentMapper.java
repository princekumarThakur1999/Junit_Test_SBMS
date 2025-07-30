package com.anoxi.mapper;

import com.anoxi.dto.StudentDto;
import com.anoxi.dto.StudentResponseDto;
import com.anoxi.dto.SubjectMarks;
import com.anoxi.entity.School;
import com.anoxi.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    //converted dto to student entity
    public static Student toStudent(StudentDto dto){
        if(dto == null){
            throw new RuntimeException("StudentDto is null");
        }
        var student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setLocation(dto.getLocation());

        if(dto.getSchoolId() != null){

            var school = new School();
            school.setSchoolId(dto.getSchoolId());
            school.setSchoolName(dto.getSchoolName());
            student.setSchool(school);
        }
        return student;
    }

    //converted student entity to responsedto
    public static StudentResponseDto toStudentResponsedto(Student student){

        if(student == null){
           throw new RuntimeException("Student is null");
        }

        var studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());

        if(student.getSchool() != null){
            studentResponseDto.setSchoolName(student.getSchool().getSchoolName());
        }
        return studentResponseDto;
    }

    //Unit Testing - for private method
    private double getPercentage(SubjectMarks subjectMarks){

        int totalMarks = subjectMarks.getEnglish() + subjectMarks.getHindi() + subjectMarks.getMaths() + subjectMarks.getScience();
        double percentage = (totalMarks/400.0) * 100;
        return percentage;
    }
}
