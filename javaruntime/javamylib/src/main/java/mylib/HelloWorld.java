package mylib;

public class HelloWorld {

	public MyModel doSomething() {
		System.out.println(this.getClass().getName()+":doSomething executed");
		return new MyModel();
	}
}
