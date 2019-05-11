package life;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StateGenerator stateGenerator = new StateGenerator();


        int n_lines = scanner.nextInt();
        long s_seed = scanner.nextLong();
        int m_number = scanner.nextInt();
        FieldState field = new FieldState(n_lines, s_seed);
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
            field = stateGenerator.generateNextState(field);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
