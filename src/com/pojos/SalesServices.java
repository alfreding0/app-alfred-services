package com.pojos;
// Generated Jul 15, 2022 5:26:53 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SalesServices generated by hbm2java
 */
@Entity
@Table(name="sales_services"
    ,schema="public"
)
public class SalesServices  implements java.io.Serializable {


     private int id;
     private Sales sales;
     private Services services;
     private int numberDays;
     private double finalPrice;
     private Date createdAt;
     private Date updatedAt;

    public SalesServices() {
    }

	
    public SalesServices(int id, Sales sales, Services services, int numberDays, double finalPrice) {
        this.id = id;
        this.sales = sales;
        this.services = services;
        this.numberDays = numberDays;
        this.finalPrice = finalPrice;
    }
    public SalesServices(int id, Sales sales, Services services, int numberDays, double finalPrice, Date createdAt, Date updatedAt) {
       this.id = id;
       this.sales = sales;
       this.services = services;
       this.numberDays = numberDays;
       this.finalPrice = finalPrice;
       this.createdAt = createdAt;
       this.updatedAt = updatedAt;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="sale_id", nullable=false)
    public Sales getSales() {
        return this.sales;
    }
    
    public void setSales(Sales sales) {
        this.sales = sales;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="service_id", nullable=false)
    public Services getServices() {
        return this.services;
    }
    
    public void setServices(Services services) {
        this.services = services;
    }

    
    @Column(name="number_days", nullable=false)
    public int getNumberDays() {
        return this.numberDays;
    }
    
    public void setNumberDays(int numberDays) {
        this.numberDays = numberDays;
    }

    
    @Column(name="final_price", nullable=false, precision=17, scale=17)
    public double getFinalPrice() {
        return this.finalPrice;
    }
    
    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_at", length=29)
    public Date getCreatedAt() {
        return this.createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at", length=29)
    public Date getUpdatedAt() {
        return this.updatedAt;
    }
    
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }




}


