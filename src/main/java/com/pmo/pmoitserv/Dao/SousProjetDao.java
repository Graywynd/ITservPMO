/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmo.pmoitserv.Dao;

import com.pmo.pmoitserv.Model.Compte;
import com.pmo.pmoitserv.Model.Projet;
import com.pmo.pmoitserv.Model.Sousprojet;


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
public class SousProjetDao {
    
    private Session session = null;
    
    public SousProjetDao(){
    
        this.session =  HibernateUtil.getSessionFactory().openSession();
      }
    
    public long getSousProjetCount(){
		Long result = null ;
		try {
                    Transaction tx = session.beginTransaction();
                    
			Criteria cr = session.createCriteria(Sousprojet.class);
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
    
    public long getSousProjetCountByProjet(int projetId){
		Long result = null ;
                Projet pjt = null ;
		try {
                    Transaction tx = session.beginTransaction();
                        pjt= (Projet) session.get(Projet.class,projetId);
			Criteria cr = session.createCriteria(Sousprojet.class).add(Restrictions.eq("projet", pjt));
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
    
    public long getSousProjetCountByCompte(int compteId){
		Long result = null ;
                Compte cpte = null ;
                List<Projet> pjts = new ArrayList<Projet>();
		try {
                    Transaction tx = session.beginTransaction();
                        cpte= (Compte) session.get(Compte.class,compteId);
                        pjts = session.createCriteria(Projet.class).add(Restrictions.eq("compte", cpte)).list();
			Criteria cr = session.createCriteria(Sousprojet.class).add(Restrictions.in("projet", pjts));
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
    
    public void addSousProjetToProjet(Sousprojet souspjt ,int projetId) {
                Projet pjt = null;
		try {
			
			Transaction tx = session.beginTransaction();
                        pjt= (Projet) session.get(Projet.class,projetId);
                        souspjt.setProjet(pjt);
                        
		        session.save(souspjt);
		

		 tx.commit();
		 session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public void deleteSousProjetFromProjet(int sousprojetId) {
        
        Sousprojet souspjt = null ;
		try {
                       Transaction tx = session.beginTransaction();
			
                        souspjt= (Sousprojet) session.get(Sousprojet.class,sousprojetId);
                        
                        
                        session.delete(souspjt);
                        tx.commit();
		        session.flush();
                        
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public void updateSousProjet(Sousprojet souspjt){
		try {
			 Transaction tx = session.beginTransaction();
			
                        session.update(souspjt);
                        tx.commit();
		        session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public List<Sousprojet> getAllSousProjets() {
		List<Sousprojet> souspjts = new ArrayList<Sousprojet>();
		try {
			Transaction tx = session.beginTransaction();
                        souspjts = session.createCriteria(Sousprojet.class).list();
                        tx.commit();
                        session.flush();
                        return souspjts ;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return souspjts;
	}
    
     public List<Sousprojet> getAllSousProjetsByProjet(int projetId) {
		List<Sousprojet> souspjts = new ArrayList<Sousprojet>();
                Projet pjt = null ;
		try {
			Transaction tx = session.beginTransaction();
                        pjt= (Projet) session.get(Projet.class,projetId);
                        souspjts = session.createCriteria(Sousprojet.class).add(Restrictions.eq("projet", pjt)).list();
                        tx.commit();
                        session.flush();
                        return souspjts ;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return souspjts;
	}

      public List<Sousprojet> getAllSousProjetsByCompte(int compteId) {
		List<Sousprojet> souspjts = new ArrayList<Sousprojet>();
                Compte cpte = null ;
                List<Projet> pjts = new ArrayList<Projet>();
		try {
                         Transaction tx = session.beginTransaction();
			cpte= (Compte) session.get(Compte.class,compteId);
                        pjts = session.createCriteria(Projet.class).add(Restrictions.eq("compte", cpte)).list();
			souspjts =  session.createCriteria(Sousprojet.class).add(Restrictions.in("projet", pjts)).list();
                        tx.commit();
                        session.flush();
                        return souspjts ;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return souspjts;
	}


     public Sousprojet getSousProjetById(int sousprojetId) {
		Sousprojet souspjt = new Sousprojet();
		try {
			 Transaction tx = session.beginTransaction();
			
                        souspjt = (Sousprojet) session.get(Sousprojet.class,sousprojetId);
                        tx.commit();
		        session.flush();
                        return souspjt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return souspjt;
	}

}
