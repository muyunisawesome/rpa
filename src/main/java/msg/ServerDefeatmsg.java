package msg;

import net.MyClient;
/**
 * 服务端向失败的一方发送的报文类
 *
 *
 */
public class ServerDefeatmsg extends BaseMsg{

	public void doBiz() {
		MyClient.getMyClient().getRoom().defeat();
	}
	

}
