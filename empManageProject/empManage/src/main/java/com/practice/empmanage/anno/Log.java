package com.practice.empmanage.anno;

import java.lang.annotation.*;

/**
 * @author wusiyu
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
}
