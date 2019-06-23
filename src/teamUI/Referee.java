package teamUI;

import SocketTools.ClientTool;
import SocketTools.Judge;
import javafx.util.Pair;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;
import java.util.ArrayList;

public class Referee extends JFrame {
//JFrame Component
	private JPanel contentPane;
	private JTextField P_name1;
	private JTextField P_number1;
	private JTextField P_score1;
	private JTextField P_name2;
	private JTextField P_name3;
	private JTextField P_name4;
	private JTextField P_name5;
	private JTextField P_name6;
	private JTextField P_name7;
	private JTextField P_name8;
	private JTextField P_number2;
	private JTextField P_number3;
	private JTextField P_number4;
	private JTextField P_number5;
	private JTextField P_number6;
	private JTextField P_number7;
	private JTextField P_number8;
	private JTextField P_item;
	private JTextField P_score2;
	private JTextField P_score3;
	private JTextField P_score4;
	private JTextField P_score5;
	private JTextField P_score6;
	private JTextField P_score7;
	private JTextField P_score8;

	//Socket tool
	private String SID="";
	private Judge mReferee=new Judge();
	private Socket conn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Referee frame = new Referee("S1");
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Referee(String SID, Socket conn) {
		this.conn=conn;
		this.SID=SID;
		setTitle("裁判员您好！");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 489);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel playeritem = new JLabel("当前比赛项目");
		playeritem.setFont(new Font("宋体", Font.PLAIN, 18));
		playeritem.setBounds(99, 21, 136, 29);
		contentPane.add(playeritem);
		
		P_item = new JTextField();
		P_item.setFont(new Font("宋体", Font.PLAIN, 18));
		P_item.setBounds(264, 21, 158, 29);
		P_item.setEditable(false);
		contentPane.add(P_item);
		P_item.setColumns(10);
		P_item.setText("比赛未开始");

		JLabel playername = new JLabel("运动员姓名");
		playername.setFont(new Font("宋体", Font.PLAIN, 18));
		playername.setBounds(55, 60, 99, 29);
		contentPane.add(playername);
		
		JLabel playerNum = new JLabel("运动员编号");
		playerNum.setFont(new Font("宋体", Font.PLAIN, 18));
		playerNum.setBounds(200, 60, 99, 29);
		contentPane.add(playerNum);
		
		JLabel playerSc = new JLabel("得分");
		playerSc.setFont(new Font("宋体", Font.PLAIN, 18));
		playerSc.setBounds(338, 60, 99, 29);
		contentPane.add(playerSc);
		
		P_name1 = new JTextField();//姓名
		P_name1.setFont(new Font("宋体", Font.PLAIN, 18));
		P_name1.setBounds(38, 99, 118, 29);
		P_name1.setEditable(false);//禁止外部编写
		contentPane.add(P_name1);
		P_name1.setColumns(10);
		
		P_name2 = new JTextField();
		P_name2.setFont(new Font("宋体", Font.PLAIN, 18));
		P_name2.setEditable(false);
		P_name2.setColumns(10);
		P_name2.setBounds(38, 138, 118, 29);
		contentPane.add(P_name2);
		
		P_name3 = new JTextField();
		P_name3.setFont(new Font("宋体", Font.PLAIN, 18));
		P_name3.setEditable(false);
		P_name3.setColumns(10);
		P_name3.setBounds(38, 177, 118, 29);
		contentPane.add(P_name3);
		
		P_name4 = new JTextField();
		P_name4.setFont(new Font("宋体", Font.PLAIN, 18));
		P_name4.setEditable(false);
		P_name4.setColumns(10);
		P_name4.setBounds(38, 216, 118, 29);
		contentPane.add(P_name4);
		
		P_name5 = new JTextField();
		P_name5.setFont(new Font("宋体", Font.PLAIN, 18));
		P_name5.setEditable(false);
		P_name5.setColumns(10);
		P_name5.setBounds(38, 255, 118, 29);
		contentPane.add(P_name5);
		
		P_name6 = new JTextField();
		P_name6.setFont(new Font("宋体", Font.PLAIN, 18));
		P_name6.setEditable(false);
		P_name6.setColumns(10);
		P_name6.setBounds(38, 294, 118, 29);
		contentPane.add(P_name6);
		
		P_name7 = new JTextField();
		P_name7.setFont(new Font("宋体", Font.PLAIN, 18));
		P_name7.setEditable(false);
		P_name7.setColumns(10);
		P_name7.setBounds(38, 333, 118, 29);
		contentPane.add(P_name7);
		
		P_name8 = new JTextField();
		P_name8.setFont(new Font("宋体", Font.PLAIN, 18));
		P_name8.setEditable(false);
		P_name8.setColumns(10);
		P_name8.setBounds(38, 372, 118, 29);
		contentPane.add(P_name8);
		
		P_number1 = new JTextField();//运动员编号
		P_number1.setFont(new Font("宋体", Font.PLAIN, 18));
		P_number1.setBounds(189, 99, 118, 29);
		P_number1.setEditable(false);//禁止外部编写
		contentPane.add(P_number1);
		P_number1.setColumns(10);
		
		P_number2 = new JTextField();
		P_number2.setFont(new Font("宋体", Font.PLAIN, 18));
		P_number2.setEditable(false);
		P_number2.setColumns(10);
		P_number2.setBounds(189, 138, 118, 29);
		contentPane.add(P_number2);
		
		P_number3 = new JTextField();
		P_number3.setFont(new Font("宋体", Font.PLAIN, 18));
		P_number3.setEditable(false);
		P_number3.setColumns(10);
		P_number3.setBounds(189, 177, 118, 29);
		contentPane.add(P_number3);
		
		P_number4 = new JTextField();
		P_number4.setFont(new Font("宋体", Font.PLAIN, 18));
		P_number4.setEditable(false);
		P_number4.setColumns(10);
		P_number4.setBounds(189, 216, 118, 29);
		contentPane.add(P_number4);
		
		P_number5 = new JTextField();
		P_number5.setFont(new Font("宋体", Font.PLAIN, 18));
		P_number5.setEditable(false);
		P_number5.setColumns(10);
		P_number5.setBounds(189, 255, 118, 29);
		contentPane.add(P_number5);
		
		P_number6 = new JTextField();
		P_number6.setFont(new Font("宋体", Font.PLAIN, 18));
		P_number6.setEditable(false);
		P_number6.setColumns(10);
		P_number6.setBounds(189, 294, 118, 29);
		contentPane.add(P_number6);
		
		P_number7 = new JTextField();
		P_number7.setFont(new Font("宋体", Font.PLAIN, 18));
		P_number7.setEditable(false);
		P_number7.setColumns(10);
		P_number7.setBounds(189, 333, 118, 29);
		contentPane.add(P_number7);
		
		P_number8 = new JTextField();
		P_number8.setFont(new Font("宋体", Font.PLAIN, 18));
		P_number8.setEditable(false);
		P_number8.setColumns(10);
		P_number8.setBounds(189, 372, 118, 29);
		contentPane.add(P_number8);
		
		P_score1 = new JTextField();//成绩
		P_score1.setFont(new Font("宋体", Font.PLAIN, 18));
		P_score1.setBounds(338, 99, 118, 29);
		contentPane.add(P_score1);
		P_score1.setColumns(10);
		
		P_score2 = new JTextField();
		P_score2.setFont(new Font("宋体", Font.PLAIN, 18));
		P_score2.setColumns(10);
		P_score2.setBounds(338, 138, 118, 29);
		contentPane.add(P_score2);
		
		P_score3 = new JTextField();
		P_score3.setFont(new Font("宋体", Font.PLAIN, 18));
		P_score3.setColumns(10);
		P_score3.setBounds(338, 177, 118, 29);
		contentPane.add(P_score3);
		
		P_score4 = new JTextField();
		P_score4.setFont(new Font("宋体", Font.PLAIN, 18));
		P_score4.setColumns(10);
		P_score4.setBounds(338, 216, 118, 29);
		contentPane.add(P_score4);
		
		P_score5 = new JTextField();
		P_score5.setFont(new Font("宋体", Font.PLAIN, 18));
		P_score5.setColumns(10);
		P_score5.setBounds(338, 255, 118, 29);
		contentPane.add(P_score5);
		
		P_score6 = new JTextField();
		P_score6.setFont(new Font("宋体", Font.PLAIN, 18));
		P_score6.setColumns(10);
		P_score6.setBounds(338, 294, 118, 29);
		contentPane.add(P_score6);
		
		P_score7 = new JTextField();
		P_score7.setFont(new Font("宋体", Font.PLAIN, 18));
		P_score7.setColumns(10);
		P_score7.setBounds(338, 333, 118, 29);
		contentPane.add(P_score7);
		
		P_score8 = new JTextField();
		P_score8.setFont(new Font("宋体", Font.PLAIN, 18));
		P_score8.setColumns(10);
		P_score8.setBounds(338, 372, 118, 29);
		contentPane.add(P_score8);



		JButton button = new JButton("提交");
		button.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*if() {
					
				}*/
				//提交成绩,导入下一位运动员
				ArrayList<Pair<String,Float>> marktable=new ArrayList<>();
				//TODO：判断数据完整性，将数据添加到marktable√
				Pair<String,Float> pair1 = new Pair<String,Float>(P_number1.getText(),Float.valueOf(P_score1.getText()));
				Pair<String,Float> pair2 = new Pair<String,Float>(P_number2.getText(),Float.valueOf(P_score2.getText()));
				Pair<String,Float> pair3 = new Pair<String,Float>(P_number3.getText(),Float.valueOf(P_score3.getText()));
				Pair<String,Float> pair4 = new Pair<String,Float>(P_number4.getText(),Float.valueOf(P_score4.getText()));
				Pair<String,Float> pair5 = new Pair<String,Float>(P_number5.getText(),Float.valueOf(P_score5.getText()));
				Pair<String,Float> pair6 = new Pair<String,Float>(P_number6.getText(),Float.valueOf(P_score6.getText()));
				Pair<String,Float> pair7 = new Pair<String,Float>(P_number7.getText(),Float.valueOf(P_score7.getText()));
				Pair<String,Float> pair8 = new Pair<String,Float>(P_number8.getText(),Float.valueOf(P_score8.getText()));

				marktable.add(pair1);
				marktable.add(pair2);
				marktable.add(pair3);
				marktable.add(pair4);
				marktable.add(pair5);
				marktable.add(pair6);
				marktable.add(pair7);
				marktable.add(pair8);

				// TODO:一组运动员名单还没有传完 打分失败√
				if(P_score1.getText().equals("")||P_score2.getText().equals("")||P_score3.getText().equals("")||
						P_score4.getText().equals("")||P_score5.getText().equals("")||P_score6.getText().equals("")||
						P_score7.getText().equals("")||P_score8.getText().equals("")){
					JFrame jf=new JFrame();
					jf.setTitle("注意");
					jf.setBounds(400, 250, 450, 300);
					jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					jf.getContentPane().setLayout(null);

					JLabel jl = new JLabel("请确认运动员成绩已全部填写");
					jl.setFont(new Font("宋体", Font.PLAIN, 18));
					jl.setBounds(110, 100, 250, 30);
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
					if(mReferee.SendMarkTable(marktable)){
						//TODO:清空页面中上一组的运动员信息√
						P_score1.setText("");
						P_score2.setText("");
						P_score3.setText("");
						P_score4.setText("");
						P_score5.setText("");
						P_score6.setText("");
						P_score7.setText("");
						P_score8.setText("");
						new Thread(new Runnable() {
							@Override
							public void run() {
								getAths();//第一组运动员名单
							}
						}).start();
					}
				}


			}
		});

		button.setBounds(357, 411, 99, 29);
		contentPane.add(button);

		JLabel label = new JLabel("提示信息");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(10, 415, 80, 29);
		contentPane.add(label);

		JTextField messagetext = new JTextField();
		messagetext.setBounds(95, 415, 238, 29);
		contentPane.add(messagetext);
		messagetext.setColumns(10);

		JButton logout = new JButton("注销");
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO：取消登录状态
				ClientTool.exit(SID);
				dispose();
				System.exit(0);
			}
		});
		logout.setFont(new Font("宋体", Font.PLAIN, 18));
		logout.setBounds(452, 0, 90, 30);
		contentPane.add(logout);
		
		this.setVisible(true);

		mReferee.logined=true;
		new Thread(new Runnable() {
			@Override
			public void run() {
				mReferee.start(SID,conn);
				P_item.setText(mReferee.getProname());
				getAths();//第一组运动员名单
			}
		}).start();
	}
	private void getAths(){
		while (!mReferee.isWorking&&!mReferee.sendmark);//等待裁判就绪
		ArrayList<Pair<String,String>> aths = mReferee.wait_Aths();
		//TODO:将aths的信息保存到界面√
		P_name1.setText(aths.get(0).getKey());
		P_name2.setText(aths.get(1).getKey());
		P_name3.setText(aths.get(2).getKey());
		P_name4.setText(aths.get(3).getKey());
		P_name5.setText(aths.get(4).getKey());
		P_name6.setText(aths.get(5).getKey());
		P_name7.setText(aths.get(6).getKey());
		P_name8.setText(aths.get(7).getKey());

		P_number1.setText(aths.get(0).getValue());
		P_number2.setText(aths.get(1).getValue());
		P_number3.setText(aths.get(2).getValue());
		P_number4.setText(aths.get(3).getValue());
		P_number5.setText(aths.get(4).getValue());
		P_number6.setText(aths.get(5).getValue());
		P_number7.setText(aths.get(6).getValue());
		P_number8.setText(aths.get(7).getValue());
	}

}
