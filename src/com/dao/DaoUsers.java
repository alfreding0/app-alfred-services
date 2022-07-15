/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojos.Users;
import com.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author alfreding0
 */
public class DaoUsers {

    public boolean insert(Users user) {
        Session session = null;
        boolean response;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
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

    public boolean update(Users user) {
        Session session = null;
        boolean response;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
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

    public boolean delete(Users user) {
        Session session = null;
        boolean response;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
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

    public List getListUsers_OnlyString() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Users";
        Query query = session.createQuery(hql);
        List<Users> listUsers = query.list();
        
        List list = new ArrayList();
        for (Users user : listUsers) {
            list.add(new Object[]{user.getId(), user.getName(), user.getEmail(), user.getPersonals().getFirstName() + " " + user.getPersonals().getLastName()});
        }        
        session.close();

        return list;
    }
    
    public List<Users> getListUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Users";
        Query query = session.createQuery(hql);
        List<Users> listUsers = query.list();    
        session.close();

        return listUsers;
    }

    public Users find(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Users where id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        Users user = (Users) query.uniqueResult();
        session.close();

        return user;
    }
}
