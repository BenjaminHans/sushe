package com.dao;

import com.bean.Student;
import com.db.HibernateUtil;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class StudentDao {
	
	//��֤��¼
	public String CheckLogin(String username, String password){
		String id = null;
		String sql="select s.student_ID from Student s where s.student_Username = ? and s.student_Password=? and Student_State='��ס'";
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		List li=session.createQuery(sql).setParameter(0, username).setParameter(1, password).list();
		id = (Integer) li.get(0)+"";
		tx.commit();
		return id;
	}
	//��֤����
	public boolean CheckPassword(String id, String password){
		boolean ps = false;
		String sql="from Student s where s.student_ID = ? and s.student_Password = ?";
		Integer id_integer = Integer.valueOf(id);
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();  
		List li =session.createQuery(sql).setParameter(0, id_integer).setParameter(1, password).list();
		if(li.iterator().hasNext()){
				ps=true;
		}
		tx.commit();
		return ps;
	}
	//��ȡ�����б�
	public List<Student> GetAllList(String strwhere,String strorder){
		String sql="from Student";
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
		List<Student> list = (List<Student>)session.createQuery(sql).list();
		tx.commit();
		return list;
	}
	//��ȡ�б�
	public List<Student> GetList(String strwhere,String strorder){
		String sql="select * from Student,Domitory,Building where Student_DomitoryID=Domitory_ID and Domitory_BuildingID=Building_ID";
		if(!(isInvalid(strwhere)))
		{
			sql+=" and "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		List<Student> list = (List<Student>)session.createQuery(sql).list();
		tx.commit();
		return list;

	}
	//��ȡָ��ID��ʵ��Bean
	public Student GetAllFirstBean(String strwhere){
		String sql="from Student where "+strwhere;
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		Student student = (Student) session.createQuery(sql).uniqueResult();
		tx.commit();
		return student;
	}
	//��ȡָ��ID��ʵ��Bean
	public Student GetFirstBean(String strwhere){
		String sql="from Student,Domitory,Building where Student_DomitoryID=Domitory_ID and Domitory_BuildingID=Building_ID and "+strwhere;
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		Student student = (Student) session.createQuery(sql).uniqueResult();
		tx.commit();
		return student;
	}
	//��ȡָ��ID��ʵ��Bean
	public Student GetAllBean(int id){
		String sql="select * from Student where Student_ID="+id;
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		Student cnbean = (Student) session.createQuery(sql).uniqueResult();
		tx.commit();
		return cnbean;
	}
	//��ȡָ��ID��ʵ��Bean
	public Student GetBean(int id){
		String sql="from Student,Domitory,Building where Student_DomitoryID=Domitory_ID and Domitory_BuildingID=Building_ID and Student_ID="+id;
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		Student cnbean = (Student) session.createQuery(sql).uniqueResult();
		tx.commit();
		return cnbean;
	}
	
	//���
	public void Add(Student cnbean){
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		session.save(cnbean);
		tx.commit();
	}
	//�޸�
	public void Update(Student cnbean){
		Session session = HibernateUtil.currentSession(); 
		Transaction tx = session.beginTransaction();  
		session.update(cnbean);
		tx.commit();
	}
	//ɾ��
	public void Delete(String strwhere){
		String sql="delete Student where ";
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

