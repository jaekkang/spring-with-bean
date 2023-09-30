package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instanece = new SingletonService();

    public static SingletonService getInstance() {
        return instanece;
    }

    private SingletonService() {

    }

    public static void main(String[] args) {
        System.out.println("싱글톤 객체 호출");
    }
}
