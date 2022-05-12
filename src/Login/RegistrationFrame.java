package Login;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class RegistrationFrame extends JFrame {

    private JTextField firstNameField = new JTextField()
                      ,lastNameField = new JTextField()
                      ,emailFiled = new JTextField();

    private JPasswordField passwordField = new JPasswordField(20)
                          ,confirmPassField = new JPasswordField(20);

    private JButton backBtn = new JButton("Go Back")
                   ,registerBtn = new JButton("Register");

    private JLabel dot1, dot2, incorrectPassLabel, successPassLabel;

    public RegistrationFrame()
    {
        this.setSize(500,500);
        this.setTitle("Welcome");
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.add(createNorthSouth(), BorderLayout.SOUTH);
        this.add(createNorthSouth(), BorderLayout.NORTH);
        this.add(createLeftRight(), BorderLayout.WEST);
        this.add(createLeftRight(), BorderLayout.EAST);
        this.add(createMiddle(), BorderLayout.CENTER);
        this.setVisible(false);
    }
    public JPanel createMiddle()
    {
        JLabel firstName = createLabel("First Name:");
        JLabel lastName = createLabel("Last Name:");
        JLabel pass = createLabel("Password:");
        JLabel passCon = createLabel("Confirm Password:");
        JLabel email = createLabel("Email:");
        JPanel panel = new JPanel();
        Border border = BorderFactory.createTitledBorder("Registration");
        incorrectPassLabel = new JLabel("*** Incorrect Password ***");
        successPassLabel = new JLabel("*** SUCCESS ***");

        panel.setBackground(Color.lightGray);
        panel.setPreferredSize(new Dimension(400,400));
        panel.setBorder(border);
        panel.setVisible(true);

        firstName.setBounds(100,95,100,40);
        lastName.setBounds(100,145,100,40);
        email.setBounds(100,195,100,40);
        pass.setBounds(100,245,100,40);
        passCon.setBounds(100,295,150,40);

        firstNameField.setBounds(225,100, 160, 30);
        lastNameField.setBounds(225,150, 160, 30);
        emailFiled.setBounds(225,200, 160, 30);
        passwordField.setBounds(225,250, 160, 30);
        confirmPassField.setBounds(225,300, 160, 30);

        backBtn.setBounds(250,360,90,30);
        registerBtn.setBounds(160,360,90,30);

        dot1 = createDots();
        dot2 = createDots();

        dot1.setBounds(80, 250,160,30);
        dot2.setBounds(80, 300,160,30);

        successPassLabel.setFont(new Font("Courier", Font.PLAIN, 14));
        successPassLabel.setForeground(Color.green);
        successPassLabel.setBounds(195 , 330 , 160,30);
        successPassLabel.setVisible(false);

        incorrectPassLabel.setFont(new Font("Courier", Font.PLAIN, 14));
        incorrectPassLabel.setForeground(Color.red);
        incorrectPassLabel.setBounds(160 , 330 , 220,30);
        incorrectPassLabel.setVisible(false);

         add(firstName);
         add(lastName);
         add(email);
         add(pass);
         add(passCon);

         add(firstNameField);
         add(lastNameField);
         add(passwordField);
         add(confirmPassField);
         add(emailFiled);
         add(dot1);
         add(dot2);
         add(successPassLabel);
         add(incorrectPassLabel);

         add(backBtn);
         add(registerBtn);

        return panel;
    }
    public JLabel createLabel(String title)
    {
        JLabel label = new JLabel(title);
        label.setFont(new Font("Courier", Font.PLAIN , 12));
        return label;
    }
    public JPanel createNorthSouth()
    {
        JPanel panel = new JPanel();
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(500,50));
        panel.setBackground(Color.lightGray);
        panel.setVisible(true);

        return panel;

    }
    public JPanel createLeftRight()
    {
        JPanel panel = new JPanel();
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(50,500));
        panel.setBackground(Color.lightGray);
        panel.setVisible(true);

        return panel;

    }
    public void clearFields()
    {
        firstNameField.setText("");
        lastNameField.setText("");
        passwordField.setText("");
        confirmPassField.setText("");
        emailFiled.setText("");
    }
    public JLabel createDots()
    {
        JLabel dot = new JLabel("*");
        dot.setForeground(Color.red);
        dot.setFont(new Font("Courier" , Font.PLAIN, 12));
        dot.setVisible(false);

        return dot;
    }
    public void passCheck(boolean check)
    {
        dot1.setVisible(check);
        dot2.setVisible(check);
        passwordField.setText("");
        confirmPassField.setText("");
        incorrectPassLabel.setVisible(check);
    }
    /**
     *
     *   ********************* GETTER AND SETTERS *********************
     */

    public JTextField getFirstNameField() {
        return firstNameField;
    }

    public void setFirstNameField(JTextField firstNameField) {
        this.firstNameField = firstNameField;
    }

    public JTextField getLastNameField() {
        return lastNameField;
    }

    public void setLastNameField(JTextField lastNameField) {
        this.lastNameField = lastNameField;
    }

    public JTextField getEmailFiled() {
        return emailFiled;
    }

    public void setEmailFiled(JTextField emailFiled) {
        this.emailFiled = emailFiled;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JPasswordField getConfirmPassField() {
        return confirmPassField;
    }

    public void setConfirmPassField(JPasswordField confirmPassField) {
        this.confirmPassField = confirmPassField;
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(JButton backBtn) {
        this.backBtn = backBtn;
    }

    public JButton getRegisterBtn() {
        return registerBtn;
    }

    public void setRegisterBtn(JButton registerBtn) {
        this.registerBtn = registerBtn;
    }

    public JLabel getDot1() {
        return dot1;
    }

    public void setDot1(JLabel dot1) {
        this.dot1 = dot1;
    }

    public JLabel getDot2() {
        return dot2;
    }

    public void setDot2(JLabel dot2) {
        this.dot2 = dot2;
    }

    public JLabel getIncorrectPassLabel() {
        return incorrectPassLabel;
    }

    public void setIncorrectPassLabel(JLabel incorrectPassLabel) {
        this.incorrectPassLabel = incorrectPassLabel;
    }

    public JLabel getSuccessPassLabel() {
        return successPassLabel;
    }

    public void setSuccessPassLabel(JLabel successPassLabel) {
        this.successPassLabel = successPassLabel;
    }
}
