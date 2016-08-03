/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmo.pmoitserv.Dao;

import com.pmo.pmoitserv.Model.Chantier;
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
public class ChantierDao {
    
     private Session session = null;
    
    public ChantierDao(){
    
        this.session =  HibernateUtil.getSessionFactory().openSession();
      }
    
    
    public long getChantierCount(){
		Long result = null ;
		try {
                    Transaction tx = session.beginTransaction();
                    
			Criteria cr = session.createCriteria(Chantier.class);
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
    
    public long getChantierCountBySousProjet(int sousprojetId){
		Long result = null ;
                Sousprojet souspjt = null ;
		try {
                    Transaction tx = session.beginTransaction();
                        souspjt= (Sousprojet) session.get(Sousprojet.class,sousprojetId);
			Criteria cr = session.createCriteria(Chantier.class).add(Restrictions.eq("sousprojet", souspjt));
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
    
    public long getChantierCountByProjet(int projetId){
		Long result = null ;
                Projet prjt = null ;
                List<Sousprojet> souspjts = new ArrayList<Sousprojet>();
		try {
                    Transaction tx = session.beginTransaction();
                        prjt= (Projet) session.get(Projet.class,projetId);
                        souspjts = session.createCriteria(Sousprojet.class).add(Restrictions.eq("projet", prjt)).list();
			Criteria cr = session.createCriteria(Chantier.class).add(Restrictions.in("sousprojet", souspjts));
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

    public long getChantierCountByCompte(int compteId){
		Long result = null ;
                Compte cpte = null ;
                List<Projet> pjts = new ArrayList<Projet>();
                List<Sousprojet> souspjts = new ArrayList<Sousprojet>();
		try {
                    Transaction tx = session.beginTransaction();
                       cpte= (Compte) session.get(Compte.class,compteId);
                        pjts = session.createCriteria(Projet.class).add(Restrictions.eq("compte", cpte)).list();
			souspjts =  session.createCriteria(Sousprojet.class).add(Restrictions.in("projet", pjts)).list();
			Criteria cr = session.createCriteria(Chantier.class).add(Restrictions.in("sousprojet", souspjts));
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
    
    public void addSousChantierToSousProjet(Chantier chantier ,int sousprojetId) {
                Sousprojet souspjt = null;
		try {
			
			Transaction tx = session.beginTransaction();
                        souspjt= (Sousprojet) session.get(Sousprojet.class,sousprojetId);
                        chantier.setSousprojet(souspjt);
                        
		        session.save(chantier);
		

		 tx.commit();
		 session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public void deleteSousProjetFromProjet(int chantierId) {
        
        Chantier chantier = null ;
		try {
                       Transaction tx = session.beginTransaction();
			
                        chantier= (Chantier) session.get(Chantier.class,chantierId);
                        
                        
                        session.delete(chantier);
                        tx.commit();
		        session.flush();
                        
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public void updateSousProjet(Chantier chantier){
		try {
			 Transaction tx = session.beginTransaction();
			
                        session.update(chantier);
                        tx.commit();
		        session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    
    public List<Chantier> getAllChantiers() {
		List<Chantier> chantiers = new ArrayList<Chantier>();
		try {
			Transaction tx = session.beginTransaction();
                        chantiers = session.createCriteria(Chantier.class).list();
                        tx.commit();
                        session.flush();
                        return chantiers ;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return chantiers;
	}
    
     public List<Chantier> getAllChnatierBySousProjet(int sousprojetId) {
		List<Chantier> chantiers = new ArrayList<Chantier>();
                Sousprojet souspjt = null ;
		try {
			Transaction tx = session.beginTransaction();
                        souspjt= (Sousprojet) session.get(Sousprojet.class,sousprojetId);
                        chantiers = session.createCriteria(Chantier.class).add(Restrictions.eq("sousprojet", souspjt)).list();
                        tx.commit();
                        session.flush();
                        return chantiers ;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return chantiers;
	}

      public List<Chantier> getAllChantierByProjet(int projetId) {
		List<Chantier> chantiers = new ArrayList<Chantier>();
                Projet pjt = null ;
                List<Sousprojet> souspjts = new ArrayList<Sousprojet>();
		try {
                         Transaction tx = session.beginTransaction();
			pjt= (Projet) session.get(Projet.class,projetId);
                        souspjts = session.createCriteria(Sousprojet.class).add(Restrictions.eq("projet", pjt)).list();
			chantiers =  session.createCriteria(Chantier.class).add(Restrictions.in("sousprojet", souspjts)).list();
                        tx.commit();
                        session.flush();
                        return chantiers ;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return chantiers;
	}


     public Chantier getChantierById(int chantierId) {
		Chantier chantier = new Chantier();
		try {
			 Transaction tx = session.beginTransaction();
			
                        chantier = (Chantier) session.get(Chantier.class,chantierId);
                        tx.commit();
		        session.flush();
                        return chantier;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return chantier;
	}
}
