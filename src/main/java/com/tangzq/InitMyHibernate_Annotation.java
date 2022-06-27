package com.tangzq;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class InitMyHibernate_Annotation {
    private static SessionFactory sessionFactory;
    public static SessionFactory sessionFactory(){
        if(sessionFactory==null){
            try {
                Configuration configuration = new Configuration();
                Properties hProperties = new Properties();
                hProperties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                hProperties.put(Environment.URL, "jdbc:/mysql://localhost:3306/lab_myhibernate?userSSL=false");
                hProperties.put(Environment.USER, "root");
                hProperties.put(Environment.PASS, "kingschan");
                hProperties.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
                hProperties.put(Environment.SHOW_SQL, "true");
                hProperties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                hProperties.put(Environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(hProperties);
                {
                configuration.addAnnotatedClass(com.tangzq.model.User_me.class);
                configuration.addAnnotatedClass(com.tangzq.model.Topic.class);
                configuration.addAnnotatedClass(com.tangzq.model.Reply.class);
                configuration.addAnnotatedClass(com.tangzq.model.Tag.class);
                configuration.addAnnotatedClass(com.tangzq.model.Catagories.class);
                 }
                ServiceRegistry serviceRegistry =
                        new StandardServiceRegistryBuilder()
                                .applySettings( configuration.getProperties() ).build();

                sessionFactory=configuration.buildSessionFactory(serviceRegistry);

            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return sessionFactory;
    }

}
