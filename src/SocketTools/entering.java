package SocketTools;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class entering {
    final static String IP_SERVER="127.0.0.1";
    final static int port=10000;
    final static int port1=10001;
    private BufferedWriter bw;
    private FileInputStream fis;
    private DataOutputStream dos;
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
    public void substuff(String SID,String Sname,String ID,String Tel, int Stype){
        try {
            Socket conn = new Socket(IP_SERVER,port);
            bw=new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            bw.write("tosubstuff"+"\n");
            bw.write(SID+"\n"+Sname+"\n"+ID+"\n"+Tel+"\n"+Integer.toString(Stype)+"\n");
            bw.write("end"+"\n");
            bw.flush();
        }catch (IOException ioe){
            return;
        }
    }
    public void subath(String Aname,String ID, int Age, int GroupID, int Grade,String sex, String  TID,int [] check){
        try{
            int[] pid=new int[9];
            Socket conn = new Socket(IP_SERVER,port);
            bw=new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            bw.write("tosubath"+"\n");
            bw.write(Aname+"\n"+ID+"\n"+Integer.toString(Age)+"\n"+Integer.toString(GroupID)+"\n");
            bw.write(Integer.toString(Grade)+"\n"+sex+"\n"+TID+"\n");
            for(int i =0;i<9;i++){
                pid[i]=check[i];
                bw.write(Integer.toString(pid[i])+"\n");
            }
            bw.write("end"+"\n");
            bw.flush();
        }catch (IOException ioe){
            return;
        }
    }
    public void subDoc(String TDoc) throws IOException{
        String url =TDoc;
        File file=new File(url);
        try {
            Socket conn = new Socket(IP_SERVER, port1);
            fis = new FileInputStream(file);
            dos = new DataOutputStream(conn.getOutputStream());
            dos.writeUTF(file.getName());
            // dos.flush();
            dos.writeLong(file.length());
            dos.flush();
            System.out.println("======== 开始传输文件 ========");
            byte[] bytes = new byte[1024];
            int length = 0;

            while ((length = fis.read(bytes, 0, bytes.length)) != -1) {
                dos.write(bytes, 0, length);
                dos.flush();
            }
            System.out.println("======== 文件传输成功 ========");
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("客户端文件传输异常");
        }finally{
            fis.close();
            dos.close();
        }
    }

}
