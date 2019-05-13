package life;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StateGenerator stateGenerator = new StateGenerator();
        //--------gui

        JFrame frame = new JFrame("FrameDemo"); // создаём главное окно приложения
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // чтобы процесс завершался после закрытия окна
        JButton button1 = new JButton("Button 1");
        button1.setBounds(0,0,100,70);// создаём кнопку
        //frame.add(button1); // добавляем кнопку на окно

       // frame.pack(); // автоматически настраиваем размер окна под содержимое
        frame.setSize(400, 500);
        frame.setVisible(true);// отображаем окно
        ////


        int n_lines = scanner.nextInt();
        //long s_seed = scanner.nextLong();
        //int m_number = scanner.nextInt();
        int m_number = 10;
        FieldState field = new FieldState(n_lines);
        DrawField drawField = new DrawField(field.getField());
        //field.print();
        //System.out.println("-------------next generation----------");
        for(int i =0; i <= m_number; i++){
            try {
                if (System.getProperty("os.name").contains("Windows"))
                    new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
                else
                    Runtime.getRuntime().exec("clear");
            }
            catch (IOException | InterruptedException e) {}
            System.out.println("Generation #"+ (i+1));
            System.out.println("Alive: "+ (field.getAliveAmount()));
            field.print();
            boolean[][] drawableField = field.getField();
            frame.setSize(100+5*drawableField.length, 100+5*drawableField.length);
            //frame.setSize(400, 500);
            frame.add(drawField);
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
