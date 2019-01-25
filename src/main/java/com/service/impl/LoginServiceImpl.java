package com.service.impl;

import com.beans.Student;
import com.beans.Teacher;
import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.dao.impl.StudentDaoImpl;
import com.dao.impl.TeacherDaoImpl;
import com.service.LoginService;
import com.utils.MD5Utils;

public class LoginServiceImpl implements LoginService {
    @Override
    public Object login(String account, String password,int status) {
        if(status==0){
            StudentDao studentDao=new StudentDaoImpl();
            if(MD5Utils.getPwd(password).equals(studentDao.queryPasswordByAccount(account))){
                Student student=studentDao.query(account);
                return student;
            }
        }
        else if(status==1){
            TeacherDao teacherDao =new TeacherDaoImpl();
            if(MD5Utils.getPwd(password).equals(teacherDao.queryPasswordByAccount(account))){
                Teacher teacher=teacherDao.query(account);
                return teacher;
            }
        }
        return null;
    }

    @Override
    public boolean register(Object obj, int status) {
        if(status==0){
            Student stu=(Student)obj;
            StudentDao studentDao=new StudentDaoImpl();
            if(studentDao.query(stu.getAccount())==null){
                stu.setPassword(MD5Utils.getPwd(stu.getPassword()));
                studentDao.add(stu);
                return true;
            }
        }
        else if(status==1){
            Teacher tea=(Teacher)obj;
            TeacherDao teacherDao=new TeacherDaoImpl();
            if(teacherDao.query(tea.getAccount())==null){
                tea.setPassword(MD5Utils.getPwd(tea.getPassword()));
                teacherDao.add(tea);
                return true;
            }
        }
        return false;
    }
}
