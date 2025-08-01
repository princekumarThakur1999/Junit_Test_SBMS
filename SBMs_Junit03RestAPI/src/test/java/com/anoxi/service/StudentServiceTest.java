package com.anoxi.service;

import com.anoxi.dto.StudentDto;
import com.anoxi.dto.StudentResponseDto;
import com.anoxi.dto.SubjectMarks;
import com.anoxi.entity.School;
import com.anoxi.entity.Student;
import com.anoxi.mapper.StudentMapper;
import com.anoxi.repo.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepo studentRepo;

    @Mock
    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void sould_successfuly_save_a_student(){

        //Given
        StudentDto dto = new StudentDto(
                01,
                "Prince kumar",
                "pyushthakur1999@gmail.com",
                "Hyd",
                101,
                "Marthoma Memorial School");

        Student student = new Student(
                01,
                "Prince kumar",
                "pyushthakur1999@gmail.com",
                "Hyd",
                new School(101, "Marthoma Memorial School"));

        Student saved = new Student(
                01,
                "Prince kumar",
                "pyushthakur1999@gmail.com",
                "Hyd",
                new School(101, "Marthoma Memorial School"));

        StudentResponseDto studentResponseDto = new StudentResponseDto(101,"Prince kumar","Marthoma Memorial School");

        //Mock the call
        Mockito.when(mapper.toStudent(dto)).thenReturn(student);
        Mockito.when(studentRepo.save(student)).thenReturn(saved);
        Mockito.when(mapper.toStudentResponsedto(saved)).thenReturn(studentResponseDto);

        //When
        StudentResponseDto responseDto = studentService.saveStudent(dto);

        //Then
        assertEquals(dto.getName(), responseDto.getName());
        assertEquals(dto.getSchoolName(), responseDto.getSchoolName());

        //Additinally Verify if mapper, and respository is called only one time. : means - it should call only one time
        Mockito.verify(mapper, Mockito.times(1)).toStudent(dto);
        Mockito.verify(mapper, Mockito.times(1)).toStudentResponsedto(saved);
        Mockito.verify(studentRepo, Mockito.times(1)).save(student);
    }

    @Test
    public void should_give_all_studentsResponse(){

        //given
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                01,
                "Prince kumar",
                "pyushthakur1999@gmail.com",
                "Hyd",
                new School(101, "Marthoma Memorial School")));

        //Mock the call
        Mockito.when(studentRepo.findAll()).thenReturn(students);

        Mockito.mockStatic(StudentMapper.class)
                .when( () -> StudentMapper.toStudentResponsedto(Mockito.any(Student.class)))
                .thenReturn(new StudentResponseDto(101,"Prince kumar","Marthoma Memorial School"));

        //when
        List<StudentResponseDto> allStudent = studentService.findAllStudent();

        //Then
        assertEquals(students.size(), allStudent.size());

        //verify
        Mockito.verify(studentRepo, Mockito.times(1)).findAll();
    }

    @Test
    public void should_return_student_by_id(){

        //Given
        Integer studentId = 01;
        Student student = new Student(
                01,
                "Prince kumar",
                "pyushthakur1999@gmail.com",
                "Hyd",
                new School(101, "Marthoma Memorial School"));

        StudentResponseDto studentResponseDto = new StudentResponseDto(101,"Prince kumar","Marthoma Memorial School");

        //Mock to call
        Mockito.when(studentRepo.findById(studentId))
                .thenReturn(Optional.of(student));
        Mockito.mockStatic(StudentMapper.class)
                .when(() -> StudentMapper.toStudentResponsedto(student))
                .thenReturn(studentResponseDto);

        //when
        StudentResponseDto studentById = studentService.findStudentById(studentId);

        //Then
        assertEquals(studentResponseDto.getName(), studentById.getName());
        assertEquals(studentResponseDto.getSchoolName(), studentById.getSchoolName());

        //verify
        Mockito.verify(studentRepo, Mockito.times(1)).findById(studentId);
    }

}