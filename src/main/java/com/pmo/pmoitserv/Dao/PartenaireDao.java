/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmo.pmoitserv.Dao;

import com.pmo.pmoitserv.Model.Compte;
import com.pmo.pmoitserv.Model.Partenaire;
import com.pmo.pmoitserv.Model.Utilisateur;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
/**
 *
 * @author saif
 */
public class PartenaireDao {
    
     private Session session = null;
    
    public PartenaireDao(){
    
        this.session =  HibernateUtil.getSessionFactory().openSession();
      }
    
    public long getPartenaireCount(){
		Long result = null ;
		try {
                    Transaction tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Partenaire.class);
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

    public void addPartenaire(Partenaire part) {
		try {
			
			Transaction tx = session.beginTransaction();
		        session.save(part);
		

		 tx.commit();
		 session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
    public void deletePartenaire(int partId) {
		try {
                       Transaction tx = session.beginTransaction();
			Partenaire part = new Partenaire();
                        part.setIdPartenaire(partId);
                        session.delete(part);
                        tx.commit();
		        session.flush();
                        
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
    public void updatePartenaire(Partenaire part){
		try {
			 Transaction tx = session.beginTransaction();
			
                        session.update(part);
                        tx.commit();
		        session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
        public List<Partenaire> getAllPartenaires() {
		List<Partenaire> parts = new ArrayList<Partenaire>();
		try {
			Transaction tx = session.beginTransaction();
                        parts = session.createCriteria(Partenaire.class).list();
                        tx.commit();
                        session.flush();
                        return parts ;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return parts;
	}
    
                
        public Partenaire getPartenaireById(int partId) {
		Partenaire part = new Partenaire();
		try {
			 Transaction tx = session.beginTransaction();
			
                        part = (Partenaire) session.get(Partenaire.class,partId);
                        tx.commit();
		        session.flush();
                        return part;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return part;
	}
    
}
