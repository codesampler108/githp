package services;

import mylib.HelloWorld;
import mylib.NewModel;

public class LibUserProxy {

    public LibUserProxy(){
    }

    public Object doSomething() {
        HelloWorld helloWorld = new HelloWorld();
        NewModel newModel = helloWorld.doSomething();
        return newModel;
    }
}
