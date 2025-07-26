package com.anoxi.dto;

public class StudentResponseDto {

    private Integer id;
    private String name;
    private String schoolName;

    public StudentResponseDto() {
        super();
    }

    public StudentResponseDto(Integer id, String name, String schoolName) {
        this.id = id;
        this.name = name;
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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
