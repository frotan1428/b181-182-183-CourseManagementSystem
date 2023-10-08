package com.tpe.domain;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Please Provide Course Name:")
    private String coursename;


    @NotEmpty(message = "Please Provide Prefix:")
    private String prefix;

    @NotNull(message = "Please Provide the Code ")
    private Integer code;

    public Long getId() {
        return id;
    }


    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


}
