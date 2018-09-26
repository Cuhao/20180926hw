import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    String password;
    int x=0;
    private JButton jbnExit =new JButton("EXIT");
    private JButton jbnsubmit =new JButton("Submit");

    private JButton jbn[][]  =new JButton[2][6];
    private JLabel jLabel =new JLabel("請按submit");
    JPanel jPane1 =new JPanel(new BorderLayout(3,3));
    JPanel jPane2 =new JPanel(new GridLayout(3,3,3,3));
    JPanel jPane3 =new JPanel(new BorderLayout(3,3));
    JPasswordField jPasswordField =new JPasswordField();
    Container cp;
    public MainFrame(){init();}
    private void init(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(10,10,600,600);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        cp.add(jPane1,BorderLayout.NORTH);  //BordLayout 排版
        cp.add(jPane2,BorderLayout.CENTER); //GirdLayout 排版
        cp.add(jPane3,BorderLayout.SOUTH);  //BordLayout 排版
        jPane3.add(jLabel);
        jPane1.add(jPasswordField);
        for (int i=0;i<2;i++){
            for (int j=0;j<5;j++){
                jbn[i][j]=new JButton();
                jPane2.add(jbn[i][j]);
                if (x<=9){
                    jbn[i][j].setText(Integer.toString(x));
                    x++;
                }
                jbn[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton tembtn =(JButton)e.getSource();
                        if (Integer.parseInt(tembtn.getText())<=9&&Integer.parseInt(tembtn.getText())>=0) {//判斷數字
                            password = jPasswordField.getText();
                            jPasswordField.setText(password + tembtn.getText());
                        }else {
                            System.out.println("*");
                        }
                    }
                });
            }
        }
        jPane2.add(jbnsubmit);
        jPane2.add(jbnExit);
        jbnsubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                JButton tembtn2 =(JButton)f.getSource();
                System.out.println("****"); //測試案件有無用
                   if (jPasswordField.getText().equals("23323456")){
                       jLabel.setText("成功");
                   }else {
                       jLabel.setText("請重新輸入");
                   }
            }
        });
        jbnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(EXIT_ON_CLOSE);
            }
        });
    }
}
