package GuiComponents;

import GuiComponents.CompletedPanel;
import GuiComponents.HomePanel;
import GuiComponents.TicketPanel;

import javax.swing.*;
import java.awt.*;


public class MiddlePanel extends JPanel {

    private HomePanel homePanel= new HomePanel();
    private TicketPanel ticketPanel = new TicketPanel();
    private CompletedPanel completedPanel = new CompletedPanel();
    private CardLayout cardLayout = new CardLayout();

    public MiddlePanel()
    {


        this.setLayout(cardLayout);
        this.setSize(500,500);
        this.setBackground(Color.darkGray);
        this.add("1" , homePanel);
        this.add("2" , ticketPanel.getScrollPane());
        this.add("3" , completedPanel.getScrollPane());
        cardLayout.show(this , "1");
        this.setVisible(true);

    }

    public CompletedPanel getCompletedPanel() {
        return completedPanel;
    }

    public void setCompletedPanel(CompletedPanel completedPanel) {
        this.completedPanel = completedPanel;
    }

    public HomePanel getHomePanel() {
        return homePanel;
    }

    public void setHomePanel(HomePanel homePanel) {
        this.homePanel = homePanel;
    }

    public TicketPanel getTicketPanel() {
        return ticketPanel;
    }

    public void setTicketPanel(TicketPanel ticketPanel) {
        this.ticketPanel = ticketPanel;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

}
