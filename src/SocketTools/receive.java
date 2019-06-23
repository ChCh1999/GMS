package SocketTools;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import Data.*;
import Data.DataOperation;
public class receive implements Runnable  {
    final static int port = 10000;

    public void run(){
        try {
            ServerSocket subserver = new ServerSocket(port);
            while(true){
                Socket socket = subserver.accept();
                Thread sub= new Thread(new TsubHandle(socket));
                sub.start();
            }
        }
        catch(IOException e){
        }
    }
}
class TsubHandle implements  Runnable{
    Socket Sub;
    data aaa=new data();
    int AIDmen=aaa.AIDmen;
    int AIDwomen=aaa.AIDwomen;
    String AID =Integer.toString(aaa.AID);
    TsubHandle(Socket sub) {
        this.Sub = sub;
        System.out.println("处理登陆信息");
    }
    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(Sub.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(Sub.getOutputStream()));

            String func = br.readLine();
            System.out.println(func);
            if(func.equals("tosubteam")){
                String Tname,TID,TPassword,TDoc;
                Tname=br.readLine();
                TID=br.readLine();
                TPassword = br.readLine();
                TDoc = br.readLine();
                br.close();
                DataOperation con = new DataOperation();
                con.InsertData(Tname,TID,TPassword,TDoc);
            }
            else if (func.equals("tosubath")){
                String Aname,ID,sex,TID,PID;
                String [] pid= new String[9];
                int Age,GroupID,Grade;
                Aname=br.readLine();
                ID=br.readLine();
                Age=Integer.parseInt(br.readLine());
                GroupID=Integer.parseInt(br.readLine());
                Grade=Integer.parseInt(br.readLine());
                sex=br.readLine();
                TID=br.readLine();
                for(int i =0; i<9; i++){
                    pid[i]=br.readLine();
                }
                if(sex.equals("men")){
                    AID=Integer.toString(AIDmen);
                    aaa.AID=AIDmen;
                   aaa.AIDmen+=2;
                }
                else if(sex.equals("women")){
                    AID = Integer.toString(AIDwomen);
                    aaa.AID=AIDwomen;
                    aaa.AIDwomen+=2;
                }
                DataOperation con1 = new DataOperation();
                con1.InsertData(Aname,ID,Age,GroupID,Grade,AID,TID);
                for(int i =0;i<9;i++){
                    if(Integer.parseInt(pid[i])>0){
                        con1.InsertData(pid[i],AID,GroupID);
                    }
                }
                br.close();
            }
            else if(func.equals("tosubstuff")){
                String Sname, ID, TEL,SID;
                int Stype;
                SID = br.readLine();
                Sname = br.readLine();
                ID = br.readLine();
                TEL = br.readLine();
                Stype = Integer.parseInt(br.readLine());
                DataOperation con1 = new DataOperation();
                con1.InsertData(SID, Sname, ID, TEL, Stype);
                br.close();
            }
            else {
                System.out.println("error...");
                return;
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
            System.out.println("BAOZUO");
        }
        System.out.println("录入结束");
    }

}
