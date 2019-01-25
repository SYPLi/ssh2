package com.service.impl;

import com.beans.Stu_Tea;
import com.beans.Teacher;
import com.dao.StuTeaDao;
import com.dao.impl.StuTeaDaoImpl;
import com.dao.impl.TeacherDaoImpl;
import com.service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
    @Override
    public Map<String, Object> initialize(int id) {
        Map<String,Object> map=new HashMap<>();
        List<Teacher> teacherlist=new TeacherDaoImpl().queryAll();
        map.put("teacherlist",teacherlist);
        List<Stu_Tea> stu_teaList=new StuTeaDaoImpl().queryByStuId(id);
        map.put("stu_teaList",stu_teaList);
        return map;
    }

    @Override
    public void apply(Stu_Tea stu_tea) {
        StuTeaDao stuTeaDao=new StuTeaDaoImpl();
        stuTeaDao.add(stu_tea);
    }
}
