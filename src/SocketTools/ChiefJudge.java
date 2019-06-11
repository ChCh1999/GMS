package SocketTools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChiefJudge {
    final int PORT=10086;
    final String ServerIP="127.0.0.1";
    public static void main(String[] args) {
        ChiefJudge m=new ChiefJudge();
        m.startpro("体操",0);
    }

    public boolean startpro(String pro,int group){
        try {
            System.out.println("启动");
            int port = PORT;
            Socket clientcp=new Socket(ServerIP,port);
            BufferedReader br=new BufferedReader(new InputStreamReader(clientcp.getInputStream()));
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(clientcp.getOutputStream(),"UTF-8"));
            TStartPro newpro=new TStartPro(clientcp,pro,group);
            Thread request=new Thread(newpro);
            request.start();
            request.join();
            String feedback=br.readLine();
            bw.write("Finished");
            //br.close();
            //bw.close();
            //clientcp.close();
            if(newpro.success){

                if(feedback.equals("End")){
                    System.out.println("结束");
                    return  true;
                }

                else
                    System.out.println("项目未正常结束");
            }else {
                return false;
            }
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return  false;
    }


}
class TStartPro implements Runnable{
    private String ProName;
    private int group;
    private boolean MOrF;
    private Socket Server;
    public boolean success;//请求成功
    public boolean done;//比赛结束
    TStartPro(Socket server,String pro,int group){
        Server=server;
        ProName=pro;
        this.group=group;
        success=false;
        done=false;
    }
    @Override
    public void run() {
//        直接忽略所有错误
        try {

            System.out.println(Server.isConnected());
            if(send(Server,ProName,group,MOrF)){
                System.out.println(ProName+"请求成功");
                success=true;
            }

            else{
                System.out.println("请求失败");
                success=false;
                return;
            }
        }catch (Exception e){

        }
    }
    public static boolean send(Socket cp,String pro,int group,boolean MaleOrFemale){
        try {
            BufferedWriter bw1=new BufferedWriter(new OutputStreamWriter(cp.getOutputStream(),"UTF-8"));
            bw1.write(pro+'\n');
            bw1.write(group+"\n");
            bw1.flush();

            BufferedReader br1=new BufferedReader(new InputStreamReader(cp.getInputStream(),"utf-8"));
            String feedback= br1.readLine();
//            bw1.close();
            //br1.close();//释放资源
            System.out.println(feedback);
            //System.out.println(br1.readLine());
            if(feedback.equals("Start")){
                return true;
            }

            else {
                return false;
            }

        }catch (Exception e ){

        }
        return false;

    }
}
