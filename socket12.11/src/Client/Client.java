package Client;

import threadchat.SocketReader;
import threadchat.SocketWriter;

import java.io.IOException;
import java.net.Socket;
/**
 * @program: socket
 * @Description: Client
 * @author: lzy
 * @date: 2019/12/11
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //ip和端口号
        Socket socket = new Socket("10.17.67.50",8888);

        Thread  send       =new Thread(new SocketWriter(socket,"我"));
        Thread  reception  =new Thread(new SocketReader(socket));

        send.start();
        reception.start();
    }
}
