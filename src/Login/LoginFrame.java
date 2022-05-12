package Login;
import GuiComponents.FrameApp;
import IssueTrackerApp.CreateConnection;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class LoginFrame extends JFrame implements ActionListener
{
    private LoginPanel panel = new LoginPanel();
    private RegistrationFrame registration = new RegistrationFrame();
    private ArrayList<Profile> myProfileList = new ArrayList<Profile>();
    private CreateConnection conn;
    private FrameApp app;


    public LoginFrame() {
        this.setSize(500,300);
        this.setTitle("Welcome");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(panel);
        this.setVisible(true);

        registration.getRegisterBtn().addActionListener(this);
        registration.getBackBtn().addActionListener(this);
        panel.getLoginBtn().addActionListener(this);
        panel.getSignIn().addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registration.getRegisterBtn())
        {
            try {
                registerNewProfile();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("registration has been clicked");
        }
        else if(e.getSource() == registration.getBackBtn())
        {
            registration.setVisible(false);
            this.setVisible(true);
        }
        else if(e.getSource() == panel.getLoginBtn())
        {
            try {
                loginAttempt();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else if(e.getSource() == panel.getSignIn())
        {
            registration.setVisible(true);
            this.setVisible(false);
        }
    }

    public void registerNewProfile() throws SQLException {
        CreateConnection conn = new CreateConnection();
        Random random = new Random();
        Profile aProfile;
        char[] x = registration.getConfirmPassField().getPassword();
        char[] y = registration.getPasswordField().getPassword();
        String pass = new String(x);
        String passCon = new String(y);

        if(pass.equals(passCon))
        {
            aProfile = new Profile(registration.getFirstNameField().getText(),
                                    registration.getLastNameField().getText(),
                                       registration.getEmailFiled().getText(),
                                                                        pass,
                                     random.nextInt(1000, 9999));

                registration.passCheck(false);
                registration.getSuccessPassLabel().setVisible(true);
                myProfileList.add(aProfile);
                conn.addRecordProfile(aProfile);
                registration.clearFields();

                JOptionPane.showMessageDialog(this, "Username: " + aProfile.getUsername() + "\n " + "id: " + aProfile.getId());

        }
        else
        {
            registration.passCheck(true);
            registration.getSuccessPassLabel().setVisible(false);
        }

    }

    public void loginAttempt() throws SQLException {
        char[] x = panel.getPasswordField().getPassword();
        String pass = new String(x);
        conn = new CreateConnection();

        for(int j = 0 ; j < myProfileList.size() ; j++)
        {
            if (myProfileList.get(j).getUsername().equals(panel.getaUsernameField().getText()))
            {
                accessApp(myProfileList.get(j) , pass);
                break;
            }
            else
            {
                panel.invalidLogin();
            }
        }

    }

    public void accessApp(Profile aProfile , String pass) throws SQLException
    {
        System.out.println("Logged in using: " + aProfile.getId());
            if(aProfile.getPassword().equals(pass))
            {
                app = new FrameApp();
                conn.appUpdateActive(this);
                conn.appUpdateCompleted(this);
                this.setVisible(false);
            }
            else
            {
                panel.invalidLogin();
            }
    }


    /**
     * ************** GETTERS AND SETTERS **************
     */
    public ArrayList<Profile> getMyProfileList() {
        return myProfileList;
    }

    public void setMyProfileList(ArrayList<Profile> myProfileList) {
        this.myProfileList = myProfileList;
    }

    public FrameApp getApp() {
        return app;
    }

    public void setApp(FrameApp app) {
        this.app = app;
    }
}
