package com.javastudy.statictest;

public class RectangleExWidthFunc {

}

class Rectangle2{
	String name;
	int width2 = 10;
	int height2 = 30;
	public int totalArea() {
		return width2 * height2;
	}
	public static int totalArea2() {
		
		//return width2 * height2; //�ν��Ͻ� ������ ��ü�� �����ؾ߸� ���������ϹǷ�
		// static�޼���� ��ü �������� ��밡���ϹǷ� �ȵȴ�
		// ���� �ν��Ͻ��� �������� ��쿡�� ������ �����ϰ�����, �װ��� ���������� ���ϹǷ� �ƿ� ��������.
		return 0; 
	}
	// �׷��� ���ο� �ִ� ������ ������� ���ϰ� �μ��� �����͸� 
    // �Ѱ� �޾Ƽ� ����ؾ��ϴ� ���̴�.
	// �׷��� �����̶� ������ �ø��� ���� ���� ����ϴ� ��ƿ �ҽ��� ���� �̿�
	public static int staticTotalArea(int width, int height) {
		return width * height;
	}
	
}