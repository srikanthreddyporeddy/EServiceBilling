package com.uhg.esbdb.datadeliverybatch.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void mailSent()
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/uhg/esbdb/datadeliverybatch/configs/Spring-Mail.xml");
    	 
    	MailMail mm = (MailMail) context.getBean("mailMail");
        mm.sendMail("Ashlesha Reddy", "BE111 Limited file information");
        System.out.println("mail sent");
    }
}
