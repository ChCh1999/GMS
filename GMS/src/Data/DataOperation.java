package Data;
import java.sql.*;
import java.util.ArrayList;
import org.javatuples.*;

public class DataOperation {
    private Connection con=null;
    private Statement state=null;
    public ResultSet rst=null;
//这里初始化的表还是试验时候的表
    public DataOperation(){
        try{
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //getConnecting（）方法，用来连接mysql的数据库
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/gms?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false  ","root","123456");
            if(!con.isClosed()){
                System.out.println("Succeeded connecting to the Database");
            }
            //创建statement 对象 ，用来执行sql 语句
            state=con.createStatement();
        }catch (ClassNotFoundException e){
            //数据库驱动类异常处理
            System.out.println("can't find the Driver!");
            e.printStackTrace();
        }catch (SQLException e){
            //数据库连接失败异常处理
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace(); //handle exception
        }
    }

//增加操作多为重载函数
    //增加一个代表队 初始化  全
    public boolean InsertData(String TName,String TID,String TPassword,String TDoc){
        String sql="insert into Team(TName,TID,TPassword,TDoc) values " +
                "('"+TName+"','"+TID+"','"+TPassword+"','"+TDoc+"')";
        try {
            state.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            System.out.println("数据库增加代表队操作出现错误");
            e.printStackTrace();
            return false;
        }
    }
    //增加运动员  初始化  全
    public boolean InsertData(String AName,String ID,int Age,int GroupID,int Grade,String AID,String TID){
        String sql="insert into athlete(AName,ID,Age,GroupID,Grade,AID,TID) values "+
                "('"+AName+"','"+ID+"',"+Age+",'"+GroupID+"',"+Grade+",'"+AID+"','"+TID+"')";
        try {
            state.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            System.out.println("数据库增加运动员操作出现错误");
            e.printStackTrace();
            return false;
        }
    }
    //增加工作人员 初始化（没有IP PID SPassword）
    public boolean InsertData(String SID,String SName,String ID,String Tel,int SType){
        String sql="insert into stuff(SID,SName,ID,Tel,SType,IP,PID) values " +
                "('"+SID+"','"+SName+"','"+ID+"','"+Tel+"',"+SType+",null,null,null)";
        try {
            state.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            System.out.println("数据库增加工作人员操作出现错误");
            e.printStackTrace();
            return false;
        }
    }
    //增加项目 初始化（没有人数）
    public boolean InsertData(String PID,String PName){
        String sql="insert into project(PID,PName) values " +
                "('"+PID+"','"+PName+"',0,0,0,0)";
        try {
            state.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            System.out.println("数据库增加项目操作出现错误");
            e.printStackTrace();
            return false;
        }
    }
    //增加match，初始化Judge 0
    public boolean InsertData(String PName,int GroupID,int Sex){
        String sql="insert into match(PName,GroupID,Sex,Judge) values " +
                "('"+PName+"',"+GroupID+","+Sex+",0)";
        try {
            state.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            System.out.println("数据库增加match操作出现错误");
            e.printStackTrace();
            return false;
        }
    }
    //增加成绩 初始化（没有预赛成绩和决赛成绩）
    public boolean InsertData(String PID,String AID,int GroupID){
        String sql="insert into gradegroup(PID,AID,GroupID,CScore,JScore) values " +
                "('"+PID+"','"+AID+"','"+GroupID+"',0f,0f)";
        try {
            state.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            System.out.println("数据库增加操作出现错误");
            e.printStackTrace();
            return false;
        }
    }

//删除操作（用各个ID来进行删除）
    //AID删除运动员
    public boolean DeleteAthlete(String AID){
        String formName="athlete";
        String condition="AID=\'"+AID+"\'";
        boolean b=DeleteData(formName,condition);
        return b;
    }
    //用PID,AID删除成绩
    public boolean DeleteGradegroup(String PID,String AID){
        String formName="gradegroup";
        String condition="PID=\'"+PID+"\' AND AID=\'"+AID+"\'";
        boolean b=DeleteData(formName,condition);
        return b;
    }
    //用PID删除一个项目比赛
    public boolean DeleteProject(String PID){
        String formName="project";
        String condition="PID=\'"+PID+"\'";
        boolean b=DeleteData(formName,condition);
        return b;
    }
    //用SID删除一个工作人员
    public boolean DeleteStuff(String SID){
        String formName="stuff";
        String condition="SID=\'"+SID+"\'";
        boolean b=DeleteData(formName,condition);
        return b;
    }
    //用TID删除一个队伍
    public boolean DeleteTeam(String TID){
        String formName="team";
        String condition="TID=\'"+TID+"\'";
        boolean b=DeleteData(formName,condition);
        return b;
    }
    //删除表中的数据 传入数据表名  删除的条件(基础调用函数)
    public boolean DeleteData(String formName,String condition){
        String sql="delete from "+formName+" where "+condition;
        try{
            state.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            System.out.println("数据库删除出现错误");
            e.printStackTrace();
            return false;
        }
    }


//修改操作(用各个ID来修改想要修改的值)
    //用SID作为条件，初始化PID的值（可修改）
    public boolean ModifyPID(String SID,String PID){
        String formName="stuff";
        String condition="SID=\'"+SID+"\'" ;
        String modified="PID=\'"+PID+"\'";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //用SID作为条件，修改裁判IP
    public boolean ModifyIP(String SID,String IP){
        String formName="stuff";
        String condition="SID=\'"+SID+"\'" ;
        String modified="IP=\'"+IP+"\'";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //用SID作为条件，初始化或添加SPassword
    public boolean ModifySPassword(String SID,String SPassword){
        String formName="stuff";
        String condition="SID=\'"+SID+"\'" ;
        String modified="SPassword=\'"+SPassword+"\'";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //PID修改裁判的状态
    public boolean ModifyStype(String PID,int Modify){
        String formName="stuff";
        String condition="PID=\'"+PID+"\'";
        String modified="SType=\'"+Modify+"\'";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //用PID作为条件，修改Count1的人数
    public boolean ModifyCount1(String PID,int C){
        String formName="project";
        String condition="PID=\'"+PID+"\'" ;
        ArrayList<Sextet<String,String,Integer,Integer,Integer,Integer>> al=SearchProject(PID);
        int Count1=al.get(0).getValue2()+C;
        String modified="Count1=\'"+Count1+"\'";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //用PID作为条件，修改Count2的人数
    public boolean ModifyCount2(String PID,int C){
        String formName="project";
        String condition="PID=\'"+PID+"\'" ;
        ArrayList<Sextet<String,String,Integer,Integer,Integer,Integer>> al=SearchProject(PID);
        int Count2=al.get(0).getValue3()+C;
        String modified="Count2=\'"+Count2+"\'";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //用PID作为条件，修改Count3的人数
    public boolean ModifyCount3(String PID,int C){
        String formName="project";
        String condition="PID=\'"+PID+"\'" ;
        ArrayList<Sextet<String,String,Integer,Integer,Integer,Integer>> al=SearchProject(PID);
        int Count3=al.get(0).getValue4()+C;
        String modified="Count3=\'"+Count3+"\'";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //用PID作为条件，修改PerGroupCount的人数
    public boolean ModifyPerGroupCount(String PID,int C){
        String formName="project";
        String condition="PID=\'"+PID+"\'" ;
        String modified="PerGroupCount=\'"+C+"\'";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //用TID作为条件，修改Team的密码
    public boolean ModifyTPassword(String TID,String TPassword){
        String formName="eam";
        String condition="TID=\'"+TID+"\'" ;
        String modified="TPassword=\'"+TPassword+"\'";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //PID，AID修改初赛成绩
    public boolean ModifyCScore(String PID,String AID,float C){
        String formName="gradegroup";
        String condition="PID=\'"+PID+"\' AND AID=\'"+AID+"\'" ;
        float CScore=C;
        String modified="CScore=\'"+CScore+"\'";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //PID,AID修改决赛成绩
    public boolean ModifyJScore(String PID,String AID,float C){
        String formName="gradegroup";
        String condition="PID=\'"+PID+"\' AND AID=\'"+AID+"\'" ;
        float JScore=C;
        String modified="JScore=\'"+JScore+"\'";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //修改数据库，传入 数据表名字  约束条件  想要修改的值(基础修改操作)
    public boolean ModifyData(String formName,String condition,String modified){
        String sql="update "+formName+" set "+modified+" where "+condition;
        try{
            state.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            System.out.println("数据库修改出现错误");
            e.printStackTrace();
            return false;
        }
    }


//查询
    //用TID返回一个队伍 队名 运动员名字 组号 初赛成绩 项目名字
    public ArrayList<Quintet<String,String,Integer,Float,String>> SearchInitialGrade(String teamID){
        String sql="select * from Search_Team_Initial_Core where TID='"+teamID+"'";
        String TName=null,AName=null,PName=null;
        int GroupID=0;
        float CSCore=0f;
        ArrayList<Quintet<String,String,Integer,Float,String>> al=new ArrayList();
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                TName=rst.getString("TID");
                AName=rst.getString("AID");
                GroupID=rst.getInt("GroupID");
                CSCore=rst.getFloat("CScore");
                PName=rst.getString("PID");
                Quintet<String,String,Integer,Float,String> a=new Quintet<>(
                        TName,AName,GroupID,CSCore,PName);
                al.add(a);
            }
            return al;
        }catch (SQLException e){
            System.out.println("视图队伍查询成绩错误");
            e.printStackTrace();
            return null;
        }
    }
    //用TID返回一个队伍 队名 运动员名字 组号 决赛成绩 项目名字
    public ArrayList<Quintet<String,String,Integer,Float,String>> SearchFinalGrade(String teamID){
        String sql="select * from Search_Team_Final_Core where TID='"+teamID+"'";
        String TName=null,AName=null,PName=null;
        float JSCore=0f;
        int GroupID=0;
        ArrayList<Quintet<String,String,Integer,Float,String>> al=new ArrayList();
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                TName=rst.getString("TID");
                AName=rst.getString("AID");
                GroupID=rst.getInt("GroupID");
                JSCore=rst.getFloat("JSCore");
                PName=rst.getString("PID");
                Quintet<String,String,Integer,Float,String> a=new Quintet<>(
                        TName,AName,GroupID,JSCore,PName);
                al.add(a);
            }
            return al;
        }catch (SQLException e){
            System.out.println("视图队伍成绩查询错误");
            e.printStackTrace();
            return null;
        }
    }
    //用AID查询个人成绩 返回 运动员姓名 运动员ID 运动员组别 运动员初赛成绩
    public ArrayList<Quartet<String,String,Integer,Float>> SearchPersonalInitialGrade(String athleteID){
        String sql="select * from gradegroup where AID='"+athleteID+"'";
        String AID=null,AName=null;
        float CSCore=0f;
        int GroupID=0,i=0;
        ArrayList<Quartet<String,String,Integer,Float>> a1=new ArrayList();
        ArrayList<Triplet<String,Integer,Float>> a2=new ArrayList();
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                AID=rst.getString("AID");
                GroupID=rst.getInt("GroupID");
                CSCore=rst.getFloat("CSCore");
                Triplet<String,Integer,Float> a=new Triplet<>(AID,GroupID,CSCore);
                a2.add(a);
            }
            String sql2="select * from athlete where AID='"+athleteID+"'";
            rst=state.executeQuery(sql2);
            while(rst.next()){
                AName=rst.getString("AName");
                AID=a2.get(i).getValue0();
                GroupID=a2.get(i).getValue1();
                CSCore=a2.get(i).getValue2();
                Quartet<String,String,Integer,Float> a=new Quartet<>(AName,AID,GroupID,CSCore);
                a1.add(a);
                i++;
            }
            return a1;
        }catch (SQLException e){
            System.out.println("个人成绩查询错误");
            e.printStackTrace();
            return null;
        }
    }
    //用AID查询个人成绩 返回 运动员姓名 运动员ID 运动员组别 运动员决赛成绩
    public ArrayList<Quartet<String,String,Integer,Float>> SearchPersonalFinalGrade(String athleteID){
        String sql="select * from gradegroup where AID='"+athleteID+"'";
        String AID=null,AName=null;
        float JSCore=0f;
        int GroupID=0,i=0;
        ArrayList<Quartet<String,String,Integer,Float>> a1=new ArrayList();
        ArrayList<Triplet<String,Integer,Float>> a2=new ArrayList();
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                AID=rst.getString("AID");
                GroupID=rst.getInt("GroupID");
                JSCore=rst.getFloat("JSCore");
                Triplet<String,Integer,Float> a=new Triplet<>(AID,GroupID,JSCore);
                a2.add(a);
            }
            String sql2="select * from athlete where AID='"+athleteID+"'";
            rst=state.executeQuery(sql2);
            while(rst.next()){
                AName=rst.getString("AName");
                AID=a2.get(i).getValue0();
                GroupID=a2.get(i).getValue1();
                JSCore=a2.get(i).getValue2();
                Quartet<String,String,Integer,Float> a=new Quartet<>(AName,AID,GroupID,JSCore);
                a1.add(a);
                i++;
            }
            return a1;
        }catch (SQLException e){
            System.out.println("个人成绩查询错误");
            e.printStackTrace();
            return null;
        }
    }
    //用裁判的SID去搜索IP
    public String SearchIP(String SID){
        String sql="select * from stuff where SID='"+SID+"'";
        String IP=null;
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                IP=rst.getString("IP");
            }
            return IP;
        }catch (SQLException e){
            System.out.println("裁判IP错误");
            e.printStackTrace();
            return null;
        }
    }

    //用PName,GroupID查询比赛是否完成(返回-1则为数据库错误，0为比赛未开始，1为比赛开始了)
    public  int SearchMatch(String PName,int GroupID){
        int J=0;
        //sql语句
        String sql="select * from match where PName='"+PName+"' AND GroupID="+GroupID+"'";
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                J=rst.getInt("Judge");
            }
            return  J;
        }catch (SQLException e){
            System.out.println("数据库match查询出现错误");
            e.printStackTrace();
            return 0;
        }
    }
    //项目ID 组别 检索选手 姓名+编号  (所有的该项目的姓名+编号)
    public ArrayList<Pair<String,String>> SearchPeopleList(String ProjectID,int GroupID){
        //sql语句
        String sql="select * from gradegroup where PID='"+ProjectID+"' AND GroupID="+GroupID+"";
        ArrayList<String> ListAthleteID=new ArrayList();
        ArrayList<Pair<String,String>> al= new ArrayList();
        String AID=null;
        //在成绩表里查询该项目，该组别的AID
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                AID=rst.getString("AID");
                ListAthleteID.add(AID);
            }
        }catch(SQLException e){
            System.out.println("检索失败");
            e.printStackTrace();
        }
        for (int i=0;ListAthleteID.get(i)!=null;i++){
            //第一个参数是用AID查询选手的名字
            Pair<String,String> Ath=new Pair<>(SearchAthlete(ListAthleteID.get(i)).get(0).getValue0(),
                    ListAthleteID.get(i));
            al.add(Ath);
        }
        return al;
    }


//查询之中所有的基础操作。
    //用AID查询运动员信息
    public ArrayList<Septet<String,String,Integer,Integer,Integer,String,String>> SearchAthlete(String AthleteID){
        //sql语句
        String sql="select * from athlete where AID='"+AthleteID+"'";
        //初始化
        String AName=null,ID=null,AID=null,TID=null;
        int Age=0,Grade=0,GroupID=0;
        ArrayList<Septet<String,String,Integer,Integer,Integer,String,String>> al=new ArrayList();
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                AName=rst.getString("AName");
                ID=rst.getString("ID");
                Age=rst.getInt("Age");
                GroupID=rst.getInt("GroupID");
                Grade=rst.getInt("Grade");
                AID=rst.getString("AID");
                TID=rst.getString("TID");
                Septet<String,String,Integer,Integer,Integer,String,String> AT=new Septet<>(AName,ID,Age,GroupID,Grade,AID,TID);
                al.add(AT);
            }
            return al;
        }catch (SQLException e){
            System.out.println("数据库Athlete查询出现错误");
            e.printStackTrace();
            return null;
        }
    }
    //用TID查询代表队信息
    public  ArrayList<Quartet<String,String,String,String>> SearchTeam(String TeamID){
        //sql语句
        String sql="select * from team where TID='"+TeamID+"'";
        //初始化
        String TName=null,TID=null,TPassword=null,TDoc=null;
        ArrayList<Quartet<String,String,String,String>> al=new ArrayList();
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                TName=rst.getString("TName");
                TID=rst.getString("TID");
                TPassword=rst.getString("TPassword");
                TDoc=rst.getString("TDoc");
                Quartet<String,String,String,String> TT=new Quartet<>(TName,TID,TPassword,TDoc);
                al.add(TT);
            }
            return al;
        }catch (SQLException e) {
            System.out.println("数据库Team查询出现错误");
            e.printStackTrace();
            return null;
        }
    }
    //用PID查询项目信息
    public  ArrayList<Sextet<String,String,Integer,Integer,Integer,Integer>> SearchProject(String ProjectID){
        //sql语句
        String sql="select * from project where PID='"+ProjectID+"'";
        //初始化
        String PID=null,PName=null;
        int Count1=0,Count2=0,Count3=0,PerGroupCount=0;
        ArrayList<Sextet<String,String,Integer,Integer,Integer,Integer>> al=new ArrayList();
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                PID=rst.getString("PID");
                PName=rst.getString("PName");
                Count1=rst.getInt("Count1");
                Count2=rst.getInt("Count2");
                Count3=rst.getInt("Count3");
                PerGroupCount=rst.getInt("PerGroupCount");
                Sextet<String,String,Integer,Integer,Integer,Integer> PT=new Sextet<>(PID,PName,Count1,Count2,Count3,PerGroupCount);
                al.add(PT);
            }
            return al;
        }catch (SQLException e){
            System.out.println("数据库Project查询出现错误");
            e.printStackTrace();
            return null;
        }
    }
    //SID查询工作人员的信息
    public  ArrayList<Septet<String,String,String,String,Integer,String,String>> SearchStuff(String StuffID){
        //sql语句
        String sql="select * from stuff where SID='"+StuffID+"'";
        //初始化
        String SID=null,SName=null,ID=null,Tel=null,IP=null,PID=null;
        int SType=0;
        ArrayList<Septet<String,String,String,String,Integer,String,String>> al=new ArrayList();
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                SID=rst.getString("SID");
                SName=rst.getString("SName");
                ID=rst.getString("ID");
                Tel=rst.getString("Tel");
                SType=rst.getInt("SType");
                IP=rst.getString("IP");
                PID=rst.getString("PID");
                Septet<String,String,String,String,Integer,String,String> T=new Septet<>(SID,SName,ID,Tel,SType,IP,PID);
                al.add(T);
            }
            return al;
        }catch (SQLException e){
            System.out.println("数据库Stuff查询出现错误");
            e.printStackTrace();
            return null;
        }
    }
    //用AID,PID二者合一查询成绩表
    public  ArrayList<Quintet<String,String,Integer,Float,Float>> SearchGradeGroup(String ProjectID,String AthleteID){
        //sql语句
        String sql="select * from gradegroup where PID='"+ProjectID+"' AND AID='"+AthleteID+"'";
        //初始化
        String PID=null,AID=null;
        int GroupID=0;
        float CScore=0.0f,JScore=0.0f;
        ArrayList<Quintet<String,String,Integer,Float,Float>> al=new ArrayList();
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                PID=rst.getString("PID");
                AID=rst.getString("AID");
                GroupID=rst.getInt("GroupID");
                CScore=rst.getFloat("CScore");
                JScore=rst.getFloat("JScore");
                Quintet<String,String,Integer,Float,Float> T=new Quintet<>(PID,AID,GroupID,CScore,JScore);
                al.add(T);
            }
            return al;
        }catch (SQLException e){
            System.out.println("数据库Gradegroup查询出现错误");
            e.printStackTrace();
            return null;
        }
    }

}
