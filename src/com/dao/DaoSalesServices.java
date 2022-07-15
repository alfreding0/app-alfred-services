/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojos.SalesServices;
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
public class DaoSalesServices {

    public boolean insert(SalesServices saleServices) {
        Session session = null;
        boolean response;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(saleServices);
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

    public boolean update(SalesServices saleServices) {
        Session session = null;
        boolean response;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(saleServices);
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

    public boolean delete(SalesServices saleServices) {
        Session session = null;
        boolean response;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(saleServices);
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

    //Retorna todas las saleServicess de la BD
    public List getListDetailSS_OnlyString(int sale_id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM SalesServices where sale_id = :sale_id";
        Query query = session.createQuery(hql);
        query.setParameter("sale_id", sale_id);
        List<SalesServices> listSalesServices = query.list();
        
        List list = new ArrayList();
        listSalesServices.forEach((obj) -> {
            list.add(new Object[]{obj.getId(), obj.getSales().getId(), obj.getServices().getName(), obj.getFinalPrice()});
        });
        
        session.close();
        
        return list;
    }
    
    public List<SalesServices> getListDetailSS(int sale_id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM SalesServices where sale_id = :sale_id";
        Query query = session.createQuery(hql);
        query.setParameter("sale_id", sale_id);
        List<SalesServices> listSalesServices = query.list();
        session.close();
        
        return listSalesServices;
    }    
    
    public SalesServices find(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM SalesServices where id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        SalesServices saleServices = (SalesServices) query.uniqueResult();
        session.close();
        
        return saleServices;
    }
}
