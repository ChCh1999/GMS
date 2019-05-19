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
		setTitle("��������Ҫ��ѯ���˶�Ա��Ϣ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] columnNames = {"�˶�Ա���","����","������Ŀ","�����ɼ�","��������","�����ɼ�","��������","��������"};
		
		Object[][] rowData = {};
		
		JTable table = new JTable(rowData,columnNames);
		
		// ���ñ��������ɫ
        table.setForeground(Color.BLACK);                   // ������ɫ
        table.setFont(new Font(null, Font.PLAIN, 14));      // ������ʽ
        table.setSelectionForeground(Color.DARK_GRAY);      // ѡ�к�������ɫ
        table.setSelectionBackground(Color.LIGHT_GRAY);     // ѡ�к����屳��
        table.setGridColor(Color.GRAY);                     // ������ɫ

        // ���ñ�ͷ
        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // ���ñ�ͷ����������ʽ
        table.getTableHeader().setForeground(Color.RED);                // ���ñ�ͷ����������ɫ
        table.getTableHeader().setResizingAllowed(false);               // ���ò������ֶ��ı��п�
        table.getTableHeader().setReorderingAllowed(false);             // ���ò������϶������������
        
        table.setRowHeight(30);
        
        table.setPreferredScrollableViewportSize(new Dimension(400,300));
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 115, 705, 311);
        contentPane.add(scrollPane);
        
        JLabel numLabel = new JLabel("�˶�Ա���");
        numLabel.setFont(new Font("����", Font.PLAIN, 18));
        numLabel.setBounds(10, 23, 90, 20);
        contentPane.add(numLabel);
        
        playerNumText = new JTextField();
        playerNumText.setBounds(110, 21, 215, 30);
        contentPane.add(playerNumText);
        playerNumText.setColumns(10);
        
        JLabel lblBisaixiangmu = new JLabel("������Ŀ");
        lblBisaixiangmu.setFont(new Font("����", Font.PLAIN, 18));
        lblBisaixiangmu.setBounds(353, 23, 90, 20);
        contentPane.add(lblBisaixiangmu);
        
        gameText = new JTextField();
        gameText.setColumns(10);
        gameText.setBounds(442, 21, 257, 30);
        contentPane.add(gameText);
        
        JButton queryButton = new JButton("��ѯ");
        queryButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		
        	}
        });
        queryButton.setBounds(292, 71, 93, 30);
        contentPane.add(queryButton);
	}
}
