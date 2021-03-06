package msg;

import net.MyServer;
import entity.RoomPojo;

/**
 * 悔棋
 */
public class ClientBackChess extends BaseMsg {

    private int roomid;
    private boolean isleft;


    public int getRoomid() {
        return roomid;
    }


    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }


    public boolean isIsleft() {
        return isleft;
    }


    public void setIsleft(boolean isleft) {
        this.isleft = isleft;
    }


    public ClientBackChess(int roomid, boolean isleft) {
        super();
        this.roomid = roomid;
        this.isleft = isleft;
    }

    @Override
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