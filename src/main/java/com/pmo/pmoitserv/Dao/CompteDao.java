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
public class CompteDao {
    
      private Session session = null;
    
    public CompteDao(){
    
        this.session =  HibernateUtil.getSessionFactory().openSession();
      }
    
    public long getCompteCount(){
		Long result = null ;
		try {
                    Transaction tx = session.beginTransaction();
			Criteria cr = session.createCriteria(Compte.class);
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

	public void addCompte(Compte cpte) {
		try {
			
			Transaction tx = session.beginTransaction();
		        session.save(cpte);
		

		 tx.commit();
		 session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
        public void deleteCompte(int compteId) {
		try {
                       Transaction tx = session.beginTransaction();
			Compte cpte = new Compte();
                        cpte.setIdCompte(compteId);
                        session.delete(cpte);
                        tx.commit();
		        session.flush();
                        
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
        public void updateCompte(Compte cpte){
		try {
			 Transaction tx = session.beginTransaction();
			
                        session.update(cpte);
                        tx.commit();
		        session.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
        
        public List<Compte> getAllComptes() {
		List<Compte> cptes = new ArrayList<Compte>();
		try {
			Transaction tx = session.beginTransaction();
                        cptes = session.createCriteria(Compte.class).list();
                        tx.commit();
                        session.flush();
                        return cptes ;		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cptes;
	}
    
                
        public Compte getCompteById(int compteId) {
		Compte cpte = new Compte();
		try {
			 Transaction tx = session.beginTransaction();
			
                        cpte = (Compte) session.get(Compte.class,compteId);
                        tx.commit();
		        session.flush();
                        return cpte;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cpte;
	}
                
        public Set<Utilisateur> getUsers_CompteById(int compteId) {
		Compte cpte = null;
                Set<Utilisateur> users = null;
		try {
			 Transaction tx = session.beginTransaction();
			
                        cpte = (Compte) session.get(Compte.class,compteId);
                        users =  cpte.getUtilisateurs();
                        tx.commit();
		        session.flush();
                        return users;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
                
                
        public void AddUserToCompte(int userId,int compteId){
                    Compte cpte = null;
                    Utilisateur user = null;
                    try {
			 Transaction tx = session.beginTransaction();
			
                        cpte = (Compte) session.get(Compte.class,compteId);
                        user = (Utilisateur) session.get(Utilisateur.class,userId);
                        user.getComptes().add(cpte);
                        session.update(user);
                        tx.commit();
		        session.flush();
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
                }
                 
                 
        public void RemoveUserFromCompte(int userId,int compteId){
                    Compte cpte = null;
                    Utilisateur user = null;
                    try {
			 Transaction tx = session.beginTransaction();
			
                        cpte = (Compte) session.get(Compte.class,compteId);
                        user = (Utilisateur) session.get(Utilisateur.class,userId);
                        if(user.getComptes().contains(cpte)){
                        user.getComptes().remove(cpte);
                        session.update(user);
                        }
                        tx.commit();
		        session.flush();
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
                }
                 
        public Set<Partenaire> getPartenaires_CompteById(int compteId) {
		Compte cpte = null;
                Set<Partenaire> parts = null;
		try {
			 Transaction tx = session.beginTransaction();
			
                        cpte = (Compte) session.get(Compte.class,compteId);
                        parts =  cpte.getPartenaires();
                        tx.commit();
		        session.flush();
                        return parts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return parts;
	}
         
        public void AddPartenaireToCompte(int partId,int compteId){
                    Compte cpte = null;
                    Partenaire part = null;
                    try {
			 Transaction tx = session.beginTransaction();
			
                        cpte = (Compte) session.get(Compte.class,compteId);
                        part = (Partenaire) session.get(Partenaire.class,partId);
                        part.getComptes().add(cpte);
                        session.update(part);
                        tx.commit();
		        session.flush();
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
                }
                 
                 
        public void RemovePartenaireFromCompte(int partId,int compteId){
                    Compte cpte = null;
                    Partenaire part = null;
                    try {
			 Transaction tx = session.beginTransaction();
			
                        cpte = (Compte) session.get(Compte.class,compteId);
                        part = (Partenaire) session.get(Partenaire.class,partId);
                        if(part.getComptes().contains(cpte)){
                        part.getComptes().remove(cpte);
                        session.update(part);
                        }
                        tx.commit();
		        session.flush();
                        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
                } 
                
                
}
