package com.AOC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

    @Value(value="小红")
    private String name;

    @Autowired
    private Homework homework;

    public Student(){}
    public Student(String name, Homework homework) {
        this.name = name;
        this.homework = homework;
    }

    public void doHomeWork(){
        System.out.println(homework.getContent());
    }

    public void doHomeWork2(){
        System.out.println("do homework2");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }
}
