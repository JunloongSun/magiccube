package org.fdh.cube;

import java.lang.reflect.Field;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Person{
    
    
    public static void main(String[] args) {
        
        Person person2=new Person();
        System.out.println(person2.hashCode());
        Person person1=new Person();
        System.out.println(person1.hashCode());
    }
     
}
