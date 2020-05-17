package controller.businesslogic;

import java.lang.reflect.Method;
import java.util.List;

public class GetDataFromDatalink {

    public List<String> getData(){
    	System.out.println("GetDataFromDatalink will call proxy class based upon run time.");
        try {
            Class<?> clazz = Class.forName("controller.businesslogic.GetDataFromDatalinkProxy");
            Object proxyClassObject = clazz.getConstructor().newInstance();
            Method proxyClassMethod = clazz.getMethod("getData");
            List<String> proxyOutput = (List) proxyClassMethod.invoke(proxyClassObject);
            return proxyOutput;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
