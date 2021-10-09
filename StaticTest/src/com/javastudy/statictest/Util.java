package com.javastudy.statictest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	// 객체 생성없이 바로 현재 날짜를 구할것이다. 
	public static String getCurrentDate(String fmt) {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		return sdf.format(new Date());
	}
	
	public static void main(String[] args) {
		System.out.println(Util.getCurrentDate("yyyy-MM-dd"));
	}
	// 1. 클래스 설계시 멤버 변수 중 모든 인스턴스에 공통적으로 사용해야하는 것에 static을 붙인다.
	
	// 인스턴스를 생성하게 되면서 각 인스턴스들을 서로 독립적이기 때문에 서로 다른 값을 유지한다.
	// 하지만 인스턴스들이 공통적으로 같은 값을 유지해야하는 경우 static을 붙이면 관리가 편리하다.
	
	// 2. static이 붙은 멤버변수는 인스턴스를 생성하지 않아도 사용할 수 있다.
	
	// static이 붙은 멤버변수(클래스 변수)는 클래스가 메모리에 올라갈 때 이미 자동적으로 생성되기 때문이다.
	
	// 3. static이 붙은 함수에서는 인스턴스 변수를 사용할 수 없다. 
	
	// static이 붙은 함수는 인스턴스 생성없이 호출가능한 반면, 인스턴스 변수는 인스턴스를 생성해야만 존재한다
	// 그러므로 static이 붙은 함수를 호출할 때 인스턴스가 생성되어 있을 수도, 그렇지 않을 수도 있다. 
	// 그래도 허용하지 않는다. 
	// 반대로 인스턴수 변수나 인스턴스 함수에서는 static이 붙은 멤버들을 사용하는 것이 언제나 가능하다.
	// 인스턴스 변수가 존재한다는 것은 static변수도 이미 메모리에 존재한다는 것을 의미 
	
	// 4. 함수내에서 인스턴스 변수를 사용하지 않는다면, static을 붙이는 것을 고려한다.
	
	// 함수의 작업 내용중에서 인스턴스 변수를 필요로 한다면, static을 붙일 수 없다.
	// 반대로 인스턴스 변수를 필요로 하지 않는다면, 가능하면 static을 붙이는 것이 좋다. 
	// 함수 호출시간이 짧아지기 떄문에 효율이 높아진다.
	// static을 안붙인 함수는 실행시 호출되어야할 함수를 찾는 과정이 추가적으로 필요하기 때문에 시간이 더 걸린다. 
}
