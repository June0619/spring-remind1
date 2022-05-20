package jwjung.spring.remind.singleton;

public class SingletonService {

    // 1. static 영역에 불변 객체를 미리 한개 생성한다.
    private static final SingletonService instance = new SingletonService();

    private int value = 0;

    // 2. public 접근 메서드를 통해 오직 이 메서드를 통해서만 객체에 접근 가능하도록 한다.

    public static SingletonService getInstance() {
        return instance;
    }
    // 3. 생성자를 private 접근제어자로 막음으로써 외부에서 new 키워드를 통한 객체 생성을 방지한다.
    private SingletonService() {};

    public void singletonObjectCall() {
        System.out.println("["+this+"] Singleton Object Call");
        value += 1;
    }
}
