package socketdemo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @program: socketdemo
 * @Description:ClientSocketTcp
 * @author: lzy
 * @date: 2019/12/9
 */
public class ClientSocketTcp {
    public static void main(String[] args){
        String message = "Hii this is cai cai cai chun chun!";
        try {
            String serverAddress = "10.3.17.50";
            int serverPort = 6666;
            Socket socket = new Socket(serverAddress, serverPort);
            BufferedWriter bufferedWriter =new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write(message);
            bufferedWriter.flush();
            socket.shutdownOutput();
        }catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (ConnectException e) {
            System.out.println("can not get connection try again!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
