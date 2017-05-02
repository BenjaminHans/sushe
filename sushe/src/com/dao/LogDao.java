package com.dao;

import com.db.HibernateUtil;
import com.bean.Admin;
import com.bean.Log;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class LogDao {

	// ��ȡ�б�
	public List<Log> GetList(String strwhere, String strorder) {
		String sql = "from Log,Teacher,Student,Domitory,Building where log_TeacherID=teacher_ID and log_StudentID=student_ID and student_DomitoryID=domitory_ID and domitory_BuildingID=building_ID";
		if (!(isInvalid(strwhere))) {
			sql += " and " + strwhere;
		}
		if (!(isInvalid(strorder))) {
			sql += " order by " + strorder;
		}
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		List<Log> list = (List<Log>) session.createQuery(sql).list();
		tx.commit();
		return list;
	}

	// ��ȡָ��ID��ʵ��Bean
	public Log GetBean(int id) {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		Log cnbean = (Log) session.get(Log.class, id);
		tx.commit();
		return cnbean;
	}

	// ���
	public void Add(Log cnbean) {

		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.save(cnbean);
		tx.commit();
	}

	// �޸�
	public void Update(Log cnbean) {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.update(cnbean);
		tx.commit();
	}

	// ɾ��
	public void Delete(String strwhere) {
		String sql = "delete Log where ";
		sql += strwhere;
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.createQuery(sql).executeUpdate();
		tx.commit();
	}

	// �ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	// ����
	public static void main(String[] args) {
		System.out.println("");
	}

}
