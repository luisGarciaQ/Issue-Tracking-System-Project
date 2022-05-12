package GuiComponents;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {


    private JButton listBtn = new JButton("Ticket List");
    private JButton completedBtn = new JButton("Completed");
    private JButton homeBtn = new JButton("Home");
    private JLabel menu = new JLabel("MENU");

    public LeftPanel() {

        homeBtn.setFocusPainted(false);
        homeBtn.setBorderPainted(false);
        homeBtn.setContentAreaFilled(false);
        homeBtn.setPreferredSize(new Dimension(145,50));
        homeBtn.setBackground(Color.darkGray);
        homeBtn.setForeground(Color.WHITE);
        homeBtn.setOpaque(true);


        listBtn.setFocusPainted(false);
        listBtn.setBorderPainted(false);
        listBtn.setContentAreaFilled(false);
        listBtn.setPreferredSize(new Dimension(145,50));
        listBtn.setBackground(Color.darkGray);
        listBtn.setForeground(Color.white);
        listBtn.setOpaque(true);

        completedBtn.setFocusPainted(false);
        completedBtn.setBorderPainted(false);
        completedBtn.setContentAreaFilled(false);
        completedBtn.setPreferredSize(new Dimension(145,50));
        completedBtn.setBackground(Color.darkGray);
        completedBtn.setForeground(Color.white);
        completedBtn.setOpaque(true);

        this.setPreferredSize(new Dimension(145 , 800));
        this.setLayout(new FlowLayout());
        this.setBackground(Color.lightGray);
        this.add(menu);
        this.add(homeBtn);
        this.add(listBtn);
        this.add(completedBtn);
        this.setVisible(true);
    }

    public JButton getHomeBtn() {
        return homeBtn;
    }

    public void setHomeBtn(JButton homeBtn) {
        this.homeBtn = homeBtn;
    }

    public JButton getListBtn() {
        return listBtn;
    }

    public void setListBtn(JButton listBtn) {
        this.listBtn = listBtn;
    }

    public JButton getCompletedBtn() {
        return completedBtn;
    }

    public void setCompletedBtn(JButton completedBtn) {
        this.completedBtn = completedBtn;
    }

    public JLabel getMenu() {
        return menu;
    }

    public void setMenu(JLabel menu) {
        this.menu = menu;
    }
}
