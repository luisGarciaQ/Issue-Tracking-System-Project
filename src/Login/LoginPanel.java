package Login;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class LoginPanel extends JPanel
{
    private TitledBorder title = new TitledBorder("Login");
    private JPanel titledPanel, leftPanel,rightPanel ,bottomPanel, topPanel;
    private JLabel aUsername, aPassword,dot1,dot2,messageIncorrect;
    private JTextField aUsernameField;
    private JPasswordField passwordField;
    private JButton loginBtn, signIn;

    public LoginPanel() {

        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(550,450));
        this.setLayout(new BorderLayout());

        createButtons();
        createField();
        createUsernamePassLabel();
        createTitledPanels();

        this.add(leftPanel,BorderLayout.WEST);
        this.add(titledPanel,BorderLayout.CENTER);
        this.add(rightPanel , BorderLayout.EAST);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.add(topPanel, BorderLayout.NORTH);
        this.setVisible(true);
    }

    public void createTitledPanels()
    {
        titledPanel = new JPanel();
        titledPanel.setBackground(Color.lightGray);
        titledPanel.setPreferredSize(new Dimension(400,200));
        titledPanel.setMaximumSize(new Dimension(400,200));
        titledPanel.setLayout(null);
        titledPanel.setBorder(title);
        titledPanel.setVisible(true);

        leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(40,450));
        leftPanel.setMaximumSize(new Dimension(40,450));
        leftPanel.setBackground(Color.lightGray);
        leftPanel.setVisible(true);

        rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(40,450));
        rightPanel.setMaximumSize(new Dimension(40,450));
        rightPanel.setBackground(Color.lightGray);
        rightPanel.setVisible(true);

        bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(550,40));
        bottomPanel.setMaximumSize(new Dimension(550,40));
        bottomPanel.setBackground(Color.lightGray);
        bottomPanel.setVisible(true);

        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(550,40));
        topPanel.setMaximumSize(new Dimension(550,40));
        topPanel.setBackground(Color.lightGray);
        topPanel.setVisible(true);

        dot1 = new JLabel("*");
        dot1.setForeground(Color.red);
        dot1.setFont(new Font("Courier" , Font.PLAIN, 12));
        dot1.setBounds(305, 3 , 100,100);
        dot1.setVisible(false);


        dot2 = new JLabel("*");
        dot2.setForeground(Color.red);
        dot2.setFont(new Font("Courier" , Font.PLAIN, 12));
        dot2.setBounds(305, 47 , 100,100);
        dot2.setVisible(false);

        messageIncorrect = new JLabel("***** Invalid login *****");
        messageIncorrect.setForeground(Color.red);
        messageIncorrect.setFont(new Font("Courier" , Font.PLAIN, 12));
        messageIncorrect.setBounds(135, 78 , 200,100);
        messageIncorrect.setVisible(false);


        titledPanel.add(aUsername);
        titledPanel.add(aPassword);
        titledPanel.add(aUsernameField);
        titledPanel.add(passwordField);
        titledPanel.add(loginBtn);
        titledPanel.add(signIn);
        titledPanel.add(dot1);
        titledPanel.add(dot2);
        titledPanel.add(messageIncorrect);
    }

    public void createUsernamePassLabel()
    {
        aUsername = new JLabel();
        aUsername.setText("Username: ");
        aUsername.setBounds(35,35,120,35);
        aUsername.setFont(new Font("Courier" , Font.PLAIN , 15));
        aUsername.setForeground(Color.black);

        aPassword = new JLabel();
        aPassword.setText("Password: ");
        aPassword.setBounds(45,85,90,35);
        aPassword.setFont(new Font("Courier" , Font.PLAIN , 15));
        aPassword.setForeground(Color.black);

    }

    public void createField()
    {
        aUsernameField = new JTextField();
        aUsernameField.setFont(new Font("Couried", Font.PLAIN, 12));
        aUsernameField.setBounds(130,37,170,32);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Couried", Font.PLAIN, 12));
        passwordField.setBounds(130,85,170,32);
    }

    public void createButtons()
    {
        loginBtn = new JButton("Login");
        loginBtn.setBounds(115, 140, 100 , 30);

        signIn = new JButton("Sign in");
        signIn.setBounds(215, 140, 100 , 30);
    }

    public void invalidLogin()
    {
        dot1.setVisible(true);
        dot2.setVisible(true);
        messageIncorrect.setVisible(true);
        aUsernameField.setText("");
        passwordField.setText("");

    }

    /**
     *
     *   ********************* GETTER AND SETTERS *********************
     */

    public JTextField getaUsernameField() {
        return aUsernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getLoginBtn() {
        return loginBtn;
    }

    public JButton getSignIn() {
        return signIn;
    }

}
