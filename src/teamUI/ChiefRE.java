package teamUI;

import SocketTools.ChiefJudge;
import SocketTools.ClientTool;
import SocketTools.GroupJudge;
import javafx.util.Pair;
import org.javatuples.Triplet;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;


//裁判员页面
public class ChiefRE extends JFrame {
//JFrame Component
	private JPanel contentPane;
	private JTextField score1_1;
	private JTextField score1_2;
	private JTextField score1_3;
	private JTextField score1_4;
	private JTextField score1_5;
	private JTextField avgNum1;
	private JTextField B_Num1;
	private JTextField P_Num1;
	private JTextField final_Num1;
	private JTextField playername1;
	private JTextField player_Num1;
	private JTextField playername2;
	private JTextField player_Num2;
	private JTextField score2_1;
	private JTextField score2_2;
	private JTextField score2_3;
	private JTextField score2_4;
	private JTextField score2_5;
	private JTextField avgNum2;
	private JTextField B_Num2;
	private JTextField P_Num2;
	private JTextField final_Num2;
	private JTextField playername3;
	private JTextField player_Num3;
	private JTextField score3_1;
	private JTextField score3_2;
	private JTextField score3_3;
	private JTextField score3_4;
	private JTextField score3_5;
	private JTextField avgNum3;
	private JTextField B_Num3;
	private JTextField P_Num3;
	private JTextField final_Num3;
	private JTextField playername4;
	private JTextField player_Num4;
	private JTextField score4_1;
	private JTextField score4_2;
	private JTextField score4_3;
	private JTextField score4_4;
	private JTextField score4_5;
	private JTextField avgNum4;
	private JTextField B_Num4;
	private JTextField P_Num4;
	private JTextField final_Num4;
	private JTextField playername5;
	private JTextField player_Num5;
	private JTextField score5_1;
	private JTextField score5_2;
	private JTextField score5_3;
	private JTextField score5_4;
	private JTextField score5_5;
	private JTextField avgNum5;
	private JTextField B_Num5;
	private JTextField P_Num5;
	private JTextField final_Num5;
	private JTextField playername6;
	private JTextField player_Num6;
	private JTextField score6_1;
	private JTextField score6_2;
	private JTextField score6_3;
	private JTextField score6_4;
	private JTextField score6_5;
	private JTextField avgNum6;
	private JTextField B_Num6;
	private JTextField P_Num6;
	private JTextField final_Num6;
	private JTextField playername7;
	private JTextField player_Num7;
	private JTextField score7_1;
	private JTextField score7_2;
	private JTextField score7_3;
	private JTextField score7_4;
	private JTextField score7_5;
	private JTextField avgNum7;
	private JTextField B_Num7;
	private JTextField P_Num7;
	private JTextField final_Num7;
	private JTextField playername8;
	private JTextField player_Num8;
	private JTextField score8_1;
	private JTextField score8_2;
	private JTextField score8_3;
	private JTextField score8_4;
	private JTextField score8_5;
	private JTextField avgNum8;
	private JTextField B_Num8;
	private JTextField P_Num8;
	private JTextField final_Num8;

//socket Tool
	private GroupJudge mChiefRE;
	//命名规则 运动员姓名playernameX 编号player_NumX 
	//裁判打分score行_列  平均分 avgNumX B分 B_NumX P分 P_NumX 最终得分final_NumX

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					org.javatuples.Pair<Integer,Socket> res=ClientTool.login("54","123");
					ChiefRE frame = new ChiefRE("54",res.getValue1());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChiefRE(String sid, Socket conn) {
		setTitle("小组裁判页");//总裁判
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 992, 565);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel P_name = new JLabel("运动员姓名");
		P_name.setFont(new Font("宋体", Font.PLAIN, 18));
		P_name.setBounds(20, 10, 106, 30);
		contentPane.add(P_name);
		
		playername1 = new JTextField();
		playername1.setFont(new Font("宋体", Font.PLAIN, 18));
		playername1.setColumns(10);
		playername1.setBounds(20, 72, 84, 30);
		playername1.setEditable(false);//禁止外部编辑
		contentPane.add(playername1);
		
		JLabel Playernumber = new JLabel("运动员编号");
		Playernumber.setFont(new Font("宋体", Font.PLAIN, 18));
		Playernumber.setBounds(142, 10, 100, 30);
		contentPane.add(Playernumber);
		
		player_Num1 = new JTextField();//运动员编号
		player_Num1.setFont(new Font("宋体", Font.PLAIN, 18));
		player_Num1.setEditable(false);
		player_Num1.setColumns(10);
		player_Num1.setBounds(114, 72, 149, 30);
		contentPane.add(player_Num1);
		
		JLabel refe_1 = new JLabel("裁判1");
		refe_1.setFont(new Font("宋体", Font.PLAIN, 18));
		refe_1.setBounds(292, 10, 53, 30);
		contentPane.add(refe_1);
		
		JLabel refe_2 = new JLabel("裁判2");
		refe_2.setFont(new Font("宋体", Font.PLAIN, 18));
		refe_2.setBounds(364, 10, 72, 30);
		contentPane.add(refe_2);
		
		JLabel refe_3 = new JLabel("裁判3");
		refe_3.setFont(new Font("宋体", Font.PLAIN, 18));
		refe_3.setBounds(437, 10, 72, 30);
		contentPane.add(refe_3);
		
		JLabel refe_4 = new JLabel("裁判4");
		refe_4.setFont(new Font("宋体", Font.PLAIN, 18));
		refe_4.setBounds(519, 10, 62, 30);
		contentPane.add(refe_4);
		
		JLabel refe_5 = new JLabel("裁判5");
		refe_5.setFont(new Font("宋体", Font.PLAIN, 18));
		refe_5.setBounds(601, 10, 72, 30);
		contentPane.add(refe_5);
		
		score1_1 = new JTextField();//运动员1的裁判1打分
		score1_1.setBounds(273, 72, 72, 30);
		score1_1.setEditable(false);
		contentPane.add(score1_1);
		score1_1.setColumns(10);
		
		score1_2 = new JTextField();//得分2
		score1_2.setColumns(10);
		score1_2.setEditable(false);
		score1_2.setBounds(355, 72, 72, 30);
		contentPane.add(score1_2);
		
		score1_3 = new JTextField();//得分3
		score1_3.setColumns(10);
		score1_3.setEditable(false);
		score1_3.setBounds(437, 72, 72, 30);
		contentPane.add(score1_3);
		
		score1_4 = new JTextField();//得分4
		score1_4.setColumns(10);
		score1_4.setEditable(false);
		score1_4.setBounds(519, 72, 72, 30);
		contentPane.add(score1_4);
		
		score1_5 = new JTextField();//得分5
		score1_5.setColumns(10);
		score1_5.setEditable(false);
		score1_5.setBounds(601, 72, 72, 30);
		contentPane.add(score1_5);
		
		JLabel avg_score = new JLabel("平均分");
		avg_score.setFont(new Font("宋体", Font.PLAIN, 18));
		avg_score.setBounds(683, 10, 62, 31);
		contentPane.add(avg_score);
		
		avgNum1 = new JTextField();//平均得分
		avgNum1.setFont(new Font("宋体", Font.PLAIN, 18));
		avgNum1.setBounds(683, 72, 84, 30);
		avgNum1.setEditable(false);
		contentPane.add(avgNum1);
		avgNum1.setColumns(10);
		
		JLabel lblB = new JLabel("B分");
		lblB.setFont(new Font("宋体", Font.PLAIN, 18));
		lblB.setBounds(782, 10, 32, 30);
		contentPane.add(lblB);
		
		B_Num1 = new JTextField();//奖励分
		B_Num1.setFont(new Font("宋体", Font.PLAIN, 18));
		B_Num1.setColumns(10);
		B_Num1.setBounds(777, 72, 84, 30);
		contentPane.add(B_Num1);
		
		JLabel lblP = new JLabel("P分");
		lblP.setFont(new Font("宋体", Font.PLAIN, 18));
		lblP.setBounds(870, 10, 32, 30);
		contentPane.add(lblP);
		
		P_Num1 = new JTextField();//惩罚分
		P_Num1.setFont(new Font("宋体", Font.PLAIN, 18));
		P_Num1.setColumns(10);
		P_Num1.setBounds(871, 72, 84, 30);
		contentPane.add(P_Num1);
		
		JButton button = new JButton("确认");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if(B_Num1.getText().equals("")||B_Num2.getText().equals("")||B_Num3.getText().equals("")||B_Num4.getText().equals("")
						||B_Num5.getText().equals("")||B_Num6.getText().equals("")||B_Num7.getText().equals("")||B_Num8.getText().equals("")
						||P_Num1.getText().equals("")||P_Num2.getText().equals("")||P_Num3.getText().equals("")||P_Num4.getText().equals("")
						||P_Num5.getText().equals("")||P_Num6.getText().equals("")||P_Num7.getText().equals("")||P_Num8.getText().equals("")
				) {
					JFrame jf=new JFrame();
					jf.setTitle("PB分为空");
					jf.setBounds(400, 250, 450, 300);
					jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					jf.getContentPane().setLayout(null);

					JLabel jl = new JLabel("PB分不能为空");
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

				new Thread(new Runnable() {
					@Override
					public void run() {
						ArrayList<Triplet<String,Float,Float>> BPMarks=new ArrayList<>();
						//TODO ；传入数据 每个成员<运动员编号 B分 P分>
						Triplet<String,Float,Float> triplet1 = new Triplet<String,Float,Float>(player_Num1.getText(),Float.valueOf(B_Num1.getText()),Float.valueOf(P_Num1.getText()));
						Triplet<String,Float,Float> triplet2 = new Triplet<String,Float,Float>(player_Num2.getText(),Float.valueOf(B_Num2.getText()),Float.valueOf(P_Num2.getText()));
						Triplet<String,Float,Float> triplet3 = new Triplet<String,Float,Float>(player_Num3.getText(),Float.valueOf(B_Num3.getText()),Float.valueOf(P_Num3.getText()));
						Triplet<String,Float,Float> triplet4 = new Triplet<String,Float,Float>(player_Num4.getText(),Float.valueOf(B_Num4.getText()),Float.valueOf(P_Num4.getText()));
						Triplet<String,Float,Float> triplet5 = new Triplet<String,Float,Float>(player_Num5.getText(),Float.valueOf(B_Num5.getText()),Float.valueOf(P_Num5.getText()));
						Triplet<String,Float,Float> triplet6 = new Triplet<String,Float,Float>(player_Num6.getText(),Float.valueOf(B_Num6.getText()),Float.valueOf(P_Num6.getText()));
						Triplet<String,Float,Float> triplet7 = new Triplet<String,Float,Float>(player_Num7.getText(),Float.valueOf(B_Num7.getText()),Float.valueOf(P_Num7.getText()));
						Triplet<String,Float,Float> triplet8 = new Triplet<String,Float,Float>(player_Num8.getText(),Float.valueOf(B_Num8.getText()),Float.valueOf(P_Num8.getText()));

						BPMarks.add(triplet1);BPMarks.add(triplet2);BPMarks.add(triplet3);
						BPMarks.add(triplet4);BPMarks.add(triplet5);BPMarks.add(triplet6);
						BPMarks.add(triplet7);BPMarks.add(triplet8);

						HashMap<String,ArrayList<Float>> marks=new HashMap<>();
						//TODO:传入数据  key值为运动员编号  值为哥哥裁判对该运动员的打分
						ArrayList<Float> all1 = new ArrayList<>();
						all1.add(Float.valueOf(score1_1.getText()));all1.add(Float.valueOf(score1_2.getText()));all1.add(Float.valueOf(score1_3.getText()));
						all1.add(Float.valueOf(score1_4.getText()));all1.add(Float.valueOf(score1_5.getText()));
						marks.put(player_Num1.getText(),all1);
						ArrayList<Float> all2 = new ArrayList<>();
						all2.add(Float.valueOf(score2_1.getText()));all2.add(Float.valueOf(score2_2.getText()));all2.add(Float.valueOf(score2_3.getText()));
						all2.add(Float.valueOf(score2_4.getText()));all2.add(Float.valueOf(score2_5.getText()));
						marks.put(player_Num2.getText(),all2);
						ArrayList<Float> all3 = new ArrayList<>();
						all3.add(Float.valueOf(score3_1.getText()));all3.add(Float.valueOf(score3_2.getText()));all3.add(Float.valueOf(score3_3.getText()));
						all3.add(Float.valueOf(score3_4.getText()));all3.add(Float.valueOf(score3_5.getText()));
						marks.put(player_Num3.getText(),all3);
						ArrayList<Float> all4 = new ArrayList<>();
						all4.add(Float.valueOf(score4_1.getText()));all4.add(Float.valueOf(score4_2.getText()));all4.add(Float.valueOf(score4_3.getText()));
						all4.add(Float.valueOf(score4_4.getText()));all4.add(Float.valueOf(score4_5.getText()));
						marks.put(player_Num4.getText(),all4);
						ArrayList<Float> all5 = new ArrayList<>();
						all5.add(Float.valueOf(score5_1.getText()));all5.add(Float.valueOf(score5_2.getText()));all5.add(Float.valueOf(score5_3.getText()));
						all5.add(Float.valueOf(score5_4.getText()));all5.add(Float.valueOf(score5_5.getText()));
						marks.put(player_Num5.getText(),all5);
						ArrayList<Float> all6 = new ArrayList<>();
						all6.add(Float.valueOf(score6_1.getText()));all6.add(Float.valueOf(score6_2.getText()));all6.add(Float.valueOf(score6_3.getText()));
						all6.add(Float.valueOf(score6_4.getText()));all6.add(Float.valueOf(score6_5.getText()));
						marks.put(player_Num6.getText(),all6);
						ArrayList<Float> all7 = new ArrayList<>();
						all7.add(Float.valueOf(score7_1.getText()));all7.add(Float.valueOf(score7_2.getText()));all7.add(Float.valueOf(score7_3.getText()));
						all7.add(Float.valueOf(score7_4.getText()));all7.add(Float.valueOf(score7_5.getText()));
						marks.put(player_Num7.getText(),all7);
						ArrayList<Float> all8 = new ArrayList<>();
						all8.add(Float.valueOf(score8_1.getText()));all8.add(Float.valueOf(score8_2.getText()));all8.add(Float.valueOf(score8_3.getText()));
						all8.add(Float.valueOf(score8_4.getText()));all8.add(Float.valueOf(score8_5.getText()));
						marks.put(player_Num8.getText(),all8);

						mChiefRE.sendConform(BPMarks,marks);

						//TODO:清空界面
						clear();

						//以下部分与末尾的初始化部分相同
						ArrayList<Pair<String,String>>aths = mChiefRE.wait_Aths();//aths  运动员编号  姓名
						//TODO:将运动员编号写入到前端
						int j = aths.size();
						if(j == 0){
							JFrame jf2=new JFrame();
							jf2.setTitle("比赛结束");
							jf2.setBounds(400, 250, 450, 300);
							jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							jf2.getContentPane().setLayout(null);

							JLabel jl2 = new JLabel("该项目比赛已结束");
							jl2.setFont(new Font("宋体", Font.PLAIN, 18));
							jl2.setBounds(150, 100, 250, 30);
							jf2.getContentPane().add(jl2);


							JButton jb2 = new JButton("确认");
							jb2.setFont(new Font("宋体", Font.PLAIN, 18));
							jb2.setBounds(170, 150, 100, 30);
							jb2.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent arg0) {
									jf2.dispose();
									//TODO:???
								}
							});
							jf2.getContentPane().add(jb2);
							jf2.setVisible(true);
						}else{
							int i = 0;
							player_Num1.setText(aths.get(0).getKey());
							playername1.setText(aths.get(0).getValue());
							i++;
							if(i < j){
								player_Num2.setText(aths.get(1).getKey());
								playername2.setText(aths.get(1).getValue());
							}i++;
							if(i < j){
								player_Num3.setText(aths.get(2).getKey());
								playername3.setText(aths.get(2).getValue());
							}i++;
							if(i < j){
								player_Num4.setText(aths.get(3).getKey());
								playername4.setText(aths.get(3).getValue());
							}i++;
							if(i < j){
								player_Num5.setText(aths.get(4).getKey());
								playername5.setText(aths.get(4).getValue());
							}i++;
							if(i < j){
								player_Num6.setText(aths.get(5).getKey());
								playername6.setText(aths.get(5).getValue());
							}i++;
							if(i < j){
								player_Num7.setText(aths.get(6).getKey());
								playername7.setText(aths.get(6).getValue());
							}i++;
							if(i < j){
								player_Num8.setText(aths.get(7).getKey());
								playername8.setText(aths.get(7).getValue());
							}i++;
						}

						mChiefRE.getMarkTablesFromServer();
						//TODO:将打分写入到前端
						ArrayList<ArrayList<Pair<String,Float>>> newmarks=mChiefRE.getMarkTables();
						//数组成员： 数据对（运动员编号，分数）
						write(newmarks);
						ArrayList<String> judges=mChiefRE.getIDOfJudges();
						//Judge的ID  序号与marks中的成绩单对应

					}
				}).start();
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 18));
        button.setBounds(722, 475, 100, 30);
		contentPane.add(button);


		playername2 = new JTextField();
		playername2.setFont(new Font("宋体", Font.PLAIN, 18));
		playername2.setEditable(false);
		playername2.setColumns(10);
		playername2.setBounds(20, 122, 84, 30);
		contentPane.add(playername2);
		
		player_Num2 = new JTextField();
		player_Num2.setFont(new Font("宋体", Font.PLAIN, 18));
		player_Num2.setEditable(false);
		player_Num2.setColumns(10);
		player_Num2.setBounds(114, 122, 149, 30);
		contentPane.add(player_Num2);
		
		score2_1 = new JTextField();
		score2_1.setEditable(false);
		score2_1.setColumns(10);
		score2_1.setBounds(273, 122, 72, 30);
		contentPane.add(score2_1);
		
		score2_2 = new JTextField();
		score2_2.setEditable(false);
		score2_2.setColumns(10);
		score2_2.setBounds(355, 122, 72, 30);
		contentPane.add(score2_2);
		
		score2_3 = new JTextField();
		score2_3.setEditable(false);
		score2_3.setColumns(10);
		score2_3.setBounds(437, 122, 72, 30);
		contentPane.add(score2_3);
		
		score2_4 = new JTextField();
		score2_4.setEditable(false);
		score2_4.setColumns(10);
		score2_4.setBounds(519, 122, 72, 30);
		contentPane.add(score2_4);
		
		score2_5 = new JTextField();
		score2_5.setEditable(false);
		score2_5.setColumns(10);
		score2_5.setBounds(601, 122, 72, 30);
		contentPane.add(score2_5);
		
		avgNum2 = new JTextField();
		avgNum2.setFont(new Font("宋体", Font.PLAIN, 18));
		avgNum2.setEditable(false);
		avgNum2.setColumns(10);
		avgNum2.setBounds(683, 122, 84, 30);
		contentPane.add(avgNum2);
		
		B_Num2 = new JTextField();
		B_Num2.setFont(new Font("宋体", Font.PLAIN, 18));
		B_Num2.setColumns(10);
		B_Num2.setBounds(777, 122, 84, 30);
		contentPane.add(B_Num2);
		
		P_Num2 = new JTextField();
		P_Num2.setFont(new Font("宋体", Font.PLAIN, 18));
		P_Num2.setColumns(10);
		P_Num2.setBounds(871, 122, 84, 30);
		contentPane.add(P_Num2);
		
		playername3 = new JTextField();
		playername3.setFont(new Font("宋体", Font.PLAIN, 18));
		playername3.setEditable(false);
		playername3.setColumns(10);
		playername3.setBounds(20, 170, 84, 30);
		contentPane.add(playername3);
		
		player_Num3 = new JTextField();
		player_Num3.setFont(new Font("宋体", Font.PLAIN, 18));
		player_Num3.setEditable(false);
		player_Num3.setColumns(10);
		player_Num3.setBounds(114, 170, 149, 30);
		contentPane.add(player_Num3);
		
		score3_1 = new JTextField();
		score3_1.setEditable(false);
		score3_1.setColumns(10);
		score3_1.setBounds(273, 170, 72, 30);
		contentPane.add(score3_1);
		
		score3_2 = new JTextField();
		score3_2.setEditable(false);
		score3_2.setColumns(10);
		score3_2.setBounds(355, 170, 72, 30);
		contentPane.add(score3_2);
		
		score3_3 = new JTextField();
		score3_3.setEditable(false);
		score3_3.setColumns(10);
		score3_3.setBounds(437, 170, 72, 30);
		contentPane.add(score3_3);
		
		score3_4 = new JTextField();
		score3_4.setEditable(false);
		score3_4.setColumns(10);
		score3_4.setBounds(519, 170, 72, 30);
		contentPane.add(score3_4);
		
		score3_5 = new JTextField();
		score3_5.setEditable(false);
		score3_5.setColumns(10);
		score3_5.setBounds(601, 170, 72, 30);
		contentPane.add(score3_5);
		
		avgNum3 = new JTextField();
		avgNum3.setFont(new Font("宋体", Font.PLAIN, 18));
		avgNum3.setEditable(false);
		avgNum3.setColumns(10);
		avgNum3.setBounds(683, 170, 84, 30);
		contentPane.add(avgNum3);
		
		B_Num3 = new JTextField();
		B_Num3.setFont(new Font("宋体", Font.PLAIN, 18));
		B_Num3.setColumns(10);
		B_Num3.setBounds(777, 170, 84, 30);
		contentPane.add(B_Num3);
		
		P_Num3 = new JTextField();
		P_Num3.setFont(new Font("宋体", Font.PLAIN, 18));
		P_Num3.setColumns(10);
		P_Num3.setBounds(871, 170, 84, 30);
		contentPane.add(P_Num3);
		
		playername4 = new JTextField();
		playername4.setFont(new Font("宋体", Font.PLAIN, 18));
		playername4.setEditable(false);
		playername4.setColumns(10);
		playername4.setBounds(20, 215, 84, 30);
		contentPane.add(playername4);
		
		player_Num4 = new JTextField();
		player_Num4.setFont(new Font("宋体", Font.PLAIN, 18));
		player_Num4.setEditable(false);
		player_Num4.setColumns(10);
		player_Num4.setBounds(114, 215, 149, 30);
		contentPane.add(player_Num4);
		
		score4_1 = new JTextField();
		score4_1.setEditable(false);
		score4_1.setColumns(10);
		score4_1.setBounds(273, 215, 72, 30);
		contentPane.add(score4_1);
		
		score4_2 = new JTextField();
		score4_2.setEditable(false);
		score4_2.setColumns(10);
		score4_2.setBounds(355, 215, 72, 30);
		contentPane.add(score4_2);
		
		score4_3 = new JTextField();
		score4_3.setEditable(false);
		score4_3.setColumns(10);
		score4_3.setBounds(437, 215, 72, 30);
		contentPane.add(score4_3);
		
		score4_4 = new JTextField();
		score4_4.setEditable(false);
		score4_4.setColumns(10);
		score4_4.setBounds(519, 215, 72, 30);
		contentPane.add(score4_4);
		
		score4_5 = new JTextField();
		score4_5.setEditable(false);
		score4_5.setColumns(10);
		score4_5.setBounds(601, 215, 72, 30);
		contentPane.add(score4_5);
		
		avgNum4 = new JTextField();
		avgNum4.setFont(new Font("宋体", Font.PLAIN, 18));
		avgNum4.setEditable(false);
		avgNum4.setColumns(10);
		avgNum4.setBounds(683, 215, 84, 30);
		contentPane.add(avgNum4);
		
		B_Num4 = new JTextField();
		B_Num4.setFont(new Font("宋体", Font.PLAIN, 18));
		B_Num4.setColumns(10);
		B_Num4.setBounds(777, 215, 84, 30);
		contentPane.add(B_Num4);
		
		P_Num4 = new JTextField();
		P_Num4.setFont(new Font("宋体", Font.PLAIN, 18));
		P_Num4.setColumns(10);
		P_Num4.setBounds(871, 215, 84, 30);
		contentPane.add(P_Num4);
		
		playername5 = new JTextField();
		playername5.setFont(new Font("宋体", Font.PLAIN, 18));
		playername5.setEditable(false);
		playername5.setColumns(10);
		playername5.setBounds(20, 261, 84, 30);
		contentPane.add(playername5);
		
		player_Num5 = new JTextField();
		player_Num5.setFont(new Font("宋体", Font.PLAIN, 18));
		player_Num5.setEditable(false);
		player_Num5.setColumns(10);
		player_Num5.setBounds(114, 261, 149, 30);
		contentPane.add(player_Num5);
		
		score5_1 = new JTextField();
		score5_1.setEditable(false);
		score5_1.setColumns(10);
		score5_1.setBounds(273, 261, 72, 30);
		contentPane.add(score5_1);
		
		score5_2 = new JTextField();
		score5_2.setEditable(false);
		score5_2.setColumns(10);
		score5_2.setBounds(355, 261, 72, 30);
		contentPane.add(score5_2);
		
		score5_3 = new JTextField();
		score5_3.setEditable(false);
		score5_3.setColumns(10);
		score5_3.setBounds(437, 261, 72, 30);
		contentPane.add(score5_3);
		
		score5_4 = new JTextField();
		score5_4.setEditable(false);
		score5_4.setColumns(10);
		score5_4.setBounds(519, 261, 72, 30);
		contentPane.add(score5_4);
		
		score5_5 = new JTextField();
		score5_5.setEditable(false);
		score5_5.setColumns(10);
		score5_5.setBounds(601, 261, 72, 30);
		contentPane.add(score5_5);
		
		avgNum5 = new JTextField();
		avgNum5.setFont(new Font("宋体", Font.PLAIN, 18));
		avgNum5.setEditable(false);
		avgNum5.setColumns(10);
		avgNum5.setBounds(683, 261, 84, 30);
		contentPane.add(avgNum5);
		
		B_Num5 = new JTextField();
		B_Num5.setFont(new Font("宋体", Font.PLAIN, 18));
		B_Num5.setColumns(10);
		B_Num5.setBounds(777, 261, 84, 30);
		contentPane.add(B_Num5);
		
		P_Num5 = new JTextField();
		P_Num5.setFont(new Font("宋体", Font.PLAIN, 18));
		P_Num5.setColumns(10);
		P_Num5.setBounds(871, 261, 84, 30);
		contentPane.add(P_Num5);
		
		playername6 = new JTextField();
		playername6.setFont(new Font("宋体", Font.PLAIN, 18));
		playername6.setEditable(false);
		playername6.setColumns(10);
		playername6.setBounds(20, 307, 84, 30);
		contentPane.add(playername6);
		
		player_Num6 = new JTextField();
		player_Num6.setFont(new Font("宋体", Font.PLAIN, 18));
		player_Num6.setEditable(false);
		player_Num6.setColumns(10);
		player_Num6.setBounds(114, 307, 149, 30);
		contentPane.add(player_Num6);
		
		score6_1 = new JTextField();
		score6_1.setEditable(false);
		score6_1.setColumns(10);
		score6_1.setBounds(273, 307, 72, 30);
		contentPane.add(score6_1);
		
		score6_2 = new JTextField();
		score6_2.setEditable(false);
		score6_2.setColumns(10);
		score6_2.setBounds(355, 307, 72, 30);
		contentPane.add(score6_2);
		
		score6_3 = new JTextField();
		score6_3.setEditable(false);
		score6_3.setColumns(10);
		score6_3.setBounds(437, 307, 72, 30);
		contentPane.add(score6_3);
		
		score6_4 = new JTextField();
		score6_4.setEditable(false);
		score6_4.setColumns(10);
		score6_4.setBounds(519, 307, 72, 30);
		contentPane.add(score6_4);
		
		score6_5 = new JTextField();
		score6_5.setEditable(false);
		score6_5.setColumns(10);
		score6_5.setBounds(601, 307, 72, 30);
		contentPane.add(score6_5);
		
		avgNum6 = new JTextField();
		avgNum6.setFont(new Font("宋体", Font.PLAIN, 18));
		avgNum6.setEditable(false);
		avgNum6.setColumns(10);
		avgNum6.setBounds(683, 307, 84, 30);
		contentPane.add(avgNum6);
		
		B_Num6 = new JTextField();
		B_Num6.setFont(new Font("宋体", Font.PLAIN, 18));
		B_Num6.setColumns(10);
		B_Num6.setBounds(777, 306, 84, 30);
		contentPane.add(B_Num6);
		
		P_Num6 = new JTextField();
		P_Num6.setFont(new Font("宋体", Font.PLAIN, 18));
		P_Num6.setColumns(10);
		P_Num6.setBounds(871, 306, 84, 30);
		contentPane.add(P_Num6);
		
		playername7 = new JTextField();
		playername7.setFont(new Font("宋体", Font.PLAIN, 18));
		playername7.setEditable(false);
		playername7.setColumns(10);
		playername7.setBounds(20, 353, 84, 30);
		contentPane.add(playername7);
		
		player_Num7 = new JTextField();
		player_Num7.setFont(new Font("宋体", Font.PLAIN, 18));
		player_Num7.setEditable(false);
		player_Num7.setColumns(10);
		player_Num7.setBounds(114, 353, 149, 30);
		contentPane.add(player_Num7);
		
		score7_1 = new JTextField();
		score7_1.setEditable(false);
		score7_1.setColumns(10);
		score7_1.setBounds(273, 353, 72, 30);
		contentPane.add(score7_1);
		
		score7_2 = new JTextField();
		score7_2.setEditable(false);
		score7_2.setColumns(10);
		score7_2.setBounds(355, 353, 72, 30);
		contentPane.add(score7_2);
		
		score7_3 = new JTextField();
		score7_3.setEditable(false);
		score7_3.setColumns(10);
		score7_3.setBounds(437, 353, 72, 30);
		contentPane.add(score7_3);
		
		score7_4 = new JTextField();
		score7_4.setEditable(false);
		score7_4.setColumns(10);
		score7_4.setBounds(519, 353, 72, 30);
		contentPane.add(score7_4);
		
		score7_5 = new JTextField();
		score7_5.setEditable(false);
		score7_5.setColumns(10);
		score7_5.setBounds(601, 353, 72, 30);
		contentPane.add(score7_5);
		
		avgNum7 = new JTextField();
		avgNum7.setFont(new Font("宋体", Font.PLAIN, 18));
		avgNum7.setEditable(false);
		avgNum7.setColumns(10);
		avgNum7.setBounds(683, 353, 84, 30);
		contentPane.add(avgNum7);
		
		B_Num7 = new JTextField();
		B_Num7.setFont(new Font("宋体", Font.PLAIN, 18));
		B_Num7.setColumns(10);
		B_Num7.setBounds(777, 353, 84, 30);
		contentPane.add(B_Num7);
		
		P_Num7 = new JTextField();
		P_Num7.setFont(new Font("宋体", Font.PLAIN, 18));
		P_Num7.setColumns(10);
		P_Num7.setBounds(871, 353, 84, 30);
		contentPane.add(P_Num7);
		
		playername8 = new JTextField();
		playername8.setFont(new Font("宋体", Font.PLAIN, 18));
		playername8.setEditable(false);
		playername8.setColumns(10);
		playername8.setBounds(20, 401, 84, 30);
		contentPane.add(playername8);
		
		player_Num8 = new JTextField();
		player_Num8.setFont(new Font("宋体", Font.PLAIN, 18));
		player_Num8.setEditable(false);
		player_Num8.setColumns(10);
		player_Num8.setBounds(114, 401, 149, 30);
		contentPane.add(player_Num8);
		
		score8_1 = new JTextField();
		score8_1.setEditable(false);
		score8_1.setColumns(10);
		score8_1.setBounds(273, 401, 72, 30);
		contentPane.add(score8_1);
		
		score8_2 = new JTextField();
		score8_2.setEditable(false);
		score8_2.setColumns(10);
		score8_2.setBounds(355, 401, 72, 30);
		contentPane.add(score8_2);
		
		score8_3 = new JTextField();
		score8_3.setEditable(false);
		score8_3.setColumns(10);
		score8_3.setBounds(437, 401, 72, 30);
		contentPane.add(score8_3);
		
		score8_4 = new JTextField();
		score8_4.setEditable(false);
		score8_4.setColumns(10);
		score8_4.setBounds(519, 401, 72, 30);
		contentPane.add(score8_4);
		
		score8_5 = new JTextField();
		score8_5.setEditable(false);
		score8_5.setColumns(10);
		score8_5.setBounds(601, 401, 72, 30);
		contentPane.add(score8_5);
		
		avgNum8 = new JTextField();
		avgNum8.setFont(new Font("宋体", Font.PLAIN, 18));
		avgNum8.setEditable(false);
		avgNum8.setColumns(10);
		avgNum8.setBounds(683, 401, 84, 30);
		contentPane.add(avgNum8);
		
		B_Num8 = new JTextField();
		B_Num8.setFont(new Font("宋体", Font.PLAIN, 18));
		B_Num8.setColumns(10);
		B_Num8.setBounds(777, 401, 84, 30);
		contentPane.add(B_Num8);
		
		P_Num8 = new JTextField();
		P_Num8.setFont(new Font("宋体", Font.PLAIN, 18));
		P_Num8.setColumns(10);
		P_Num8.setBounds(871, 401, 84, 30);
		contentPane.add(P_Num8);
		
		JButton ReButton = new JButton("重评");
		ReButton.setFont(new Font("宋体", Font.PLAIN, 18));
		ReButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame jf=new JFrame();
				jf.setTitle("确认重评？");
				jf.setBounds(250, 250, 450, 300);
				jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf.setResizable(false);
				jf.getContentPane().setLayout(null);

				JLabel rejl = new JLabel("请输入需要重评的裁判员号");
				rejl.setFont(new Font("宋体", Font.PLAIN, 18));
				rejl.setBounds(115, 40, 250, 30);
				jf.getContentPane().add(rejl);

				JTextField retext = new JTextField();
				retext.setFont(new Font("宋体", Font.PLAIN, 18));
				retext.setBounds(100, 100, 250, 30);
				jf.getContentPane().add(retext);

				JButton canceljb = new JButton("取消");
				canceljb.setFont(new Font("宋体",Font.PLAIN,18));
				canceljb.setBounds(100,200, 70, 30);
				jf.getContentPane().add(canceljb);
				canceljb.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						jf.dispose();
					}
				});

				JButton rejb = new JButton("确认");
				rejb.setFont(new Font("宋体",Font.PLAIN,18));
				rejb.setBounds(250,200, 70, 30);
				jf.getContentPane().add(rejb);
				rejb.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						int index=Integer.parseInt(retext.getText());
						if(index>=0&&index<mChiefRE.getIDOfJudges().size()){
							new Thread(new Runnable() {
								@Override
								public void run() {
									mChiefRE.sendConform(index);
									//TODO:将打分写入到前端（与后面接受打分表相同，刷新整个打分表）
									ArrayList<ArrayList<Pair<String,Float>>> marks=mChiefRE.getMarkTables();
									//数组成员： 数据对（运动员编号，分数）
									write(marks);
									ArrayList<String> judges=mChiefRE.getIDOfJudges();
									//Judge的ID  序号与marks中的成绩单对应
								}
							}).start();
						}else {
							//TODO:提示输入有误
							retext.setText("请确认输入是否正确");
						}
					}
				});

				jf.setVisible(true);
			}
		});
        ReButton.setBounds(473, 475, 100, 30);
		contentPane.add(ReButton);

		JButton logoutjb = new JButton("注销");
		logoutjb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//注销登录状态
				ClientTool.exit(sid);
				dispose();
				System.exit(0);
			}
		});
		logoutjb.setFont(new Font("宋体", Font.PLAIN, 18));
        logoutjb.setBounds(227, 475, 100, 30);
		contentPane.add(logoutjb);
		this.setVisible(true);

		mChiefRE=new GroupJudge(sid);
		mChiefRE.logined=true;

		new Thread(new Runnable() {
			@Override
			public void run() {
				mChiefRE.start(conn);
				ArrayList<Pair<String,String>>aths = mChiefRE.wait_Aths();//aths  运动员编号  姓名
				//TODO:将运动员编号写入到前端
				int j = aths.size();
				int i = 0;
				player_Num1.setText(aths.get(0).getKey());
				playername1.setText(aths.get(0).getValue());
				i++;
				if(i < j){
					player_Num2.setText(aths.get(1).getKey());
					playername2.setText(aths.get(1).getValue());
				}i++;
				if(i < j){
					player_Num3.setText(aths.get(2).getKey());
					playername3.setText(aths.get(2).getValue());
				}i++;
				if(i < j){
					player_Num4.setText(aths.get(3).getKey());
					playername4.setText(aths.get(3).getValue());
				}i++;
				if(i < j){
					player_Num5.setText(aths.get(4).getKey());
					playername5.setText(aths.get(4).getValue());
				}i++;
				if(i < j){
					player_Num6.setText(aths.get(5).getKey());
					playername6.setText(aths.get(5).getValue());
				}i++;
				if(i < j){
					player_Num7.setText(aths.get(6).getKey());
					playername7.setText(aths.get(6).getValue());
				}i++;
				if(i < j){
					player_Num8.setText(aths.get(7).getKey());
					playername8.setText(aths.get(7).getValue());
				}i++;
				mChiefRE.getMarkTablesFromServer();
				//TODO:将打分写入到前端
				ArrayList<ArrayList<Pair<String,Float>>> marks=mChiefRE.getMarkTables();
				write(marks);
				//数组成员： 数据对（运动员编号，分数）
				ArrayList<String> judges=mChiefRE.getIDOfJudges();
				//Judge的ID  序号与marks中的成绩单对应

			}
		}).start();

	}

	private void clear(){
		playername1.setText(""); playername2.setText("");playername3.setText("");
		playername4.setText("");playername5.setText("");playername6.setText("");
		playername7.setText("");playername8.setText("");

		player_Num1.setText("");player_Num2.setText("");player_Num3.setText("");
		player_Num4.setText("");player_Num5.setText("");player_Num6.setText("");
		player_Num7.setText("");player_Num8.setText("");

		score1_1.setText("");score1_2.setText("");score1_3.setText("");score1_4.setText("");score1_5.setText("");
		score2_1.setText("");score2_2.setText("");score2_3.setText("");score2_4.setText("");score2_5.setText("");
		score3_1.setText("");score3_2.setText("");score3_3.setText("");score3_4.setText("");score3_5.setText("");
		score4_1.setText("");score4_2.setText("");score4_3.setText("");score4_4.setText("");score4_5.setText("");
		score5_1.setText("");score5_2.setText("");score5_3.setText("");score5_4.setText("");score5_5.setText("");
		score6_1.setText("");score6_2.setText("");score6_3.setText("");score6_4.setText("");score6_5.setText("");
		score7_1.setText("");score7_2.setText("");score7_3.setText("");score7_4.setText("");score7_5.setText("");
		score8_1.setText("");score8_2.setText("");score8_3.setText("");score8_4.setText("");score8_5.setText("");

		P_Num1.setText("");P_Num2.setText("");P_Num3.setText("");
		P_Num4.setText("");P_Num5.setText("");P_Num6.setText("");
		P_Num7.setText("");P_Num8.setText("");

		B_Num1.setText("");B_Num2.setText("");B_Num3.setText("");
		B_Num4.setText("");B_Num5.setText("");B_Num6.setText("");
		B_Num7.setText("");B_Num8.setText("");

	}
	private String avgsum (ArrayList<ArrayList<Pair<String,Float>>> arrayList,int i){
		float sum = arrayList.get(0).get(i).getValue()+arrayList.get(1).get(i).getValue()+arrayList.get(2).get(i).getValue()
				+arrayList.get(3).get(i).getValue()+arrayList.get(4).get(i).getValue();
		String avgsum = Float.toString(sum/arrayList.size());
		return avgsum;
	}

	private void write(ArrayList<ArrayList<Pair<String,Float>>> marks){
		int j = marks.get(0).size();
		int i = 0;
		if(i < j){
			score1_1.setText(marks.get(0).get(0).getValue().toString());
			score1_2.setText(marks.get(1).get(0).getValue().toString());
			score1_3.setText(marks.get(2).get(0).getValue().toString());
			score1_4.setText(marks.get(3).get(0).getValue().toString());
			score1_5.setText(marks.get(4).get(0).getValue().toString());
			avgNum1.setText(avgsum(marks,i));
		}i++;
		if((i < j)){
			score2_1.setText(marks.get(0).get(1).getValue().toString());
			score2_2.setText(marks.get(1).get(1).getValue().toString());
			score2_3.setText(marks.get(2).get(1).getValue().toString());
			score2_4.setText(marks.get(3).get(1).getValue().toString());
			score2_5.setText(marks.get(4).get(1).getValue().toString());
			avgNum2.setText(avgsum(marks,i));
		}else{
			P_Num2.setText("/");
			B_Num2.setText("/");
		}i++;
		if((i < j)){
			score3_1.setText(marks.get(0).get(2).getValue().toString());
			score3_2.setText(marks.get(1).get(2).getValue().toString());
			score3_3.setText(marks.get(2).get(2).getValue().toString());
			score3_4.setText(marks.get(3).get(2).getValue().toString());
			score3_5.setText(marks.get(4).get(2).getValue().toString());
			avgNum3.setText(avgsum(marks,i));
		}else{
			P_Num3.setText("/");
			B_Num3.setText("/");
		}i++;
		if((i < j)){
			score4_1.setText(marks.get(0).get(3).getValue().toString());
			score4_2.setText(marks.get(1).get(3).getValue().toString());
			score4_3.setText(marks.get(2).get(3).getValue().toString());
			score4_4.setText(marks.get(3).get(3).getValue().toString());
			score4_5.setText(marks.get(4).get(3).getValue().toString());
			avgNum4.setText(avgsum(marks,i));
		}else{
			P_Num4.setText("/");
			B_Num4.setText("/");
		}i++;
		if((i < j)){
			score5_1.setText(marks.get(0).get(4).getValue().toString());
			score5_2.setText(marks.get(1).get(4).getValue().toString());
			score5_3.setText(marks.get(2).get(4).getValue().toString());
			score5_4.setText(marks.get(3).get(4).getValue().toString());
			score5_5.setText(marks.get(4).get(4).getValue().toString());
			avgNum5.setText(avgsum(marks,i));
		}else{
			P_Num5.setText("/");
			B_Num5.setText("/");
		}i++;
		if((i < j)){
			score6_1.setText(marks.get(0).get(5).getValue().toString());
			score6_2.setText(marks.get(1).get(5).getValue().toString());
			score6_3.setText(marks.get(2).get(5).getValue().toString());
			score6_4.setText(marks.get(3).get(5).getValue().toString());
			score6_5.setText(marks.get(4).get(5).getValue().toString());
			avgNum6.setText(avgsum(marks,i));
		}else{
			P_Num6.setText("/");
			B_Num6.setText("/");
		}i++;
		if((i < j)){
			score7_1.setText(marks.get(0).get(6).getValue().toString());
			score7_2.setText(marks.get(1).get(6).getValue().toString());
			score7_3.setText(marks.get(2).get(6).getValue().toString());
			score7_4.setText(marks.get(3).get(6).getValue().toString());
			score7_5.setText(marks.get(4).get(6).getValue().toString());
			avgNum7.setText(avgsum(marks,i));
		}else{
			P_Num7.setText("/");
			B_Num7.setText("/");
		}i++;
		if((i < j)){
			score8_1.setText(marks.get(0).get(7).getValue().toString());
			score8_2.setText(marks.get(1).get(7).getValue().toString());
			score8_3.setText(marks.get(2).get(7).getValue().toString());
			score8_4.setText(marks.get(3).get(7).getValue().toString());
			score8_5.setText(marks.get(4).get(7).getValue().toString());
			avgNum8.setText(avgsum(marks,i));
		}else{
			P_Num8.setText("/");
			B_Num8.setText("/");
		}i++;
	}
}


