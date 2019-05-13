package life;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseButton extends JButton {
    private String pause = "Pause";
    private String unpause = "Unpause";
    private volatile boolean isPaused = false;

    public PauseButton() {
        setText(pause);
        addActionListener(pauseListener);
    }

    ActionListener pauseListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            isPaused = !isPaused;
            if(isPaused) {
                setText(unpause);
            } else{
                setText(pause);
            }

        }
    };

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }
}
