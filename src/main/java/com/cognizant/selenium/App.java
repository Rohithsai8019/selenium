package com.cognizant.selenium;

class Animal{
	
	String name;
	String breed;
	
	Animal(){
		name = "horse";
	}
	Animal(String name,String breed){
		this.name = name;
		this.breed= breed;
	}
}
	
class Dog extends Animal{
	Dog(String name, String breed){
	super(name ,breed);
	
	}
	void display() {
		System.out.println(name);
	}
}



public class App {
    public static void main(String[] args) {
    	
    	Dog a = new Dog("dog","unknown");
    	System.out.println(a.name);
    	
    }
}
