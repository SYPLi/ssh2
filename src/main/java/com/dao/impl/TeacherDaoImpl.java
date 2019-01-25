package com.dao.impl;

import com.beans.Student;
import com.beans.Teacher;
import com.dao.TeacherDao;
import com.utils.HibUtil;
import org.hibernate.query.Query;

import java.util.List;

public class TeacherDaoImpl implements TeacherDao {
    @Override
    public void add(Teacher tea) {
        HibUtil.add(tea);
    }

    @Override
    public String queryPasswordByAccount(String account) {
        String hql="select a.password from Teacher a where a.account='"+account+"'";
        Query q= HibUtil.getQuery(hql);
        Object obj=q.uniqueResult();
        String password=null;
        if(obj!=null){
            password=obj.toString();
        }
        return password;
    }

    @Override
    public Teacher query(String account) {
        String hql="select a from Teacher a where a.account='"+account+"'";
        Query q= HibUtil.getQuery(hql);
        Teacher teacher=(Teacher)q.uniqueResult();
        return teacher;
    }

    @Override
    public List<Teacher> queryAll() {
        String hql="select a from Teacher a";
        Query q=HibUtil.getQuery(hql);
        List<Teacher> list=q.list();
        return list;
    }
}
