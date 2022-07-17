/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojos.Services;
import com.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alfreding0
 */
public class DaoServices{

    public boolean insert(Services service) {
        Session session = null;
        boolean response;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(service);
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

    public boolean update(Services service) {
        Session session = null;
        boolean response;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(service);
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

    public boolean delete(Services service) {
        Session session = null;
        boolean response;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(service);
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

    public List<Services> getListServices() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Services";
        Query query = session.createQuery(hql);
        List<Services> listServices = query.list();
        session.close();

        return listServices;
    }

    public Services find(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Services where id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        Services service = (Services) query.uniqueResult();
        session.close();

        return service;
    }

    public List<Services> findPersonalForName(String value) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        String hql = "FROM Services where name LIKE :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", "%"+value+"%");
        List<Services> list = query.list();
        session.close();

        return list;
    }
}
