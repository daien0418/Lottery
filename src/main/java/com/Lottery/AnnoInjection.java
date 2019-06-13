package com.Lottery;

import java.beans.MethodDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnoInjection {

    public static Object inject(Object obj) throws IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException {

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            Dai dai = field.getAnnotation(Dai.class);
            if (dai != null) {
                System.out.println("Field-'" + field.getName() + "'-injected with value of " + dai.name());
                obj.getClass()
                        .getMethod("set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1),
                                new Class[] { String.class })
                        .invoke(obj, dai.name());
            }
        }

        Method[] methods = obj.getClass().getDeclaredMethods();
        for (Method method : methods) {
            Dai dai = method.getAnnotation(Dai.class);
            if (dai != null) {
                System.out.println("Method-'" + method.getName() + "'-injected with value of " + dai.name());
                method.invoke(obj, dai.name());
            }
        }

        return obj;
    }

}
