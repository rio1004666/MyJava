package com.javastudy.statictest;

public class RectangleEx {
	public static void main(String[] args) {
		System.out.println("Rectangle 변경 전");
		System.out.println("가로(width):"+ Rectangle.width);
		System.out.println("세로(height):"+ Rectangle.height);
		Rectangle r1 = new Rectangle();
		r1.name = "book";
		Rectangle r2 = new Rectangle();
		r2.name = "phone";
		System.out.println("\n 인스턴스 r1,r2의 name,width,height");
		System.out.println("r1:" + r1.name +"/"+r1.width + "/" + r1.height);
		System.out.println("r2:" + r2.name +"/"+r2.width + "/" + r2.height);
		System.out.println("\n인스턴스 r1의 name,width,height변경하면");
		// r1의 인스턴스 변수는 r1만 바뀐다
		// r2의 인스턴스 변수는 static변수가 아니므로 바뀌지 않는다.
		// 하지만 r2의 static변수도 같이 바뀐다. 
		r1.name = "table";
		r1.width = 50;
		r1.height = 50;
		System.out.println("인스턴스 r1,r2의 name,width,height");
		System.out.println("r1:" + r1.name + "/"+ r1.width+"/"+r1.height);
		System.out.println("r2:" + r2.name + "/"+ r2.width+"/"+r2.height);
	}
}
class Rectangle{
	public String name;
	static int width = 100;
	static int height = 200;
}