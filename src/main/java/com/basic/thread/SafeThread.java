package com.basic.thread;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author htj
 * @since 2019/6/6 10:02
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE})
public @interface SafeThread {}
