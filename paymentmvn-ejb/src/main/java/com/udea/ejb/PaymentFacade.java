/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.entity.Payment;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Diego
 */
@Stateless
public class PaymentFacade extends AbstractFacade<Payment> implements PaymentFacadeLocal {

    @PersistenceContext(unitName = "com.udea_paymentmvn-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaymentFacade() {
        super(Payment.class);
    }
    
    
     @Override
    public List<Payment> getAllPayments() {
        Query query= em.createNamedQuery("Payment.findAll");
        return query.getResultList();
    }
    
    
}
