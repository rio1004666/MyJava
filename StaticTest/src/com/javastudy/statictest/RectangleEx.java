package com.javastudy.statictest;

public class RectangleEx {
	public static void main(String[] args) {
		System.out.println("Rectangle ���� ��");
		System.out.println("����(width):"+ Rectangle.width);
		System.out.println("����(height):"+ Rectangle.height);
		Rectangle r1 = new Rectangle();
		r1.name = "book";
		Rectangle r2 = new Rectangle();
		r2.name = "phone";
		System.out.println("\n �ν��Ͻ� r1,r2�� name,width,height");
		System.out.println("r1:" + r1.name +"/"+r1.width + "/" + r1.height);
		System.out.println("r2:" + r2.name +"/"+r2.width + "/" + r2.height);
		System.out.println("\n�ν��Ͻ� r1�� name,width,height�����ϸ�");
		// r1�� �ν��Ͻ� ������ r1�� �ٲ��
		// r2�� �ν��Ͻ� ������ static������ �ƴϹǷ� �ٲ��� �ʴ´�.
		// ������ r2�� static������ ���� �ٲ��. 
		r1.name = "table";
		r1.width = 50;
		r1.height = 50;
		System.out.println("�ν��Ͻ� r1,r2�� name,width,height");
		System.out.println("r1:" + r1.name + "/"+ r1.width+"/"+r1.height);
		System.out.println("r2:" + r2.name + "/"+ r2.width+"/"+r2.height);
	}
}
class Rectangle{
	public String name;
	static int width = 100;
	static int height = 200;
}