/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojos.Customers;
import com.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alfreding0
 */
public class DaoCustomers{

    public boolean insert(Customers customer) {
        Session session = null;
        boolean response;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(customer);
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

    public boolean update(Customers customer) {
        Session session = null;
        boolean response;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(customer);
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

    public boolean delete(Customers customer) {
        Session session = null;
        boolean response;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(customer);
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

    public List<Customers> getListCustomers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Customers";
        Query query = session.createQuery(hql);
        List<Customers> listCustomers = query.list();
        session.close();

        return listCustomers;
    }

    public Customers find(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Customers where id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        Customers customer = (Customers) query.uniqueResult();
        session.close();

        return customer;
    }

    public List<Customers> findPersonalForFirstName(String value) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        String hql = "FROM Customers where first_name LIKE :first_name";
        Query query = session.createQuery(hql);
        query.setParameter("first_name", "%"+value+"%");
        List<Customers> list = query.list();
        session.close();

        return list;
    }
}
