package Server;

import javafx.util.Pair;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class GroupJudge{
    private boolean signed=false;

    //登录用
    final String IP_SERVER="127.0.0.1";
    final int PORT_LOGIN=10087;
    final int PORT_LISTEN=10088;


    //连接用
    private BufferedReader br;
    private BufferedWriter bw;
    private Socket connection;

    //数据
    private ArrayList<ArrayList<Pair<String,Float>>> MarkTables;
    //监控用
    public  boolean logined=false;//是否成功登陆
    public  boolean sendmark=true;//是否准备好接受队员表
    public boolean prodone=false;//项目结束
    public boolean MarkTableDone=false;//成绩表传输完毕
    private String ID;

    public static void main(String[] args) {
        GroupJudge test=new GroupJudge();
        //test.login("2019001");
//        while (true){
//            test.wait_Aths();
//            test.getMarkTables();
//            test.sendConform(true);
//        }

    }
    GroupJudge(){

    }

//    public boolean login(String id){
//        try{
//            Socket login=new Socket(IP_SERVER,PORT_LOGIN);
//            BufferedReader br_login=new BufferedReader(new InputStreamReader(login.getInputStream()));
//            BufferedWriter bw_login=new BufferedWriter(new OutputStreamWriter(login.getOutputStream()));
//
//            bw_login.write(id+'\n'+'\n');
//            bw_login.flush();
//            //System.out.println(id);
//            if(Boolean.parseBoolean(br_login.readLine())){
//                logined=true;
//                ID=id;
//                System.out.println("登录成功");
//                return true;
//            }else {
//                return false;
//            }
//        }catch (UnknownHostException une){
//            System.out.println(une);
//            return false;
//        }catch (IOException ioe){
//            System.out.println(ioe);
//            return false;
//        }
//
//    }

    public void start(){
        try {
            ServerSocket judge=new ServerSocket(PORT_LISTEN);
            Socket conn = judge.accept();
            connection=conn;
            br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            bw=new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            return;
        }catch (IOException ioe){
            return;
        }
    }

    //获取服务器传输的运动员名单ArrayList<Pair<String,String>>（运动员编号，姓名）
    public ArrayList<Pair<String,String>> wait_Aths(){
        ArrayList<Pair<String,String>>Aths=new ArrayList<>();
        if(logined){
            try {
                String Name;
                String Num;
                bw.write("ready");
                while ((Num=br.readLine())!="Finished"){
                    Name=br.readLine();
                    Aths.add(new Pair<String,String>(Num,Name));
                }
                //获取完成
                sendmark=true;
                return Aths;
            }catch (IOException a){
                return null;
            }

        }
        return Aths;
    }

    //接收成绩表
    public void getMarkTables(){
        //ArrayList<ArrayList<Pair<String,Float>>> res=new ArrayList<>();
        MarkTables=new ArrayList<>();
        try {
            br.readLine();
            while (!br.readLine().equals("FinishSendMarks")){
                bw.write("ready\n");
                ArrayList<Pair<String,Float>>MarkTable=new ArrayList<>();
                String Num;
                while (!(Num=br.readLine()).equals("Done")){
                    float mark=Float.parseFloat(br.readLine());
                    MarkTable.add(new Pair<>(Num,mark));
                }
                MarkTables.add(MarkTable);
            }
            MarkTableDone=true;
        }catch (IOException ioe){

        }

    }
    public void sendConform(Boolean pass){
        sendmark=true;
        try {
            bw.write(Boolean.TRUE.toString());
        }catch (IOException ioe){
            System.out.println("信号错误-小组裁判");
        }

    }

}
