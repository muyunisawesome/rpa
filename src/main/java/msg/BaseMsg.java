package msg;

import java.io.Serializable;
import java.net.Socket;

/**
 * 客户端与服务器消息基础类
 */
public abstract class BaseMsg implements Serializable {

    protected Socket client;

    public Socket getClient() {
        return client;
    }

    public void setClient(Socket client) {
        this.client = client;
    }

    /**
     * 业务模板方法
     */
    public abstract void doBiz();

}
