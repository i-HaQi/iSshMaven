package com.alan.hibernate.orm;

import java.util.List;

public interface ICatService {

	public void createCat(Cat cat);

	public List<Cat> listCats();

	public long getCatsCount();

}
