package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Scanner;

public class Application {
    public static void addAlien(int id, String name, String color, String food){
        Alien alienObj = new Alien();
        alienObj.setId(id);
        alienObj.setName(name);
        alienObj.setColor(color);
        alienObj.setFood(food);
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.save(alienObj);
        tx.commit();
    }
    static Alien getAlienById(int id){
        Alien alienObj = new Alien();
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        alienObj = (Alien) session.get(Alien.class, id);
        tx.commit();
        return alienObj;
    }
    static void showFirstLevelCache(int id){
        Alien alienObj = new Alien();
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        alienObj = (Alien) session.get(Alien.class, id);
        System.out.println(alienObj);
        alienObj = (Alien) session.get(Alien.class, id);
        System.out.println(alienObj);
        tx.commit();
    }
    static void showSecondLevelCache(int id){
        Alien alienObj = new Alien();
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();

        Session session1 = sf.openSession();
        Transaction tx1 = session1.beginTransaction();
        alienObj = (Alien) session1.get(Alien.class, id);
        System.out.println(alienObj);
        tx1.commit();

        Session session2 = sf.openSession();
        Transaction tx2 = session2.beginTransaction();
        alienObj = (Alien) session2.get(Alien.class, id);
        System.out.println(alienObj);
        tx2.commit();
    }
    static void executeCacheableHQL(){
        Alien alienObj = new Alien();
        Configuration con  = new Configuration().configure().addAnnotatedClass(Alien.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session1 = sf.openSession();
        Transaction tx1 = session1.beginTransaction();
        Query q1 = session1.createQuery("from Alien where id = 101",Alien.class);
        q1.setCacheable(true);
        alienObj = (Alien) q1.uniqueResult();
        System.out.println(alienObj);
        tx1.commit();
        Session session2 = sf.openSession();
        Transaction tx2 = session1.beginTransaction();
        Query q2 = session2.createQuery("from Alien where id = 101", Alien.class);
        q2.setCacheable(true);
        alienObj = (Alien) q2.uniqueResult();
        System.out.println(alienObj);
        tx2.commit();

    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        char c = 'n';
        while(c != 'y') {
            System.out.println("Press 1 to Save the Alien object to database");
            System.out.println("Press 2 to  Retrieve the Alien object for specific Id");
            System.out.println("Press 3 to Show first level cache");
            System.out.println("Press 4 to Show second level cache");
            System.out.println("Press 5 to Execute Cacheable HQL query");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("\nEnter the Alien ID : ");
                    int id = sc.nextInt();
                    System.out.print("\nEnter the Alien Name : ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("\nEnter the Alien Color :");
                    String color = sc.nextLine();
                    System.out.print("\nEnter the Alien Food :");
                    String food = sc.nextLine();
                    addAlien(id, name, color, food);
                    break;
                case 2:
                    System.out.print("\nEnter the Alien ID to retrieve the Alien object for specific Id : ");
                    System.out.println(getAlienById(sc.nextInt()));
                    break;
                case 3:
                    System.out.print("\nEnter the Alien ID to show first level cache : ");
                    showFirstLevelCache(sc.nextInt());
                    break;
                case 4:
                    System.out.print("\nEnter the Alien ID to show second level cache : ");
                    showSecondLevelCache(sc.nextInt());
                    break;
                case 5:
                    executeCacheableHQL();
                    break;
                default:
                    System.out.println("!!! Sorry you have selected wrong choice !!!");
            }

            System.out.println("If you want to exit Press 'y'");
            c = sc.next().charAt(0);
        }
        System.out.println("!!! BYE !!!");
    }
}
