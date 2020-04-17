package cn.ximoon.framework.db;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 列注解
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {

    /**
     * 数据库列名
     * @return
     */
    String name() default "";

    /**
     * 是否主键
     * @return
     */
    boolean primaryKey() default false;

    /**
     * 是否唯一约束
     * @return
     */
    boolean unique() default false;

}