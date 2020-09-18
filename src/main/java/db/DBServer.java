package db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class DBServer {

    public static void main(String[] args) throws IOException {

        Map<String, String> dbMap = new HashMap<>();

        ServerSocket server = new ServerSocket(8080);
        Socket socket = server.accept();
        OutputStream out = socket.getOutputStream();
        InputStream input = socket.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        PrintWriter writer = new PrintWriter(out);
        String message = null;
        while (true) {
            try {
                if (socket.isConnected()) {
                    message = in.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
            if (null == message) {
                continue;
            }
            if (message.startsWith("set:")) {
                message = message.substring(4);
                int ipOffset = message.indexOf(":");
                String user = message.substring(0, ipOffset);
                if (dbMap.containsKey(user)) {
                    writer.println("false:已存在用户名，重新输入");
                    writer.flush();
                    continue;
                }
                dbMap.put(user, message.substring(ipOffset + 1));
                writer.println("true");
                writer.flush();
                continue;
            }
            if (message.startsWith("get:")) {
                message = message.substring(4);
                int ipOffset = message.indexOf(":");
                String user = message.substring(0, ipOffset);
                if (dbMap.containsKey(user)) {
                    writer.println("true:".concat(dbMap.get(user)));
                    writer.flush();
                    continue;
                }
                writer.println("false:用户未登陆");
                writer.flush();
                continue;
            }
            if (message.startsWith("del:")) {
                message = message.substring(4);
                int ipOffset = message.indexOf(":");
                String user = message.substring(0, ipOffset);
                if (dbMap.containsKey(user)) {
                    dbMap.remove(user);
                    writer.println("true:移除成功");
                    writer.flush();
                    continue;
                }
                writer.println("false:移除失败");
                writer.flush();
                continue;
            }
        }
    }
}
