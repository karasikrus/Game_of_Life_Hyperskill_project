package life;

import javax.swing.*;
import java.awt.*;


public class DrawField extends JComponent {
    private Color color = Color.black;
    private int x = 30;
    private int y = 30;
    private int width = 10;
    private int height = 10;
    private boolean[][] field;

    public void setField(boolean[][] field) {
        this.field = field;
    }

    public DrawField(boolean[][] field) {
        this.field = field;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void paint(Graphics g) {
        g.setColor(color);
       // g.fillRect(x, y, width, height);
       // g.drawRect(x+10,y+10,width,height);
        for(int i = 0; i< field.length; i++){
            for (int j = 0; j< field.length; j++){
                if (field[i][j]){
                    g.fillRect(x+i*width, y+j*height, width+1,height+1);
                } else{
                    g.drawRect(x+i*width, y+j*height, width,height);
                }
            }
        }
    }
}