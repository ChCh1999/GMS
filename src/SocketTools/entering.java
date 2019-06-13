package SocketTools;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.File;
import java.net.UnknownHostException;
public class entering {
    final static String IP_SERVER=ServerData.ipOfServer;
    final static int PORT_LOGIN=ServerData.PORT_Login;
    final static int port=10000;
    private BufferedWriter bw;
    public  boolean logined=false;
    public static void main(String[] args) {
    }
    public void subteam(String Tname,String TID, String TPassword ,String TDoc){
        try {
            Socket conn = new Socket(IP_SERVER,port);
            bw=new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            bw.write("tosubteam");
            bw.write(Tname+"\n"+TID+"\n"+TPassword+"\n"+TDoc);
            bw.write("end");
        }catch (IOException ioe){
            return;
        }
    }
    public void substuff(String Sname,String ID,String Tel, int Stype, int state){
        try {
            Socket conn = new Socket(IP_SERVER,port);
            bw=new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            bw.write("tosubstuff");
            bw.write(Sname+"\n"+ID+"\n"+Tel+"\n"+Stype+"\n"+state);
            bw.write("end");
        }catch (IOException ioe){
            return;
        }
    }
    public void subath(String Aname,String ID, int Age, int GroupID, int Grade,String sex, String  TID){
        try{
            Socket conn = new Socket(IP_SERVER,port);
            bw=new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            bw.write("tosubath");
            bw.write(Aname+"\n"+ID+"\n"+Age+"\n"+GroupID);
            bw.write(Grade+"\n"+sex+"\n"+TID);
            bw.write("end");
        }catch (IOException ioe){
            return;
        }
    }
    public void subgrade(String PID,int GroupID ){
        try {
            Socket conn = new Socket(IP_SERVER, port);
            bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            bw.write("tosubgrade");
            bw.write(PID+"\n"+GroupID);
            bw.write("end");
        }
        catch(IOException ioe){
            return;
        }
    }
//    public void subword(String path){
//        int length = 0;
//        byte[] sendBytes = null;
//        Socket socket = null;
//        DataOutputStream dos = null;
//        FileInputStream fis = null;
//        try {
//            try {
//                ServerSocket enter3=new ServerSocket(PORT_LOGIN);
//                Socket conn = enter3.accept();
//                dos = new DataOutputStream(conn.getOutputStream());
//                File file = new File(path);
//                fis = new FileInputStream(file);
//                sendBytes = new byte[1024];
//                while ((length = fis.read(sendBytes, 0, sendBytes.length)) > 0) {
//                    dos.write(sendBytes, 0, length);
//                    dos.flush();
//                }
//            } finally {
//                if (dos != null)
//                    dos.close();
//                if (fis != null)
//                    fis.close();
//                if (socket != null)
//                    socket.close();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
