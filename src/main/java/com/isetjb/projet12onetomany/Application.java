/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isetjb.projet12onetomany;

import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
/**
 *
 * @author MALEK
 */
public class Application {
  /**
     * Attribute declaration for factory to share between methods.
     */
    private static SessionFactory factory;

    public static void main(String[] args) {
        System.out.println("JavaSE + Maven + Hibernate + MySQL : Many to One Association");

        // Open connection  pool
        factory = HibernateUtil.getSessionFactory();

        Session session = factory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // new Contrat
            Contrat contrat_a = new Contrat();
            contrat_a.setPrixlocationjour(10);
             Date date1 = new Date();
            contrat_a.setDate_debut(date1);
             Date date2 = new Date();
            contrat_a.setDate_fin(date2);
            session.save(contrat_a);
            
            // new Contrat
            Contrat contrat_b = new Contrat();
            contrat_b.setPrixlocationjour(20);
             Date date3 = new Date();
            contrat_b.setDate_debut(date3);
             Date date4 = new Date();
            contrat_b.setDate_fin(date4);
            session.save(contrat_b);
            
            // new Contrat
            Contrat contrat_c = new Contrat();
            contrat_c.setPrixlocationjour(10);
             Date date5 = new Date();
            contrat_c.setDate_debut(date1);
             Date date6 = new Date();
            contrat_c.setDate_fin(date2);
            session.save(contrat_c);
            
            // new Voiture
            Voiture voiture_a = new Voiture();
            voiture_a.setMat("Matricule a");
            voiture_a.setColeur("Couleure a");
            voiture_a.getContrats().add(contrat_b);
            session.save(voiture_a);

            // new Voiture
            Voiture voiture_b = new Voiture();
            voiture_b.setMat("Matricule b");
            voiture_b.setColeur("Couleure b");
            voiture_b.getContrats().add(contrat_c);
            session.save(voiture_b);

            // new Voiture
            Voiture voiture_c = new Voiture();
            voiture_c.setMat("Matricule c");
            voiture_c.setColeur("Couleure c");
            voiture_c.getContrats().add(contrat_a);
            session.save(voiture_c);
            
             // new Marque
            Marque marque_a = new Marque();
            marque_a.setNom("marque a");
            marque_a.setConstr("constructor a");
            marque_a.getVoitures().add(voiture_a);
            marque_a.getVoitures().add(voiture_c);
            session.save(marque_a);

            // new Marque
            Marque marque_b = new Marque();
            marque_b.setNom("marque b");
            marque_b.setConstr("constructor b");
            marque_b.getVoitures().add(voiture_b);
            session.save(marque_b);
            
            
            
            //new Client 
            Client client_a = new Client();
            client_a.setNom("client a");
            client_a.setNum(1);
            client_a.getContrats().add(contrat_a);
            session.save(client_a);
            
            //new Client
            Client client_b = new Client();
            client_b.setNom("client b");
            client_b.setNum(2);
            client_b.getContrats().add(contrat_b);
            session.save(client_b);
            
            //new Etiquette
            Etiquette etiq_a = new Etiquette();
            etiq_a.setNom("Tiquette a");
            etiq_a.setCouleur("couleur a");
            etiq_a.getVoitures().add(voiture_a);
            session.save(etiq_a);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            //e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            session.close();
        }

        // Cleaning up connection pool
        factory.close();
    }  
}
