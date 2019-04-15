package Data;
import java.sql.*;
import java.util.ArrayList;
import org.javatuples.*;

public class DataOperation {
    private Connection con=null;
    private Statement state=null;
    public ResultSet rst=null;
//�����ʼ���ı�������ʱ��ı�
    public DataOperation(){
        try{
            //��������
            Class.forName("com.mysql.cj.jdbc.Driver");
            //getConnecting������������������mysql�����ݿ�
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mt?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false  ","root","123456");
            if(!con.isClosed()){
                System.out.println("Succeeded connecting to the Database");
            }
            //����statement ���� ������ִ��sql ���
            state=con.createStatement();
        }catch (ClassNotFoundException e){
            //���ݿ��������쳣����
            System.out.println("can't find the Driver!");
            e.printStackTrace();
        }catch (SQLException e){
            //���ݿ�����ʧ���쳣����
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace(); //handle exception
        }
    }

//���Ӳٶ�Ϊ���غ���
    //����һ������� ��ʼ��  ȫ
    public boolean InsertData(String TName,String TID,String TPassword,String TDoc){
        String sql="insert into Team(TName,TID,TPassword,TDoc) values " +
                "('"+TName+"','"+TID+"','"+TPassword+"','"+TDoc+"')";
        try {
            state.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            System.out.println("���ݿ����Ӵ���Ӳ������ִ���");
            e.printStackTrace();
            return false;
        }
    }
    //�����˶�Ա  ��ʼ��  ȫ
    public boolean InsertData(String AName,String ID,int Age,int GroupID,int Grade,String AID,String TID){
        String sql="insert into athlete(AName,ID,Age,GroupID,Grade,AID,TID) values "+
                "('"+AName+"','"+ID+"',"+Age+",'"+GroupID+"',"+Grade+",'"+AID+"','"+TID+"')";
        try {
            state.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            System.out.println("���ݿ������˶�Ա�������ִ���");
            e.printStackTrace();
            return false;
        }
    }
    //���ӹ�����Ա ��ʼ����û��IP PID��
    public boolean InsertData(String SID,String SName,String ID,String Tel,int SType){
        String sql="insert into stuff(SID,SName,ID,Tel,SType,IP,PID) values " +
                "('"+SID+"','"+SName+"','"+ID+"','"+Tel+"',"+SType+",null,null)";
        try {
            state.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            System.out.println("���ݿ����ӹ�����Ա�������ִ���");
            e.printStackTrace();
            return false;
        }
    }
    //������Ŀ ��ʼ����û��������
    public boolean InsertData(String PID,String PName){
        String sql="insert into project(PID,PName) values " +
                "('"+PID+"','"+PName+"',0,0,0,0)";
        try {
            state.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            System.out.println("���ݿ�������Ŀ�������ִ���");
            e.printStackTrace();
            return false;
        }
    }
    //����match����ʼ��Judge 0
    public boolean InsertData(String PName,int GroupID,int Sex){
        String sql="insert into match(PName,GroupID,Sex,Judge) values " +
                "('"+PName+"',"+GroupID+","+Sex+",0)";
        try {
            state.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            System.out.println("���ݿ�����match�������ִ���");
            e.printStackTrace();
            return false;
        }
    }
    //���ӳɼ� ��ʼ����û��Ԥ���ɼ��;����ɼ���
    public boolean InsertData(String PID,String AID,int GroupID){
        String sql="insert into gradegroup(PID,AID,GroupID,CScore,JScore) values " +
                "('"+PID+"','"+AID+"','"+GroupID+"',0,0)";
        try {
            state.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            System.out.println("���ݿ����Ӳ������ִ���");
            e.printStackTrace();
            return false;
        }
    }

//ɾ���������ø���ID������ɾ����
    //AIDɾ���˶�Ա
    public boolean DeleteAthlete(String AID){
        String formName="athlete";
        String condition="AID=\'"+AID+"\'";
        boolean b=DeleteData(formName,condition);
        return b;
    }
    //��PID,AIDɾ���ɼ�
    public boolean DeleteGradegroup(String PID,String AID){
        String formName="gradegroup";
        String condition="PID=\'"+PID+"\' AND AID=\'"+AID+"\'";
        boolean b=DeleteData(formName,condition);
        return b;
    }
    //��PIDɾ��һ����Ŀ����
    public boolean DeleteProject(String PID){
        String formName="project";
        String condition="PID=\'"+PID+"\'";
        boolean b=DeleteData(formName,condition);
        return b;
    }
    //��SIDɾ��һ��������Ա
    public boolean DeleteStuff(String SID){
        String formName="stuff";
        String condition="SID=\'"+SID+"\'";
        boolean b=DeleteData(formName,condition);
        return b;
    }
    //��TIDɾ��һ������
    public boolean DeleteTeam(String TID){
        String formName="team";
        String condition="TID=\'"+TID+"\'";
        boolean b=DeleteData(formName,condition);
        return b;
    }
    //ɾ�����е����� �������ݱ���  ɾ��������(�������ú���)
    public boolean DeleteData(String formName,String condition){
        String sql="delete from "+formName+" where "+condition;
        try{
            state.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            System.out.println("���ݿ�ɾ�����ִ���");
            e.printStackTrace();
            return false;
        }
    }


//�޸Ĳ���(�ø���ID���޸���Ҫ�޸ĵ�ֵ)
    //��SID��Ϊ��������ʼ��PID��ֵ
    public boolean ModifyPID(String SID,String PID){
        String formName="stuff";
        String condition="SID=\'"+SID+"\'" ;
        String modified="PID=\'"+PID+"\'";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //��SID��Ϊ�������޸Ĳ���IP
    public boolean ModifyIP(String SID,String IP){
        String formName="stuff";
        String condition="SID=\'"+SID+"\'" ;
        String modified="IP=\'"+IP+"\'";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //��PID��Ϊ�������޸�Count1������
    public boolean ModifyCount1(String PID,int C){
        String formName="project";
        String condition="PID=\'"+PID+"\'" ;
        ArrayList<Sextet<String,String,Integer,Integer,Integer,Integer>> al=SearchProject(PID);
        int Count1=al.get(0).getValue2()+C;
        String modified="Count1=\'"+Count1+"\'";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //��PID��Ϊ�������޸�Count2������
    public boolean ModifyCount2(String PID,int C){
        String formName="project";
        String condition="PID=\'"+PID+"\'" ;
        ArrayList<Sextet<String,String,Integer,Integer,Integer,Integer>> al=SearchProject(PID);
        int Count2=al.get(0).getValue3()+C;
        String modified="Count2=\'"+Count2+"\'";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //��PID��Ϊ�������޸�Count3������
    public boolean ModifyCount3(String PID,int C){
        String formName="project";
        String condition="PID=\'"+PID+"\'" ;
        ArrayList<Sextet<String,String,Integer,Integer,Integer,Integer>> al=SearchProject(PID);
        int Count3=al.get(0).getValue4()+C;
        String modified="Count3=\'"+Count3+"\'";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //��PID��Ϊ�������޸�PerGroupCount������
    public boolean ModifyPerGroupCount(String PID,int C){
        String formName="project";
        String condition="PID=\'"+PID+"\'" ;
        ArrayList<Sextet<String,String,Integer,Integer,Integer,Integer>> al=SearchProject(PID);
        int PerGroupCount=al.get(0).getValue5()+C;
        String modified="PerGroupCount=\'"+PerGroupCount+"\'";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //��TID��Ϊ�������޸�Team������
    public boolean ModifyTPassword(String TID,String TPassword){
        String formName="eam";
        String condition="TID=\'"+TID+"\'" ;
        String modified="TPassword=\'"+TPassword+"\'";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //PID��AID�޸ĳ����ɼ�
    public boolean ModifyCScore(String PID,String AID,float C){
        String formName="gradegroup";
        String condition="PID=\'"+PID+"\' AND AID=\'"+AID+"\'" ;
        float CScore=C;
        String modified="CScore=\'"+CScore+"\'";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //PID,AID�޸ľ����ɼ�
    public boolean ModifyJScore(String PID,String AID,float C){
        String formName="gradegroup";
        String condition="PID=\'"+PID+"\' AND AID=\'"+AID+"\'" ;
        float JScore=C;
        String modified="JScore=\'"+JScore+"\'";
        boolean b=ModifyData(formName,condition,modified);
        return b;
    }
    //�޸����ݿ⣬���� ���ݱ�����  Լ������  ��Ҫ�޸ĵ�ֵ(�����޸Ĳ���)
    public boolean ModifyData(String formName,String condition,String modified){
        String sql="update "+formName+" set "+modified+" where "+condition;
        try{
            state.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            System.out.println("���ݿ��޸ĳ��ִ���");
            e.printStackTrace();
            return false;
        }
    }


//��ѯ
    //��TID����һ������ ���� �˶�Ա���� ��� �����ɼ� ��Ŀ����
    public ArrayList<Quintet<String,String,Integer,Float,String>> SearchInitialGrade(String teamID){
        String sql="select * from Search_Team_Initial_Core where TID='"+teamID+"'";
        String TName=null,AName=null,PName=null;
        int GroupID=0;
        float CSCore=0;
        ArrayList<Quintet<String,String,String,Float,String>> al=new ArrayList();
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                TName=rst.getString("TID");
                AName=rst.getString("AID");
                GroupID=rst.getString("GroupID");
                CSCore=rst.getFloat("CScore");
                PName=rst.getString("PID");
                Quintet<String,String,String,Float,String> a=new Quintet<>(
                        TName,AName,GroupID,CSCore,PName);
                al.add(a);
                return al;
            }
        }catch (SQLException e){
            System.out.println("��ͼ������ѯ���ִ���");
            e.printStackTrace();
            return null;
        }
    }
    //��TID����һ������ ���� �˶�Ա���� ��� �����ɼ� ��Ŀ����
    public ArrayList<Quintet<String,String,Integer,Float,String>> SearchFinalGrade(String teamID){
        String sql="select * from Search_Team_Final_Core where TID='"+teamID+"'";
        String TName=null,AName=null,PName=null;
        float JSCore=0;
        int GroupID=0;
        ArrayList<Quintet<String,String,String,Float,String>> al=new ArrayList();
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                TName=rst.getString("TID");
                AName=rst.getString("AID");
                GroupID=rst.getString("GroupID");
                JSCore=rst.getFloat("JSCore");
                PName=rst.getString("PID");
                Quintet<String,String,String,Float,String> a=new Quintet<>(
                        TName,AName,GroupID,JSCore,PName);
                al.add(a);
                return al;
            }
        }catch (SQLException e){
            System.out.println("��ͼ������ѯ���ִ���");
            e.printStackTrace();
            return null;
        }
    }
    //��AID��ѯ���˵ĳɼ���δ��ɣ�
    public ArrayList<Quintet<String,String,String,Float,String>> SearchPersonalGrade(String athleteID){
        String sql="select * from gradegroup where AID='"+athleteID+"'";
        String TName=null,AName=null,GroupID=null,PName=null;
        float JSCore=0;
        ArrayList<Quintet<String,String,String,Float,String>> al=new ArrayList();
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                TName=rst.getString("TID");
                AName=rst.getString("AID");
                GroupID=rst.getString("GroupID");
                JSCore=rst.getFloat("JSCore");
                PName=rst.getString("PID");
                Quintet<String,String,String,Float,String> a=new Quintet<>(
                        TName,AName,GroupID,JSCore,PName);
                al.add(a);
                return al;
            }
        }catch (SQLException e){
            System.out.println("��ͼ������ѯ���ִ���");
            e.printStackTrace();
            return null;
        }
    }
    //�ò��е�SIDȥ����IP
    public String SearchIP(String SID){
        String sql="select * from stuff where SID='"+SID+"'";
        String IP=null;
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                IP=rst.getString("IP");
                return IP;
            }
        }catch (SQLException e){
            System.out.println("��ͼ������ѯ���ִ���");
            e.printStackTrace();
            return null;
        }
    }

    //��PName,GroupID,Sex��ѯ�����Ƿ����(����-1��Ϊ���ݿ����0Ϊ����δ��ʼ��1Ϊ������ʼ��)
    public  int SearchMatch(String PName,int GroupID,int Sex){
        //�ж�
        boolean judge=false;
        int J=0;
        //sql���
        String sql="select * from match where PName='"+PName+"' AND GroupID="+GroupID+"' AND Sex="+Sex;
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                J=rst.getInt("Judge");
                judge=true;
            }
        }catch (SQLException e){
            System.out.println("���ݿ�match��ѯ���ִ���");
            e.printStackTrace();
        }finally {
            if(judge){
                return J;
            }else {
                return -1;
            }
        }
    }
    //��ĿID ��� ����ѡ�� ����+���  (���еĸ���Ŀ������+���)
    public ArrayList<Pair<String,String>> SearchPeopleList(String ProjectID,int GroupID){
        //sql���
        String sql="select * from gradegroup where PID='"+ProjectID+"' AND GroupID="+GroupID+"";
        ArrayList<String> ListAthleteID=new ArrayList();
        ArrayList<Pair<String,String>> al=new new ArrayList();
        String AID=null;
        //�ڳɼ������ѯ����Ŀ��������AID
        try{
            rst=state.executeQuery(sql);
            while(rst.next()){
                AID=rst.getString("AID");
                ListAthleteID.add(AID);
            }
        }catch(SQLException e){
            System.out.println("����ʧ��");
            e.printStackTrace();
        }
        for (int i=0;ListAthleteID.get(i)!=null;i++){
            //��һ����������AID��ѯѡ�ֵ�����
            Pair<String,String> Ath=new Pair<>(SearchAthlete(ListAthleteID.get(i)).get(0).getValue0(),
                    ListAthleteID.get(i));
            al.add(Ath);
        }
        return al;
    }


//��ѯ֮�����еĻ���������
    //��AID��ѯ�˶�Ա��Ϣ
    public ArrayList<Septet<String,String,Integer,Integer,Integer,String,String>> SearchAthlete(String AthleteID){
        //�ж�
        boolean judge=false;
        //sql���
        String sql="select * from athlete where AID='"+AthleteID+"'";
        //��ʼ��
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
        }catch (SQLException e){
            System.out.println("���ݿ�Athlete��ѯ���ִ���");
            e.printStackTrace();
        }finally {
            if(judge){
                return al;
            }else {
                return null;
            }
        }
    }
    //��TID��ѯ�������Ϣ
    public  ArrayList<Quartet<String,String,String,String>> SearchTeam(String TeamID){
        //�ж�
        boolean judge=false;
        //sql���
        String sql="select * from team where TID='"+TeamID+"'";
        //��ʼ��
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
        }catch (SQLException e){
            System.out.println("���ݿ�Team��ѯ���ִ���");
            e.printStackTrace();
        }finally {
            if(judge){
                return al;
            }else {
                return null;
            }
        }
    }
    //��PID��ѯ��Ŀ��Ϣ
    public  ArrayList<Sextet<String,String,Integer,Integer,Integer,Integer>> SearchProject(String ProjectID){
        //�ж�
        boolean judge=false;
        //sql���
        String sql="select * from project where PID='"+ProjectID+"'";
        //��ʼ��
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
        }catch (SQLException e){
            System.out.println("���ݿ�Project��ѯ���ִ���");
            e.printStackTrace();
        }finally {
            if(judge){
                return al;
            }else {
                return null;
            }
        }
    }
    //SID��ѯ������Ա����Ϣ
    public  ArrayList<Septet<String,String,String,String,Integer,String,String>> SearchStuff(String StuffID){
        //�ж�
        boolean judge=false;
        //sql���
        String sql="select * from stuff where SID='"+StuffID+"'";
        //��ʼ��
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
                judge=true;
            }
        }catch (SQLException e){
            System.out.println("���ݿ�Stuff��ѯ���ִ���");
            e.printStackTrace();
        }finally {
            if(judge){
                return al;
            }else {
                return null;
            }
        }
    }
    //��AID,PID���ߺ�һ��ѯ�ɼ���
    public  ArrayList<Quintet<String,String,Integer,Float,Float>> SearchGradeGroup(String ProjectID,String AthleteID){
        //�ж�
        boolean judge=false;
        //sql���
        String sql="select * from gradegroup where PID='"+ProjectID+"' AND AID='"+AthleteID+"'";
        //��ʼ��
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
                judge=true;
            }
        }catch (SQLException e){
            System.out.println("���ݿ�Gradegroup��ѯ���ִ���");
            e.printStackTrace();
        }finally {
            if(judge){
                return al;
            }else {
                return null;
            }
        }
    }

    public void finalize(){
        try{
            String sql="select * from student";
            //ResultSet�࣬�����������ݿ��
            ResultSet rs=state.executeQuery(sql);
            //��ʾ���
            long studentNumber =0;
            String name=null;
            while (rs.next()){
                studentNumber=rs.getLong("StudentNumber");
                name=rs.getString("Name");
                System.out.println(studentNumber+"\t"+name);
            }
        }catch (SQLException e){
            System.out.println("���ݿ�ɾ�����ִ���");
            e.printStackTrace();
        }
    }
}
