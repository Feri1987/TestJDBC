package net.jnile;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Application {

    public static void main(String[] args) {

        ClassPathResource res = new ClassPathResource("applicationContext.xml");
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(res);


        ContactDao dao = (ContactDao) xmlBeanFactory.getBean("contactDao");

        Contact contact = dao.getContactById(2);

        System.out.println(contact);


    }
}
