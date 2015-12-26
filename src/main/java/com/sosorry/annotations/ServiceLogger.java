package com.sosorry.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ServiceLogger {
/*
 * This is just a marker annotation for aop logging purpose.
 * Instead of loading a heavy aspect Loggable package just creating mine.
 * 
 * */
}
