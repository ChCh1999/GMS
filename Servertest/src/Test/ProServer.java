package Server;

import Data.DataOperation;
import org.javatuples.Pair;
import sun.security.util.Password;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

class ServerData {
    final static int PORT1 = 10086;//总裁判连接监听端口
    final static int PORT2 = 10087;//登录监听端口
    final static int PORT3 = 10088;//连接裁判用端口
}

public class ProServer {

    ArrayList<Thread> proline = new ArrayList<>();

    public static void main(String[] args) {
        ProServer test = new ProServer();
        test.start();
    }

    public void start() {
        // 为了简单起见，所有的异常信息都往外抛
        try {
            TServer loginServer = new TServer();
            new Thread(loginServer).start();
            int port = ServerData.PORT1;
            ServerSocket server = new ServerSocket(port);
            System.out.println("等待与客户端建立连接.....");
            while (true) {
                // server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的
                Socket socket = server.accept();
                // 每接收到一个Socket就建立一个新的线程来处理它
                Thread master = new Thread(new TProMaster(socket));
                proline.add(master);
                master.start();
            }
//            server.close();
        } catch (Exception e) {

        }
    }
}

//    处理Socket请求的线程类
class TProMaster implements Runnable {
    private Socket socket;

    public TProMaster(Socket socket) {
        this.socket = socket;
    }/*构造函数*/

    @Override
    public void run() {
        try {
            handlerSocket();
        } catch (Exception e) {
            e.toString();
        }
    }

    //处理与总裁判通信
    private void handlerSocket() throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(socket.getInputStream(), "UTF-8"));
        BufferedWriter MessageToClient = new BufferedWriter(
            new OutputStreamWriter(socket.getOutputStream()));
        DataOperation dbo=new DataOperation();
        String proName;//项目名
        int group;//年龄组别
        // 读取客户端发过来的信息了
        System.out.println("服务器链接" + socket.isConnected() + socket.getPort());

        proName = br.readLine();//项目名
        group = Integer.parseInt(br.readLine());//组别
        //boolean MOrF=Boolean.parseBoolean(br.readLine());//男生组String='true'
        System.out.println("Form Client：" + proName + "开始");
//                创建项目信息处理线程是否进行

        int index=proName.indexOf("决赛");
        //未进行的初赛、已完成相应初赛且尚未进行的决赛则进入后流程
        if ((index==-1&&dbo.SearchMatch(proName,group)==0) ||
                (index!=-1&&dbo.SearchMatch(proName.substring(0,index),group)==2)&&
                        dbo.SearchMatch(proName,group)==0) {
            Thread prohandle = new Thread(new TProHandle(proName, group, socket));

            //开始处理比赛信息
            prohandle.start();
            //输出流回应一下客户端
            MessageToClient.write("Start" + '\n');
            System.out.println(proName+"Start");

            //刷新流
            MessageToClient.flush();
            //等待比赛结束
            prohandle.join();


            MessageToClient.write("End" + '\n');
            MessageToClient.flush();
            System.out.println("End");
//            System.out.println(br.readLine());
        } else {
            System.out.println("Wrong");
            MessageToClient.write("WrongRequest");
        }
        //System.out.println("To Client:" + "copy:" + proName + "开始");
//        br.close();
//        MessageToClient.close();
    }


}

/*处理单一项目小组比赛信息的线程*/
class TProHandle implements Runnable {
    //项目信息
    private String ProName;
    private String ProID;
    private int group;
    //private int MOrF;

    //Socket连接
    public Socket Chief;
    private Socket Group;
    private ArrayList<Socket> Judges;
    String IPOfGroup;
    ArrayList<String> IPOfJudges = new ArrayList<String>();

    //数据库工具
    Data.DataOperation myConn;




    //        构造函数
    public TProHandle(String Project, int group, Socket c) {
        myConn = new DataOperation();
        ProName = Project;
        this.group = group;
        ProID=myConn.SearchPID(ProName);
        Chief = c;
    }

    @Override
    public void run() {
//        try {
//            Thread.sleep(6000);
//        }catch (Exception e){
//            e.toString();
//        }
        handlerSocket();
    }

    private void handlerSocket() {
        ArrayList<Pair<String, String>> Aths=new ArrayList<>();
        int index=ProName.indexOf("决赛");

        if(index==-1)
            Aths= myConn.SearchPeopleList(ProID,group);
        else
            Aths=myConn.SearchFinalPeopleList(ProID,group);

        int count=Aths.size();
        //        TODO:init读取各个裁判的ip
        IPOfGroup = "127.0.0.1";
        IPOfJudges.add("127.0.0.1");
        try {

            Group = new Socket(IPOfGroup, ServerData.PORT3);
            for (String ip : IPOfJudges) {
                Socket Stemp = new Socket(ip, ServerData.PORT3);
                Judges.add(Stemp);
            }
        } catch (UnknownHostException uhe) {

        } catch (IOException ioe) {

        }
        int tag = 0;
        while (tag < Aths.size()) {
            ArrayList<Pair<String, String>> OneGroup = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                if (tag < Aths.size()) {
                    OneGroup.add(Aths.get(tag));
                    tag++;
                } else {
                    break;
                }

            }
            if (OneGroup != null) {
                SendMessageOfAthletes(OneGroup);
            } else {
                //TODO:结束进程

            }
        }
        //TODO:结束进程
    }

    private void SendMessageOfAthletes(ArrayList<Pair<String, String>> Aths) {

        Thread GroupMessage;
        //记录run类与线程的数组
        ArrayList<TSendAthletesMessage> ListOfJudges = new ArrayList<>();
        ArrayList<Thread> ListOfThread = new ArrayList<>();
        //ArrayList<TSendAthletesMessage> ListOfMarkTable=new ArrayList<>();
        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(Group.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(Group.getOutputStream()));

            GroupMessage = new Thread(new TSendAthletesMessage(Group, Aths));
            GroupMessage.start();

            for (Socket Stemp : Judges) {
                if (Stemp.isConnected()) {
                    TSendAthletesMessage TSMtemp = new TSendAthletesMessage(Stemp, Aths);
                    Thread Ttemp = new Thread(TSMtemp);
                    ListOfJudges.add(TSMtemp);
                    ListOfThread.add(Ttemp);
                    Ttemp.start();
                }
            }

            GroupMessage.join();
            //等待裁判完成打分
            for (Thread t : ListOfThread) {
                t.join();
            }

            bw.write("Send Start\n");
            for (TSendAthletesMessage mark : ListOfJudges) {
                SendMarkTable(Group, mark);
            }

            bw.write("FinishSendMarks");
            String feedback = br.readLine();
//            br.close();
//            bw.close();
            if (feedback.equals("OK")) {
                //若确认通过则返回
                //TODO 读取奖励分惩罚分
                //TODO 统计最终分数存储到数据库
                return;
            } else {
                SendMessageOfAthletes(Aths);
                return;
            }
        } catch (Exception x) {
//      TODO 异常处理
        }

    }

    //发送从裁判获得的打分
    private void SendMarkTable(Socket target, TSendAthletesMessage message) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(target.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(target.getOutputStream()));
        /*bw.write(ProName+"marks");
        if(br.readLine().equals("copy")){

        }*/
        //输出成绩表中所有姓名+成绩
        bw.write("SendMarkTable");
        bw.write(message.NameOfJudge);
        while (!br.readLine().equals("ready")) ;//等待直到ready
        for (Pair<String, Float> mark : message.MarkTable     //Pair<AthNum,Mark>
                ) {
            bw.write(mark.getValue0().toString() + '\n');
            bw.write(mark.getValue1().toString() + '\n');
        }
        bw.write("Done");
//        bw.close();
//        br.close();
    }
}

//发送信息线程类 系统发送小组队员名单给裁判 暂存信息
class TSendAthletesMessage implements Runnable {
    Socket target;
    String NameOfJudge;
    ArrayList<Pair<String, String>> Message;
    ArrayList<Pair> MarkTable = new ArrayList<>();

    public TSendAthletesMessage(Socket s, ArrayList<Pair<String, String>> a) {
        target = s;
        Message = a;
    }

    public void run() {
        try {
            SendMessage(target, Message);
        } catch (Exception e) {

        }//TODO：异常处理
    }

    //    发送运动员名单
    public void SendMessage(Socket s, ArrayList<Pair<String, String>> Aths) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        int size = Aths.size();
        if (size == 0) {
            bw.write("Over");
        }
        bw.write(Aths.size() + '\n');
        NameOfJudge = br.readLine();
        while (!br.readLine().equals("ready")) ;//阻塞直到裁判准备好
        for (Pair<String, String> Ath : Aths) {
            bw.write(Ath.getValue0() + '\n');
            bw.write(Ath.getValue1() + '\n');
        }
        bw.write("Finished");
//        if(br.readLine().equals("ready")){
//            for (Pair<String,String> Ath:Aths) {
//                bw.write(Ath.getValue0()+'\n');
//                bw.write(Ath.getValue1()+'\n');
//            }
//            bw.write("Finished");
//        }
        if (br.readLine().equals("GroupJudge")) {
            return;//目标是小组裁判时结束
        } else {
            //TODO:获取分数
            br.readLine();//等待客户端反馈命令
            String command;
            String AthNum;
            float Marks;
            while ((command = br.readLine()) != "Finished") {
                AthNum = command;
                Marks = Float.parseFloat(br.readLine());
                MarkTable.add(new Pair(AthNum, Marks));
            }
            //读取名字+分数直到null;
        }
//        bw.flush();
//        br.close();
//        bw.close();
    }
}

//处理登陆连接的线程
class TServer implements Runnable {
    ServerSocket loginserver;

    @Override
    public void run() {
        try {
            int port = ServerData.PORT2;
            loginserver = new ServerSocket(port);
            System.out.println("等待连接请求...");
            while (true) {
                // server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的
                Socket socket = loginserver.accept();
                // 每接收到一个Socket就建立一个新的线程来处理它
                Thread login = new Thread(new THandle(socket));
                login.start();
            }

        } catch (IOException e) {

        }
    }

    public void stopLoginServer() {
        //TODO:终止服务器
    }
}

class THandle implements Runnable {
    Socket User;
    private BufferedReader br;
    private BufferedWriter bw;
    THandle(Socket user) {
        this.User = user;
        System.out.println("处理登陆信息");
//        try{
//            br = new BufferedReader(new InputStreamReader(User.getInputStream()));
//            bw = new BufferedWriter(new OutputStreamWriter(User.getOutputStream()));
//        }catch (IOException ioe){
//            System.out.println(ioe);
//        }

    }

    @Override
    public void run() {

        try {
<<<<<<< Updated upstream:Servertest/src/Test/ProServer.java
            BufferedReader br = new BufferedReader(new InputStreamReader(User.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(User.getOutputStream()));
            br.readLine();//"login request"
            String SID = br.readLine();
            String Password=br.readLine();
            if (checkIDOfJudge(SID,Password)){
                bw.write(Boolean.TRUE.toString() + '\n');
                DataOperation dbo=new DataOperation();
                System.out.println(User.getInetAddress().toString());
                dbo.ModifyIP(SID,User.getInetAddress().toString());
                bw.write("1"+ '\n');//裁判状态（总裁判/小组裁判/裁判）
=======
            br = new BufferedReader(new InputStreamReader(User.getInputStream()));
            bw = new BufferedWriter(new OutputStreamWriter(User.getOutputStream()));
            String command=br.readLine();//"login request"
            switch (command){
                case "login request":
                    String SID = br.readLine();
                    String Password=br.readLine();
                    if (checkIDOfJudge(SID,Password)){
                        bw.write(Boolean.TRUE.toString() + '\n');

                        DataOperation dbo=new DataOperation();
                        //TODO:状态检索以及相应的修改
                        if(dbo.Search_SLogin(SID)){

                        }
//                        if(dbo.SearchStype(SID)!=1){
//                            System.out.println(User.getInetAddress().toString());
//                            dbo.ModifyIP(SID,User.getInetAddress().toString());
//                        }
                        bw.write(dbo.SearchStype(SID)+ "\n");//裁判状态（总裁判/小组裁判/裁判）
                    }
                    else
                        if(checkIDofGroup(SID,Password)){
                            bw.write(Boolean.TRUE.toString() + '\n');
                            bw.write(String.valueOf(ServerData.NumOfGroup)+ '\n');
                        }else
                            bw.write(Boolean.FALSE.toString() + '\n');

                    bw.flush();
                    break;

                case "change password":
                    String TID = br.readLine();
                    String TPassword=br.readLine();
                    String newpassword=br.readLine();
                    if(changePassword(TID,TPassword,newpassword)){
                        bw.write(Boolean.TRUE.toString() + '\n');
                    }else {
                        bw.write(Boolean.FALSE.toString() + '\n');
                    }
                    bw.flush();
                    break;

                case "search request":

                default:
                    System.out.println("wrong command");

>>>>>>> Stashed changes:src/SocketTools/ProServer.java
            }
            else
                bw.write(Boolean.FALSE.toString() + '\n');

            bw.flush();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        System.out.println("登录成功");
    }

    public boolean checkIDOfJudge(String sid,String passward) {
        //验证身份，通过则返回true 并调整裁判的IP以及状态
        Data.DataOperation dbo = new DataOperation();
        if (dbo.Stuff_Verify_password(sid,passward)) {
            String IP_target = User.getInetAddress().getHostAddress();
            dbo.ModifyIP(sid, IP_target);
            System.out.println("验证成功");
            return true;
        } else {
            return false;
        }
    }
}



