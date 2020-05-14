package com.AOC;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student student = context.getBean(Student.class);
        System.out.println(student.getName()+"准备做作业了");
        student.doHomeWork();
        student.doHomeWork2();
        context.close();

    }
}

