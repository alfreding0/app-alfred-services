/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojos.Sales;
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
public class DaoSales {

    public boolean insert(Sales cirugia) {
        Session session = null;
        boolean response;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(cirugia);
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

    public boolean update(Sales cirugia) {
        Session session = null;
        boolean response;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(cirugia);
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

    public boolean delete(Sales sale) {
        //First delete from detail table
        DaoSalesServices daoSalesServices = new DaoSalesServices();
        List<SalesServices> lista = daoSalesServices.getListDetailSS(sale.getId());
        lista.forEach((saleService) -> { daoSalesServices.delete(saleService); });

        //Now delete sale
        Session session = null;
        boolean response;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(sale);
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

    public List getListSales_OnlyString() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Sales";
        Query query = session.createQuery(hql);
        List<Sales> listSales = query.list();
        
        List lista = new ArrayList();
        for (Sales cirugia : listSales) {
            lista.add(new Object[]{cirugia.getId(), cirugia.getDateTime(), cirugia.getTotal(), cirugia.getCustomers().getFirstName()+" "+cirugia.getCustomers().getLastName(), cirugia.getPersonals().getFirstName()+" "+cirugia.getPersonals().getLastName()});
        }        
        session.close();

        return lista;
    }
    
    public List<Sales> getListSales() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Sales";
        Query query = session.createQuery(hql);
        List<Sales> listaSaless = query.list();    
        session.close();

        return listaSaless;
    }

    public Sales find(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Sales where id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        Sales cirugia = (Sales) query.uniqueResult();
        session.close();

        return cirugia;
    }
}
