/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmo.pmoitserv.Dao;

import com.pmo.pmoitserv.Model.Chantier;
import com.pmo.pmoitserv.Model.Utilisateur;
import com.pmo.pmoitserv.Model.Action;
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
public class ActionDao {
    
    private Session session = null;
    
    public ActionDao(){
    
        this.session =  HibernateUtil.getSessionFactory().openSession();
      }
    
     public long getActionCount(){
		Long result = null ;
		try {
                    Transaction tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Action.class);
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
     
     public long getActionCountByChantier(int chantierId){
		Long result = null ;
                Chantier chantier = null ;
		try {
                    Transaction tx = session.beginTransaction();
                        chantier= (Chantier) session.get(Chantier.class,chantierId);
			Criteria cr = session.createCriteria(Action.class).add(Restrictions.eq("chantier", chantier));
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
     
      public long getActionCountBySousProjet(int sousprojetId){
		Long result = null ;
                Sousprojet souspjt = null ;
                List<Chantier> chantiers = new ArrayList<Chantier>();
		try {
                    Transaction tx = session.beginTransaction();
                        souspjt= (Sousprojet) session.get(Sousprojet.class,sousprojetId);
                        chantiers = session.createCriteria(Chantier.class).add(Restrictions.eq("sousprojet", souspjt)).list();
			Criteria cr = session.createCriteria(Action.class).add(Restrictions.in("chantier", chantiers));
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
      
      public long getActionCountByProjet(int projetId){
		Long result = null ;
                Projet pjt = null ;
                List<Sousprojet> souspjts = new ArrayList<Sousprojet>();
                List<Chantier> chantiers = new ArrayList<Chantier>();
		try {
                    Transaction tx = session.beginTransaction();
                       pjt= (Projet) session.get(Projet.class,projetId);
                        souspjts = session.createCriteria(Sousprojet.class).add(Restrictions.eq("projet", pjt)).list();
			chantiers =  session.createCriteria(Chantier.class).add(Restrictions.in("sousprojet", souspjts)).list();
			Criteria cr = session.createCriteria(Action.class).add(Restrictions.in("chantier", chantiers));
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
      
       public long getActionCountByCompte(int compteId){
		Long result = null ;
                Compte cpte = null ;
                List<Projet> pjts = new ArrayList<Projet>();
                List<Sousprojet> souspjts = new ArrayList<Sousprojet>();
                List<Chantier> chantiers = new ArrayList<Chantier>();
		try {
                    Transaction tx = session.beginTransaction();
                       cpte= (Compte) session.get(Compte.class,compteId);
                        pjts =session.createCriteria(Projet.class).add(Restrictions.eq("compte", cpte)).list();
                        souspjts = session.createCriteria(Sousprojet.class).add(Restrictions.in("projet", pjts)).list();
			chantiers =  session.createCriteria(Chantier.class).add(Restrictions.in("sousprojet", souspjts)).list();
			Criteria cr = session.createCriteria(Action.class).add(Restrictions.in("chantier", chantiers));
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
      
	public void addActionToChantier_User(Action act ,int chantierId , int userId) {
            Chantier chantier = null ;
            Utilisateur user = null ;
		try {
			
			Transaction tx = session.beginTransaction();
                        chantier = (Chantier) session.get(Chantier.class,chantierId);
                        user = (Utilisateur) session.get(Utilisateur.class,userId);
                        act.setUtilisateur(user);
                        act.setChantier(chantier);
		        session.save(act);
		

		 tx.commit();
		 session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
        public void deleteActionFromChantier(int actId) {
            Action act = null;
		try {
                       Transaction tx = session.beginTransaction();
			act = (Action) session.get(Action.class, actId);
                        session.delete(act);
                        tx.commit();
		        session.flush();
                        
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
        public void updateAction(Action act){
		try {
			 Transaction tx = session.beginTransaction();
			
                        session.update(act);
                        tx.commit();
		        session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
        public List<Action> getAllActions() {
		List<Action> acts = new ArrayList<Action>();
		try {
			Transaction tx = session.beginTransaction();
                        acts = session.createCriteria(Action.class).list();
                        tx.commit();
                        session.flush();
                        return acts ;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return acts;
	}
        
        public List<Action> getAllActionsByChantier(int chantierId) {
		List<Action> acts = new ArrayList<Action>();
                Chantier chantier = null ;
		try {
			Transaction tx = session.beginTransaction();
                        chantier= (Chantier) session.get(Chantier.class,chantierId);
                        acts = session.createCriteria(Action.class).add(Restrictions.eq("chantier", chantier)).list();
                        tx.commit();
                        session.flush();
                        return acts ;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return acts;
	}
     
       public List<Action> getAllActionsBySousProjet(int sousprojetId) {
		List<Action> acts = new ArrayList<Action>();
                Sousprojet souspjt = null ;
                List<Chantier> chantiers = new ArrayList<Chantier>();
		try {
                         Transaction tx = session.beginTransaction();
			souspjt= (Sousprojet) session.get(Sousprojet.class,sousprojetId);
                        chantiers = session.createCriteria(Chantier.class).add(Restrictions.eq("sousprojet", souspjt)).list();
			acts =  session.createCriteria(Action.class).add(Restrictions.in("chantier", chantiers)).list();
                        tx.commit();
                        session.flush();
                        return acts ;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return acts;
	}
       
        public List<Action> getAllActionsByProjet(int projetId) {
		List<Action> acts = new ArrayList<Action>();
                Projet pjt = null ;
                List<Sousprojet> souspjts = new ArrayList<Sousprojet>();    
                List<Chantier> chantiers = new ArrayList<Chantier>();
		try {
                         Transaction tx = session.beginTransaction();
			pjt= (Projet) session.get(Projet.class,projetId);
                        souspjts = session.createCriteria(Sousprojet.class).add(Restrictions.eq("projet", pjt)).list();
                        chantiers = session.createCriteria(Chantier.class).add(Restrictions.in("sousprojet", souspjts)).list();
			acts =  session.createCriteria(Action.class).add(Restrictions.in("chantier", chantiers)).list();
                        tx.commit();
                        session.flush();
                        return acts ;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return acts;
	}

    
                
        public Action getActionById(int actId) {
		Action act = new Action();
		try {
			 Transaction tx = session.beginTransaction();
			
                        act = (Action) session.get(Action.class,actId);
                        tx.commit();
		        session.flush();
                        return act;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return act;
	}
                
    
}
