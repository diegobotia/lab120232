/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.ejb.PaymentFacadeLocal;
import com.udea.entity.Payment;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import static org.primefaces.component.captcha.Captcha.PropertyKeys.language;

/**
 *
 * @author Diego
 */
public class PaymentBean {

    @EJB
    private com.udea.ejb.PaymentFacadeLocal paymentFacade;
    public UIComponent myButton;
    
    public UIComponent getMyButton(){
        return myButton;
    }

    public void setMyButton(UIComponent myButton) {
        this.myButton = myButton;
    }

    private int id;
    private double amount;
    private String name;
    private String email;
    private long card;
    private Date date = new Date();
    private int cvvNo;
    private String contrasena;
    private String txtContrasenaRepita;
    boolean disable = true;
    
    String sSubCadena;
    String mensajecard;
    String m;
    
     private List<Payment> payments; //para visualizar en la tabla
    
     //retorna una lista de clientes para mostrar en un datatable de JSF
    public List<Payment> getPayments(){
   if((payments==null)||(payments.isEmpty()))
       refresh();
       return payments;
}
     
     
    private void refresh() {
payments=paymentFacade.getAllPayments();
}
    
    
    public boolean isDisable(){
        return disable;
        
    }
    
    public void setDisable(boolean disable){
       this.disable= disable;
    }

    public PaymentFacadeLocal getPaymentFacade() {
        return paymentFacade;
    }

    public void setPaymentFacade(PaymentFacadeLocal paymentFacade) {
        this.paymentFacade = paymentFacade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCard() {
        return card;
    }

    public void setCard(long card) {
        this.card = card;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCvvNo() {
        return cvvNo;
    }

    public void setCvvNo(int cvvNo) {
        this.cvvNo = cvvNo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTxtContrasenaRepita() {
        return txtContrasenaRepita;
    }

    public void setTxtContrasenaRepita(String txtContrasenaRepita) {
        this.txtContrasenaRepita = txtContrasenaRepita;
    }

    public String getsSubCadena() {
        return sSubCadena;
    }

    public void setsSubCadena(String sSubCadena) {
        this.sSubCadena = sSubCadena;
    }

    public String getMensajecard() {
        return mensajecard;
    }

    public void setMensajecard(String mensajecard) {
        this.mensajecard = mensajecard;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }
    
    
    
    
    
    /**
     * Creates a new instance of PaymentBean
     */
    public PaymentBean() {
    }
    
    
    public String guardar(){
         Payment p = new Payment();
         p.setId(id);
       p.setName(name);
       p.setEmail(email);
       p.setAmount(amount);
       p.setCard(card);
       p.setCvvno(cvvNo);
       p.setDate(date);
       this.paymentFacade.create(p);
       m=this.getMensajecard();
        return "PaymentCreate";
    }
    
    
    public String validar(){
    
        String sCadena;
        sCadena= String.valueOf(card);
        sSubCadena = sCadena.substring(0,4);
        int val= Integer.parseInt(sSubCadena);
        if(val >=0000 && val <= 5555) {
           FacesMessage message = new FacesMessage("TARJETA VISA");
           FacesContext context = FacesContext.getCurrentInstance();
           context.addMessage(myButton.getClientId(context), message);
           mensajecard = "ES VISA";
          disable = false;
          this.setMensajecard(mensajecard);
          return this.getMensajecard();
        }
        else if(val >=8000 && val <= 9999) {
           FacesMessage message = new FacesMessage("TARJETA MASTERCARD");
           FacesContext context = FacesContext.getCurrentInstance();
           context.addMessage(myButton.getClientId(context), message);
           mensajecard = "ES MASTERCARD";
          disable = false;
          this.setMensajecard(mensajecard);
          return this.getMensajecard();
        } else {
        FacesMessage message = new FacesMessage("TARJETA INVALIDA");
           FacesContext context = FacesContext.getCurrentInstance();
           context.addMessage(myButton.getClientId(context), message);
        }
        
        return null;
        
    }
    
private Locale locale= FacesContext.getCurrentInstance().getViewRoot().getLocale();
public Locale getLocale(){
    return locale;   
}

public String getLanguage(){
   return locale.getLanguage();
}
    
    
public void changeLanguage(String language){
   locale=new Locale(language);
   FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
}    
    
    
    
    
}



































