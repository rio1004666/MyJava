public class Singleton {
	
	// Eager Initilialization(�̸� �ʱ�ȭ, Tread-safe)
    // ���� �⺻���� Eager initialization ���
	// ���� Ŭ���� ���� ���������� instance ������ �����ϰ� 
	// private static�� ����ؼ� �ν��Ͻ�ȭ�� ������� ������
	// �����ϸ鼭 ���ÿ� private���� ���� Ű���带 ����� instance�� �ٷ� 
	// ���� ���� ���ϵ��� �մϴ�. 
	// �����ڿ��� private ���� ���� Ű���带 �ٿ� �ٸ� Ŭ�������� new���� ���ϵ����մϴ�.
	// ������ �����޼����� getInstance()�޼��带 �̿�Ť��ؼ�
	// �ν��Ͻ��� �����ϵ��� �Ͽ� ���Ϲ����� ���� �ν��Ͻ��� ����ϴ� �⺻ �̱��� ��Ģ�� ��Ű�� �մϴ�.
	//  private static Singleton instance = new Singleton();
//	// static���� �޸𸮿� �ڵ����� �ε��� �� �ϳ��� �����ϴ� �ν��Ͻ� 
//	private Singleton() {}
//	// ������ ����ȭ������ 
//    public static Singleton getInstance() {
//    	return instance;
//    }
    // ����: static���� ������ ������ �̱��� ��ü�� �����߱� ������ 
    // Ŭ���� �δ��� ���� Ŭ������ �ε��� �� �̱��� ��ü�� �����˴ϴ�.
    // Ŭ���� �δ��� ���� Ŭ������ ���ʷ� �ε� �� �� ��ü�� ���������� 
    // Thread-safe�մϴ�. 
    
    // ����: �̱��� ��ü ��������� ������� Ŭ������ �ε��Ǵ� ������ 
    // �׻� �̱��� ��ü�� �����ǰ�, �޸𸮸� ��� �ֱ⶧���� ��ȿ�����̴�. 
    
    
    /*Lazy Initialization with synchronized(����ȭ ��)
     * 
     * synchronized Ű���带 �̿��� ������ �ʱ�ȭ ��� 
     * �ż��忡 ����ȭ ���� �����ؼ� Thread-safe�� �����մϴ�.
     * 
     * �����Ͻ����� �ƴ� �ν��Ͻ��� �ʿ��� ������ ��û�Ͽ�
     * ���� ���ε�(��Ÿ�ӽÿ� ������ ������)�� ���� �ν��Ͻ��� 
     * �����ϴ� ����� ���մϴ�. 
     * */
//	 private static Singleton uniqueInstance;
//     private Singleton() {}
//     public static synchronized Singleton getInstance() {
//    	 if(uniqueInstance == null) {
//    		 uniqueInstance = new Singleton();
//    	 }
//    	 return uniqueInstance;
//     }// ������ �� �޼��带 ����ȭ Ű����� �ع����� Ŭ�����δ��� �ε��ϸ鼭 �ڵ����� 
     // �� static�޼��尡 �޸𸮿� �÷����ٵ� �׷��� synchronized �� ���ٵ� �׷��� �Ǹ� �������ϰ� �ɰ�������. 
     // �׷��� ����ȭ ����� ���� �����ؼ� 
     // �ν��Ͻ��� �����ʾ��� ��쿡�� synchronized�ؼ� ����ȭ�� �̷�� 
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
    
    // volatile ������ ����ϰ� ���� �ʴ� ��Ƽ ������ ���ø����̼ǿ�����
   /*
    * �۾��� �����ϴ� ���� ���� ����� ���� MainMemory���� ���� ����
    * ���� CPU Cache�� �����ϰ� �˴ϴ�. ���࿡ ��Ƽ ������ ȯ�濡��
    * �����尡 �������� �о�� �� ������ cpu cache�� ����� ����
    * �ٸ��� ������ ���� ����ġ ������ �߻��ϰ� �Ǵµ� volatileŰ���尡 �̷������� �ذ�
    * �� volatile������ MainMemory�� ���� �����ϰ� �о���� ������
    * ���� �� ����ġ ������ ������ �ʽ��ϴ�. 
    * 
    * ��Ƽ ������ ȯ�濡�� �ϳ��� ������� read and write�ϸ�,
    * ������ ������� read�� �ϴ� ��� ������ �ֽŰ��� ����
    * 
    * ��Ƽ ������ ȯ�濡�� �������� �����尡 write�ϴ� ��Ȳ�̶��
    * ����ȭ ���� �����ؼ� ���ڼ��� �����ؾ��Ѵ� 
    * */
    
    
    
    
    
    // �̱��濡�� ����ȭ �̽��� ������ �ذ��ϱ� ���ؼ� 
  	// Ŭ���� �δ��� �ʱ�ȭ�����ʰ� �������ε��� ���� ȣ���ÿ� �ʱ�ȭ������ �� ������ ����Ų��
  	// �׷����ʰ� Ŭ���� �δ��� Ŭ������ �ʱ�ȭ�ϸ鼭 �������ε����� �ν��Ͻ��� �̸� �����ϴ� ���
  	// ��Ƽ������ ȯ�濡�� ��������� ���ÿ� �ν��Ͻ� ������ �ϰԵȴٸ� �������� �� ������ �Ҿ������°��ȴ� 
  	// ���� �ν��Ͻ��� static�̱� ������ Ŭ�����ε� �������� �ѹ��� ȣ��ǰ� 
  	// final�� �Ἥ �ٽ� ���� �Ҵ� ���� �ʵ��� �ϰ� �Ͽ���. 
    
    /*private static class InnerInstanceClazz() {
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return InnerInstanceClazz.instance;
    }*/
}