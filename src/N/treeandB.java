package N;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class treeandB extends JFrame implements ActionListener {  //???????//

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    JButton btnNewButton,btnNewButton_1,btnNewButton_2,btnNewButton_3;
    JPanel panel_1;
    static treeandB frame = new treeandB();
    JTree tree;
    JScrollPane scrollPane;

            public void run() {
                try {
                    frame.init();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

    }



    public void init() {
        setTitle("\u5546\u54C1\u7BA1\u7406");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 654, 424);
        setLocationRelativeTo(null );
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 638, 385);
        contentPane.add(panel);
        panel.setLayout(null);

        panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 318, 292);
        panel.add(panel_1);
        panel_1.setLayout(null);








        JPanel panel_2 = new JPanel();
        panel_2.setBounds(317, 0, 321, 292);
        panel.add(panel_2);
        panel_2.setLayout(null);

        JTextPane textPane = new JTextPane();//?????//
        textPane.setBounds(0, 0, 321, 149);
        panel_2.add(textPane);

        btnNewButton = new JButton("\u6DFB\u52A0");//Ìí¼Ó
        btnNewButton.setBounds(61, 323, 93, 23);
        panel.add(btnNewButton);

        btnNewButton_1 = new JButton("\u7F16\u8F91");//±à¼­//
        btnNewButton_1.setBounds(212, 323, 93, 23);
        panel.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("1");
            }
        });

        btnNewButton_2 = new JButton("\u5220\u9664");//É¾³ý//
        btnNewButton_2.setBounds(346, 323, 93, 23);
        panel.add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("2");
            }
        });

        btnNewButton_3 = new JButton("\u9000\u51FA");//???//
        btnNewButton_3.setBounds(481, 323, 93, 23);
        panel.add(btnNewButton_3);
        btnNewButton_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(EXIT_ON_CLOSE);
            }
        });
        btnNewButton.addActionListener(this );


    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnNewButton) {
            addGoods son4=new addGoods();
            son4.run();
            this.dispose();

        }
    }






}