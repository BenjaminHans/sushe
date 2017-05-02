package com.dao;

import com.db.HibernateUtil;
import com.bean.Admin;
import com.bean.TB;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TBDao {
	
	//��ȡ�б�
	public List<TB> GetList(String strwhere,String strorder){
		String sql="from TB,Teacher,Building where TB_TeacherID=Teacher_ID and TB_BuildingID=Building_ID";
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
		
		List<TB> list = (List<TB>)session.createQuery(sql).list();
		 
		tx.commit();
		return list;
	}
	
	//��ȡָ��ID��ʵ��Bean
	public TB GetBean(int id){
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		TB cnbean = (TB) session.get(TB.class, id);
		tx.commit();
		return cnbean;
	}
	
	//���
	public void Add(TB cnbean){
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		session.save(cnbean);
		tx.commit();
	}
	//�޸�
	public void Update(TB cnbean){
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		session.update(cnbean);
		tx.commit();
	}
	//ɾ��
	public void Delete(String strwhere){
		String sql="delete TB where ";
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

