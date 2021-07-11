package ATM1.ATMD;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class His extends JFrame {
    static His frame4=new His();
    private JPanel contentPane;
    private JTable table_1;
    private PreparedStatement pstmt;
    private DefaultTableModel model;//�������ģ��
    public void run() {
        try {
            frame4.init();
            frame4.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void init() {
        setTitle("\u6B22\u8FCE\u4F7F\u7528\u94F6\u884CATM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 511);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setVisible(true);

        JButton btnNewButton = new JButton("8");
        btnNewButton.setBounds(10, 77, 93, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("7");
        btnNewButton_1.setBounds(10, 158, 93, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("6");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                His his=new His();
                his.run();
                frame4.dispose();


            }
        });
        btnNewButton_2.setBounds(10, 337, 93, 23);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("5");
        btnNewButton_3.setBounds(10, 254, 93, 23);
        contentPane.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("4");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_4.setBounds(654, 77, 93, 23);
        contentPane.add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("3");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnNewButton_5.setBounds(654, 158, 93, 23);
        contentPane.add(btnNewButton_5);

        JButton btnNewButton_6 = new JButton("2");
        btnNewButton_6.setBounds(654, 254, 93, 23);
        contentPane.add(btnNewButton_6);

        JButton btnNewButton_7 = new JButton("1");            //���ذ�ť
        btnNewButton_7.setBounds(654, 337, 93, 23);
        contentPane.add(btnNewButton_7);
        btnNewButton_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Historicaldata historicaldata=new Historicaldata();
                historicaldata.run();
                frame4.dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "\u5386\u53F2\u6570\u636E\u67E5\u8BE2\u7A97\u53E3", TitledBorder.CENTER, TitledBorder.TOP, null, null));
        panel.setBounds(113, 64, 499, 307);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("\u300A\u8FD1\u4E00\u4E2A\u6708");
        lblNewLabel.setBounds(0, 282, 72, 15);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("\u8FD4\u56DE\u300B");
        lblNewLabel_1.setBounds(435, 282, 54, 15);
        panel.add(lblNewLabel_1);
        frame4.setLocationRelativeTo(null);
        try {
            // ����MySql����
            Class.forName("com.mysql.cj.jdbc.Driver");
            // �������ݿ�����
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/text?useUnicode=true&characterEncoding=UTF8",
                    "root",
                    "123456");
            System.out.println("���ӳɹ���");
            // ����Statment����
            Statement stmt = conn.createStatement();
            // ��ȡ��ѯ�����
            ResultSet rs = stmt.executeQuery("SELECT * FROM atmbankdatabase.atm");
            //�б�����
            String[] columnNames = {"��������", "֧��", "����", "�Է��˺�"};
            //��ѯ����
            model=new DefaultTableModel();//���ؼ����� λ�ò��ܱ� ֻ��������
            String sql1="select * from atmbankdatabase.atm where DATE_SUB(CURDATE(),INTERVAL 30 DAY )<=date (date)";
            //where DATE_SUB(CURDATE(),INTERVAL 30 DAY)<=date (��������)
            //ִ�в�ѯ����ȡ���
            pstmt=conn.prepareStatement(sql1);
            rs=pstmt.executeQuery();

            //��ȡ������������������Ϊ�������ı���
            ResultSetMetaData rsmd=rs.getMetaData();
            //�������
            int count=rsmd.getColumnCount();
//			��������ӵ����ģ����Ϊ����
            for(int i=1;i<=count;i++){
                model.addColumn(rsmd.getColumnName(i));
            }
            //ÿ������һ������
            String[] row=new String[count];
            while(rs.next()){
                //����ѯ����ÿ�����ݸ���������
                for(int i=0;i<count;i++)
                    row[i]=rs.getString(i+1);
                //����һ��
                model.addRow(row);
            }
            //�ر�����
            rs.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        table_1 = new JTable();
        table_1.setModel(model);
        JScrollPane scrollPane = new JScrollPane(table_1);
        scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPane.setBounds(10, 20, 479, 259);
        panel.add(scrollPane);
        scrollPane.setViewportView(table_1);
    }
}
