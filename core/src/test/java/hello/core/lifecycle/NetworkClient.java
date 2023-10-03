package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient {

    private String url;

    public NetworkClient() {

    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + " message = " + message);
    }

    public void disConnect() {
        System.out.println("close : " + url);
    }


    @PostConstruct
    public void init() throws Exception {
        connect();
        call("초기화 할 메세지");
    }

    @PreDestroy
    public void close() throws Exception {
        disConnect();
    }
}
