package GuiComponents;

import IssueTrackerApp.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class  FrameApp extends JFrame implements ActionListener {

    private JPanel topPanel = new JPanel();
    private LeftPanel leftPanel = new LeftPanel();
    private JLabel nameApp = new JLabel("Issue Tracker");
    private BorderLayout border = new BorderLayout(10 ,10);
    private MiddlePanel middlepanel = new MiddlePanel();
    private ButtonPanel buttonPanel = new ButtonPanel();
    private TheTicket theTicket = new TheTicket();
    private ArrayList<TheTicket> listOfTickets = new ArrayList<>();
    private CreateConnection conn = new CreateConnection();
    private Statement statement = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);


    public FrameApp() throws SQLException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900,1000);
        this.setVisible(true);

        nameApp.setForeground(Color.BLACK);
        nameApp.setBounds(300,0,250,100);
        nameApp.setFont(new Font("Courier" , Font.PLAIN , 30));


        topPanel.setPreferredSize(new Dimension(800 , 100));
        topPanel.setBackground(Color.lightGray);
        topPanel.add(nameApp);
        topPanel.setLayout(null);
        topPanel.setVisible(true);


        leftPanel.getCompletedBtn().addActionListener(this);
        leftPanel.getListBtn().addActionListener(this);
        leftPanel.getHomeBtn().addActionListener(this);
        buttonPanel.getAddBtn().addActionListener(this);
        buttonPanel.getClearBtn().addActionListener(this);



        this.setLayout(border);
        this.add(buttonPanel , BorderLayout.SOUTH);
        this.add(middlepanel , BorderLayout.CENTER);
        this.add(leftPanel , BorderLayout.WEST);
        this.add(topPanel, BorderLayout.NORTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == leftPanel.getListBtn())
        {
            middlepanel.getCardLayout().show(middlepanel , "2");
        }
        else if(e.getSource() == buttonPanel.getAddBtn())
        {
            theTicket.setTitle(middlepanel.getHomePanel().getTitleField().getText());
            theTicket.setDate(middlepanel.getHomePanel().getDateField().getText());
            theTicket.setOwner(middlepanel.getHomePanel().getOwnerField().getText());
            theTicket.setDescription(middlepanel.getHomePanel().getDescriptionArea().getText());
            addTicket(updatingActiveTicket(theTicket));
        }
        else if(e.getSource() == leftPanel.getHomeBtn())
        {
            middlepanel.getCardLayout().show(middlepanel,"1");

        }
        else if(e.getSource() == buttonPanel.getClearBtn())
        {
            middlepanel.getHomePanel().getTitleField().setText("");
            middlepanel.getHomePanel().getDateField().setText("");
            middlepanel.getHomePanel().getOwnerField().setText("");
            middlepanel.getHomePanel().getDescriptionArea().setText("");
        }
        else if(e.getSource() == leftPanel.getCompletedBtn())
        {
            middlepanel.getCardLayout().show(middlepanel, "3");
        }


    }

    // ****************** METHODS ******************

    public void addTicket(TheTicket ticket)
    {
        System.out.println("*** Ticket Added ***");
        individualTicket ticketNew = new individualTicket();

        System.out.println("This is the ID of ticket: " + ticket.getID());
        ticketNew.getTitle().setText(ticket.getTitle());
        ticketNew.getDate().setText(ticket.getDate());     // ADDING THE TEXT INFORMATION TO THE INDIVIDUAL TICKET
        ticketNew.getOwner().setText(ticket.getOwner());
        ticketNew.getDescription().setText(ticket.getDescription());
        ticketNew.getId().setText(Integer.toString(ticket.getID()));

        listOfTickets.add(ticket);

        middlepanel.getTicketPanel().add(ticketNew);

        middlepanel.getHomePanel().getTitleField().setText("");
        middlepanel.getHomePanel().getDateField().setText("");
        middlepanel.getHomePanel().getOwnerField().setText("");
        middlepanel.getHomePanel().getDescriptionArea().setText("");

        ticketNew.getCompleteBtn().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == ticketNew.getCompleteBtn())
                {
                    String completedBy = middlepanel.getCompletedPanel().createField();
                    addingCompletedTicket(ticketNew, completedBy);
                    try{
                        System.out.println(ticket.getID());
                        conn.activeToCompleted(ticket.getID(), completedBy); // record deleted according to the ticket ID
                        conn.deleteRecordActive(ticket.getID());
                        System.out.println("Record transferred to completed ticket table under ID#: " + ticket.getID());
                    }catch (Exception f){f.printStackTrace();}
                }
            }
        });

        ticketNew.getDeleteBtn().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource() == ticketNew.getDeleteBtn())
                {
                    middlepanel.getTicketPanel().remove(ticketNew);
                    middlepanel.getTicketPanel().repaint();
                    middlepanel.getTicketPanel().revalidate();
                    try{
                        conn.deleteRecordActive(ticket.getID()); // record deleted according to the ticket ID
                        System.out.println("Record has been deleted from Active talbe ID#: " + ticket.getID());
                    }catch (Exception f){f.printStackTrace();}

                }
            }
        });
    }

    /**
     *      This method receives a ticket object, it adds it to the active table in
     *      Mysql, gets the ID generated in Mysql and updates the ticket's ID number.
     *
     * @param ticket
     * @return ticket with its ticket ID
     */

    public TheTicket updatingActiveTicket(TheTicket ticket)
    {
        System.out.println("*** New Record Added ***");
        try
        {
            conn.addRecordsActive(ticket.getTitle(), ticket.getDate(),ticket.getOwner(), ticket.getDescription());
            ResultSet rs = statement.executeQuery("SELECT * FROM TicketSystem.Active");
            rs.last();
            ticket.setID(rs.getInt("ID"));
        }catch (Exception e){e.printStackTrace();}
        return ticket;
    }

    /**
     *  *********** ADD PERTINENT NOTES **************
     * @param ticketNew
     */
    public void addingCompletedTicket(individualTicket ticketNew, String completedBy)
    {
        middlepanel.getCompletedPanel().add(ticketNew);
        ticketNew.getInnerPanel().remove(ticketNew.getCompleteBtn());
        ticketNew.getInnerPanel().remove(ticketNew.getDeleteBtn());
        ticketNew.getInnerPanel().add(ticketNew.getRemoveBtn());
        ticketNew.getInnerPanel().add(middlepanel.getCompletedPanel().getCompletedBy());
        ticketNew.getOwner().setText(completedBy);
        ticketNew.getOwnerLabel().setText("Completed by: ");
        middlepanel.getTicketPanel().repaint();
        middlepanel.getTicketPanel().revalidate();

        ticketNew.getRemoveBtn().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource() == ticketNew.getRemoveBtn())
                {
                    System.out.println("Remove has been clicked");
                    middlepanel.getCompletedPanel().remove(ticketNew);
                    middlepanel.getCompletedPanel().repaint();
                    middlepanel.getCompletedPanel().revalidate();
                    try{
                        conn.deleteRecordCompleted(Integer.parseInt(ticketNew.getId().getText())); // record deleted according to the ticket ID
                        System.out.println("Record has been deleted from Completed talbe ID#: " + ticketNew.getId().getText());
                    }catch (Exception f){f.printStackTrace();}

                }
            }
        });

    }


    // ****************** GETTERS AND SETTERS ******************+


    public JPanel getTopPanel() {
        return topPanel;
    }

    public void setTopPanel(JPanel topPanel) {
        this.topPanel = topPanel;
    }

    public JPanel getLeftPanel() {
        return leftPanel;
    }

    public void setLeftPanel(LeftPanel leftPanel) {
        this.leftPanel = leftPanel;
    }

    public JLabel getNameApp() {
        return nameApp;
    }

    public void setNameApp(JLabel nameApp) {
        this.nameApp = nameApp;
    }

    public BorderLayout getBorder() {
        return border;
    }

    public void setBorder(BorderLayout border) {
        this.border = border;
    }

    public ButtonPanel getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(ButtonPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    public CreateConnection getConn() {
        return conn;
    }

    public void setConn(CreateConnection conn) {
        this.conn = conn;
    }

    public MiddlePanel getMiddlepanel() {
        return middlepanel;
    }

    public void setMiddlepanel(MiddlePanel middlepanel) {
        this.middlepanel = middlepanel;
    }

    public TheTicket getTheTicket() {
        return theTicket;
    }

    public void setTheTicket(TheTicket theTicket) {
        this.theTicket = theTicket;
    }

    public ArrayList<TheTicket> getListOfTickets() {
        return listOfTickets;
    }

    public void setListOfTickets(ArrayList<TheTicket> listOfTickets) {
        this.listOfTickets = listOfTickets;
    }
}
