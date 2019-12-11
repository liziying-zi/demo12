package socketdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: socketdemo
 * @Description: ServerSocketTcp
 * @author: lzy
 * @date: 2019/12/2
 */
public class ServerSocketTcp {
    public static void main(String[] args){
        int serverPort = 6666;
        String message;
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort);
            Socket socket = serverSocket.accept();
            //创建一个线程，接受消息
            //循环一直接收消息
            BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
            //通过while循环不断读取信息， czczczdczsdcxccx

            while ((message = bufferedReader.readLine())!=null){
                //输出打印
                System.out.println(message);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

