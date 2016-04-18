package com.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Administrator on 2016/3/18.
 */
@Entity//数据库用
public class Ke {



    @Id
    private String Id;

    private String className;
    private String teacherName;
    private String address;
    private int whatDay;
    private int startTime;
    private int length;

    private int startWeek;
    private int endWeek;

    private String schoolName;
    private String theClassName;


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getWhatDay() {
        return whatDay;
    }

    public void setWhatDay(int whatDay) {
        this.whatDay = whatDay;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(int startWeek) {
        this.startWeek = startWeek;
    }

    public int getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(int endWeek) {
        this.endWeek = endWeek;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getTheClassName() {
        return theClassName;
    }

    public void setTheClassName(String theClassName) {
        this.theClassName = theClassName;
    }
}
