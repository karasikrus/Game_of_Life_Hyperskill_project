package life;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButton extends JButton {
    private volatile boolean isReset = false;

    public ResetButton() {
        addActionListener(resetListener);
        setText("Reset");
    }

    public boolean isReset() {
        return isReset;
    }

    public void setReset(boolean reset) {
        isReset = reset;
    }

    ActionListener resetListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            isReset = !isReset;
        }
    };
}
