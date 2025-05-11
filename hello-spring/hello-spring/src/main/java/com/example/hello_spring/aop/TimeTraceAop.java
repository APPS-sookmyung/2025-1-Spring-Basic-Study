package com.example.hello_spring.aop;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TimeTraceAop {

    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START " + joinPoint.toString());
        try {
            return joinPoint.preceed();

        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
