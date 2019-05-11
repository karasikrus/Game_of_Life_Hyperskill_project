package life;

import java.util.Random;

public class FieldState {

    private boolean field[][];

    public FieldState(boolean[][] field) {
        this.field = field;
    }

    public FieldState(int n_lines, long s_seed) {
        field = new boolean[n_lines][n_lines];
        Random random = new Random(s_seed);
        for(int i = 0; i<n_lines; i++){
            for (int j = 0; j< n_lines; j++){
                field[i][j] = random.nextBoolean();
            }
        }
    }
    public void print(){
        for(int i = 0; i<field.length; i++){
            for (int j = 0; j< field.length; j++){
                System.out.print(field[i][j] ? 'O' : ' ');
            }
            System.out.println();
        }
    }
    public int getAliveAmount(){
        int result = 0;
        for(int i = 0; i<field.length; i++){
            for (int j = 0; j< field.length; j++){
                if (field[i][j]){
                    result++;
                }
            }
        }
        return result;
    }

    public boolean[][] getField() {
        return field;
    }

    public void setField(boolean[][] field) {
        this.field = field;
    }




}
