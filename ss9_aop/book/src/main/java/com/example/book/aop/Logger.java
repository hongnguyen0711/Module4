package com.example.book.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    public static int count = 0;

    @After("execution(* com.example.book.controller..*.*(..))")
    public void count(JoinPoint joinPoint) {
        count++;
        System.out.println("số lần truy cập " + count);
    }

    @Around("execution(* com.example.book.controller..*.*(..))")
    public Object count(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("Trước khi Thực Hiên");
        Object object = proceedingJoinPoint.getArgs();
        System.out.println("Sau Khi Thực Hiện");
        return object;
    }
}
