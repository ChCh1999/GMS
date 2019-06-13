package SocketTools;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import Data.*;
import Data.DataOperation;
public class receive  implements Runnable {
    final static int port = 10000;
    static int AIDmen=000;
    static int AIDwomen=001;
    static int SID=0;
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

//    public static void receiveFile(Socket socket) {
//        byte[] inputByte = null;
//        int length = 0;
//        DataInputStream dis = null;
//        FileOutputStream fos = null;
//        try {
//            try {
//                dis = new DataInputStream(socket.getInputStream());
//                fos = new FileOutputStream(new File(""));
//                inputByte = new byte[1024];
//                System.out.println("开始接收数据...");
//                while ((length = dis.read(inputByte, 0, inputByte.length)) > 0) {
//                    System.out.println(length);
//                    fos.write(inputByte, 0, length);
//                    fos.flush();
//                }
//                System.out.println("完成接收");
//            } finally {
//                if (fos != null)
//                    fos.close();
//                if (dis != null)
//                    dis.close();
//                if (socket != null)
//                    socket.close();
//            }
//        } catch (Exception e) {
//        }
//    }
}
class TsubHandle implements  Runnable{
    Socket Sub;
    receive aaa = new receive();
    int AIDmen=aaa.AIDmen;
    int AIDwomen=aaa.AIDwomen;
    int SID=aaa.SID;
    String AID=null;
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
                Age=br.read();
                GroupID=br.read();
                Grade=br.read();
                sex=br.readLine();
                TID=br.readLine();
                if(sex.equals("men")){
                    AID=Integer.toString(AIDmen + 2);
                   aaa.AIDmen+=2;
                }
                else if(sex.equals("women")){
                    AID = Integer.toString(AIDwomen +2);
                    aaa.AIDwomen+=2;
                }
                DataOperation con1 = new DataOperation();
                con1.InsertData(Aname,ID,Age,GroupID,Grade,AID,TID);
                while(br.readLine().equals("end")){
                    br.close();
                }

            }
            else if(func.equals("tosubstuff")){
                String Sname, ID, TEL;
                int Stype,SLogin;
                Sname = br.readLine();
                ID = br.readLine();
                TEL = br.readLine();
                Stype = br.read();
                SLogin= br.read();
                DataOperation con1 = new DataOperation();
                con1.InsertData(Integer.toString(SID), Sname, ID, TEL, Stype,SLogin);
                aaa.SID++;
                while (br.readLine().equals("end")) {
                    br.close();
                }
            }
            else if(func.equals("tosubgrade")){
                String PID;
                int GroupID;
                PID=br.readLine();
                GroupID = br.read();
                DataOperation con1 = new DataOperation();
                con1.InsertData(PID,AID,GroupID);
                while (br.readLine().equals("end")) {
                    br.close();
                }
            }
            else {
                System.out.println("error");
                return;
            }

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        System.out.println("录入结束");
    }

}