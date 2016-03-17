/**
 * Created by i-lan on 16/3/11.
 */

import com.alan.hibernate.orm.Cat;
import com.alan.hibernate.orm.ICatService;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ServiceImplTest {

    @Resource
    private ICatService catService;

    long startMili;// 当前时间对应的毫秒数
    long endMili;

    @Before
    public void setUp() throws Exception {
        startMili = System.currentTimeMillis();// 当前时间对应的毫秒数
        System.out.println("方法开始!");
    }

    @After
    public void tearDown() throws Exception {
        endMili = System.currentTimeMillis();// 当前时间对应的毫秒数
        long time = endMili - startMili;
        System.out.println("方法结束,耗时：" + time);
    }

    @Test
    public void testService() throws Exception {
        Cat cat1 = new Cat();
        cat1.setName("Hello world");
        cat1.setCreatedDate(new Date());
        catService.createCat(cat1);

        Cat cat2 = new Cat();
        cat2.setName("喵喵");
        cat2.setCreatedDate(new Date());
        catService.createCat(cat2);

        Cat cat3 = new Cat();
        cat3.setName("汪汪");
        cat3.setCreatedDate(new Date());
        catService.createCat(cat3);
        System.out.println(catService.getCatsCount());

        assertEquals(3,catService.getCatsCount());
    }

    @Test
    public void testJust() throws Exception {
        System.out.println("ToBeOne");
        Thread.sleep(1000);
    }
}