package common;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LibUser {

    private  Object proxyClassObject ;
    private  Method[] proxyClassMethods ;

    private static LibUser instance = new LibUser();
    public static LibUser getInstance() {
        return instance;
    }
    private LibUser(){
        try {
            Class<?> clazz = Class.forName("services.LibUserProxy");
            // note that proxy class is not directly visible in this module
            // but at run time, class loader will have this class
            Constructor<?> constructor = clazz.getConstructor();
            proxyClassObject = constructor.newInstance();
            proxyClassMethods = clazz.getDeclaredMethods();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object doSomething() {
        // pass it to proxy. LibUser has no code of its own
        Object methodOutput = proxyMethodExec("doSomething");
        if (methodOutput != null)
            return methodOutput;
        return null;
    }

    private Object proxyMethodExec(String methodName) {
        try {
            for (Method m : proxyClassMethods) {
                if (m.getName().equals(methodName)) {
                    try {
                        Object methodOutput = m.invoke(proxyClassObject);
                        System.out.println("proxy class method executed:"+methodOutput.getClass().getCanonicalName());
                        return methodOutput;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
