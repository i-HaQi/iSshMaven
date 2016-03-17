package com.alan.hibernate.orm;

import java.util.List;

public class CatServiceImpl implements ICatService {

	private ICatDao catDao;

	public ICatDao getCatDao() {
		return catDao;
	}

	public void setCatDao(ICatDao catDao) {
		this.catDao = catDao;
	}

	public void createCat(Cat cat) {

		if (catDao.findCatByName(cat.getName()) != null)
			throw new RuntimeException("è" + cat.getName() + "�Ѿ����ڡ�" );

		catDao.createCat(cat);
	}

	public long getCatsCount() {
		return catDao.getCatsCount();
	}

	public List<Cat> listCats() {
		return catDao.listCats();
	}

}
