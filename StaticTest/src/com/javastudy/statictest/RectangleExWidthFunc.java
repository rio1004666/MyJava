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
		
		//return width2 * height2; //인스턴스 변수는 객체를 생성해야만 참조가능하므로
		// static메서드는 객체 생성없이 사용가능하므로 안된다
		// 물론 인스턴스를 생성했을 경우에는 참조가 가능하겠지만, 그것을 예측하지는 못하므로 아예 에러난다.
		return 0; 
	}
	// 그래서 내부에 있는 변수를 사용하지 못하고 인수로 데이터를 
    // 넘겨 받아서 계산해야하는 것이다.
	// 그래서 조금이라도 성능을 올리기 위해 자주 사용하는 유틸 소스에 많이 이용
	public static int staticTotalArea(int width, int height) {
		return width * height;
	}
	
}