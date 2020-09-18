package msg;

import lombok.Data;
import net.MyServer;
import entity.RoomPojo;

/**
 * 悔棋
 */
@Data
public class ClientBackChess extends BaseMsg {

    private int roomid;

    private boolean isleft;

    public ClientBackChess(int roomid, boolean isleft) {
        super();
        this.roomid = roomid;
        this.isleft = isleft;
    }


    public void doBiz() {
        RoomPojo roompojo = MyServer.getMyServer().getRooms().get(roomid);
        if (isleft) {
            ServerBackChess msg = new ServerBackChess();
            MyServer.getMyServer().sendMsgToClient(msg, roompojo.getRightPlayer());
        } else {
            ServerBackChess msg = new ServerBackChess();
            MyServer.getMyServer().sendMsgToClient(msg, roompojo.getLeftPlayer());
        }
    }

}