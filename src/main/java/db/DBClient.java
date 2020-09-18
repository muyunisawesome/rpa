package db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class DBClient {

    private Thread client;

    private Queue<String> queue = new ArrayBlockingQueue<String>(1000);

    public DBClient() {
        client = new Thread(() -> {
            Socket socket = new Socket();
            try {
                socket.setSoTimeout(5000000);
            } catch (SocketException e) {
                e.printStackTrace();
            }
            try {
                socket.connect(new InetSocketAddress("192.168.44.199", 8080), 5000000);
            } catch (IOException e) {
                e.printStackTrace();
            }
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (writer == null || in == null) {
                return;
            }
            while (true) {
                String message = queue.poll();
                if (null == message) {
                    continue;
                }

            }

        });
        client.start();
    }
}
