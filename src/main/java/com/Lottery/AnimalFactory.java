package com.Lottery;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AnimalFactory {

    public static Animal getAnimal(Class<? extends Animal> clazz)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        final Animal obj = clazz.newInstance();
        AnnoInjection.inject(obj);
        Animal retAnimal = (Animal) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] { Animal.class },
                new InvocationHandler() {

                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object ret;
                        if(method.getName().equals("getName")){
                            System.out.println("filter");
                        }
                        ret = method.invoke(obj, args);
                        return ret;
                    }
                });
        return retAnimal;
    }

}
