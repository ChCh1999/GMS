package teamUI;

import Data.DataOperation;
import SocketTools.data;
import SocketTools.entering;
import SocketTools.getword;
import SocketTools.receive;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class Apply extends JFrame {
    int count=0;
    String Tname,TID,TDoc;
    String TPassword="123456";
    String leadname,doctorname,trainname,judgename;
    String leadid,doctorid,trainid,judgeid;
    String leadtel,doctortel,traintel,judgetel;
    String leadsid,doctorsid,trainsid,judgesid;
    String [] error = new String[6];
	private JPanel contentPane;
	private JTextField tnameText;
	private JTextField leadername;
	private JTextField leaderID;
	private JTextField leaderPhNum;
	private JTextField Dname;
	private JTextField trainername;
	private JTextField refename;
	private JTextField DID;
	private JTextField trainerID;
	private JTextField refeID;
	private JTextField DPhNum;
	private JTextField trainerPhNum;
	private JTextField refePhNum;
	private JLabel readyNum;
	private JTextField readytext;
    private JFileChooser fileChooser = new JFileChooser();

	/**
	 * Launch the application.
	 */

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    Thread rec= new Thread(new receive());
                    rec.start();
                    Thread hhh=new Thread(new getword());
                    hhh.start();
                    Apply frame = new Apply();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
	/**
	 * Create the frame.
	 */
	public Apply() {
		setTitle("代表队报名");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 728, 387);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//代表队名称
		JLabel label = new JLabel("代表队名称");//代表队名称
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(10, 10, 97, 29);
		contentPane.add(label);
		
		//获取代表队名称
		
		tnameText = new JTextField();
		tnameText.setBounds(129, 10, 182, 27);
		contentPane.add(tnameText);
		tnameText.setColumns(10);

		
		JLabel leader = new JLabel("领队");//领队
		leader.setFont(new Font("宋体", Font.PLAIN, 18));
		leader.setBounds(10, 78, 97, 29);
		contentPane.add(leader);
		
		JLabel doctor = new JLabel("队医");//队医
		doctor.setFont(new Font("宋体", Font.PLAIN, 18));
		doctor.setBounds(10, 117, 97, 29);
		contentPane.add(doctor);
		
		JLabel trainer = new JLabel("教练员");//教练员
		trainer.setFont(new Font("宋体", Font.PLAIN, 18));
		trainer.setBounds(10, 156, 97, 29);
		contentPane.add(trainer);
		
		JLabel referee = new JLabel("裁判员");//裁判员
		referee.setFont(new Font("宋体", Font.PLAIN, 18));
		referee.setBounds(10, 195, 97, 29);
		contentPane.add(referee);

        JLabel SIDLabel = new JLabel("工号");
        SIDLabel.setFont(new Font("宋体", Font.PLAIN, 18));
        SIDLabel.setBounds(108, 47, 54, 29);
        contentPane.add(SIDLabel);

		JLabel name = new JLabel("姓名");//姓名
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("宋体", Font.PLAIN, 18));
        name.setBounds(186, 47, 66, 29);
		contentPane.add(name);
		
		JLabel IDnumber = new JLabel("身份证号");//身份证号
		IDnumber.setHorizontalAlignment(SwingConstants.CENTER);
		IDnumber.setFont(new Font("宋体", Font.PLAIN, 18));
        IDnumber.setBounds(273, 47, 137, 29);
		contentPane.add(IDnumber);
		
		leadername = new JTextField();//领队姓名
        leadname=leadername.getText();
		leadername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				
			}
		});
        leadername.setBounds(186, 83, 66, 23);
		contentPane.add(leadername);
		leadername.setColumns(10);

		JLabel phonenumber = new JLabel("电话号码");//电话号码
		phonenumber.setHorizontalAlignment(SwingConstants.CENTER);
		phonenumber.setFont(new Font("宋体", Font.PLAIN, 18));
        phonenumber.setBounds(445, 47, 137, 29);
		contentPane.add(phonenumber);

        leaderID = new JTextField();//领队身份证号
        leaderID.setColumns(10);
        leaderID.setBounds(267, 84, 168, 23);
        contentPane.add(leaderID);

        leaderPhNum = new JTextField();//领队电话号码
        leaderPhNum.setColumns(10);
        leaderPhNum.setBounds(445, 83, 168, 23);
        contentPane.add(leaderPhNum);

        Dname = new JTextField();//队医姓名
        Dname.setColumns(10);
        Dname.setBounds(186, 123, 66, 23);
        contentPane.add(Dname);

        DID = new JTextField();//队医身份证号
        DID.setColumns(10);
        DID.setBounds(267, 122, 168, 23);
        contentPane.add(DID);

        DPhNum = new JTextField();//队医电话号码
        DPhNum.setColumns(10);
        DPhNum.setBounds(445, 123, 168, 23);
        contentPane.add(DPhNum);

        trainername = new JTextField();//教练员姓名
        trainername.setColumns(10);
        trainername.setBounds(186, 162, 66, 23);
        contentPane.add(trainername);

        trainerID = new JTextField();//教练员身份证号
        trainerID.setColumns(10);
        trainerID.setBounds(267, 162, 168, 23);
        contentPane.add(trainerID);

        trainerPhNum = new JTextField();//教练员电话号码
        trainerPhNum.setColumns(10);
        trainerPhNum.setBounds(445, 161, 168, 23);
        contentPane.add(trainerPhNum);

        refename = new JTextField();//裁判员姓名
        refename.setColumns(10);
        refename.setBounds(186, 201, 66, 23);
        contentPane.add(refename);

        refeID = new JTextField();//裁判员身份证号
        refeID.setColumns(10);
        refeID.setBounds(267, 201, 168, 23);
        contentPane.add(refeID);

        refePhNum = new JTextField();//裁判员电话号码
        refePhNum.setColumns(10);
        refePhNum.setBounds(445, 201, 168, 23);
        contentPane.add(refePhNum);

        JTextField teamnumber = new JTextField();
        teamnumber.setBounds(433, 13, 182, 27);
        contentPane.add(teamnumber);
        teamnumber.setColumns(10);


        JLabel lblNewLabel = new JLabel("代表队账号");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
        lblNewLabel.setBounds(331, 10, 97, 29);
        contentPane.add(lblNewLabel);

        JTextField leaderSID = new JTextField();
        leaderSID.setBounds(87, 83, 75, 23);
        contentPane.add(leaderSID);
        leaderSID.setColumns(10);

        JTextField DrSID = new JTextField();
        DrSID.setColumns(10);
        DrSID.setBounds(87, 123, 75, 23);
        contentPane.add(DrSID);

        JTextField trainerSID = new JTextField();
        trainerSID.setColumns(10);
        trainerSID.setBounds(87, 162, 75, 23);
        contentPane.add(trainerSID);

        JTextField refeSID = new JTextField();
        refeSID.setColumns(10);
        refeSID.setBounds(87, 201, 75, 23);
        contentPane.add(refeSID);
		
		readyNum = new JLabel("已录入人员数");
		readyNum.setFont(new Font("宋体", Font.PLAIN, 18));
		readyNum.setBounds(10, 244, 131, 29);
		contentPane.add(readyNum);

		
		readytext = new JTextField();
		readytext.setBounds(147, 247, 78, 27);
		readytext.setEditable(false);
		contentPane.add(readytext);
		readytext.setColumns(10);
        readytext.setText(Integer.toString(count));

		JButton messageup = new JButton("上传文件");//上传文件
		messageup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
                int i = fileChooser.showOpenDialog(getContentPane());// 显示文件选择对话框
                if (i == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();// 获得选中的文件对象
                    TDoc=selectedFile.getAbsolutePath();
                }
                try {
					entering enter =new entering();
					enter.subDoc(TDoc); // 传输文件
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		messageup.setBounds(446, 246, 111, 28);
		contentPane.add(messageup);

		JButton backbutton = new JButton("返回");
		backbutton.setFont(new Font("宋体", Font.PLAIN, 18));
		backbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		backbutton.setBounds(77, 287, 200, 40);
		contentPane.add(backbutton);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"单杠","双杠","吊环","跳马","自由体操","鞍马","蹦床","高低杠","平衡木"}));
        comboBox.setBounds(623, 162, 79, 23);
        contentPane.add(comboBox);

        JButton btnNewButton = new JButton("录入队员信息");
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 18));
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Tname=tnameText.getText();
                leadname=leadername.getText();
                leadid=leaderID.getText();
                leadtel=leaderPhNum.getText();
                leadsid=leaderSID.getText();
                doctorname = Dname.getText();
                doctorid=DID.getText();
                doctortel=DPhNum.getText();
                doctorsid=DrSID.getText();
                trainname=trainername.getText();
                trainid=trainerID.getText();
                traintel=trainerPhNum.getText();
                trainsid=trainerSID.getText();
                judgename=refename.getText();
                judgeid=refeID.getText();
                judgetel = refePhNum.getText();
                judgesid= refeSID.getText();
                TID= teamnumber.getText();
                data aaa=new data();
                aaa.AIDmen=Integer.parseInt(TID)*50;
                aaa.AIDwomen=Integer.parseInt(TID)*50;

                DataOperation conn = new DataOperation();
                for(int i=0;i<6;i++){error[i]=" ";}
                if(conn.JudgeTID(TID)){error[0]="代表队账号";};
                if(conn.JudgeSID(leadsid)){error[1]="领队职工号";};
                if(conn.JudgeSID(doctorsid)){error[2]="队医职工号";};
                if(conn.JudgeSID(trainsid)){error[3]="教练职工号";};
                if(conn.JudgeSID(judgesid)){error[4]="裁判职工号";};
                int flag=0;
                for(int j=0;j<5;j++){
                    if(error[j]!=" "){
                        flag=1;
                        break;
                    }
                }
                if(leadsid.equals(doctorsid)||leadsid.equals(trainsid)||leadsid.equals(judgesid)
                        ||doctorsid.equals(trainsid)||doctorsid.equals(judgesid)||trainsid.equals(judgesid)){
                    error[5]="职工号命名重复";
                    flag=1;
                }
                if(flag==1) {
                    JFrame jf=new JFrame();
                    jf.setTitle("录入数据已经存在！！！");
                    jf.setBounds(400, 250, 450, 300);
                    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    jf.getContentPane().setLayout(null);

                    JLabel jl = new JLabel(error[0]+error[1]+error[2]
                            +error[3]+error[4]+error[5]);
                    jl.setFont(new Font("宋体", Font.PLAIN, 18));
                    jl.setBounds(170, 100, 200, 30);
                    jf.getContentPane().add(jl);
                    jf.setVisible(true);

                    JButton jb = new JButton("返回");
                    jb.setFont(new Font("宋体", Font.PLAIN, 18));
                    jb.setBounds(170, 150, 100, 30);
                    jb.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent arg0) {
                            jf.dispose();
                        }
                    });
                    jf.getContentPane().add(jb);
                }
                else{
                    entering enter = new entering();
                    enter.subteam(Tname,TID,TPassword,TDoc);
                    enter.substuff(leadsid,leadname,leadid,leadtel,4,0);
                    enter.substuff(doctorsid,doctorname,doctorid,doctortel,5,0);
                    enter.substuff(trainsid,trainname,trainid,traintel,6,0);
                    enter.substuff(judgesid,judgename,judgeid,judgetel,1,0);
                    INathlete inathlete =new INathlete(TID);
                    String str[] = null;
                    comboBox.setModel(new DefaultComboBoxModel(str));
                    comboBox.updateUI();
                }
            }
        });
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnNewButton.setBounds(310, 287, 220, 40);
        contentPane.add(btnNewButton);

        JLabel pnamelabel = new JLabel("项目");
        pnamelabel.setHorizontalAlignment(SwingConstants.CENTER);
        pnamelabel.setFont(new Font("宋体", Font.PLAIN, 18));
        pnamelabel.setBounds(603, 47, 78, 29);
        contentPane.add(pnamelabel);
        this.setVisible(true);

		this.setVisible(true);
	}
}
