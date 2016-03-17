package com.alan.hibernate.orm;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class CatDaoImpl extends HibernateDaoSupport implements ICatDao {

	public void createCat(Cat cat) {
		this.getHibernateTemplate().persist(cat);
	}

	public Cat findCatByName(String name) {
		List<Cat> catList = this.getHibernateTemplate().find(
				" select c from Cat c where c.name = ? ", name);
		if (catList.size() > 0)
			return catList.get(0);
		return null;
	}

	public long getCatsCount() {
		return (Long) this.getSession(true).createQuery(
				" select count(c) from Cat c ").uniqueResult();
	}

	public List<Cat> listCats() {
		return this.getHibernateTemplate().find(" select c from Cat c ");
	}

}
