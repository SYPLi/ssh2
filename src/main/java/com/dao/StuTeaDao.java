package com.dao;

import com.beans.Stu_Tea;

import java.util.List;

public interface StuTeaDao {
    public List<Stu_Tea> queryByStuId(int stu_id);
    public List<Stu_Tea> queryByTeaId(int tea_id);
    public void add(Stu_Tea stu_tea);
    public void update(Stu_Tea stu_tea);
    public void delete(Stu_Tea stu_tea);
    public Stu_Tea get(int id);
}
