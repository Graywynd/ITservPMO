/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmo.pmoitserv.Dao;

import com.pmo.pmoitserv.Model.Compte;
import com.pmo.pmoitserv.Model.Projet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author saif
 */
public class ProjetDao {
    
     private Session session = null;
    
    public ProjetDao(){
    
        this.session =  HibernateUtil.getSessionFactory().openSession();
      }
    
    
    public long getProjetCount(){
		Long result = null ;
		try {
                    Transaction tx = session.beginTransaction();
                    
			Criteria cr = session.createCriteria(Projet.class);
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
    
    public long getProjetCountByCompte(int compteId){
		Long result = null ;
                Compte cpte = null ;
		try {
                    Transaction tx = session.beginTransaction();
                        cpte= (Compte) session.get(Compte.class,compteId);
			Criteria cr = session.createCriteria(Projet.class).add(Restrictions.eq("compte", cpte));
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
    
    public void addProjetToCompte(Projet pjt ,int compteId) {
                Compte cpte = null;
		try {
			
			Transaction tx = session.beginTransaction();
                        cpte= (Compte) session.get(Compte.class,compteId);
                        pjt.setCompte(cpte);
                        
		        session.save(pjt);
		

		 tx.commit();
		 session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public void deleteProjetFromCompte(int projetId) {
        
        Projet pjt = null ;
		try {
                       Transaction tx = session.beginTransaction();
			
                        pjt= (Projet) session.get(Projet.class,projetId);
                        
                        
                        session.delete(pjt);
                        tx.commit();
		        session.flush();
                        
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public void updateProjet(Projet pjt){
		try {
			 Transaction tx = session.beginTransaction();
			
                        session.update(pjt);
                        tx.commit();
		        session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public List<Projet> getAllProjets() {
		List<Projet> pjts = new ArrayList<Projet>();
		try {
			Transaction tx = session.beginTransaction();
                        pjts = session.createCriteria(Projet.class).list();
                        tx.commit();
                        session.flush();
                        return pjts ;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pjts;
	}
    
     public List<Projet> getAllProjetsByCompte(int compteId) {
		List<Projet> pjts = new ArrayList<Projet>();
                Compte cpte = null ;
		try {
			Transaction tx = session.beginTransaction();
                        cpte= (Compte) session.get(Compte.class,compteId);
                        pjts = session.createCriteria(Projet.class).add(Restrictions.eq("compte", cpte)).list();
                        tx.commit();
                        session.flush();
                        return pjts ;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pjts;
	}


     public Projet getProjetById(int projetId) {
		Projet pjt = new Projet();
		try {
			 Transaction tx = session.beginTransaction();
			
                        pjt = (Projet) session.get(Projet.class,projetId);
                        tx.commit();
		        session.flush();
                        return pjt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pjt;
	}
     

}
