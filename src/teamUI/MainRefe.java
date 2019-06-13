package teamUI;

import SocketTools.ChiefJudge;
import SocketTools.Judge;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;

public class MainRefe extends JFrame {

	private JPanel contentPane;
	ChiefJudge chiefJudge=new ChiefJudge(this);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainRefe frame = new MainRefe();
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
	public MainRefe() {
		setTitle("总裁判您好");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 494);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("通知栏");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(10, 10, 64, 32);
		contentPane.add(label);
		
		JTextArea messageArea = new JTextArea();
		messageArea.setBounds(84, 10, 609, 140);
		messageArea.setLineWrap(true);
		JScrollPane messagePane=new JScrollPane(messageArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		messagePane.setBounds(84, 16, 592, 139);
		contentPane.add(messagePane);




		JLabel label_2 = new JLabel("性别");
		label_2.setFont(new Font("宋体", Font.PLAIN, 18));
		label_2.setBounds(21, 177, 53, 20);
		contentPane.add(label_2);
		
		JPanel sex_panel = new JPanel();
		sex_panel.setBounds(117, 165, 491, 39);
		contentPane.add(sex_panel);

		JRadioButton radioB_man = new JRadioButton("男",true);
		radioB_man.setFont(new Font("宋体", Font.PLAIN, 18));
		sex_panel.add(radioB_man);
		
		JRadioButton radioB_woman = new JRadioButton("女");
		radioB_woman.setFont(new Font("宋体", Font.PLAIN, 18));
		sex_panel.add(radioB_woman);

		ButtonGroup bg_sex =new ButtonGroup();
		bg_sex.add(radioB_man);
		bg_sex.add(radioB_woman);




		JLabel label_3 = new JLabel("年龄组");
		label_3.setFont(new Font("宋体", Font.PLAIN, 18));
		label_3.setBounds(19, 219, 64, 20);
		contentPane.add(label_3);
		
		JPanel age_panel = new JPanel();
		age_panel.setBounds(117, 214, 491, 39);
		contentPane.add(age_panel);
		
		JRadioButton radioButton_2 = new JRadioButton("7-8",true);
		radioButton_2.setFont(new Font("宋体", Font.PLAIN, 18));
		age_panel.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("9-10");
		radioButton_3.setFont(new Font("宋体", Font.PLAIN, 18));
		age_panel.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("11-12");
		radioButton_4.setFont(new Font("宋体", Font.PLAIN, 18));
		age_panel.add(radioButton_4);

		ButtonGroup bg_age =new ButtonGroup();
		bg_age.add(radioButton_2);
		bg_age.add(radioButton_3);
		bg_age.add(radioButton_4);




		JLabel label_1 = new JLabel("比赛项目");
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(10, 266, 81, 20);
		contentPane.add(label_1);


		JPanel game_panel = new JPanel();
		game_panel.setLayout(null);
		game_panel.setBounds(117, 266, 491, 81);
		contentPane.add(game_panel);

		JRadioButton dangang = new JRadioButton("单杠");
		dangang.setBounds(6, 6, 56, 23);
		game_panel.add(dangang);

		JRadioButton shuanggang = new JRadioButton("双杠");
		shuanggang.setBounds(97, 6, 56, 23);
		game_panel.add(shuanggang);

		JRadioButton diaohuan = new JRadioButton("吊环");
		diaohuan.setBounds(187, 6, 63, 23);
		game_panel.add(diaohuan);

		JRadioButton tiaoma = new JRadioButton("跳马");
		tiaoma.setBounds(6, 41, 56, 23);
		game_panel.add(tiaoma);

		JRadioButton ticao = new JRadioButton("自由体操");
		ticao.setBounds(292, 41, 80, 23);
		game_panel.add(ticao);

		JRadioButton anma = new JRadioButton("鞍马");
		anma.setBounds(292, 6, 56, 23);
		game_panel.add(anma);

		JRadioButton bengchuang = new JRadioButton("蹦床");
		bengchuang.setBounds(402, 6, 63, 23);
		game_panel.add(bengchuang);

		JRadioButton gaodigang = new JRadioButton("高低杠");
		gaodigang.setBounds(97, 41, 69, 23);
		game_panel.add(gaodigang);

		JRadioButton pinghengmu = new JRadioButton("平衡木",true);
		pinghengmu.setBounds(187, 41, 80, 23);
		game_panel.add(pinghengmu);

		ButtonGroup bg_game=new ButtonGroup();
		bg_game.add(dangang);
		bg_game.add(shuanggang);
		bg_game.add(diaohuan);
		bg_game.add(tiaoma);
		bg_game.add(ticao);
		bg_game.add(anma);
		bg_game.add(bengchuang);
		bg_game.add(gaodigang);
		bg_game.add(pinghengmu);





		JLabel label_4 = new JLabel("预决赛");
		label_4.setFont(new Font("宋体", Font.PLAIN, 18));
		label_4.setBounds(21, 354, 64, 20);
		contentPane.add(label_4);
		
		JPanel befinal_panel = new JPanel();
		befinal_panel.setBounds(117, 351, 491, 39);
		contentPane.add(befinal_panel);
		
		JRadioButton jRB_yusai = new JRadioButton("预赛",true);
		jRB_yusai.setFont(new Font("宋体", Font.PLAIN, 18));
		befinal_panel.add(jRB_yusai);
		
		JRadioButton jRB_juesai = new JRadioButton("决赛");
		jRB_juesai.setFont(new Font("宋体", Font.PLAIN, 18));
		befinal_panel.add(jRB_juesai);

		ButtonGroup bg_befinal =new ButtonGroup();
		bg_befinal.add(jRB_yusai);
		bg_befinal.add(jRB_juesai);
		
		JButton button = new JButton("比赛开始");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				//获取通知栏
				String textarea=messageArea.getText();

				//获取各个选项的值
				String sex=findthebuttonText(bg_sex);
				String game=findthebuttonText(bg_game);
				String age=findthebuttonText(bg_age);
				String befinal=findthebuttonText(bg_befinal);

				//最后传递给ChiefJudge的值
				int groupID=JudgeTheAge(age);
				String finalString=sex+"子"+age+"组"+game+befinal;

				chiefJudge.startpro(finalString,groupID);
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 18));
		button.setBounds(278, 415, 145, 30);
		contentPane.add(button);
	}

	//判断是哪个年龄组的
	public int JudgeTheAge(String age){
		switch (age){
			case "7-8":
				return 1;
			case "9-10":
				return 2;
			case "11-12":
				return 3;
			default:
				return -1;
		}
	}
	//找到button组中的选项text值
	public String findthebuttonText(ButtonGroup bg){
		String Text=null;
			Enumeration<AbstractButton> radioBtns=bg.getElements();
		while (radioBtns.hasMoreElements()) {
			AbstractButton btn = radioBtns.nextElement();
			if(btn.isSelected()){
				Text=btn.getText();
				break;
			}
		}
		return Text;
	}
}
