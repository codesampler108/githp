package services;

import common.Controller;
import mylib.HelloWorld;

public class Serviceone {
    public static void main(String[] args) {
        Serviceone serviceone = new Serviceone();
        try {
            serviceone.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void execute()  {
        // library is visible here
        /*HelloWorld helloWorld = new HelloWorld();
        helloWorld.doSomething();
        */

        Controller controller =new Controller();
        Object response = controller.service();
        System.out.println("response:"+response.getClass().getCanonicalName());
    }
}
