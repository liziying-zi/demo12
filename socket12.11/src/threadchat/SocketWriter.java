package threadchat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @program: socket
 * @Description: SocketWriter
 * @author: lzy
 * @date: 2019/12/11
 */
public class SocketWriter implements Runnable {

    private Socket socket;
    private String userName;
    private PrintWriter pw;

    public SocketWriter(Socket socket) {
        this.socket = socket;
    }

    public SocketWriter(Socket socket, String userName) {
        this.socket = socket;
        this.userName = userName;
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
        String temp=new String();
        Scanner input=new Scanner(System.in);
        try {
            //打印流 通过Socket用于发送消息
            pw=new PrintWriter(socket.getOutputStream(),true);

            while (true){
                temp=input.nextLine();
                //将消息发送出去
                pw.println(userName+":"+temp);
                //以bye结尾就退出
                if(temp.endsWith("bye")){
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(pw!=null){
                pw.close();
            }
        }
    }
}
