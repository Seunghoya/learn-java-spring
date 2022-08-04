package learnjavaspring.core.singleton;

public class SingletonService {

    // static 영역에 객체 instance를 미리 하나 생성해준다.
    private static final SingletonService instance = new SingletonService();

    // 생성한 인스턴스는 오직 getInstance() 메서드 호출을 통해서만 조회할 수 있다. 이 메서드는 항상 같은 인스턴스를 반환한다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 인스턴스가 반복 생성되어선 안되므로 private로 막아서 혹시라도 외부에서 new 키워드로 인스턴스가 생성되는 것을 막는다.
    private SingletonService() {
        
    }
    
    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
