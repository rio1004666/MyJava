package com.javastudy.statictest;

public class FavoriteCoffee {
	static String coffee ="아메리카노";
	public static void main(String[] args) {
		FavoriteCoffee kate = new FavoriteCoffee();
		FavoriteCoffee kevin = new FavoriteCoffee();
		
		System.out.println("kate가 좋아하는 커피:" + kate.coffee);
		System.out.println("kevin이 좋아하는 커피:" + kevin.coffee);
		
		// static변수는 공용이므로 변경하면 
		// 모든 객체는 같은 static변수를 참조하므로 
		// 전부 바뀐채로 참조해서 값을 얻게 된다. 
		
		kate.coffee = "라떼";
		System.out.println("kate가 좋아하는 커피:"+ kate.coffee);
		System.out.println("kevin이 좋아하는 커피:" + kevin.coffee);
				
	}
}
