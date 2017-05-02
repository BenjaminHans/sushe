package com.dao;

import com.db.HibernateUtil;
import com.bean.Out1;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class OutDao {
	
	//获取列表
	public List<Out1> GetList(String strwhere,String strorder){
		String sql="from Out1 o,Student s where o.Out_StudentID=s.Student_ID";
		if(!(isInvalid(strwhere)))
		{
			sql+=" where "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		
		List<Out1> list = (List<Out1>)session.createQuery(sql).list();
		 
		tx.commit();
		return list;
	}
	
	//获取指定ID的实体Bean
	public Out1 GetBean(int id){
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		Out1 admin = (Out1) session.get(Out1.class, id);
		tx.commit();
		return admin;
	}
	
	//添加
	public void Add(Out1 cnbean){
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		session.save(cnbean);
		tx.commit();
	}
	//修改
	public void Update(Out1 cnbean){
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		session.update(cnbean);
		tx.commit();
	}
	//删除
	public void Delete(String strwhere){
		String sql="delete Out where ";
		sql+=strwhere;
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		session.createQuery(sql).executeUpdate();
		tx.commit();
	}

	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println("");
	}
	
}

