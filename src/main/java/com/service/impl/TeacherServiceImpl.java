package com.service.impl;

import com.beans.Stu_Tea;
import com.beans.Student;
import com.dao.StuTeaDao;
import com.dao.impl.StuTeaDaoImpl;
import com.dao.impl.StudentDaoImpl;
import com.service.TeacherService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherServiceImpl implements TeacherService {
    @Override
    public Map<String, Object> initialize(int id) {
        Map<String,Object> map=new HashMap<>();
        List<Student> studentList=new StudentDaoImpl().queryAll();
        map.put("studentList",studentList);
        List<Stu_Tea> stu_teaList=new StuTeaDaoImpl().queryByTeaId(id);
        map.put("stu_teaList",stu_teaList);
        return map;
    }

    @Override
    public void accept_refuse(int id, int status) {
        StuTeaDao stuTeaDao=new StuTeaDaoImpl();
        Stu_Tea stu_tea=stuTeaDao.get(id);
        stu_tea.setStatus(status);
        stuTeaDao.update(stu_tea);
    }

    @Override
    public void cancel(int id) {
        StuTeaDao stuTeaDao=new StuTeaDaoImpl();
        Stu_Tea stu_tea=stuTeaDao.get(id);
        stuTeaDao.delete(stu_tea);
    }
}
