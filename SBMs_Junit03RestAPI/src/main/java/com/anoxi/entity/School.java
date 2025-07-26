package com.anoxi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class School{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer schoolId;
    private String  schoolName;

    public School() {
        super();
    }

    public School(Integer schoolId, String  schoolName) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
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
