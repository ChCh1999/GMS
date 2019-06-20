package SocketTools;

import org.javatuples.Quartet;
import org.javatuples.Septet;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

public class ClientTool {

    public static void main(String[] args) {
        login("2019001","000");
    }

    final static String IP_SERVER=ServerData.ipOfServer;
    final static int PORT_LOGIN=ServerData.PORT_Login;
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
                return 0;
            }
        }catch (UnknownHostException une){
            System.out.println(une);
            return 0;
        }catch (IOException ioe){
            System.out.println(ioe);
            return 0;
        }
    }
    public static void exit(String SID){
        try{
            Socket exit=new Socket(IP_SERVER,PORT_LOGIN);
//            BufferedReader br=new BufferedReader(new InputStreamReader(exit.getInputStream()));
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(exit.getOutputStream()));

            bw.write("exit request"+'\n');
            bw.write(SID+'\n');
            bw.flush();
        }catch (UnknownHostException une){
            System.out.println(une);
        }catch (IOException ioe){
            System.out.println(ioe);
        }
    }
    public static boolean changePassword(String SID,String Password,String newPassword){
        try{
            Socket login=new Socket(IP_SERVER,PORT_LOGIN);
            BufferedReader br_login=new BufferedReader(new InputStreamReader(login.getInputStream()));
            BufferedWriter bw_login=new BufferedWriter(new OutputStreamWriter(login.getOutputStream()));

            bw_login.write("change password"+'\n');
            bw_login.write(SID+'\n');
            bw_login.write(Password+'\n');
            bw_login.write(newPassword+'\n');
            bw_login.flush();
            //System.out.println(id);
            if(Boolean.parseBoolean(br_login.readLine())){
                System.out.println("修改成功");
                return true;
            }else {
                System.out.println("修改失败");
                return false;
            }
        }catch (UnknownHostException une){
            System.out.println(une);
            return false;
        }catch (IOException ioe){
            System.out.println(ioe);
            return false;
        }
    }


    public static HashMap<String,String> getAllTeamName(){
        try{
            Socket socket=new Socket(IP_SERVER,PORT_LOGIN);
            BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            bw.write("get team name\n");
            bw.flush();
            int count=Integer.parseInt(br.readLine());
            HashMap<String,String> res=new HashMap<>();
            int i=0;
            String temp;
            while (!(temp=br.readLine()).equals("Finished")){
                String id=br.readLine();
                res.put(temp,id);
                i++;
            }
            return res;
        }catch (UnknownHostException une){
            System.out.println(une);
            return null;
        }catch (IOException ioe){
            System.out.println(ioe);
            return null;
        }
    }

    //使用运动员ID查找成绩 运动员编号 姓名 比赛项目 初赛成绩  初赛排名 决赛成绩 决赛排名
    public static ArrayList<Septet<String,String,String,Float,Integer,Float,Integer>>SearchAthByNum(String atnNum){
//         login= null;
        ArrayList<Septet<String,String,String,Float,Integer,Float,Integer>>res=new ArrayList<>();
        try {
            Socket search = new Socket(IP_SERVER,PORT_LOGIN);
            BufferedReader br=new BufferedReader(new InputStreamReader(search.getInputStream()));
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(search.getOutputStream()));
            bw.write("Search ath by athnum\n");
            bw.write(atnNum+"\n");
            bw.flush();
            String num;
            while (!(num=br.readLine()).equals("Finished")){
                String name=br.readLine();
                String pro=br.readLine();
                Float cMark=Float.parseFloat(br.readLine());
                Integer cRank=Integer.parseInt(br.readLine());
                Float jMark=Float.parseFloat(br.readLine());
                Integer jRank=Integer.parseInt(br.readLine());
                res.add(new Septet<String,String,String,Float,Integer,Float,Integer>(num,name,pro,cMark,cRank,jMark,jRank));
            }
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //使用项目信息  查找成绩 运动员编号 姓名 比赛项目 初赛成绩  初赛排名 决赛成绩 决赛排名
    public static ArrayList<Septet<String,String,String,Float,Integer,Float,Integer>> SearchAthByPro(String proname){
        ArrayList<Septet<String,String,String,Float,Integer,Float,Integer>>res=new ArrayList<>();
        try {
            Socket search = new Socket(IP_SERVER,PORT_LOGIN);
            BufferedReader br=new BufferedReader(new InputStreamReader(search.getInputStream()));
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(search.getOutputStream()));
            bw.write("Search ath by proname\n");
            bw.write(proname+"\n");
            bw.flush();
            String num;
            while (!(num=br.readLine()).equals("Finished")){
                String name=br.readLine();
                String pro=br.readLine();
                Float cMark=Float.parseFloat(br.readLine());
                Integer cRank=Integer.parseInt(br.readLine());
                Float jMark=Float.parseFloat(br.readLine());
                Integer jRank=Integer.parseInt(br.readLine());
                res.add(new Septet<String,String,String,Float,Integer,Float,Integer>(num,name,pro,cMark,cRank,jMark,jRank));
            }
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //使用teamID查找 Quartet<团队名，比赛项目，团队成绩，团队排名>
    public static ArrayList<Quartet<String,String,Float,Integer>> SearchTeamGradeByTID(String TID){
        ArrayList<Quartet<String,String,Float,Integer>> res=new ArrayList<>();
        try {
            Socket search = new Socket(IP_SERVER,PORT_LOGIN);
            BufferedReader br=new BufferedReader(new InputStreamReader(search.getInputStream()));
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(search.getOutputStream()));
            bw.write("Search team by tid\n");
            bw.write(TID+"\n");
            bw.flush();
            String tName;
            while (!(tName=br.readLine()).equals("Finished")){
                String pro=br.readLine();
                Float Mark=Float.parseFloat(br.readLine());
                Integer Rank=Integer.parseInt(br.readLine());
                res.add(new Quartet<>(tName,pro,Mark,Rank));
            }
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //使用项目信息查找 Quartet<团队名，比赛项目，团队成绩，团队排名>
    public static ArrayList<Quartet<String,String,Float,Integer>> SearchTeamGradeByPro(String PName,int group){
        ArrayList<Quartet<String,String,Float,Integer>> res=new ArrayList<>();
        try {
            Socket search = new Socket(IP_SERVER,PORT_LOGIN);
            BufferedReader br=new BufferedReader(new InputStreamReader(search.getInputStream()));
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(search.getOutputStream()));
            bw.write("Search team by pro info\n");
            //TODO：确定性别
            bw.write(PName+"\n");
            bw.write(group+"\n");
            bw.flush();
            String tName;
            while (!(tName=br.readLine()).equals("Finished")){
                String pro=br.readLine();
                Float Mark=Float.parseFloat(br.readLine());
                Integer Rank=Integer.parseInt(br.readLine());
                res.add(new Quartet<>(tName,pro,Mark,Rank));
            }
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
