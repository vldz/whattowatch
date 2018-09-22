package com.vanillastorm.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

public class JavaApplicationContext {
    private Config config = new JavaConfig();
    private Map<String, Object> pool = new HashMap<>();

    public Object getBean(String objectName) throws IllegalAccessException, InstantiationException, InvocationTargetException { // bean == component

        Class<Object> impl = config.<Object>getImpl(objectName);
        Constructor<?> constructor = impl.getConstructors()[0];

        if (constructor.getParameterCount() > 0) {

            Parameter[] parameters = constructor.getParameters();
            Object[] initArgs = new Object[parameters.length];

            for (int i = 0; i < parameters.length; i++) {
                Parameter param = parameters[i];
                String typeName = param.getType().getSimpleName();
                typeName = Character.toLowerCase(typeName.charAt(0)) + typeName.substring(1);
                System.out.println(typeName);

                if (pool.get(typeName) != null) {
                    initArgs[i] = pool.get(typeName);
                } else {
                    initArgs[i] = getBean(typeName);
                    pool.put(typeName, initArgs[i]);
                }
                System.out.println(initArgs[i]);
            }

            Object bean = constructor.newInstance(initArgs);
            Class<?> clazz = bean.getClass();
            Method method;

            try {
                method = clazz.getMethod("postCreate");
                method.invoke(bean);
            } catch (Exception e) {
                // e.getMessage();
            }

            try {
                Method[] methods = clazz.getMethods();
                for (int i = 0; i < methods.length; i++) {
                    Method currMethod = methods[i];
                    if (!currMethod.getName().equals("postCreate") && currMethod.isAnnotationPresent(PostCreate.class)) { // подгружать метод с определенной аннотацией
                        currMethod.invoke(bean);
                    }
                }
            } catch (Exception e) {
                // e.getMessage();
            }

            return bean;

        } else {

            return impl.newInstance();
        }
    }
}
