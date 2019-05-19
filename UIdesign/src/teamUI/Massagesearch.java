package teamUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Massagesearch extends JFrame {

	private JPanel contentPane;
	private JTextField playerNumText;
	private JTextField gameText;

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
		setTitle("请输入需要查询的运动员信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] columnNames = {"运动员编号","姓名","比赛项目","初赛成绩","初赛排名","决赛成绩","决赛排名","团体排名"};
		
		Object[][] rowData = {};
		
		JTable table = new JTable(rowData,columnNames);
		
		// 设置表格内容颜色
        table.setForeground(Color.BLACK);                   // 字体颜色
        table.setFont(new Font(null, Font.PLAIN, 14));      // 字体样式
        table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
        table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
        table.setGridColor(Color.GRAY);                     // 网格颜色

        // 设置表头
        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // 设置表头名称字体样式
        table.getTableHeader().setForeground(Color.RED);                // 设置表头名称字体颜色
        table.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
        table.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列
        
        table.setRowHeight(30);
        
        table.setPreferredScrollableViewportSize(new Dimension(400,300));
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 115, 705, 311);
        contentPane.add(scrollPane);
        
        JLabel numLabel = new JLabel("运动员编号");
        numLabel.setFont(new Font("宋体", Font.PLAIN, 18));
        numLabel.setBounds(10, 23, 90, 20);
        contentPane.add(numLabel);
        
        playerNumText = new JTextField();
        playerNumText.setBounds(110, 21, 215, 30);
        contentPane.add(playerNumText);
        playerNumText.setColumns(10);
        
        JLabel lblBisaixiangmu = new JLabel("比赛项目");
        lblBisaixiangmu.setFont(new Font("宋体", Font.PLAIN, 18));
        lblBisaixiangmu.setBounds(353, 23, 90, 20);
        contentPane.add(lblBisaixiangmu);
        
        gameText = new JTextField();
        gameText.setColumns(10);
        gameText.setBounds(442, 21, 257, 30);
        contentPane.add(gameText);
        
        JButton queryButton = new JButton("查询");
        queryButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		
        	}
        });
        queryButton.setBounds(292, 71, 93, 30);
        contentPane.add(queryButton);
	}
}
