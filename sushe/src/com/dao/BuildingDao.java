package com.dao;

import com.db.HibernateUtil;
import com.bean.Admin;
import com.bean.Building;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;

public class BuildingDao {
	
	//��ȡ�б�
	public List<Building> GetList(String strwhere,String strorder){
			String sql="from Building";
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
			List<Building> list = (List<Building>)session.createQuery(sql).list();	 
			tx.commit();
			return list;
	}
	
	//��ȡָ��ID��ʵ��Bean
	public Building GetBean(int id){
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  		
		Building cnbean1 = (Building) session.get(Building.class, id);
		tx.commit();
		return cnbean1;
	}
	
	//���
	public void Add(Building cnbean){
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		session.save(cnbean);
		tx.commit();
	}
	//�޸�
	public void Update(Building cnbean){
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		session.update(cnbean);
		tx.commit();
	}
	//ɾ��
	public void Delete(String strwhere){
		String sql="delete Building where ";
		sql+=strwhere;
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		session.createQuery(sql).executeUpdate();
		tx.commit();		
	}

	
	//�ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	
	//����
	public static void main(String[] args) {
		System.out.println("");
	}
	
}

