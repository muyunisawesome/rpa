package msg;

import net.MyClient;
import entity.User;

/**
 * 登录成功报文类，由服务器发往客户端
 */
public class ServerLoginSucMsg extends BaseMsg {

    //跟新使用数据库的User对象
    private User user;

    public ServerLoginSucMsg(User user) {
        super();
        this.user = user;
    }

    public void doBiz() {
        System.out.println(user); //打出用户名
        //客户端姓名输入框，关闭跳转到大厅
        MyClient.getMyClient().getNamedialog().loginSuc(user);
    }

}
