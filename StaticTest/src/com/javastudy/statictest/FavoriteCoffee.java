package com.javastudy.statictest;

public class FavoriteCoffee {
	static String coffee ="�Ƹ޸�ī��";
	public static void main(String[] args) {
		FavoriteCoffee kate = new FavoriteCoffee();
		FavoriteCoffee kevin = new FavoriteCoffee();
		
		System.out.println("kate�� �����ϴ� Ŀ��:" + kate.coffee);
		System.out.println("kevin�� �����ϴ� Ŀ��:" + kevin.coffee);
		
		// static������ �����̹Ƿ� �����ϸ� 
		// ��� ��ü�� ���� static������ �����ϹǷ� 
		// ���� �ٲ�ä�� �����ؼ� ���� ��� �ȴ�. 
		
		kate.coffee = "��";
		System.out.println("kate�� �����ϴ� Ŀ��:"+ kate.coffee);
		System.out.println("kevin�� �����ϴ� Ŀ��:" + kevin.coffee);
				
	}
}
