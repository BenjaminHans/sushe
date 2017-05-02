package com.dao;

import com.db.HibernateUtil;
import com.bean.Teacher;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TeacherDao {

	// ��֤��¼
	public String CheckLogin(String username, String password) {
		String id = null;
		String sql = "select t.teacher_ID from Teacher t where t.teacher_Username=? and t.teacher_Password=?";
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		List li = session.createQuery(sql).setParameter(0, username).setParameter(1, password).list();
		id = (Integer) li.get(0) + "";
		tx.commit();
		return id;
	}

	// ��֤����
	public boolean CheckPassword(String id, String password) {
		boolean ps = false;
		String sql = "from Teacher t where t.teacher_ID = ? and t.teacher_Password = ?";
		Integer id_integer = Integer.valueOf(id);
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		List li = session.createQuery(sql).setParameter(0, id_integer).setParameter(1, password).list();
		if (li.iterator().hasNext()) {
			ps = true;
		}
		tx.commit();
		return ps;
	}

	// ��ȡ�б�
	public List<Teacher> GetList(String strwhere, String strorder) {
		String sql = "from Teacher";
		if (!(isInvalid(strwhere))) {
			sql += " where " + strwhere;
		}
		if (!(isInvalid(strorder))) {
			sql += " order by " + strorder;
		}
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		List<Teacher> list = (List<Teacher>) session.createQuery(sql).list();
		tx.commit();
		return list;
	}

	// ��ȡָ��ID��ʵ��Bean
	public Teacher GetBean(int id) {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		Teacher cnbean = (Teacher) session.get(Teacher.class, id);
		tx.commit();
		return cnbean;
	}

	// ���
	public void Add(Teacher cnbean) {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.save(cnbean);
		tx.commit();
	}

	// �޸�
	public void Update(Teacher cnbean) {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.update(cnbean);
		tx.commit();
	}

	// ɾ��
	public void Delete(String strwhere) {
		String sql = "delete Student where ";
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
