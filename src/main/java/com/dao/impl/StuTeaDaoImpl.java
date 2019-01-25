package com.dao.impl;

import com.beans.Stu_Tea;
import com.dao.StuTeaDao;
import com.utils.HibUtil;
import org.hibernate.query.Query;

import java.util.List;

public class StuTeaDaoImpl implements StuTeaDao {
    @Override
    public List<Stu_Tea> queryByStuId(int stu_id) {
        String hql="select a from Stu_Tea a where a.stu_id="+stu_id;
        Query q= HibUtil.getQuery(hql);
        List<Stu_Tea> list=q.list();
        return list;
    }

    @Override
    public List<Stu_Tea> queryByTeaId(int tea_id) {
        String hql="select a from Stu_Tea a where a.tea_id="+tea_id;
        Query q= HibUtil.getQuery(hql);
        List<Stu_Tea> list=q.list();
        return list;
    }

    @Override
    public void add(Stu_Tea stu_tea) {
        HibUtil.add(stu_tea);
    }

    @Override
    public void update(Stu_Tea stu_tea) {
        HibUtil.update(stu_tea);
    }

    @Override
    public void delete(Stu_Tea stu_tea) {
        HibUtil.delete(stu_tea);
    }

    @Override
    public Stu_Tea get(int id) {
        return (Stu_Tea) HibUtil.get(Stu_Tea.class,id);
    }
}
