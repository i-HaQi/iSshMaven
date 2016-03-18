package com.alan.hibernate.orm;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.util.Date;
import java.util.List;
public class OrmRun {

    private static Logger logger  =  LoggerFactory.getLogger(OrmRun.class);

    public static void main(String[] args) {

        logger.error("Hello，{}——{}","阿澜","To Be The One!");

        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
                "applicationContext.xml"));

        ICatService catService = (ICatService) factory.getBean("catService");


        Cat cat1 = new Cat();
        cat1.setName("Hello world");
        cat1.setCreatedDate(new Date());
        catService.createCat(cat1);

        Cat cat2 = new Cat();
        cat2.setName("你好 阿哲");
        cat2.setCreatedDate(new Date());
        catService.createCat(cat2);

        Cat cat3 = new Cat();
        cat3.setName("我的天哪");
        cat3.setCreatedDate(new Date());
        catService.createCat(cat3);

        List<Cat> catList = catService.listCats();

        for (Cat c : catList) {
            System.out.println("Name: " + c.getName());

        }

    }

}
