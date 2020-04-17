package cn.ximoon.framework.db;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 表注解
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {

    /**
     * 设置表名
     */
    String name() default "";

    /**
     * 是否所有属性建表列
     * @return
     */
    boolean all() default false;

}