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
            String func = br.readLine();
            System.out.println(func);
            if(func.equals("tosubteam")){
                String Tname,TID,TPassword,TDoc;
                Tname=br.readLine();
                TID=br.readLine();
                TPassword = br.readLine();
                TDoc = br.readLine();
                DataOperation con = new DataOperation();
                con.InsertData(Tname,TID,TPassword,TDoc);
                while(br.readLine().equals("end")){
                    br.close();
                }
            }
            else if (func.equals("tosubath")){
                String Aname,ID,sex,TID;
                int Age,GroupID,Grade;
                Aname=br.readLine();
                ID=br.readLine();
                Age=Integer.parseInt(br.readLine());
                GroupID=Integer.parseInt(br.readLine());
                Grade=Integer.parseInt(br.readLine());
                sex=br.readLine();
                TID=br.readLine();
                if(sex.equals("men")){
                    AID=Integer.toString(AIDmen );
                    aaa.AID=AIDmen;
                   aaa.AIDmen+=2;

                }
                else if(sex.equals("women")){
                    AID = Integer.toString(AIDwomen );
                    aaa.AID=AIDwomen;
                    aaa.AIDwomen+=2;
                }

                DataOperation con1 = new DataOperation();
                con1.InsertData(Aname,ID,Age,GroupID,Grade,AID,TID);
                while(br.readLine().equals("end")){
                    br.close();
                }

            }
            else if(func.equals("tosubstuff")){
                String Sname, ID, TEL,SID;
                int Stype;
                int SLogin;
                SID = br.readLine();
                Sname = br.readLine();
                ID = br.readLine();
                TEL = br.readLine();
                Stype = Integer.parseInt(br.readLine());
                SLogin= Integer.parseInt(br.readLine());
                DataOperation con1 = new DataOperation();
                con1.InsertData(SID, Sname, ID, TEL, Stype,SLogin);

                while (br.readLine().equals("end")) {
                    br.close();
                }
            }
            else if(func.equals("tosubgrade")){
                String PID;
                int GroupID;
                PID=br.readLine();
                GroupID = Integer.parseInt(br.readLine());
                DataOperation con1 = new DataOperation();
                con1.InsertData(PID,AID,GroupID);
                while (br.readLine().equals("end")) {
                    br.close();
                }
            }
            else {
                System.out.println("error...");
                return;
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        System.out.println("录入结束");
    }

}
