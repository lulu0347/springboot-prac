package com.example.demo.constant;

public class KindTest {
	
	public static void main(String[] args) {
		
		ItemKind kind = ItemKind.CELLPHONE;
		String s = kind.name();
		System.out.println(s); //CELLPHONE
		
		String s2 = "OTHERS";
		ItemKind kind2 = ItemKind.valueOf(s2);
		
		
	}
}
