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
    //增加工作人员 初始化（没有IP PID SPassword,SLogin）
    public boolean InsertData(String SID,String SName,String ID,String Tel,int SType){
        String sql="insert into stuff(SID,SName,ID,Tel,SType,IP,PID,SPassword,SLogin) values " +
                "('"+SID+"','"+SName+"','"+ID+"','"+Tel+"',"+SType+",null,'10',null,0)";
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
    //用SID作为条件，修改SLogin的状态
    public boolean ModifySLogin(String SID){
        boolean judge=Search_SLogin(SID);
        int SLogin=0;
        if(!judge){
            SLogin=1;
        }else {
            SLogin=0;
        }
        String formName="stuff";
        String condition="SID=\'"+SID+"\'" ;
        String modified="SLogin="+SLogin+"";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //PID修改裁判的状态
    public boolean ModifyStype(String PID,int Modify){
        String formName="stuff";
        String condition="PID=\'"+PID+"\'";
        String modified="SType="+Modify+"";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //用PID作为条件，修改Count1的人数
    public boolean ModifyCount1(String PID,int C){
        String formName="project";
        String condition="PID=\'"+PID+"\'" ;
        ArrayList<Sextet<String,String,Integer,Integer,Integer,Integer>> al=SearchProject(PID);
        int Count1=al.get(0).getValue2()+C;
        String modified="Count1="+Count1+"";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //用PID作为条件，修改Count2的人数
    public boolean ModifyCount2(String PID,int C){
        String formName="project";
        String condition="PID=\'"+PID+"\'" ;
        ArrayList<Sextet<String,String,Integer,Integer,Integer,Integer>> al=SearchProject(PID);
        int Count2=al.get(0).getValue3()+C;
        String modified="Count2="+Count2+"";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //用PID作为条件，修改Count3的人数
    public boolean ModifyCount3(String PID,int C){
        String formName="project";
        String condition="PID=\'"+PID+"\'" ;
        ArrayList<Sextet<String,String,Integer,Integer,Integer,Integer>> al=SearchProject(PID);
        int Count3=al.get(0).getValue4()+C;
        String modified="Count3="+Count3+"";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //用PID作为条件，修改PerGroupCount的人数
    public boolean ModifyPerGroupCount(String PID,int C){
        String formName="project";
        String condition="PID=\'"+PID+"\'" ;
        String modified="PerGroupCount="+C+"";
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
    public boolean ModifyCScore(String PID,int GroupID,String AID,float C){
        String formName="gradegroup";
        String condition="PID=\'"+PID+"\' AND AID=\'"+AID+"\' AND GroupID="+GroupID+"" ;
        float CScore=C;
        String modified="CScore="+CScore+"";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //PID,AID修改决赛成绩
    public boolean ModifyJScore(String PID,int GroupID,String AID,float C){
        String formName="gradegroup";
        String condition="PID=\'"+PID+"\' AND AID=\'"+AID+"\' AND GroupID="+GroupID+"" ;
        float JScore=C;
        String modified="JScore="+JScore+"";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //修改match表的比赛状态
    public boolean ModifyMatch_Judge(String PName,int Judge){
        String formName="match";
        String condition="PName=\'"+PName+"\'" ;
        String modified="Judge="+Judge+"";
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
    //用AID查询个人成绩 返回 运动员编号 姓名 比赛项目 初赛成绩  初赛排名 决赛成绩 决赛排名
    public ArrayList<Septet<String,String,String,Float,Integer,Float,Integer>> SearchAthleteGrade(String athleteID){
        String sql1="select * from Search_Team_Initial_Core where AID='"+athleteID+"'";
        String AID=athleteID,AName=null,PName=null,PID=null;
        int GroupID=0;
        float CSCore=0f,JSCore=0f;
        //部分返回
        ArrayList<Triplet<String,String,String>> al1=new ArrayList();
        try{
            rst=state.executeQuery(sql1);
            while(rst.next()){
                AName=rst.getString("AName");
                PName=rst.getString("PName");
                Triplet<String,String,String> T=new Triplet<>(athleteID,AName,PName);
                al1.add(T);
            }
        }catch (SQLException e){
            System.out.println("视图队伍查询成绩错误");
            e.printStackTrace();
        }

        //总返回
        ArrayList<Septet<String,String,String,Float,Integer,Float,Integer>> al=new ArrayList<>();
        try{
            String sql2="select * from gradegroup where AID='"+athleteID+"'";
           // ArrayList<String> al_pid=new ArrayList<>();
            rst=state.executeQuery(sql2);
            int i=0;
            while(rst.next()){
                PID=rst.getString("PID");
                GroupID=rst.getInt("GroupID");
                Quartet<Float,Integer,Float,Integer> AT = SearchTheRank(PID,GroupID,athleteID);
                Septet<String,String,String,Float,Integer,Float,Integer> AT2 =new Septet<>(al1.get(i).getValue0(),al1.get(i).getValue1(),
                        al1.get(i).getValue2(),AT.getValue0(),AT.getValue1(),AT.getValue2(),AT.getValue3());
                al.add(AT2);
            }
            return al;
        }catch (SQLException e){
            System.out.println("视图队伍查询成绩错误");
            e.printStackTrace();
            return null;
        }
    }
    //用PID，GroupID查询 返回 运动员编号 姓名 比赛项目 初赛成绩  初赛排名 决赛成绩 决赛排名
    public ArrayList<Septet<String,String,String,Float,Integer,Float,Integer>> SearchProjectGrade(String projectID,int GroupID){
        //PID AID rank score
        ArrayList<Quartet<String,String,Integer,Float>> arrayList1=SearchTheAtheleteRank("Search_Team_Initial_Core",projectID,GroupID);
        ArrayList<Quartet<String,String,Integer,Float>> arrayList2=SearchTheAtheleteRank("Search_Team_Final_Core",projectID,GroupID);
        //最后的返回结果
        ArrayList<Septet<String,String,String,Float,Integer,Float,Integer>> arrayList=new ArrayList<>();
        for(int i=0;i<arrayList1.size();i++){
            String AName=SearchAname(arrayList1.get(i).getValue1());
            String PName=SearchPName(arrayList1.get(i).getValue0());
            arrayList.add(new Septet<>(arrayList1.get(i).getValue1(),AName,PName,arrayList1.get(i).getValue3(),arrayList1.get(i).getValue2(),0f,0));
        }
        for(int i=0;i<arrayList2.size();i++){
            //遍历arrayList1找到是否有决赛的AID
            for(int j=0;j<arrayList1.size();j++){
                if(arrayList2.get(i).getValue1().equals(arrayList1.get(j).getValue1())){
                    arrayList.add(j,new Septet<>(arrayList.get(j).getValue0(),arrayList.get(j).getValue1(),arrayList.get(j).getValue2(),
                            arrayList.get(j).getValue3(),arrayList.get(j).getValue4(),arrayList2.get(i).getValue3(),arrayList2.get(i).getValue2()));
                    arrayList.remove(j+1);
                }
            }
        }
        return arrayList;
    }
    //用teamID查询整个成绩 返回 团队名 比赛项目 团队成绩 团队排名
    public ArrayList<Quartet<String,String,Float,Integer>> SearchTeamAll(String teamID){
        String sql="select PID,GroupID from gradegroup";
        String PID=null;
        int GroupID=0;
        //找到所有的不同的项目
        ArrayList<Pair<String,Integer>> al=new ArrayList<>();
        //最后的返回
        ArrayList<Quartet<String,String,Float,Integer>> a=new ArrayList<>();
        try{
            rst=state.executeQuery(sql);
            //先找到不同的PID的分组
            while(rst.next()){
                boolean judge=false;
                PID=rst.getString("PID");
                for(int i=0;i<al.size();i++){
                    if(PID.equals(al.get(i).getValue0())){
                        judge=true;
                        break;
                    }
                }
                if (!judge){
                    GroupID=rst.getInt("GroupID");
                    al.add(new Pair<>(PID,GroupID));
                }
            }
            //找到之后分别进行操作
            for(int i=0;i<al.size();i++){
                Pair<Integer,Float> team=SearchTeamRank(teamID,al.get(i).getValue0(),al.get(i).getValue1());
                String Tname=SearchTName(teamID);
                String Pname=SearchPName(al.get(i).getValue0());
                a.add(new Quartet<>(Tname,Pname,team.getValue1(),team.getValue0()));
            }
            return a;
        }catch (SQLException e){
            System.out.println("视图队伍查询成绩错误");
            e.printStackTrace();
            return null;
        }
    }
    //用teamID,projectid,goupID查团体赛成绩及排名   排名  分数
    public Pair<Integer,Float> SearchTeamRank(String teamID,String projectID,int goupID){
        ArrayList<Triplet<String,Float,Integer>> arrayList=SearchTheTeamRank(projectID,goupID);
        boolean judge=false;
        Pair<Integer,Float> team=null;
        for(int i=0;i<arrayList.size();i++){
            if(teamID.equals(arrayList.get(i).getValue0())){
                judge=true;
                team.setAt0(arrayList.get(i).getValue2());
                team.setAt1(arrayList.get(i).getValue1());
                break;
            }
        }
        return team;
    }
    //用PID AID 确定初赛排名，决赛排名
    public Quartet<Float,Integer,Float,Integer> SearchTheRank(String projectID,int GroupID,String AthleteID){
        int initialRank=0,finalRank=0;
        float CScore=0f,JScore=0f;
        ArrayList<Quartet<String,String,Integer,Float>> alInitial=SearchTheAtheleteRank("Search_Team_Initial_Core",projectID,GroupID);
        ArrayList<Quartet<String,String,Integer,Float>> alFinal=SearchTheAtheleteRank("Search_Team_Final_Core",projectID,GroupID);
        for (int i=0;i<alInitial.size();i++){
            if (AthleteID.equals(alInitial.get(i).getValue1())){
                initialRank=alInitial.get(i).getValue2();
                CScore=alInitial.get(i).getValue3();
                break;
            }
        }
        for (int i=0;i<alFinal.size();i++){
            if (AthleteID.equals(alFinal.get(i).getValue1())){
                finalRank=alFinal.get(i).getValue2();
                JScore=alFinal.get(i).getValue3();
                break;
            }
        }
        Quartet<Float,Integer,Float,Integer> AT=new Quartet<>(CScore,initialRank,JScore,finalRank);
        return AT;
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
    //用PID和SType(不同种类的裁判)去查询负责该项目的裁判IP
    public ArrayList<String> SearchProject_IP(String PID,int SType){
        String sql="select * from stuff where PID='"+PID+"' SType="+SType+"";
        ArrayList<String> arrayList=new ArrayList<>();
        String IP=null;
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                IP=rst.getString("IP");
                arrayList.add(IP);
            }
            return arrayList;
        }catch (SQLException e){
            System.out.println("裁判SType错误");
            e.printStackTrace();
            return null;
        }
    }
    //用裁判的SID 返回Stype
    public int SearchStype(String SID){
        String sql="select * from stuff where SID='"+SID+"'";
        int SType=0;
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                SType=rst.getInt("SType");
            }
            return SType;
        }catch (SQLException e){
            System.out.println("裁判SType错误");
            e.printStackTrace();
            return 0;
        }
    }
    //用ID查SID
    public String SearchSId(String ID){
        String sql="select * from stuff where ID='"+ID+"'";
        String SID=null;
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                SID=rst.getString("SID");
            }
            return SID;
        }catch (SQLException e){
            System.out.println("裁判SID错误");
            e.printStackTrace();
            return null;
        }
    }
    //SID password 返回bool
    public boolean Stuff_Verify_password(String SID,String password){
        String sql="select * from stuff where SID='"+SID+"'";
        String SPassword=null;
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                SPassword=rst.getString("SPassword");
            }
            if (SPassword.equals(password)){
                return true;
            }else {
                return false;
            }
        }catch (SQLException e){
            System.out.println("裁判密码判断错误");
            e.printStackTrace();
            return false;
        }
    }
    //用AID查名字
    public String SearchAname(String AID){
        String sql="select * from athlete where AID='"+AID+"'";
        String AName=null;
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                AName=rst.getString("AName");
            }
            return AName;
        }catch (SQLException e){
            System.out.println("PID查询错误");
            e.printStackTrace();
            return null;
        }
    }
    //用项目的名字查ID
    public String SearchPID(String PName){
        String sql="select * from project where PName='"+PName+"'";
        String PID=null;
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                PID=rst.getString("PID");
            }
            return PID;
        }catch (SQLException e){
            System.out.println("PID查询错误");
            e.printStackTrace();
            return null;
        }
    }
    //用PID查PName
    public String SearchPName(String PID){
        String sql="select * from project where PID='"+PID+"'";
        String PName=null;
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                PName=rst.getString("PName");
            }
            return PName;
        }catch (SQLException e){
            System.out.println("PID查询错误");
            e.printStackTrace();
            return null;
        }
    }
    //用TID查TName
    public String SearchTName(String TID){
        String sql="select * from team where TID='"+TID+"'";
        String TName=null;
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                TName=rst.getString("TName");
            }
            return TName;
        }catch (SQLException e){
            System.out.println("PID查询错误");
            e.printStackTrace();
            return null;
        }
    }
    //用SID查询SLogin的状态,true为已登陆，false为未登陆
    public boolean Search_SLogin(String SID){
        String sql="select * from stuff where SID='"+SID+"'";
        int SLogin=0;
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                SLogin=rst.getInt("SLogin");
            }
        }catch (SQLException e){
            System.out.println("裁判SID错误");
            e.printStackTrace();
        }finally {
            if(SLogin == 1){
                return true;
            }else {
                return false;
            }
        }
    }
    //用PName,GroupID查询比赛是否完成(返回-1则为数据库错误，0初赛比赛未开始，1初赛比赛开始了，2为初赛比赛结束，
    // 3决赛比赛未开始，4决赛比赛开始了，5决赛比赛结束)
    public  int SearchMatch(String PName,int GroupID){
        int J=0;
        //sql语句
        String sql="select * from match where PName='"+PName+"' AND GroupID="+GroupID;
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
    //项目ID groupid 检索决赛选手 姓名+编号
    public ArrayList<Pair<String,String>> SearchFinalPeopleList(String ProjectID,int GroupID){
        //sql语句
        String sql="select * from gradegroup where PID='"+ProjectID+"' GroupID="+GroupID+"  ORDER BY CScore DESC";
        ArrayList<String> ListAthleteID=new ArrayList();
        ArrayList<Pair<String,String>> al= new ArrayList();
        String AID=null;
        //在成绩表里查询该项目，该组别的AID
        try{
            rst=state.executeQuery(sql);
            for(int i=0;i<10;i++){
                if(rst.next()){
                    AID=rst.getString("AID");
                    ListAthleteID.add(AID);
                }
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
    //项目ID 检索初赛选手 姓名+编号  (所有的该项目的姓名+编号)
    public ArrayList<Pair<String,String>> SearchPeopleList(String ProjectID,int GroupID){
        //sql语句
        String sql="select * from gradegroup where PID='"+ProjectID+"' GroupID="+GroupID+"";
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
    //判断TID,是否存在
    public boolean JudgeTID(String TeamID){
        String sql="select TID from team ";
        String TID=null;
        boolean judge=false;
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                TID=rst.getString("TID");
                if(TID.equals(TeamID)){
                    judge=true;
                }
            }
            return judge;
        }catch (SQLException e){
            System.out.println("视图队伍查询成绩错误");
            e.printStackTrace();
            return false;
        }
    }
    //判断SID,是否存在
    public boolean JudgeSID(String StuffID){
        String sql="select SID from stuff ";
        String SID=null;
        boolean judge=false;
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                SID=rst.getString("SID");
                if(SID.equals(StuffID)){
                    judge=true;
                }
            }
            return judge;
        }catch (SQLException e){
            System.out.println("视图队伍查询成绩错误");
            e.printStackTrace();
            return false;
        }
    }
    //查询所有的PID
    public ArrayList<String> SearchAllPID(){
        String sql="select PID from project";
        String PID=null;
        boolean judge=false;
        //最后要返回的东西
        ArrayList<String> arrayList=new ArrayList<>();
        try{
            rst=state.executeQuery(sql);
            //不同的PID加入数组   然后相同数量加1 不同数量为0
            while(rst.next()){
                PID=rst.getString("PID");
                for(int i=0;i<arrayList.size();i++){
                    if(PID.equals(arrayList.get(i))){
                        judge=true;
                        break;
                    }
                }
                if (!judge){
                    arrayList.add(PID);
                }
            }
            return arrayList;
        }catch (SQLException e){
            System.out.println("视图队伍查询成绩错误");
            e.printStackTrace();
            return null;
        }
    }
    //查询所有还有空位的项目。 返回  可以添加裁判的Pname
    public ArrayList<String> SearchProjectList(){
        String sql="select PID from stuff";
        String PID=null;
        //String 是不同的PID  Integer是表示裁判数量
        ArrayList<Pair<String,Integer>> arrayList=new ArrayList<>();
        //最后要返回的东西
        ArrayList<String> arrayList1=new ArrayList<>();
        try{
            rst=state.executeQuery(sql);
            //不同的PID加入数组   然后相同数量加1 不同数量为0
            while(rst.next()){
                boolean judge=false;
                int address=0;
                PID=rst.getString("PID");
                for(int i=0;i<arrayList.size();i++){
                    if(PID.equals(arrayList.get(i).getValue0())){
                        judge=true;
                        address=i;
                        break;
                    }
                }
                if (!judge){
                    arrayList.add(new Pair<>(PID,1));
                }else {
                    arrayList.add(new Pair<>(PID,arrayList.get(address).getValue1()+1));
                    arrayList.remove(address);
                }
            }
            rst=state.executeQuery(sql);
            ArrayList<String> arrayList2=SearchAllPID();
            //将已经有五个裁判的项目剔除
            for (int i=0;i<arrayList.size();i++){
                if(arrayList.get(i).getValue1() >= 5){
                    arrayList2.remove(arrayList.get(i).getValue0());
                }
            }
            //将PID转化为PName
            for (int i=0;i<arrayList2.size();i++){
                String Pname=SearchPName(arrayList2.get(i));
                arrayList1.add(Pname);
            }
            return arrayList1;
        }catch (SQLException e){
            System.out.println("视图队伍查询成绩错误");
            e.printStackTrace();
            return null;
        }
    }
    //查询所有的tid，tname
    public ArrayList<Pair<String,String>> SearchAllteam(){
        String sql="select TID,TName from team";
        String TID=null,TName=null;
        ArrayList<Pair<String,String>> arrayList=new ArrayList<>();
        try{
            rst=state.executeQuery(sql);
            while (rst.next()){
                TID=rst.getString("TID");
                TName=rst.getString("TName");
                arrayList.add(new Pair<>(TID,TName));
            }
            return arrayList;
        }catch (SQLException e){
            System.out.println("视图队伍查询成绩错误");
            e.printStackTrace();
            return null;
        }
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
    //用PID，查询选手的排名情况
    public ArrayList<Quartet<String,String,Integer,Float>> SearchTheAtheleteRank(String tablename,String PID,int GroupID){
        String sql="select * from "+tablename+" where PID='"+PID+"' GroupID="+GroupID+"";
        String AID=null;
        Float Score=0f;
        int rank=0;
        //PID AID rank Score
        ArrayList<Quartet<String,String,Integer,Float>> al=new ArrayList();
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                AID=rst.getString("AID");
                if(tablename.equals("Search_Team_Initial_Core")){
                    Score=rst.getFloat("CScore");
                }else {
                    Score=rst.getFloat("JScore");
                }
                if(Score != 0f){
                    rank++;
                }
                Quartet<String,String,Integer,Float> a=new Quartet<>(
                        PID,AID,rank,Score);
                al.add(a);
            }
            return al;
        }catch (SQLException e){
            System.out.println("视图队伍查询成绩错误");
            e.printStackTrace();
            return null;
        }
    }
    //PID，groupID 查询团队的排名情况,分数的获得情况
    public ArrayList<Triplet<String,Float,Integer>> SearchTheTeamRank(String ProjectID,int groupid){
        String sql="select * from athlete,gradegroup where PID='"+ProjectID+"' and GroupID="+groupid+"";
        String TID=null;
        float cscore=0f,jscore=0f,grade=0f;
        //String为TID,Float为分数,int 为排名
        ArrayList<Triplet<String,Float,Integer>> al1=new ArrayList<>();
        try{
            rst=state.executeQuery(sql);
            //先找到不同的TID的分组
            while(rst.next()){
                boolean judge=false;
                TID=rst.getString("TID");
                for(int i=0;i<al1.size();i++){
                    if(TID.equals(al1.get(i).getValue0())){
                        judge=true;
                        break;
                    }
                }
                if (!judge){
                    al1.add(new Triplet<>(TID,0f,0));
                }
            }
            //把成绩添加进去
            while(rst.next()){
                //暂时的成绩
                float score=0f;
                TID=rst.getString("TID");
                for(int i=0;i<al1.size();i++){
                    if(TID.equals(al1.get(i).getValue0())){
                        cscore=rst.getFloat("CScore");
                        jscore=rst.getFloat("JScore");
                        //选择成绩最好的那个赋值
                        if(cscore >= jscore){
                            score=cscore;
                        }else {
                            score=jscore;
                        }
                        grade=grade+score;
                        al1.remove(i);
                        al1.add(new Triplet<>(TID,grade,i));
                        break;
                    }
                }
            }
            //排序的函数
            for(int i=0;i<al1.size();i++){
                for(int j=0;j<al1.size()-1;j++){
                    if(al1.get(j).getValue1()<=al1.get(j+1).getValue1()){
                        al1.add(j,new Triplet<>(al1.get(j+1).getValue0(),al1.get(j+1).getValue1(),j));
                        al1.add(j+1,new Triplet<>(al1.get(j).getValue0(),al1.get(j).getValue1(),j+1));
                        al1.remove(j+2);
                        al1.remove(j+3);
                    }
                }
            }
            return al1;
        }catch (SQLException e){
            System.out.println("视图队伍查询成绩错误");
            e.printStackTrace();
            return null;
        }
    }

}
