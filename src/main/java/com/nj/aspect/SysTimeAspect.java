package com.nj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Observable;

@Aspect
@Component
public class SysTimeAspect {
    /**
     * 切入点
     */
    @Pointcut("bean(DeviceMapper)")
    public void doTime(){}

    @Before("doTime()")
    public void doBefore(JoinPoint jp){
        System.out.println("time doBefore()");
    }
    @After("doTime()")
    public void doAfter(){//类似于finally{}代码块
        System.out.println("time doAfter()");
    }
    /**核心业务正常结束时执行
     * 说明：假如有after，先执行after,再执行returning*/
    @AfterReturning("doTime()")
    public void doAfterReturning(){
        System.out.println("time doAfterReturning");
    }
    /**核心业务出现异常时执行
     * 说明：假如有after，先执行after,再执行Throwing*/
    @AfterThrowing("doTime()")
    public void doAfterThrowing(){
        System.out.println("time doAfterThrowing");
    }
    @Around("doTime()")
    public Object doAround(ProceedingJoinPoint jp)
            throws Throwable{
        System.out.println("doAround.before");
        try {
            Object obj=jp.proceed();
            return obj;
        }catch(Throwable e) {
            System.out.println("doAround.error-->"+e.getMessage());
            throw e;
        }finally {
            System.out.println("doAround.after");
        }

    }
}
