package GuiComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private JButton addBtn = new JButton("Add");
    private JButton clearBtn = new JButton("Clear");
    private ActionListener actionListener;

    public ButtonPanel()
    {
        this.add(addBtn);
        this.add(clearBtn);
        this.setPreferredSize(new Dimension(800 , 100));
        this.setBackground(Color.lightGray);
        this.setVisible(true);
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public void setAddBtn(JButton addBtn) {
        this.addBtn = addBtn;
    }

    public JButton getClearBtn() {
        return clearBtn;
    }

    public void setClearBtn(JButton clearBtn) {
        this.clearBtn = clearBtn;
    }

    public ActionListener getActionListener() {
        return actionListener;
    }

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }
}
