import mylib.HelloWorld;
import mylib.MyModel;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LibUserProxy {

    public LibUserProxy(){
    }

    public Object doSomething() {
        HelloWorld helloWorld = new HelloWorld();
        MyModel myModel = helloWorld.doSomething();
        return myModel;
    }
}
