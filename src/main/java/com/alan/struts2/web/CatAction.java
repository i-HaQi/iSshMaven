package com.alan.struts2.web;

import com.alan.hibernate.orm.Cat;
import com.alan.hibernate.orm.ICatDao;
import com.alan.hibernate.orm.ICatService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CatAction {

	private ICatService catService;

	private Cat cat;

	private List<Cat> catList = new ArrayList<Cat>();

	public String add() {

		cat.setCreatedDate(new Date());
		
		catService.createCat(cat);

		return list();
	}

	public String list() {

		catList = catService.listCats();

		return "list";
	}

	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}

	public List<Cat> getCatList() {
		return catList;
	}

	public void setCatList(List<Cat> catList) {
		this.catList = catList;
	}

	public ICatService getCatService() {
		return catService;
	}

	public void setCatService(ICatService catService) {
		this.catService = catService;
	}
}
