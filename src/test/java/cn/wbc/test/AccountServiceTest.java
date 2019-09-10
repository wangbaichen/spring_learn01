package cn.wbc.test;

import cn.wbc.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用单元测试，测试我们的配置
 */
public class AccountServiceTest {
    @Test
    public void testFindAll(){
        //1.获取容器
        ApplicationContext ac
                = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取业务层对象
        IAccountService as
                = ac.getBean("accountService", IAccountService.class);
        //3.执行方法
    }

    @Test
    public void testFindOne(){

    }

    @Test
    public void testSave(){

    }

    @Test
    public void testUpdate(){

    }


    @Test
    public void testDelete(){

    }




}
