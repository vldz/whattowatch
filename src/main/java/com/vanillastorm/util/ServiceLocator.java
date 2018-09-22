package com.vanillastorm.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class ServiceLocator {
    private Config config = new JavaConfig();

    public Object createObject(String objectName) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<Object> impl = config.<Object>getImpl(objectName);
        Constructor<?> constructor = impl.getConstructors()[0];
        if (constructor.getParameterCount() > 0) {
            Parameter param = constructor.getParameters()[0];
            String typeName = param.getType().getSimpleName();
            typeName = Character.toLowerCase(typeName.charAt(0)) + typeName.substring(1);
            Object constructorParam = createObject(typeName);
            return constructor.newInstance(new Object[] {constructorParam});
        } else {
            return impl.newInstance();
        }
    }
}
