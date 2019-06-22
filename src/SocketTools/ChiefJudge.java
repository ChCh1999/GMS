package SocketTools;

import teamUI.MainRefe;

import java.io.*;
import java.net.Socket;

public class ChiefJudge {
    final int PORT=ServerData.PORT_Chief;
    final String ServerIP=ServerData.ipOfServer;
    private String cID;
    private MainRefe mReferee;
//    public static void main(String[] args) {
//        ChiefJudge m=new ChiefJudge();
//        m.startpro("体操",0);
//    }
    public ChiefJudge(MainRefe mRe,String cID){
        mReferee=mRe;
        this.cID=cID;
    }
    public void startpro(String pro,int group){
        try {
//            System.out.println("启动");
            int port = PORT;
            Socket clientcp=new Socket(ServerIP,port);
//            BufferedReader br=new BufferedReader(new InputStreamReader(clientcp.getInputStream()));
//            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(clientcp.getOutputStream(),"UTF-8"));
            TStartPro newpro=new TStartPro(clientcp,pro,group,mReferee);
            Thread request=new Thread(newpro);
            request.start();
//            request.join();
//            String feedback=br.readLine();
////            bw.write("Finished");
//            //br.close();
//            //bw.close();
//            //clientcp.close();
//            if(newpro.success){
//
//                if(feedback.equals("End")){
//                    System.out.println("结束");
//                    return  true;
//                }
//
//                else
//                    System.out.println("项目未正常结束");
//            }else {
//                return false;
//            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
//        return  false;
    }

    public String getcID() {
        return cID;
    }
}
class TStartPro implements Runnable{
    private MainRefe mReferee;
    private String ProName;
    private int group;

    private Socket Server;
    private BufferedWriter bw;
    private BufferedReader br;
    public boolean success;//请求成功
    public boolean done;//比赛结束
    TStartPro(Socket server,String pro,int group,MainRefe mRe){
        mReferee=mRe;
        Server=server;
        ProName=pro;
        this.group=group;
        try {
            br=new BufferedReader(new InputStreamReader(Server.getInputStream(),"utf-8"));
            bw=new BufferedWriter(new OutputStreamWriter(Server.getOutputStream(),"UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        success=false;
        done=false;
    }
    @Override
    public void run() {
//        直接忽略所有错误
        try {

            System.out.println(Server.isConnected());
            if(send(Server,ProName,group)){
                System.out.println(ProName+"请求成功");
                //TODO:前端提示相应的请求成功消息
                mReferee.addmessageArea(mReferee.getMessageArea(),ProName+"请求成功\n");
                success=true;
                String feedback=br.readLine();
                if(feedback.equals("End")){
                    System.out.println("结束");
                    //TODO:前端提示相应的比赛结束消息
                    mReferee.addmessageArea(mReferee.getMessageArea(),ProName+"结束\n");
                }

                else{
                    //TODO:前端提示相应的比赛没有成功结束消息
                    System.out.println("项目未正常结束");
                    mReferee.addmessageArea(mReferee.getMessageArea(),ProName+"项目未正常结束,"+feedback+"\n");
                }

            }
            else{
                System.out.println("请求失败");
                //TODO:前端提示相应的请求失败消息
                mReferee.addmessageArea(mReferee.getMessageArea(),ProName+"请求失败\n");
                success=false;
                return;
            }
        }catch (Exception e){

        }
    }
    public boolean send(Socket cp,String pro,int group){
        try {
            bw.write(pro+'\n');
            bw.write(group+"\n");
            bw.flush();


            String feedback= br.readLine();
//            bw1.close();
            //br1.close();//释放资源
            System.out.println(feedback);
            if(feedback.equals("Start")){
                return true;
            } else {
                return false;
            }

        }catch (Exception e ){

        }
        return false;

    }
}
