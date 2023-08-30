package com.udea.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-08-13T14:10:44")
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile SingularAttribute<Payment, Date> date;
    public static volatile SingularAttribute<Payment, Double> amount;
    public static volatile SingularAttribute<Payment, String> name;
    public static volatile SingularAttribute<Payment, Integer> id;
    public static volatile SingularAttribute<Payment, String> email;
    public static volatile SingularAttribute<Payment, Long> card;
    public static volatile SingularAttribute<Payment, Integer> cvvno;

}