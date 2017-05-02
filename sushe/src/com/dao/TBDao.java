package com.dao;

import com.db.HibernateUtil;
import com.bean.Admin;
import com.bean.TB;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TBDao {
	
	//获取列表
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
	
	//获取指定ID的实体Bean
	public TB GetBean(int id){
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		TB cnbean = (TB) session.get(TB.class, id);
		tx.commit();
		return cnbean;
	}
	
	//添加
	public void Add(TB cnbean){
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		session.save(cnbean);
		tx.commit();
	}
	//修改
	public void Update(TB cnbean){
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		session.update(cnbean);
		tx.commit();
	}
	//删除
	public void Delete(String strwhere){
		String sql="delete TB where ";
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

