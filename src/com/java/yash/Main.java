package com.java.yash;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1 :  GK");
		System.out.println("2 :  DBMS");
		System.out.println("Enter 1 to take GK test");
		Scanner sc = new Scanner(System.in);
		
		ReadingXml data = new ReadingXml();
		
		int subject = sc.nextInt();
		if(subject==1) {
			System.out.print(data.readGKXML());
		}else {
			System.out.println("no data of this type");
		}
		
		
		

	}

}
