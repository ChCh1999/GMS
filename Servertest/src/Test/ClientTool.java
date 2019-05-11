package Server;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTool {

    public static void main(String[] args) {
        login("2019001","000");
    }

    final static String IP_SERVER="127.0.0.1";
    final static int PORT_LOGIN=10087;
    public static int login(String SID,String Password){
        try{
            Socket login=new Socket(IP_SERVER,PORT_LOGIN);
            BufferedReader br_login=new BufferedReader(new InputStreamReader(login.getInputStream()));
            BufferedWriter bw_login=new BufferedWriter(new OutputStreamWriter(login.getOutputStream()));

            bw_login.write("login request"+'\n');
            bw_login.write(SID+'\n');
            bw_login.write(Password+'\n');
            bw_login.flush();
            //System.out.println(id);
            if(Boolean.parseBoolean(br_login.readLine())){
                int state=Integer.parseInt(br_login.readLine());
                System.out.println("登录成功");
                return state;
            }else {
                System.out.println("登录失败");
                return -1;
            }
        }catch (UnknownHostException une){
            System.out.println(une);
            return -1;
        }catch (IOException ioe){
            System.out.println(ioe);
            return -1;
        }
    }
}
