package teamUI;

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
	private Judge mReferee;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Referee frame = new Referee();
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
	public Referee() {
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
				//TODO：判断数据完整性，将数据添加到marktable
				if(mReferee.SendMarkTable(marktable)){
					//TODO:清空页面中上一组的运动员信息
					getAths();	//获取下一组运动员名单
				}
				else {
					//TODO:一组运动员名单还没有传完 打分失败
				}
			}
		});

		button.setBounds(202, 411, 99, 29);
		contentPane.add(button);
		this.setVisible(true);

		mReferee.logined=true;
		mReferee.start();
		P_item.setText(mReferee.getProname());
		getAths();//第一组运动员名单
	}
	private void getAths(){
		ArrayList<Pair<String,String>> aths = mReferee.wait_Aths();
		//TODO:将aths的信息保存到界面
	}

}
