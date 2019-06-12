package teamUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Massagesearch extends JFrame {

	private JPanel p_contentPane;

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
		setTitle("查询界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 505);
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

		JTable ptable = new JTable(rowData,columnNames);

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

		JLabel lblBisaixiangmu = new JLabel("比赛项目");
		lblBisaixiangmu.setFont(new Font("宋体", Font.PLAIN, 18));
		lblBisaixiangmu.setBounds(353, 23, 90, 20);
		playersearch.add(lblBisaixiangmu);

		JTextField gameText = new JTextField();
		gameText.setColumns(10);
		gameText.setBounds(442, 21, 257, 30);
		playersearch.add(gameText);

		JButton queryButton = new JButton("查询");
		queryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		queryButton.setBounds(291, 61, 93, 30);
		playersearch.add(queryButton);

		JPanel teamsearch = new JPanel();
		tabbedPane.addTab("团队查询", null, teamsearch, null);
		teamsearch.setLayout(null);

		String[] tcolumnNames = {"团队名","比赛项目","团队成绩"};

		Object[][] trowData = {};

		JTable ttable = new JTable(trowData,tcolumnNames);

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
		tNumLabel.setBounds(10, 23, 90, 20);
		teamsearch.add(tNumLabel);

		JTextField teamNumText = new JTextField();
		teamNumText.setBounds(110, 21, 215, 30);
		teamNumText.setColumns(10);
		teamsearch.add(teamNumText);

		JLabel tlblBisaixiangmu = new JLabel("比赛项目");
		tlblBisaixiangmu.setFont(new Font("宋体", Font.PLAIN, 18));
		tlblBisaixiangmu.setBounds(353, 23, 90, 20);
		teamsearch.add(tlblBisaixiangmu);

		JTextField tgameText = new JTextField();
		tgameText.setColumns(10);
		tgameText.setBounds(442, 21, 257, 30);
		teamsearch.add(tgameText);

		JButton tqueryButton = new JButton("查询");
		tqueryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		tqueryButton.setBounds(291, 61, 93, 30);
		teamsearch.add(tqueryButton);

	}

}