package life;

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
        for(int i =0; i < m_number; i++){
            field = stateGenerator.generateNextState(field);
        }
        field.print();
    }
}
