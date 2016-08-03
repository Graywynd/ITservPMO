
import com.pmo.pmoitserv.Model.Utilisateur;
import com.pmo.pmoitserv.Dao.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saif
 */
public class newMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		
		
		
            //    Utilisateur u = (Utilisateur) session.get(Utilisateur.class,2);
              //  Chantier c = (Chantier) session.get(Chantier.class,2);
                
                Utilisateur u = new Utilisateur(1,"Graywynd","rootpass","Khiari","Seif","54659879","seif@gmail.com",0, null, null, null, null, null, null, null, null, null);               
                
                

	        
		
		session.save(u);
		

		session.getTransaction().commit();
		session.close();
    }
    
}
