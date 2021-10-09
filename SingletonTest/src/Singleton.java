public class Singleton {
	
	// Eager Initilialization(이른 초기화, Tread-safe)
    // 가장 기본적인 Eager initialization 방식
	// 먼저 클래스 내에 전역변수로 instance 변수를 생성하고 
	// private static을 사용해서 인스턴스화에 상관없이 접근이
	// 가능하면서 동시에 private접근 제어 키워드를 사용해 instance에 바로 
	// 접근 하지 못하도록 합니다. 
	// 생성자에도 private 접근 제어 키워드를 붙여 다른 클래스에서 new하지 못하도록합니다.
	// 오로지 정적메서드인 getInstance()메서드를 이요ㅕㅇ해서
	// 인스턴스를 접근하도록 하여 유일무이한 동일 인스턴스를 사용하는 기본 싱글톤 원칙을 지키게 합니다.
	//  private static Singleton instance = new Singleton();
//	// static으로 메모리에 자동으로 로딩됨 단 하나만 공유하는 인스턴스 
//	private Singleton() {}
//	// 문제는 동기화문제임 
//    public static Singleton getInstance() {
//    	return instance;
//    }
    // 장점: static으로 생성된 변수에 싱글톤 객체를 선언했기 때문에 
    // 클래스 로더에 의해 클래스가 로딩될 때 싱글톤 객체가 생성됩니다.
    // 클래스 로더에 의해 클래스가 최초로 로딩 될 때 객체가 생성됨으로 
    // Thread-safe합니다. 
    
    // 단점: 싱글톤 객체 사용유무와 상관없이 클래스가 로딩되는 시점에 
    // 항상 싱글톤 객체가 생성되고, 메모리를 잡고 있기때문에 비효율적이다. 
    
    
    /*Lazy Initialization with synchronized(동기화 블럭)
     * 
     * synchronized 키워드를 이용한 게으른 초기화 방식 
     * 매서드에 동기화 블럭을 지정해서 Thread-safe를 보장합니다.
     * 
     * 컴파일시점이 아닌 인스턴스가 필요한 시점에 요청하여
     * 동적 바인딩(런타임시에 성격이 결정됨)을 통해 인스턴스를 
     * 생성하는 방식을 말합니다. 
     * */
//	 private static Singleton uniqueInstance;
//     private Singleton() {}
//     public static synchronized Singleton getInstance() {
//    	 if(uniqueInstance == null) {
//    		 uniqueInstance = new Singleton();
//    	 }
//    	 return uniqueInstance;
//     }// 하지만 이 메서드를 동기화 키워드로 해버리면 클래스로더가 로딩하면서 자동으로 
     // 이 static메서드가 메모리에 올려질텐데 그러면 synchronized 가 될텐데 그렇게 되면 성능저하가 심각해진다. 
     // 그래서 동기화 블록을 따로 지정해서 
     // 인스턴스가 되지않았을 경우에만 synchronized해서 동기화를 이룬다 
	private volatile static Singleton uniqueInstance;
    private Singleton() {}
    private static Singleton getInstance() {
    	if(uniqueInstance == null) {
    		synchronized (Singleton.class) {
				if(uniqueInstance == null) {
					uniqueInstance = new Singleton();
				}
			}
    	}
    	return uniqueInstance;
    }
    
    // volatile 변수를 사용하고 있지 않는 멀티 스레드 어플리케이션에서는
   /*
    * 작업을 수행하는 동안 성능 향상을 위해 MainMemory에서 읽은 변수
    * 값을 CPU Cache에 저장하게 됩니다. 만약에 멀티 스레드 환경에서
    * 스레드가 변수값을 읽어올 때 각가의 cpu cache에 저장된 값이
    * 다르기 때문에 변값 불일치 문제가 발생하게 되는데 volatile키워드가 이런문제를 해결
    * 즉 volatile변수는 MainMemory에 값을 저장하고 읽어오기 때문에
    * 변수 값 불일치 문제가 생기지 않습니다. 
    * 
    * 멀티 스레드 환경에서 하나의 스레드는 read and write하먀,
    * 나머지 스레드는 read만 하는 경우 변수의 최신값을 보장
    * 
    * 멀티 스레드 환경에서 여러개의 스레드가 write하는 상황이라면
    * 동기화 블럭을 지정해서 원자성을 보장해야한다 
    * */
    
    
    
    
    
    // 싱글톤에서 동기화 이슈와 성능을 해결하기 위해서 
  	// 클래스 로더가 초기화하지않고 동적바인딩을 통해 호출당시에 초기화함으로 써 성능을 향상시킨다
  	// 그렇지않고 클래스 로더가 클래스를 초기화하면서 정적바인딩으로 인스턴스를 미리 생성하는 경우
  	// 멀티스레드 환경에서 스레드들이 동시에 인스턴스 생성을 하게된다면 정보변형 등 스레드 불안정상태가된다 
  	// 내부 인스턴스는 static이기 때문에 클래스로딩 시점에서 한번만 호출되고 
  	// final을 써서 다시 값이 할당 되지 않도록 하게 하였다. 
    
    /*private static class InnerInstanceClazz() {
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return InnerInstanceClazz.instance;
    }*/
}