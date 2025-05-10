package in.prec.springcore.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.prec.springcore.di.beans.Car;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context=new ClassPathXmlApplicationContext("context.xml");
    	Car car=context.getBean(Car.class);
    	
//    	car.setManufacturer("Honda");
    	System.out.println(car);
    }
}
