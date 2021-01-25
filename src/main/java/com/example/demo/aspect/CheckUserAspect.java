package com.example.demo.aspect;

import com.example.demo.service.CheckUserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect //表示是切面
@Component
public class CheckUserAspect {

    @Autowired
    private CheckUserService checkUserService;

//    @Pointcut("execution(* com.example.demo.service.*(..))") //定义一个切点，表示再该文件下任意输入参数、任意返回值的任意方法，都进行拦截
    @Pointcut("@annotation(com.example.demo.anotation.AdminOnly)") //定义一个切点,表示使用了AdminOnly注解的方法，都进行拦截
    public void checkAdmin(){

    }

    @Before("checkAdmin()")
    public void check1() throws Exception{
        System.out.println("----前置通知1-----");
        checkUserService.check();//如果抛出异常，则不会执行后续的前置通知
    }

    @Before("checkAdmin()")
    public void check2(JoinPoint joinPoint) throws Exception{
        // joinPoint 会打印出切入点，即被拦截到的方法
        System.out.println("----前置通知2-----"+joinPoint);
    }


    //如果被拦截的方法抛出异常，则不执行该方法
    @AfterReturning("checkAdmin()")
    public void check3(JoinPoint joinPoint) throws Exception{
        // joinPoint 会打印出切入点，即被拦截到的方法
        System.out.println("----返回通知-----"+joinPoint);
    }


    //如果被拦截的方法完成，无论是否正常执行，都会执行该方法
    @After("checkAdmin()")
    public void check4(JoinPoint joinPoint) throws Exception{
        // joinPoint 会打印出切入点，即被拦截到的方法
        System.out.println("----后置通知-----"+joinPoint);
    }

    //如果被拦截的方法抛出异常，则执行该方法
    @AfterThrowing("checkAdmin()")
    public void check5(JoinPoint joinPoint) throws Exception{
        // joinPoint 会打印出切入点，即被拦截到的方法
        System.out.println("----异常通知-----"+joinPoint);
    }


    //环绕通知
    @Around("checkAdmin()")
    public Object check6(ProceedingJoinPoint joinPoint) throws Throwable {
        // 环绕通知前
        System.out.println("----环绕通知前-----"+joinPoint);
        String s = "";
        char charAt = s.charAt(i);
        StringBuffer sb = new StringBuffer("");
        charAt!=' ';
        //需要手动调用下方法,如果被拦截的方法，则不执行环绕通知后的代码
        Object proceed = joinPoint.proceed();
        System.out.println("----环绕通知后-----"+joinPoint);
        return proceed;

    }



}
