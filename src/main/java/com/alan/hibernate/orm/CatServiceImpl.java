package com.alan.hibernate.orm;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatServiceImpl implements ICatService {
    private static Logger logger = LoggerFactory.getLogger(CatServiceImpl.class);

    private ICatDao catDao;

    public ICatDao getCatDao() {
        return catDao;
    }

    public void setCatDao(ICatDao catDao) {
        this.catDao = catDao;
    }

    public void createCat(Cat cat) {

        if (catDao.findCatByName(cat.getName()) != null)
            throw new RuntimeException("è" + cat.getName() + "�Ѿ����ڡ�");

        catDao.createCat(cat);
    }

    public long getCatsCount() {
        long total = catDao.getCatsCount();

        logger.error("{}cats!", total);

        return total;
    }

    public List<Cat> listCats() {
        List<Cat> catList = catDao.listCats();

        logger.error("Hello,{}", catList);

        return catList;
    }

}
