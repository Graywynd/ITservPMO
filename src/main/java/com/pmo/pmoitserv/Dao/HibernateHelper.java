/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmo.pmoitserv.Dao;

import com.pmo.pmoitserv.Dao.HibernateUtil;
import com.pmo.pmoitserv.Model.Utilisateur;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author saif
 */
public class HibernateHelper {
    
    Session session = null;

    public HibernateHelper() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public void listUsers( ){
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         List users = session.createQuery("FROM Utilisateur").list(); 
         for (Iterator iterator = 
                           users.iterator(); iterator.hasNext();){
            Utilisateur user = (Utilisateur) iterator.next(); 
            System.out.print("First Name: " + user.getUtilisateurPrenom()); 
            System.out.print("  Last Name: " + user.getUtilisateurNom()); 
            }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   
   public List listActions( ){
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         List actions = session.createQuery("FROM Action").list(); 
         
         
         tx.commit();
         return actions;
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return null ;
   }
   
   public List listComptes( ){
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         List comptes = session.createQuery("FROM Compte").list(); 
         
         
         tx.commit();
         return comptes;
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return null ;
   }
    
}
