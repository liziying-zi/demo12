package threadchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
/**
 * @program: socket
 * @Description: SocketReader
 * @author: lzy
 * @date: 2019/12/11
 */
public class SocketReader implements Runnable {

    private Socket socket;

    private BufferedReader br;

    public SocketReader(Socket socket) {
        this.socket = socket;
    }
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        String temp = new String();
        try {
            //创建缓冲流 读取消息
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                temp = br.readLine();
                System.out.println(temp);
                //以bye结尾就退出
                if(temp.endsWith("bye")){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(br!=null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
