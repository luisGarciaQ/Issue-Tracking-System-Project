package IssueTrackerApp;

import GuiComponents.individualTicket;
import Login.LoginFrame;
import Login.Profile;

import java.net.PortUnreachableException;
import java.sql.*;

public class CreateConnection {


    private Connection connection = null;
    public static ResultSet resultSet;

    // CREATING CONNECTION TO MYSQL
    public CreateConnection() throws SQLException {
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TicketSystem", "root", "123456789");
        }catch (Exception e){e.printStackTrace();}
    }
    // DELETING RECORDS OFF OF TICKETS TABLE
    public  void deleteRecordActive(int id) throws SQLException {
        try
        {
            CallableStatement myStmt = connection.prepareCall("{call delete_data_active(?)}");
            myStmt.setInt(1 , id);
            myStmt.execute();
        }catch (Exception e){e.printStackTrace();}

    }

    public  void deleteRecordCompleted(int id) throws SQLException {
        try
        {
            CallableStatement myStmt = connection.prepareCall("{call delete_data_completed(?)}");
            myStmt.setInt(1 , id);
            myStmt.execute();
        }catch (Exception e){e.printStackTrace();}

    }
    // ADDING RECORD TO THE TICKETS TABLE
    public void addRecordsActive(String title, String date, String owner ,String description) throws SQLException
    {
        try
        {
            CallableStatement myStmt = connection.prepareCall("{call add_record_active(?,?,?,?)}");

            myStmt.setString(1 , title);
            myStmt.setString(2 , date);
            myStmt.setString(3 , owner);
            myStmt.setString(4 , description);
            myStmt.execute();
        }catch (Exception e){e.printStackTrace();}
        System.out.println("Record has been added to the Active table");
    }

    public void activeToCompleted(int ID, String completedBy) throws SQLException {
        CallableStatement myStmt = connection.prepareCall("{call active_to_completed(?,?)}");
        myStmt.setInt(1 ,ID);
        myStmt.setString(2, completedBy);
        myStmt.execute();
        System.out.println("Ticket ID: " + ID + " has been completed and transferred to Completed table");
    }

    public void addRecordProfile(Profile aProfile) throws SQLException
    {
        try
        {
            CallableStatement myStmt = connection.prepareCall("{call add_record_profile(?,?,?,?,?,?)}");

            myStmt.setInt(1 , aProfile.getId());
            myStmt.setString(2 , aProfile.getFirstName());
            myStmt.setString(3 , aProfile.getLastName());
            myStmt.setString(4 , aProfile.getEmail());
            myStmt.setString(5 , aProfile.getPassword());
            myStmt.setString(6 , aProfile.getUsername());
            myStmt.execute();
        }catch (Exception e){e.printStackTrace();}
        System.out.println("Record has been added to the Profile table");
    }

    public  void appUpdateActive(LoginFrame login) throws SQLException {
        try {
            Statement statement = connection.createStatement();
            // QUERY REQUESTING INFO FROM TABLE AND UPDATING IT
            ResultSet resultSet = statement.executeQuery("SELECT * FROM TicketSystem.Active");
            while (resultSet.next()) {

                TheTicket ticket = new TheTicket(resultSet.getInt("ID"), resultSet.getString("Title"), resultSet.getString("Date"), resultSet.getString("Owner"),resultSet.getString("Description"));
                login.getApp().getListOfTickets().add(ticket);
                login.getApp().addTicket(ticket);
            }
        }catch(Exception e){e.printStackTrace();}
    }

    public  void appUpdateCompleted(LoginFrame login) throws SQLException
    {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM TicketSystem.Completed");
        while (resultSet.next()) {
            individualTicket ticketNew = new individualTicket();
            ticketNew.getId().setText(Integer.toString(resultSet.getInt("ID")));
            ticketNew.getTitle().setText(resultSet.getString("Title"));
            String completedBy = resultSet.getString("CompBy");
            ticketNew.getDescription().setText(resultSet.getString("Description"));
            login.getApp().addingCompletedTicket(ticketNew, completedBy);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public static ResultSet getResultSet() {
        return resultSet;
    }

    public static void setResultSet(ResultSet resultSet) {
        CreateConnection.resultSet = resultSet;
    }
}
