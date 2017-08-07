package org.slingerxv.recorder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类对应表检查
 * 
 * @author hank
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableCheck {
	/**
	 * 表名
	 * 
	 * @return
	 */
	String value() default "";

	String[] shardingList();

	String charset() default "utf-8";
}