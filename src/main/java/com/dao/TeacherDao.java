package com.dao;

import com.beans.Teacher;

import java.util.List;

public interface TeacherDao {
    public void add(Teacher tea);
    public String queryPasswordByAccount(String account);
    public Teacher query(String account);
    public List<Teacher> queryAll();
}
