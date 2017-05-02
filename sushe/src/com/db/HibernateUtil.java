package com.db;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.bean.Admin;


public class HibernateUtil  
	{  
	    public static final SessionFactory sessionFactory;  
	    //����sessionFactory  
	    static  
	    {  
	        try  
	        {  
	            // ����Ĭ�ϵ�hibernate.cfg.xml������һ��Configuration��ʵ��  
	            Configuration configuration = new Configuration()  
	                .configure();  
	            // ��Configurationʵ��������SessionFactoryʵ��  
	            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
	            		applySettings(configuration.getProperties()).buildServiceRegistry();  
	            sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
	        }  
	        catch (Throwable ex)  
	        {  
	            System.err.println("Initial SessionFactory creation failed." + ex);  
	            throw new ExceptionInInitializerError(ex);  
	        }  
	    }  
	  
	    // ThreadLocal���Ը������̵߳����ݹ�����˲�����Ҫ���߳�ͬ��  
	    public static final ThreadLocal<Session> session  
	        = new ThreadLocal<Session>();  
	    //����Session  
	    public static Session currentSession()  
	        throws HibernateException  
	    {  
	        //ͨ���̶߳���.get()������ȫ����S ession  
	        Session s = session.get();  
	        // ������̻߳�û��Session,�򴴽�һ���µ�Session  
	        if (s == null)  
	        {  
	            s = sessionFactory.openSession();  
	            // ����õ�Session�����洢��ThreadLocal����session��  
	            session.set(s);  
	        }  
	        return s;  
	    }  
	    //�ر�Session  
	    public static void closeSession()  
	        throws HibernateException  
	    {  
	        Session s = session.get();  
	        if (s != null)  
	            s.close();  
	        session.set(null);  
	    } 
} 
