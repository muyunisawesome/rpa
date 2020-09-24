package msg;

import net.MyServer;

/**
 * 功能: 退出发送报文
 */
public class ClientLogoutMsg extends BaseMsg {

    public void doBiz() {
        MyServer.getMyServer().deleteUserClient(this.client); //服务器删除用户
        ServerUserListMsg msg2 = new ServerUserListMsg(MyServer.getMyServer().getUserList());
        MyServer.getMyServer().sendMsgToAll(msg2);
    }
}
