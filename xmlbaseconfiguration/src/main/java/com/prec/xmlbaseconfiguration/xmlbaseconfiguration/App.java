package com.prec.xmlbaseconfiguration.xmlbaseconfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.prec.xmlbaseconfiguration.beans.Car;
import com.prec.xmlbaseconfiguration.beans.Person;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	
//        Car car=context.getBean(Car.class);
////        car.setModel("Swift");
//        Person person=context.getBean("Komal",Person.class);
//        
//        System.out.println(car);
//        System.out.println(person);
        
        Car car =context.getBean(Car.class);
        car.setModel("Honda");
        System.out.println(context.getBean(Person.class));
    }
}
