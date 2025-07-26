package com.anoxi.dto;


import com.anoxi.entity.School;

public class StudentDto {

    private Integer id;
    private String name;
    private String email;
    private String location;
    private Integer schoolId;
    private String schoolName;

    public StudentDto() {
        super();
    }

    public StudentDto(Integer id, String name, String email, String location, Integer schoolId, String schoolName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.location = location;
        this.schoolId = schoolId;
        this.schoolName = schoolName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}

