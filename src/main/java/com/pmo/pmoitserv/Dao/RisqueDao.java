/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmo.pmoitserv.Dao;




import com.pmo.pmoitserv.Model.Projet;
import com.pmo.pmoitserv.Model.Risque;

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
public class RisqueDao {
    
     private Session session = null;
    
    public RisqueDao(){
    
        this.session =  HibernateUtil.getSessionFactory().openSession();
      }
    
     public long getRisuqeCount(){
		Long result = null ;
		try {
                    Transaction tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Risque.class);
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
     
     public long getRisqueCountByProjet(int projetId){
		Long result = null ;
                Projet pjt = null ;
		try {
                    Transaction tx = session.beginTransaction();
                        pjt= (Projet) session.get(Projet.class,projetId);
			Criteria cr = session.createCriteria(Risque.class).add(Restrictions.eq("projet", pjt));
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
     
     public void addDemandeToProjet(Risque rsq ,int projetId ) {
            Projet pjt = null ;
           
		try {
			
			Transaction tx = session.beginTransaction();
                        pjt = (Projet) session.get(Projet.class,projetId);
                        
                        rsq.setProjet(pjt);
		        session.save(rsq);
		

		 tx.commit();
		 session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
     public void deleteRisqueFromProjet(int risqueId) {
            Risque rsq = null;
		try {
                       Transaction tx = session.beginTransaction();
			rsq = (Risque) session.get(Risque.class, risqueId);
                        session.delete(rsq);
                        tx.commit();
		        session.flush();
                        
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
     public void updateRisque(Risque rsq){
		try {
			 Transaction tx = session.beginTransaction();
			
                        session.update(rsq);
                        tx.commit();
		        session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
     public List<Risque> getAllRisques() {
		List<Risque> rsqs = new ArrayList<Risque>();
		try {
			Transaction tx = session.beginTransaction();
                        rsqs = session.createCriteria(Risque.class).list();
                        tx.commit();
                        session.flush();
                        return rsqs ;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rsqs;
	}
        
     public List<Risque> getAllDemandesByProjet(int projetId) {
		List<Risque> rsqs = new ArrayList<Risque>();
                Projet pjt = null ;
		try {
			Transaction tx = session.beginTransaction();
                        pjt= (Projet) session.get(Projet.class,projetId);
                        rsqs = session.createCriteria(Risque.class).add(Restrictions.eq("projet", pjt)).list();
                        tx.commit();
                        session.flush();
                        return rsqs ;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rsqs;
	}
    
}
