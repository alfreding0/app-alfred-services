/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojos.Personals;
import com.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alfreding0
 */
public class DaoPersonals{

    public boolean insert(Personals personal) {
        Session session = null;
        boolean response;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(personal);
            session.getTransaction().commit();
            response = true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
            response = false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        return response;
    }

    public boolean update(Personals personal) {
        Session session = null;
        boolean response;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(personal);
            session.getTransaction().commit();
            response = true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
            response = false;
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return response;
    }

    public boolean delete(Personals personal) {
        Session session = null;
        boolean response;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(personal);
            session.getTransaction().commit();
            response = true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
            response = false;
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return response;
    }

    public List<Personals> getListPersonals() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Personals";
        Query query = session.createQuery(hql);
        List<Personals> listPersonals = query.list();
        session.close();

        return listPersonals;
    }

    public Personals find(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Personals where id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        Personals personal = (Personals) query.uniqueResult();
        session.close();

        return personal;
    }

    public List<Personals> findPersonalForFirstName(String value) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        String hql = "FROM Personals where first_name LIKE :first_name";
        Query query = session.createQuery(hql);
        query.setParameter("first_name", "%"+value+"%");
        List<Personals> list = query.list();
        session.close();

        return list;
    }
}
