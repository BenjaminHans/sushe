package com.dao;

import com.db.HibernateUtil;
import com.bean.Admin;
import com.bean.Building;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;

public class BuildingDao {
	
	//获取列表
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
	
	//获取指定ID的实体Bean
	public Building GetBean(int id){
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  		
		Building cnbean1 = (Building) session.get(Building.class, id);
		tx.commit();
		return cnbean1;
	}
	
	//添加
	public void Add(Building cnbean){
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		session.save(cnbean);
		tx.commit();
	}
	//修改
	public void Update(Building cnbean){
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		session.update(cnbean);
		tx.commit();
	}
	//删除
	public void Delete(String strwhere){
		String sql="delete Building where ";
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

