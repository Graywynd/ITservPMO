/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmo.pmoitserv.Dao;

import com.pmo.pmoitserv.Model.Projet;
import com.pmo.pmoitserv.Model.Demande;
import com.pmo.pmoitserv.Model.Pointsus;
import com.pmo.pmoitserv.Model.Utilisateur;



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
public class DemandeDao {
    
     private Session session = null;
    
    public DemandeDao(){
    
        this.session =  HibernateUtil.getSessionFactory().openSession();
      }
    
     public long getDemandeCount(){
		Long result = null ;
		try {
                    Transaction tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Demande.class);
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
     
     public long getDemandeCountByProjet(int projetId){
		Long result = null ;
                Projet pjt = null ;
		try {
                    Transaction tx = session.beginTransaction();
                        pjt= (Projet) session.get(Projet.class,projetId);
			Criteria cr = session.createCriteria(Demande.class).add(Restrictions.eq("projet", pjt));
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
     
     public void addDemandeToProjet_User(Demande dmde ,int projetId , int userId) {
            Projet pjt = null ;
            Utilisateur user = null ;
		try {
			
			Transaction tx = session.beginTransaction();
                        pjt = (Projet) session.get(Projet.class,projetId);
                        user = (Utilisateur) session.get(Utilisateur.class,userId);
                        dmde.setUtilisateur(user);
                        dmde.setProjet(pjt);
		        session.save(dmde);
		

		 tx.commit();
		 session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
     public void deleteDemandeFromProjet(int demandeId) {
            Demande dmde = null;
		try {
                       Transaction tx = session.beginTransaction();
			dmde = (Demande) session.get(Demande.class, demandeId);
                        session.delete(dmde);
                        tx.commit();
		        session.flush();
                        
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
     public void updateDemande(Demande dmde){
		try {
			 Transaction tx = session.beginTransaction();
			
                        session.update(dmde);
                        tx.commit();
		        session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
     public List<Demande> getAllDemandes() {
		List<Demande> dmdes = new ArrayList<Demande>();
		try {
			Transaction tx = session.beginTransaction();
                        dmdes = session.createCriteria(Demande.class).list();
                        tx.commit();
                        session.flush();
                        return dmdes ;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dmdes;
	}
        
     public List<Demande> getAllDemandesByProjet(int projetId) {
		List<Demande> dmdes = new ArrayList<Demande>();
                Projet pjt = null ;
		try {
			Transaction tx = session.beginTransaction();
                        pjt= (Projet) session.get(Projet.class,projetId);
                        dmdes = session.createCriteria(Pointsus.class).add(Restrictions.eq("projet", pjt)).list();
                        tx.commit();
                        session.flush();
                        return dmdes ;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dmdes;
	}
    
    
}
