package GuiComponents;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class HomePanel extends JPanel {


    private JTextField TitleField = new JTextField();
    private JTextField dateField = new JTextField();
    private JTextField ownerField = new JTextField();
    private JTextArea descriptionArea = new JTextArea();
    private JLabel title = new JLabel("Title:");
    private JLabel date = new JLabel("Date:");
    private JLabel owner = new JLabel("Owner:");
    private JLabel Description = new JLabel("Description:");


    public HomePanel()
    {
        Description.setBounds(260, 280, 200 , 40);
        Description.setFont(new Font("Courier" , Font.PLAIN , 25));
        Description.setForeground(Color.white);

        title.setForeground(Color.white);
        title.setBounds(100, 35, 100 , 40);
        title.setFont(new Font("Courier" , Font.PLAIN , 25));

        date.setForeground(Color.white);
        date.setBounds(100, 115, 100 , 40);
        date.setFont(new Font("Courier" , Font.PLAIN , 25));

        owner.setForeground(Color.white);
        owner.setBounds(100, 195, 100 , 40);
        owner.setFont(new Font("Courier" , Font.PLAIN , 25));

        TitleField.setBounds(210 , 41 , 250 , 30);

        dateField.setBounds(210 , 121 , 250 , 30);

        ownerField.setBounds(210 , 201 , 250 , 30);

        descriptionArea.setBounds(150 , 330 , 400 , 150);
        descriptionArea.setLineWrap(true);



        this.add(title);
        this.add(TitleField);
        this.add(date);
        this.add(dateField);
        this.add(owner);
        this.add(ownerField);
        this.add(Description);
        this.add(descriptionArea);
        this.setPreferredSize(new Dimension(500 ,500));
        this.setLayout(null);
        this.setBackground(Color.darkGray);
        this.setVisible(true);
    }


    public JTextField getTitleField() {
        return TitleField;
    }

    public void setTitleField(JTextField titleField) {
        TitleField = titleField;
    }

    public JTextField getDateField() {
        return dateField;
    }

    public void setDateField(JTextField dateField) {
        this.dateField = dateField;
    }

    public JTextField getOwnerField() {
        return ownerField;
    }

    public void setOwnerField(JTextField ownerField) {
        this.ownerField = ownerField;
    }

    public JTextArea getDescriptionArea() {
        return descriptionArea;
    }

    public void setDescriptionArea(JTextArea descriptionArea) {
        this.descriptionArea = descriptionArea;
    }

    public JLabel getTitle() {
        return title;
    }

    public void setTitle(JLabel title) {
        this.title = title;
    }

    public JLabel getDate() {
        return date;
    }

    public void setDate(JLabel date) {
        this.date = date;
    }

    public JLabel getOwner() {
        return owner;
    }

    public void setOwner(JLabel owner) {
        this.owner = owner;
    }

    public JLabel getDescription() {
        return Description;
    }

    public void setDescription(JLabel description) {
        Description = description;
    }
}
