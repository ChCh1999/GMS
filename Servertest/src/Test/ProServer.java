package Test;

import org.javatuples.Pair;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ProServer {
    final int PORT1=10086;
    ArrayList<Thread> proline=new ArrayList<>();
    public static void main(String[] args) {
        ProServer test=new ProServer();
        test.start();
    }

    public void start(){
        // 为了简单起见，所有的异常信息都往外抛
        try {
            int port = 10086;
            ServerSocket server = new ServerSocket(port);
            System.out.println("等待与客户端建立连接...");
            while (true) {
                // server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的
                Socket socket = server.accept();
                // 每接收到一个Socket就建立一个新的线程来处理它
                Thread master=new Thread(new TProMaster(socket));
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
        // 读取客户端发过来的信息了
        System.out.println("服务器链接"+socket.isConnected()+socket.getPort());
        BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), "UTF-8"));
        BufferedWriter MessageToClient = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
        String proName;
        proName = br.readLine();
        int group=Integer.parseInt(br.readLine());//
        boolean MOrF=Boolean.parseBoolean(br.readLine());//男生组String='true'
        System.out.println("Form Client：" + proName + "开始");
//                创建项目信息处理线程是否进行
        //TODO:检查判定对应的比赛 未进行则为true
        if(true){
            Thread prohandle=new Thread(new TProHandle(proName,group,MOrF,socket));
            prohandle.start();
            //                输出流回应一下客户端
            MessageToClient.write("Start"+'\n');
            System.out.println("Start");
            MessageToClient.flush();
            prohandle.join();
            //MessageToClient.flush();
            MessageToClient.write("End"+'\n');
            MessageToClient.flush();
            System.out.println("End");
            System.out.println(br.readLine());
            //MessageToClient.flush();
        }else {
            MessageToClient.write("Wrong");
        }
        //System.out.println("To Client:" + "copy:" + proName + "开始");
//        br.close();
//        MessageToClient.close();
    }


}

/*处理单一项目小组比赛信息的线程*/
class TProHandle implements Runnable {
    private String ProName;
    private int group;
    private boolean MOrF;
    public Socket Chief;
    String IPOfGroup;

    ArrayList<String> IPOfJudges=new ArrayList<String>();
    //        构造函数
    public TProHandle(String Project,int group,boolean mof,Socket c) {
        ProName = Project;
        this.group=group;
        MOrF=mof;
        Chief=c;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(6000);
        }catch (Exception e){
            e.toString();
        }
            //handlerSocket();
    }

    private void handlerSocket()  {
        String[] Aths=new String[10];
//        TODO:while ()获取选手名单不为空时{SendMessageOOfAthletes(Aths);}
        SendMessageOfAthletes(Aths);
    }
    private void SendMessageOfAthletes(String[] Aths){
//        TODO:init读取各个裁判的ip
        IPOfGroup="127.0.0.1";
        IPOfJudges.add("127.0.0.1");
        Thread GroupMessage;
        //记录run类与线程的数组
        ArrayList<TSendAthletesMessage> ListOfJudges=new ArrayList<>();
        ArrayList<Thread> ListOfThread=new ArrayList<>();
        ArrayList<TSendAthletesMessage> ListOfMarkTable=new ArrayList<>();
        try {
            Socket chief = new Socket(IPOfGroup, 2019);
            GroupMessage=new Thread(new TSendAthletesMessage(chief,Aths));
            GroupMessage.start();
            for (String ip:IPOfJudges) {
                Socket Stemp=new Socket(ip,2019);
                if(Stemp.isConnected()){
                    TSendAthletesMessage TSMtemp=new TSendAthletesMessage(Stemp,Aths);
                    Thread Ttemp=new Thread(TSMtemp);
                    ListOfJudges.add(TSMtemp);
                    ListOfThread.add(Ttemp);
                    Ttemp.start();
                }
            }
            GroupMessage.join();
            //等待裁判完成打分
            for (Thread t:ListOfThread
                 ) {
                t.join();
            }
            for(TSendAthletesMessage mark:ListOfJudges){
                SendMarkTable(chief,mark);
            }
            BufferedReader br=new BufferedReader(new InputStreamReader(chief.getInputStream()));
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(chief.getOutputStream()));
            bw.write("FinishSendMarks");
            String feedback=br.readLine();
//            br.close();
//            bw.close();
            if(feedback.equals("OK")){
                //若确认通过则返回
                //TODO 读取奖励分惩罚分
                //TODO 统计最终分数存储到数据库
                return;
            }else{
                SendMessageOfAthletes(Aths);
                return;
            }
        }catch (Exception x){
//      TODO 异常处理
        }

    }

    //发送从裁判获得的打分
    private void SendMarkTable(Socket target,TSendAthletesMessage message) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(target.getInputStream()));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(target.getOutputStream()));
        /*bw.write(ProName+"marks");
        if(br.readLine().equals("copy")){

        }*/
        //输出成绩表中所有姓名+成绩
        bw.write("SendMarkTable");
        bw.write(message.NameOfJudge);
        while(!br.readLine().equals("ready"));//等待直到ready
        for (Pair<String,Float> mark:message.MarkTable
                ) {
            bw.write(mark.getValue0()+'\n');
            bw.write(mark.getValue1().toString()+'\n');
        }
        bw.write("done");
//        bw.close();
//        br.close();
    }
}

//发送信息线程类 系统发送小组队员名单给裁判 暂存信息
class TSendAthletesMessage implements Runnable{
    Socket target;
    String NameOfJudge;
    String[]Message;
    ArrayList<Pair>MarkTable=new ArrayList<>();
    public TSendAthletesMessage(Socket s,String[] a){
        target=s;
        Message=a;
    }
    public void run() {
        try {
            SendMessage(target,Message);
        }catch (Exception e){

        }//TODO：异常处理
    }

//    发送运动员名单
    public void SendMessage(Socket s,String[] Aths)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bw.write("sendMessageOfAthlete\n");
        NameOfJudge=br.readLine();
        if(br.readLine().equals("ready")){
            for (String Ath:Aths) {
                bw.write(Ath+'\n');
            }
            bw.write("done");
        }
        if(br.readLine().equals("GroupJudge")){
            return;//目标是小组裁判时结束
        }else{
            //TODO:获取分数
            br.readLine();
            String Name;
            float Marks;
            while((Name=br.readLine())!="Finished"){
                Marks=Float.parseFloat(br.readLine());
                MarkTable.add(new Pair(Name,Marks));
            }
            //读取名字+分数直到null;
        }
//        bw.flush();
//        br.close();
//        bw.close();
    }
}

class TLoginServer implements Runnable{
    @Override
    public void run() {

    }
}




