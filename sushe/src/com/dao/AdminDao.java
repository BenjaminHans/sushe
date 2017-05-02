package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.Admin;
import com.db.HibernateUtil;

public class AdminDao {
	
	//验证登录
	public String CheckLogin(String username, String password){
		String id = null;
		String sql="select a.admin_ID from Admin a where a.admin_Username = ? and a.admin_Password = ?";
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		List li=session.createQuery(sql).setParameter(0, username).setParameter(1, password).list();
		id = (Integer) li.get(0)+"";
		tx.commit();
		return id;
	}
	//验证密码
	public boolean CheckPassword(String id, String password){
		boolean ps = false;
		Integer id_integer = Integer.valueOf(id);
		String sql="select a from Admin a where a.admin_ID = ? and a.admin_Password = ?";
		Session session = HibernateUtil.currentSession();
		Transaction tx =                         session.beginTransaction();  
		List li =session.createQuery(sql).setParameter(0, id_integer).setParameter(1, password).list();
		if(li.iterator().hasNext()){
			ps=true;
		}
		tx.commit();
		return ps;
	}
	//获取列表
	public List<Admin> GetList(String strwhere,String strorder){
		String sql="from Admin";
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
		
		List<Admin> list = (List<Admin>)session.createQuery(sql).list();
		 
		tx.commit();
		return list;
	}
	
	//获取指定ID的实体Bean
	public Admin GetBean(int id){
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		Admin admin = (Admin) session.get(Admin.class, id);
		tx.commit();
		return admin;
	}
	
	//添加
	public void Add(Admin cnbean){
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		session.save(cnbean);
		tx.commit();
		
	}
	//修改
	public void Update(Admin cnbean){
		
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		session.update(cnbean);
		tx.commit();
		
	}
	//删除
	public void Delete(String strwhere){
		String sql="delete Admin where ";
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

