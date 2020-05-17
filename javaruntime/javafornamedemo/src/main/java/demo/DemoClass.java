package demo;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

public class DemoClass {

	public static void main(String[] args) {
		System.out.println("Running DemoClass");
		DemoClass dc = new DemoClass();
		printjvmarguments();
		printclasspath();
		dc.doit();
	}

	private static void printjvmarguments() {
		System.out.println("Print jvm args");
		RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
		List<String> arguments = runtimeMxBean.getInputArguments();
		arguments.forEach(x->System.out.println(x));
	}

	private static void printclasspath() {
		System.out.println("print classpath");
		ClassLoader cl = ClassLoader.getSystemClassLoader();

		URL[] urls = ((URLClassLoader) cl).getURLs();

		for (URL url : urls) {
			System.out.println(url.getFile());
		}

	}

	public void doit() {
		System.out.println("print methods SomeClass");
		try {
			Class<?> clazz = Class.forName("SomeClass");
			Method[] declaredMethods = clazz.getDeclaredMethods();
			for (Method m : declaredMethods) {
				System.out.println("Method name:"+m.getName());
			}
			Object newInstance = clazz.getConstructor().newInstance();
			Method method = clazz.getMethod("doSomething");
			method.invoke(newInstance);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
