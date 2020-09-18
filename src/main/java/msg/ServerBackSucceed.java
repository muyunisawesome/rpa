package msg;

import net.MyClient;
/**
 * 服务端向客户端发送悔棋成功的报文类
 *
 *
 */
public class ServerBackSucceed extends BaseMsg{

	public void doBiz() {
        MyClient.getMyClient().getRoom().BackSucceed();
		System.out.println("悔棋成功");
	}

}
