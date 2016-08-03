/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmo.pmoitserv.Dao;

import com.pmo.pmoitserv.Model.Compte;
import com.pmo.pmoitserv.Model.Utilisateur;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

/**
 *
 * @author saif
 */
public class UserDao {
    
    private Session session = null;
    
    public UserDao(){
    
        this.session =  HibernateUtil.getSessionFactory().openSession();
      }
    
    
   	public long getUserCount(){
		Long result = null ;
		try {
                    Transaction tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Utilisateur.class);
                        cr.setProjection(Projections.rowCount());
                        result = (Long)cr.uniqueResult();
                        tx.commit();
                        session.flush();
                        return result ;
                        
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void addUser(Utilisateur user) {
		try {
			
			Transaction tx = session.beginTransaction();
		        session.save(user);
		

		 tx.commit();
		 session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
        public void deleteUser(int userId) {
		try {
                       Transaction tx = session.beginTransaction();
			Utilisateur user = new Utilisateur();
                        user.setIdUtilisateur(userId);
                        session.delete(user);
                        tx.commit();
		        session.flush();
                        
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
        public void updateUser(Utilisateur user){
		try {
			 Transaction tx = session.beginTransaction();
			
                        session.update(user);
                        tx.commit();
		        session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
        public List<Utilisateur> getAllUsers() {
		List<Utilisateur> users = new ArrayList<Utilisateur>();
		try {
			Transaction tx = session.beginTransaction();
                        users = session.createCriteria(Utilisateur.class).list();
                        tx.commit();
                        session.flush();
                        return users ;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return users;
	}
    
                
        public Utilisateur getUserById(int userId) {
		Utilisateur user = new Utilisateur();
		try {
			 Transaction tx = session.beginTransaction();
			
                        user = (Utilisateur) session.get(Utilisateur.class,userId);
                        tx.commit();
		        session.flush();
                        return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
                
               
                
    
}
