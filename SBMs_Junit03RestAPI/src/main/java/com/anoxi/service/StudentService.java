package com.anoxi.service;

import com.anoxi.dto.StudentDto;
import com.anoxi.dto.StudentResponseDto;
import com.anoxi.entity.Student;
import com.anoxi.mapper.StudentMapper;
import com.anoxi.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;


    @Autowired
    private StudentMapper mapper;

    //save Student details into db
    public StudentResponseDto saveStudent(StudentDto dto){

        Student student = mapper.toStudent(dto);
        Student saved = studentRepo.save(student);
        //studentRepo.save(student);  -- mistakenly i wrote 2 times : Just verify with Junit
        if(saved.getId() != null){
            return  mapper.toStudentResponsedto(saved);
        }
        return null;
    }

    //find all student
    public List<StudentResponseDto> findAllStudent(){

        return  studentRepo.findAll()
                .stream()
                .map(StudentMapper::toStudentResponsedto)
                .collect(Collectors.toList());
    }
}
