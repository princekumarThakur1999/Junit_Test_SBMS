package com.anoxi.mapper;

import com.anoxi.dto.SubjectMarks;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    //Testing private method
    @Test
    public void testgetPercentageUsingReflection() throws Exception{

        //Given
        SubjectMarks marks = new SubjectMarks(80, 70, 90, 60);

        //create service class
        StudentMapper mapper = new StudentMapper();
        Method method = StudentMapper.class.getDeclaredMethod("getPercentage", SubjectMarks.class);
        method.setAccessible(true);

        Double percentage = (Double) method.invoke(mapper, marks);

        Assertions.assertEquals(75.0, percentage);
    }

    @Test
    public void testGetPercentage_HalfMarks() throws Exception{

        //Given
        SubjectMarks marks = new SubjectMarks(50, 50, 50, 50);

        //create mapper class : class where method is present
        StudentMapper mapper = new StudentMapper();
        Method method = StudentMapper.class.getDeclaredMethod("getPercentage", SubjectMarks.class);  // get method ( "method name", parameter)
        method.setAccessible(true);  // access private method

        Double percentage = (Double) method.invoke(mapper, marks);  //invoking mappper class method with parameter

        Assertions.assertEquals(50.0, percentage);
    }
}