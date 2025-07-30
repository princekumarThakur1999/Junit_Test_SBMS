package com.anoxi.dto;

public class SubjectMarks {

    private Integer english;
    private Integer hindi;
    private Integer maths;
    private Integer science;

    public SubjectMarks() {
        super();
    }

    public SubjectMarks(Integer english, Integer hindi, Integer maths, Integer science) {
        this.english = english;
        this.hindi = hindi;
        this.maths = maths;
        this.science = science;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getHindi() {
        return hindi;
    }

    public void setHindi(Integer hindi) {
        this.hindi = hindi;
    }

    public Integer getMaths() {
        return maths;
    }

    public void setMaths(Integer maths) {
        this.maths = maths;
    }

    public Integer getScience() {
        return science;
    }

    public void setScience(Integer science) {
        this.science = science;
    }
}
