package GuiComponents;

import javax.swing.*;
import java.awt.*;

public class CompletedPanel extends JPanel {

    private JScrollPane scrollPane = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    private JLabel completedBy = new JLabel();
    private JTextField completedByField = new JTextField();

    public CompletedPanel()
    {

        scrollPane.setSize(500, 150);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBackground(Color.darkGray);
        this.setVisible(true);
    }

    public String createField()
    {
        String response = JOptionPane.showInputDialog(null , "Completed by: ");
        return response;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JLabel getCompletedBy() {
        return completedBy;
    }

    public void setCompletedBy(JLabel completedBy) {
        this.completedBy = completedBy;
    }

    public JTextField getCompletedByField() {
        return completedByField;
    }

    public void setCompletedByField(JTextField completedByField) {
        this.completedByField = completedByField;
    }
}
