package com.dao.impl;

import com.beans.Student;
import com.dao.StudentDao;
import com.utils.HibUtil;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void add(Student stu) {
        HibUtil.add(stu);
    }

    @Override
    public String queryPasswordByAccount(String account) {
        String hql="select a.password from Student a where a.account='"+account+"'";
        Query q= HibUtil.getQuery(hql);
        Object obj=q.uniqueResult();
        String password=null;
        if(obj!=null){
            password=obj.toString();
        }
        return password;
    }

    @Override
    public Student query(String account) {
        String hql="select a from Student a where a.account='"+account+"'";
        Query q= HibUtil.getQuery(hql);
        Student student=(Student)q.uniqueResult();
        return student;
    }

    @Override
    public List<Student> queryAll() {
        String hql="select a from Student a";
        Query q=HibUtil.getQuery(hql);
        List<Student> list=q.list();
        return list;
    }
}
