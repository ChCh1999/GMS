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

    final int PORT_LISTEN=ServerData.PORT_Judge;
    final String IP_SERVER=ServerData.ipOfServer;

    //属性
    private String ID;
    private String proname;

    //交互用
    private BufferedReader br;
    private BufferedWriter bw;
    private Socket connection;

    //控制用
    public  boolean logined=false;//是否成功登陆
    public  boolean sendmark=false;//是否接受了队员表
    public boolean prodone=false;//项目结束
    public boolean isWorking=false;
    public void start(String SID,Socket conn){
        try {
            ID=SID;
//            ServerSocket judge=new ServerSocket(PORT_LISTEN);
//            Socket conn = judge.accept();
            br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            bw=new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            connection=conn;
            proname=br.readLine();
            isWorking=true;
            return;
        }catch (IOException ioe){
            return;
        }

    }
    //获取服务器传输的运动员名单ArrayList<Pair<String,String>>（运动员编号，姓名）
    public ArrayList<Pair<String,String>> wait_Aths(){
        ArrayList<Pair<String,String>>Aths=new ArrayList<>();
        if(logined&&!sendmark){
            try {
                String Num;
                String Name;
//                while (connection==null);//等待连接成功
                String message=br.readLine();
                if(message.equals("over")){
                    return Aths;
                }
                int amount=Integer.parseInt(message);
                bw.write("ready");
                bw.flush();
                for(int i=0;i<amount;i++){
                    if ((Num=br.readLine())!="Finished"){
                        Name=br.readLine();
                        Pair<String,String> pa=new Pair<>(Num,Name);
                        Aths.add(new Pair<String,String>(Num,Name));
                    }
                }
                bw.write("Judge\n");
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
                bw.flush();
                sendmark=false;
                return true;
            }catch (IOException ioe){

            }

        }
        return false;
    }

    public String getProname() {
        return proname;
    }

    public boolean exit() {
        if(sendmark){
            //有比赛未完成，无法退出
            return false;
        }else {
            try {
                bw.write("Exit\n");
                bw.write(ID);
                bw.flush();
                return true;
            }catch (IOException ioe){
                return false;
            }

        }
    }
}
