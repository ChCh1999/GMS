package SocketTools;
import javafx.util.Pair;
import org.javatuples.Triplet;

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

    public  boolean sendAth=true;//是否准备好接受队员表
    public  boolean sendmark=false;
    public  boolean sendConfirm=false;

    private String ID;

    public static void main(String[] args) {
        GroupJudge test=new GroupJudge();


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
       if(sendAth){
           ArrayList<Pair<String,String>>Aths=new ArrayList<>();
           if(logined){
               try {
                   String Name;
                   String Num;
                   int amount=Integer.parseInt(br.readLine());
                   bw.write("ready");
                   for(int i=0;i<amount;i++){
                       if ((Num=br.readLine())!="Finished") {

                           Name = br.readLine();
                           Aths.add(new Pair<String, String>(Num, Name));
                       }
                   }
                   //获取完成
                   bw.write("GroupJudge\n");
                   sendAth=false;
                   sendmark=true;
                   return Aths;
               }catch (IOException a){
                   return null;
               }

           }
           return Aths;
       }else {
           return null;
       }
    }

    //接收成绩表
    public void getMarkTables(){
        if(sendmark){
            //ArrayList<ArrayList<Pair<String,Float>>> res=new ArrayList<>();
            MarkTables=new ArrayList<>();
            try {
                br.readLine();//Send Start
                while (!br.readLine().equals("FinishSendMarks")){
                    br.readLine();//SendMarkTable
                    br.readLine();//IDOfJudge
                    bw.write("ready\n");
                    ArrayList<Pair<String,Float>>MarkTable=new ArrayList<>();
                    String Num;
                    while (!(Num=br.readLine()).equals("Done")){
                        float mark=Float.parseFloat(br.readLine());
                        MarkTable.add(new Pair<>(Num,mark));
                    }
                    MarkTables.add(MarkTable);
                }
                sendConfirm=true;
                sendmark=false;
            }catch (IOException ioe){

            }
        }


    }

    public void sendConform(ArrayList<Triplet<String,Float,Float>> messages){//运动员编号、B分、P分
        if(sendConfirm){
            try {
                bw.write(Boolean.TRUE.toString());
                for (Triplet<String,Float,Float> message:messages) {
                    bw.write(message.getValue0()+"\n");
                    bw.write(message.getValue1()+"\n");
                    bw.write(message.getValue2()+"\n");
                }
                bw.write("Finished\n");
                sendAth=true;
                sendConfirm=false;
            }catch (IOException ioe){
                System.out.println("信号错误-小组裁判");
            }
        }

    }
    public void sendConform(){//运动员编号、B分、P分
        if(sendConfirm){
            try {
                bw.write(Boolean.FALSE.toString());
                sendAth=true;
                sendConfirm=false;
            }catch (IOException ioe){
                System.out.println("信号错误-小组裁判");
            }
        }

    }
}
