package com.anoxi.controller;

import com.anoxi.apiresponse.ApiResponse;
import com.anoxi.dto.StudentDto;
import com.anoxi.dto.StudentResponseDto;
import com.anoxi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> saveStudent(@RequestBody StudentDto dto){

        ApiResponse<StudentResponseDto> response = new ApiResponse<>();

        StudentResponseDto studentResponseDto = service.saveStudent(dto);
        if (studentResponseDto.getId() == null){
            response.setStatus(500);
            response.setMsg("Failed to Save Student details in DB");
            response.setData(null);

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.setStatus(201);
        response.setMsg("Student details Created");
        response.setData(studentResponseDto);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllStudents(){

        ApiResponse<List<StudentResponseDto>> response = new ApiResponse<>();

        List<StudentResponseDto> allStudent = service.findAllStudent();

        if (allStudent.isEmpty()){
            response.setStatus(500);
            response.setMsg("Failed to get All Students");
            response.setData(null);

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.setStatus(200);
        response.setMsg("Get All students");
        response.setData(allStudent);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getStudentById(@RequestParam("id") Integer id){

        ApiResponse<StudentResponseDto> response = new ApiResponse<>();

        StudentResponseDto studentById = service.findStudentById(id);

        if (studentById.getId() == null){
            response.setStatus(500);
            response.setMsg("Failed to get Student");
            response.setData(null);

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.setStatus(200);
        response.setMsg("Successfully retrieve Student details");
        response.setData(studentById);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
