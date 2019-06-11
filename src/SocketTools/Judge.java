package SocketTools;

import javafx.util.Pair;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Judge {

    public static void main(String[] args) {
        ClientTool.login("1270.0.1","123456");
    }

    final int PORT_LISTEN=10088;
    final String IP_SERVER="/127.0.0.1";

    //属性
    private String ID;

    //交互用
    private BufferedReader br;
    private BufferedWriter bw;
    private Socket connection;

    //控制用
    public  boolean logined=false;//是否成功登陆
    public  boolean sendmark=false;//是否准备好接受队员表
    public boolean prodone=false;//项目结束

    public void start(){
        try {
            ServerSocket judge=new ServerSocket(PORT_LISTEN);
            Socket conn = judge.accept();
            br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            bw=new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            connection=conn;
            return;
        }catch (IOException ioe){
            return;
        }

    }
    public String getProName(){
        return null;
    }
    //获取服务器传输的运动员名单ArrayList<Pair<String,String>>（运动员编号，姓名）
    public ArrayList<Pair<String,String>> wait_Aths(){
        ArrayList<Pair<String,String>>Aths=new ArrayList<>();
        if(logined){
            try {
                String Num;
                String Name;
//                while (connection==null);//等待连接成功
                bw.write("ready");
                while ((Num=br.readLine())!="Finished"){
                    Name=br.readLine();
                    Pair<String,String> pa=new Pair<>(Num,Name);
                    Aths.add(new Pair<String,String>(Num,Name));

                }
                //获取完成
                sendmark=true;
                return Aths;
            }catch (IOException ioe){
                return null;
            }

        }
        return Aths;
    }

    //发送完成的打分表
    public boolean SendMarkTable(ArrayList<Pair<String,Float>> marktable ){
        if(logined&&sendmark){
            try {
                bw.write(ID);
                for(Pair<String,Float> a:marktable){
                    bw.write(a.getKey()+'\n');
                    bw.write(a.getValue().toString()+'\n');
                }
                bw.write("Finished");
                sendmark=false;
                return true;
            }catch (IOException ioe){

            }

        }
        return false;
    }
}
