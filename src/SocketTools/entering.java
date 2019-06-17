package SocketTools;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class entering {
    final static String IP_SERVER="127.0.0.1";
    final static int port=10000;
    private BufferedWriter bw;
    public static void main(String[] args) {
    }
    public void subteam(String Tname,String TID, String TPassword ,String TDoc){
        try {
            Socket conn = new Socket(IP_SERVER,port);
            bw=new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            bw.write("tosubteam"+"\n");
            bw.write(Tname+"\n"+TID+"\n"+TPassword+"\n"+TDoc+"\n");
            bw.write("end"+"\n");
            bw.flush();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    public void substuff(String Sname,String ID,String Tel, int Stype, int state){
        try {
            Socket conn = new Socket(IP_SERVER,port);
            bw=new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            bw.write("tosubstuff"+"\n");
            bw.write(Sname+"\n"+ID+"\n"+Tel+"\n"+Integer.toString(Stype)+"\n"+Integer.toString(state)+"\n");
            bw.write("end"+"\n");
            bw.flush();
        }catch (IOException ioe){
            return;
        }
    }
    public void subath(String Aname,String ID, int Age, int GroupID, int Grade,String sex, String  TID){
        try{
            Socket conn = new Socket(IP_SERVER,port);
            bw=new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            bw.write("tosubath"+"\n");
            bw.write(Aname+"\n"+ID+"\n"+Integer.toString(Age)+"\n"+Integer.toString(GroupID)+"\n");
            bw.write(Integer.toString(Grade)+"\n"+sex+"\n"+TID+"\n");
            bw.write("end"+"\n");
            bw.flush();
        }catch (IOException ioe){
            return;
        }
    }
    public void subgrade(String PID,int GroupID ){
        try {
            Socket conn = new Socket(IP_SERVER, port);
            bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            bw.write("tosubgrade"+"\n");
            bw.write(PID+"\n"+Integer.toString(GroupID)+"\n");
            bw.write("end"+"\n");
            bw.flush();
        }
        catch(IOException ioe){
            return;
        }
    }

}
