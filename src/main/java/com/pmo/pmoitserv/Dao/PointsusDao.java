/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmo.pmoitserv.Dao;

import com.pmo.pmoitserv.Model.Action;
import com.pmo.pmoitserv.Model.Chantier;
import com.pmo.pmoitserv.Model.Projet;
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
public class PointsusDao {
    
    private Session session = null;
    
    public PointsusDao(){
    
        this.session =  HibernateUtil.getSessionFactory().openSession();
      }
    
    public long getPointsusCount(){
		Long result = null ;
		try {
                    Transaction tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Pointsus.class);
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
     
     public long getPointsusCountByProjet(int projetId){
		Long result = null ;
                Projet pjt = null ;
		try {
                    Transaction tx = session.beginTransaction();
                        pjt= (Projet) session.get(Projet.class,projetId);
			Criteria cr = session.createCriteria(Pointsus.class).add(Restrictions.eq("projet", pjt));
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
     
     public void addPointsusToProjet_User(Pointsus pnt ,int projetId , int userId) {
            Projet pjt = null ;
            Utilisateur user = null ;
		try {
			
			Transaction tx = session.beginTransaction();
                        pjt = (Projet) session.get(Projet.class,projetId);
                        user = (Utilisateur) session.get(Utilisateur.class,userId);
                        pnt.setUtilisateur(user);
                        pnt.setProjet(pjt);
		        session.save(pnt);
		

		 tx.commit();
		 session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
        public void deletePointsusFromChantier(int pntId) {
            Pointsus pnt = null;
		try {
                       Transaction tx = session.beginTransaction();
			pnt = (Pointsus) session.get(Pointsus.class, pntId);
                        session.delete(pnt);
                        tx.commit();
		        session.flush();
                        
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
        public void updatePointsus(Pointsus pnt){
		try {
			 Transaction tx = session.beginTransaction();
			
                        session.update(pnt);
                        tx.commit();
		        session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
        public List<Pointsus> getAllPointsus() {
		List<Pointsus> pnts = new ArrayList<Pointsus>();
		try {
			Transaction tx = session.beginTransaction();
                        pnts = session.createCriteria(Pointsus.class).list();
                        tx.commit();
                        session.flush();
                        return pnts ;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pnts;
	}
        
        public List<Pointsus> getAllPointsusByProjet(int projetId) {
		List<Pointsus> pnts = new ArrayList<Pointsus>();
                Projet pjt = null ;
		try {
			Transaction tx = session.beginTransaction();
                        pjt= (Projet) session.get(Projet.class,projetId);
                        pnts = session.createCriteria(Pointsus.class).add(Restrictions.eq("projet", pjt)).list();
                        tx.commit();
                        session.flush();
                        return pnts ;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pnts;
	}
}
