package util;

import ch.qos.logback.core.net.SyslogOutputStream;

public class Text {
	Animal animal = new Animal();
	String s = "lj";
	int c = 23;
	{
		c = 90;
		String s = "sdf";
		Animal animal = new Animal();
		System.out.println("this is a method squra");
		animal.name();
	}

	public Text() {
		System.out.println("this is text");
	}

	public static void main(String[] args){
		Text text = new Text();
		Text text1 = new Text();
		text.animal.name();
		System.out.println("c"+text.c);
	}

	private final void get(int i){

	}
	public void get(){}


}