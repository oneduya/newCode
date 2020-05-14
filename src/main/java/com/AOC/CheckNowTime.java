package com.AOC;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class CheckNowTime {

    @Pointcut("execution(* *.doHomeWork*(..))")
    public void point(){}

    @Before("point()")
    public void beforDoHomework(){
        System.out.println(new Date(System.currentTimeMillis()));
    }
}
