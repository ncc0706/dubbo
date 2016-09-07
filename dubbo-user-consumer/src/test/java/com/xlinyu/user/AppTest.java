package com.xlinyu.user;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xlinyu.user.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:dubbo-consumer.xml"})
public class AppTest extends TestCase {
	
	@Resource
    private IUserService helloService;

    @Test
    public void helloWorld() {

        String message = helloService.sayHello(" 嗨美女, I'am coming....");

        System.out.println(message);
    }
}
