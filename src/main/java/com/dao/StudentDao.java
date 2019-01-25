package com.dao;

import com.beans.Student;

import java.util.List;

public interface StudentDao {
    public void add(Student stu);
    public String queryPasswordByAccount(String account);
    public Student query(String account);
    public List<Student> queryAll();
}
