package life;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class GameOfLife {

    public GameOfLife() {
    }
    public void run(){
        Scanner scanner = new Scanner(System.in);
        StateGenerator stateGenerator = new StateGenerator();
        //--------gui

        JFrame frame = new JFrame("Game of Life"); // создаём главное окно приложения
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // чтобы процесс завершался после закрытия окна
        // JButton button1 = new JButton("Button 1");
        // button1.setBounds(0,0,100,70);// создаём кнопку
        //frame.add(button1); // добавляем кнопку на окно

        // frame.pack(); // автоматически настраиваем размер окна под содержимое
        //frame.setSize(400, 500);
        //frame.setVisible(true);// отображаем окно
        ////


        int n_lines = scanner.nextInt();
        //long s_seed = scanner.nextLong();
        //int m_number = scanner.nextInt();
        int m_number = 10;
        FieldState field = new FieldState(n_lines);
        DrawField drawField = new DrawField(field.getField());
        JLabel generationLabel = new JLabel();
        JLabel aliveAmountLabel = new JLabel();
        JPanel textInfo = new JPanel();
        //field.print();
        //System.out.println("-------------next generation----------");
        for(int i =0; i <= m_number; i++){
            /*try {
                if (System.getProperty("os.name").contains("Windows"))
                    new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
                else
                    Runtime.getRuntime().exec("clear");
            }
            catch (IOException | InterruptedException e) {}
            */
            String generationNumber = "Generation #"+ (i+1);
            String aliveAmount = "Alive: "+ (field.getAliveAmount());
            // System.out.println(generationNumber);
            // System.out.println(aliveAmount);
            // field.print();
            boolean[][] drawableField = field.getField();
            frame.setSize(100+10*drawableField.length, 100+10*drawableField.length);
            //frame.setSize(400, 500);
            frame.revalidate();
            generationLabel.setText(generationNumber);
            aliveAmountLabel.setText(aliveAmount);
            textInfo.add(generationLabel, BorderLayout.NORTH);
            textInfo.add(aliveAmountLabel, BorderLayout.AFTER_LAST_LINE);
            textInfo.repaint();
            frame.add(textInfo, BorderLayout.NORTH);
            frame.add(drawField);
            frame.repaint();
            frame.setVisible(true);
            field = stateGenerator.generateNextState(field);
            drawField.setField(field.getField());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
