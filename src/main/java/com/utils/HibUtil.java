package com.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.Serializable;

public class HibUtil {
    private static SessionFactory sessionFactory;
    static {
        Configuration cfg=new Configuration();
        cfg.configure();
        sessionFactory=cfg.buildSessionFactory();
    }

    private static Session getSession(){
        return sessionFactory.openSession();
    }
    private static void close(Session s){
        if(s!=null){
            s.close();
        }
    }

    public static int add(Object obj){
        Session session=getSession();
        Transaction tx=session.beginTransaction();
        Serializable i=session.save(obj);
        tx.commit();
        close(session);
        return (Integer)i;
    }

    public static void delete(Object obj){
        Session session=getSession();
        Transaction tx=session.beginTransaction();
        session.delete(obj);
        tx.commit();
        close(session);
    }

    public static boolean update(Object obj){
        Session session=null;
        try{
            session=getSession();
            Transaction tx=session.beginTransaction();
            session.update(obj);
            tx.commit();
        }catch (Exception e){
            return false;
        }finally {
            close(session);
        }
        return true;
    }

    public static Object get(Class clazz,int id){
        Session session=getSession();
        Transaction tx=session.beginTransaction();
        Object obj=session.get(clazz,id);
        tx.commit();
        close(session);
        return obj;
    }

    public static Query getQuery(String hql){
        return getSession().createQuery(hql);
    }
}
