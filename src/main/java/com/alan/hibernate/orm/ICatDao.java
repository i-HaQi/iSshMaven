package com.alan.hibernate.orm;

import java.util.List;

public interface ICatDao {

	public void createCat(Cat cat);

	public Cat findCatByName(String name);

	public List<Cat> listCats();

	public long getCatsCount();

}
