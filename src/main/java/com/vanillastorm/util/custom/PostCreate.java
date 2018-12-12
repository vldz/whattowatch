package com.vanillastorm.util.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD) //аннотацию можно повесить на метод
@Retention(value = RetentionPolicy.RUNTIME) // аннотация будет доступна в процессе работы приложения
public @interface PostCreate {

}
