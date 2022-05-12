package GuiComponents;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class individualTicket extends JPanel {

    private Border border = BorderFactory.createLineBorder(Color.black , 2);
    private JPanel innerPanel = new JPanel();
    private JTextField id = new JTextField();
    private JTextField title = new JTextField("This is a test title");
    private JTextField date = new JTextField();
    private JTextField owner = new JTextField();
    private JTextArea description = new JTextArea();
    private JButton completeBtn = new JButton("Complete");
    private JButton deleteBtn = new JButton("Delete");
    private JButton removeBtn = new JButton("Remove");
    private JScrollPane scroll = new JScrollPane(description , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    private JLabel ownerLabel = new JLabel("Assigned to: ");

    public individualTicket()
    {
        this.setBorder(border);
        this.setBackground(Color.lightGray);
        this.setPreferredSize(new Dimension(745, 200));
        this.setMaximumSize(new Dimension(745, 200));
        this.setLayout(new FlowLayout());
        this.setVisible(true);

        innerPanel.setPreferredSize(new Dimension(710 , 180));
        innerPanel.setBackground(Color.lightGray);
        innerPanel.setLayout(null);
        innerPanel.setVisible(true);

        completeBtn.setBounds(555 ,55, 100,35);

        deleteBtn.setBounds(555 ,95, 100,35);

        removeBtn.setBounds(555 ,75, 100,35);

        date.setFont(new Font("Courier", Font.PLAIN, 12));
        date.setBounds(600 , 0 , 100 , 30);
        date.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        date.setBackground(null);
        date.setEditable(false);

        id.setFont(new Font("Courier", Font.PLAIN, 10));
        id.setBounds(5 , 0 , 100 , 30);
        id.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        id.setBackground(null);
        id.setEditable(false);

        title.setPreferredSize(new Dimension(120 , 30));
        title.setFont(new Font("Courier", Font.PLAIN, 20));
        title.setBounds(35 , 10 , 200 , 30);
        title.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        title.setBackground(null);
        title.setEditable(false);

        scroll.setPreferredSize(new Dimension(450 , 200));
        scroll.setFont(new Font("Courier" , Font.PLAIN , 15));
        scroll.setBounds(35,45, 500  , 100);
        description.setEditable(false);
        description.setLineWrap(false);

        owner.setFont(new Font("Courier", Font.PLAIN, 12));
        owner.setBounds(555 , 145 , 150 , 40);
        owner.setBorder(BorderFactory.createLineBorder(Color.white, 0));
        owner.setBackground(null);
        owner.setEditable(false);

        ownerLabel.setForeground(Color.black);
        ownerLabel.setBounds(460, 145, 100 , 40);
        ownerLabel.setFont(new Font("Courier" , Font.PLAIN , 12));

        innerPanel.add(title);
        innerPanel.add(scroll);
        innerPanel.add(date);
        innerPanel.add(completeBtn);
        innerPanel.add(deleteBtn);
        innerPanel.add(owner);
        innerPanel.add(id);
        innerPanel.add(ownerLabel);

        this.add(innerPanel,BorderLayout.CENTER);

    }
// ********************* GETTERS & SETTERS  *********************


    public JButton getRemoveBtn() {
        return removeBtn;
    }

    public void setRemoveBtn(JButton removeBtn) {
        this.removeBtn = removeBtn;
    }

    public JLabel getOwnerLabel() {
        return ownerLabel;
    }

    public void setOwnerLabel(JLabel ownerLabel) {
        this.ownerLabel = ownerLabel;
    }

    public JPanel getInnerPanel() {
        return innerPanel;
    }

    public void setInnerPanel(JPanel innerPanel) {
        this.innerPanel = innerPanel;
    }

    public JTextField getId() {
        return id;
    }

    public void setId(JTextField id) {
        this.id = id;
    }

    public JTextField getTitle() {
        return title;
    }

    public void setTitle(JTextField title) {
        this.title = title;
    }

    public JTextField getDate() {
        return date;
    }

    public void setDate(JTextField date) {
        this.date = date;
    }

    public JTextField getOwner() {
        return owner;
    }

    public void setOwner(JTextField owner) {
        this.owner = owner;
    }

    public JTextArea getDescription() {
        return description;
    }

    public void setDescription(JTextArea description) {
        this.description = description;
    }

    public JButton getCompleteBtn() {
        return completeBtn;
    }

    public void setCompleteBtn(JButton completeBtn) {
        this.completeBtn = completeBtn;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JButton getDeleteBtn() {
        return deleteBtn;
    }

    public void setDeleteBtn(JButton deleteBtn) {
        this.deleteBtn = deleteBtn;
    }

    @Override
    public Border getBorder() {
        return border;
    }

    @Override
    public void setBorder(Border border) {
        this.border = border;
    }

}
