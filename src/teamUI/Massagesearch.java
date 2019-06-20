package teamUI;

import SocketTools.ClientTool;
import org.javatuples.Septet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Massagesearch extends JFrame {

	private JPanel p_contentPane;
	private HashMap<String,String>Teams;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Massagesearch frame = new Massagesearch();
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
	public Massagesearch() {
		//获取队伍信息
		Teams=ClientTool.getAllTeamName();




		setTitle("查询界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 505);
        setResizable(false);

		p_contentPane = new JPanel();
		p_contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p_contentPane);
		p_contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 746, 451);
		p_contentPane.add(tabbedPane);

		JPanel playersearch = new JPanel();
		tabbedPane.addTab("运动员查询", null, playersearch, null);
		playersearch.setLayout(null);

		String[] columnNames = {"运动员编号","姓名","比赛项目","初赛成绩","初赛排名","决赛成绩","决赛排名"};

		Object[][] rowData = {};

		DefaultTableModel pmodel = new DefaultTableModel(rowData,columnNames);
		JTable ptable = new JTable(pmodel);

		// 设置表格内容颜色
		ptable.setForeground(Color.BLACK);                   // 字体颜色
		ptable.setFont(new Font(null, Font.PLAIN, 14));      // 字体样式
		ptable.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
		ptable.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
		ptable.setGridColor(Color.GRAY);                     // 网格颜色

		// 设置表头
		ptable.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // 设置表头名称字体样式
		ptable.getTableHeader().setForeground(Color.RED);                // 设置表头名称字体颜色
		ptable.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
		ptable.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列

		ptable.setRowHeight(30);

		ptable.setPreferredScrollableViewportSize(new Dimension(400,300));

		JScrollPane scrollPane = new JScrollPane(ptable);
		scrollPane.setBounds(10, 101, 705, 311);
		playersearch.add(scrollPane);

		JLabel pNumLabel = new JLabel("运动员编号");
		pNumLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		pNumLabel.setBounds(10, 23, 90, 20);
		playersearch.add(pNumLabel);

		JTextField playerNumText = new JTextField();
		playerNumText.setBounds(110, 21, 215, 30);
		playerNumText.setColumns(10);
		playersearch.add(playerNumText);

//		JLabel lblBisaixiangmu = new JLabel("比赛项目");
//		lblBisaixiangmu.setFont(new Font("宋体", Font.PLAIN, 18));
//		lblBisaixiangmu.setBounds(353, 23, 90, 20);
//		playersearch.add(lblBisaixiangmu);

//		JComboBox pbisaixiangmu = new JComboBox();
//		pbisaixiangmu.setModel(new DefaultComboBoxModel(new String[] {"全部","单杠", "双杠","吊环","鞍马","蹦床","跳马","高低杠","平衡木","自由体操"}));
//		pbisaixiangmu.setFont(new Font("宋体", Font.PLAIN, 18));
//		pbisaixiangmu.setBounds(439, 25, 104, 25);
//		playersearch.add(pbisaixiangmu);

		JButton queryButton = new JButton("查询");
		queryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//pbisaixiangmu.getSelectedItem()//获得所选
				//TODO:清空现有记录，进行运动员编号查询，刷新界面
				String athNum=playerNumText.getText();
				if(!athNum.isEmpty()){
					//执行查询
					ArrayList<Septet<String,String,String,Float,Integer,Float,Integer>> res =
							ClientTool.SearchAthByNum(athNum);
					if(!res.isEmpty()) {
						//TODO:清空当前查询结果界面，输出结果到前端
						//res为七元组  运动员编号 姓名 比赛项目 初赛成绩  初赛排名 决赛成绩 决赛排名
						return;
					}
				}

				//TODO:提示输入无效

			}
		});
		queryButton.setBounds(291, 61, 93, 30);
		playersearch.add(queryButton);

		JPanel teamsearch = new JPanel();
		tabbedPane.addTab("团队查询", null, teamsearch, null);
		teamsearch.setLayout(null);

		String[] tcolumnNames = {"团队名","比赛项目","年龄组","性别","团队成绩","团队排名"};

		Object[][] trowData = {};

		DefaultTableModel tmodel = new DefaultTableModel(trowData,tcolumnNames);
		JTable ttable = new JTable(tmodel);

		// 设置表格内容颜色
		ttable.setForeground(Color.BLACK);                   // 字体颜色
		ttable.setFont(new Font(null, Font.PLAIN, 14));      // 字体样式
		ttable.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
		ttable.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
		ttable.setGridColor(Color.GRAY);                     // 网格颜色

		// 设置表头
		ttable.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // 设置表头名称字体样式
		ttable.getTableHeader().setForeground(Color.RED);                // 设置表头名称字体颜色
		ttable.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
		ttable.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列

		ttable.setRowHeight(30);

		ttable.setPreferredScrollableViewportSize(new Dimension(400,300));

		JScrollPane tscrollPane = new JScrollPane(ttable);
		tscrollPane.setBounds(10, 101, 705, 311);
		teamsearch.add(tscrollPane);

		JLabel tNumLabel = new JLabel("团队");
		tNumLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		tNumLabel.setBounds(10, 25, 48, 27);
		teamsearch.add(tNumLabel);

		//团队号
		JComboBox teamNumBox = new JComboBox();
		teamNumBox.setBounds(57, 25, 206, 25);
		//TODO：拉取数据库信息置入string
		String [] string = new String[Teams.keySet().size()+1] ;
		Teams.keySet().toArray(string);
		string[Teams.keySet().size()]="全部";
		teamNumBox.setModel(new DefaultComboBoxModel(string));
		teamsearch.add(teamNumBox);

		JLabel tlblBisaixiangmu = new JLabel("比赛项目");
		tlblBisaixiangmu.setFont(new Font("宋体", Font.PLAIN, 18));
		tlblBisaixiangmu.setBounds(273, 25, 90, 20);
		teamsearch.add(tlblBisaixiangmu);



		JComboBox txiangmuBox = new JComboBox();
		txiangmuBox.setModel(new DefaultComboBoxModel(new String[] {"男子单杠", "男子双杠","男子吊环","男子跳马","男子自由体操","男子鞍马","男子蹦床","男子高低杠","男子平衡木"
				,"女子跳马","女子高低杠","女子平衡木","女子自由体操","女子蹦床"}));
		txiangmuBox.setFont(new Font("宋体", Font.PLAIN, 18));
		txiangmuBox.setToolTipText("");
		txiangmuBox.setBounds(353, 25, 176, 25);
		teamsearch.add(txiangmuBox);

		JLabel agelabel = new JLabel("年龄组");
		agelabel.setFont(new Font("宋体", Font.PLAIN, 18));
		agelabel.setBounds(539, 25, 54, 20);
		teamsearch.add(agelabel);

		JComboBox ageBox = new JComboBox();
		ageBox.setFont(new Font("宋体", Font.PLAIN, 18));
		ageBox.setModel(new DefaultComboBoxModel(new String[] {"全部","7-8", "9-10", "11-12"}));
		ageBox.setBounds(603, 25, 77, 25);
		teamsearch.add(ageBox);

//		JLabel sexLabel = new JLabel("性别");
//		sexLabel.setFont(new Font("宋体", Font.PLAIN, 18));
//		sexLabel.setBounds(618, 25, 48, 20);
//		teamsearch.add(sexLabel);
//
//		JComboBox sexBox = new JComboBox();
//		sexBox.setModel(new DefaultComboBoxModel(new String[] {"全部","男","女"}));
//		sexBox.setBounds(666, 25, 49, 25);
//		teamsearch.add(sexBox);

		JPanel itemsearch = new JPanel();
		tabbedPane.addTab("项目查询", null, itemsearch, null);
		itemsearch.setLayout(null);

//		String[] icolumnNames = {"比赛项目","年龄组","性别","运动员姓名","成绩","排名"};
		String[] icolumnNames = {"运动员编号","姓名","比赛项目","初赛成绩","初赛排名","决赛成绩","决赛排名"};

		Object[][] irowData = {};

		DefaultTableModel imodel = new DefaultTableModel(irowData,icolumnNames);
		JTable itable = new JTable(imodel);

		// 设置表格内容颜色
		itable.setForeground(Color.BLACK);                   // 字体颜色
		itable.setFont(new Font(null, Font.PLAIN, 14));      // 字体样式
		itable.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
		itable.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
		itable.setGridColor(Color.GRAY);                     // 网格颜色

		// 设置表头
		itable.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // 设置表头名称字体样式
		itable.getTableHeader().setForeground(Color.RED);                // 设置表头名称字体颜色
		itable.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
		itable.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列

		itable.setRowHeight(30);

		itable.setPreferredScrollableViewportSize(new Dimension(400,300));

		JScrollPane iscrollPane = new JScrollPane(itable);
		iscrollPane.setBounds(10, 101, 705, 311);
		itemsearch.add(iscrollPane);

		JLabel itemLabel = new JLabel("比赛项目");
		itemLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		itemLabel.setBounds(22, 25, 84, 20);
		itemsearch.add(itemLabel);

		JComboBox itemBox = new JComboBox();
		itemBox.setModel(new DefaultComboBoxModel(new String[] {"男子单杠", "男子双杠","男子吊环","男子跳马","男子自由体操","男子鞍马","男子蹦床","男子高低杠","男子平衡木"
				,"女子跳马","女子高低杠","女子平衡木","女子自由体操","女子蹦床"}));
		itemBox.setFont(new Font("宋体", Font.PLAIN, 18));
		itemBox.setToolTipText("");
		itemBox.setBounds(116, 25, 183, 25);
		itemsearch.add(itemBox);

		JLabel iageLabel = new JLabel("年龄组");
		iageLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		iageLabel.setBounds(329, 25, 67, 20);
		itemsearch.add(iageLabel);

		JComboBox iageBox = new JComboBox();
		iageBox.setFont(new Font("宋体", Font.PLAIN, 18));
		iageBox.setModel(new DefaultComboBoxModel(new String[] {"全部","7-8", "9-10", "11-12"}));
		iageBox.setBounds(406, 25, 77, 25);
		itemsearch.add(iageBox);

//		JLabel isexLabel = new JLabel("性别");
//		isexLabel.setFont(new Font("宋体", Font.PLAIN, 18));
//		isexLabel.setBounds(421, 25, 48, 20);
//		itemsearch.add(isexLabel);
//
//		JComboBox isexBox = new JComboBox();
//		isexBox.setFont(new Font("宋体", Font.PLAIN, 18));
//		isexBox.setModel(new DefaultComboBoxModel(new String[] {"全部","男","女"}));
//		isexBox.setBounds(479, 25, 69, 25);
//		itemsearch.add(isexBox);

//		JLabel gameLabel = new JLabel("预/决赛");
//		gameLabel.setFont(new Font("宋体", Font.PLAIN, 18));
//		gameLabel.setBounds(512, 25, 74, 20);
//		itemsearch.add(gameLabel);
//
//		JComboBox comboBox = new JComboBox();
//		comboBox.setModel(new DefaultComboBoxModel(new String[] {"预赛","决赛"}));
//		comboBox.setFont(new Font("宋体", Font.PLAIN, 18));
//		comboBox.setBounds(596, 25, 69, 25);
//		itemsearch.add(comboBox);

		JButton iqueryButton = new JButton("查询");
		iqueryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//TODO:清空现有记录，进行项目查询，刷新界面
			}
		});
		iqueryButton.setBounds(283, 61, 93, 30);
		itemsearch.add(iqueryButton);

	}
	//向表格Table输入数据的函数
	public void add(JTable table,Object[] obj) {
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		tableModel.addRow(obj);
		table.invalidate();
	}
}