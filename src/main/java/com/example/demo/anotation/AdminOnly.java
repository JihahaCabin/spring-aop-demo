package com.example.demo.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//声明注解进行拦截
@Retention(RetentionPolicy.RUNTIME) // 声明该注解是什么时候使用，此处为运行时使用
@Target(ElementType.METHOD) //声明该注解是在哪里使用
public @interface AdminOnly {

}
