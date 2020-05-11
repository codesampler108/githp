package common;

public class Controller {
    private LibUser libUser = LibUser.getInstance();

    public Object service(){
        // controller calls other classes for processing.
        // here its calling a class called LibUser
        Object response = libUser.doSomething();
        return response;
    }
}
