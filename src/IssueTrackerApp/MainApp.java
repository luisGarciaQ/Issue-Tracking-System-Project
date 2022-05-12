package IssueTrackerApp;

import GuiComponents.FrameApp;
import GuiComponents.individualTicket;
import Login.LoginFrame;
import Login.Profile;
import Login.RegistrationFrame;

import java.sql.*;

public class MainApp {
 // ****************** DATABASE INFORMATION ******************

    public static CreateConnection conn;
    public static LoginFrame loginFrame;

    public static void main(String[] args) throws SQLException {

        loginFrame = new LoginFrame();
        conn = new CreateConnection();
        loginUpdateProfiles();

    }

    public static void loginUpdateProfiles() throws SQLException
    {
        Statement statement = conn.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM TicketSystem.Profiles");
        while (resultSet.next()) {

            Profile aProfile = new Profile(resultSet.getString("FirstName"),
                    resultSet.getString("LastName"),
                    resultSet.getString("Email"),
                    resultSet.getString("Password"),
                    resultSet.getInt("IDProfiles"));
                    aProfile.setUsername(resultSet.getString("Username"));

            System.out.println(aProfile.toString());

            loginFrame.getMyProfileList().add(aProfile);
        }
    }

}
