package Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class Shopp extends JFrame implements ActionListener {
    JButton button;
    JMenuBar menuBar;
    JMenu menu;
    JTextArea textArea;
    JMenuItem menuItem;
    Shopp(){
        init();
    }
    void init(){
        setTitle("商品价格");
        setBounds(300,300,400,500);
        menuBar=new JMenuBar();
        menu=new JMenu("文件");
        menuItem=new JMenuItem("打开文件");
        menuItem.addActionListener(this);
        menu.add(menuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar); //**  这一步特别一点 别的都用new 这个用setJMenuBar
        textArea=new JTextArea(20,20);
        button=new JButton("计算价格");
        button.addActionListener(this);
        add(textArea,BorderLayout.CENTER);
        add(button,BorderLayout.SOUTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==menuItem){                    //菜单栏的监控
            JFileChooser jFileChooser=new JFileChooser();
            jFileChooser.showOpenDialog(this);
            File dir= jFileChooser.getCurrentDirectory();
            String filename=jFileChooser.getSelectedFile().getName();
            File file=new File(dir,filename);
            try {
                FileReader fileReader =new FileReader(file);
                BufferedReader bufferedReader=new BufferedReader(fileReader);
                String str;
                while ((str=bufferedReader.readLine())!=null){
                    textArea.append(str+"\n");
                }
                bufferedReader.close();        //先开后关原则
                fileReader.close();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if (e.getSource()==button){       //按钮的监控
            Scanner scanner=new Scanner(textArea.getText());
            scanner.useDelimiter("[^1-9]+");
            int  sum=0;
            while (scanner.hasNext()){
                sum+=scanner.nextInt();
            }
            textArea.append(String.valueOf(sum));
        }
    }
    public static void main(String args[]){
        Shopp shopp=new Shopp();
    }
}

