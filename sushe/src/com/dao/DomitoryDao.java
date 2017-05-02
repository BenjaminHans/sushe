package com.dao;

import com.bean.Admin;
import com.bean.Domitory;
import com.db.HibernateUtil;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DomitoryDao {

	// 获取列表
	public List<Domitory> GetList(String strwhere, String strorder) {
		String sql = "from Domitory";
		if (!(isInvalid(strwhere))) {
			sql += " where " + strwhere;
		}
		if (!(isInvalid(strorder))) {
			sql += " order by " + strorder;
		}
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();

		List<Domitory> list = (List<Domitory>) session.createQuery(sql).list();

		tx.commit();
		return list;
	}

	// 获取指定ID的实体Bean
	public Domitory GetBean(int id) {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		Domitory admin = (Domitory) session.get(Domitory.class, id);
		tx.commit();
		return admin;
	}

	// 添加
	public void Add(Domitory cnbean) {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.save(cnbean);
		tx.commit();
	}

	// 修改
	public void Update(Domitory cnbean) {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.update(cnbean);
		tx.commit();
	}

	// 删除
	public void Delete(String strwhere) {
		String sql = "delete Domitory where ";
		sql += strwhere;
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.createQuery(sql).executeUpdate();
		tx.commit();
	}

	// 判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	// 测试
	public static void main(String[] args) {
		System.out.println("");
	}

}
