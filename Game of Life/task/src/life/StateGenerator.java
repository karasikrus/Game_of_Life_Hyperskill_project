package life;

public class StateGenerator {
    public StateGenerator() {
    }
    public FieldState generateNextState(boolean[][] field){
        boolean[][] thisField = field;
        boolean[][] nextField = new boolean[thisField.length][thisField.length];
        for(int i = 0; i<thisField.length; i++){
            for (int j = 0; j< thisField.length; j++){
                int aliveNeighbours = 0;
                for(int k = -1; k < 2; k++){
                    for (int l = -1; l < 2; l++){
                        if (!(k==0&&l==0)){
                            if(thisField[(i+k+thisField.length) % thisField.length][(j+l+thisField.length) % thisField.length]){
                                aliveNeighbours++;
                            }
                        }
                    }
                }
                if ((aliveNeighbours) < 2 || (aliveNeighbours > 3)){
                    nextField[i][j] = false;
                } else if(aliveNeighbours == 3){
                    nextField[i][j] = true;
                } else{
                    nextField[i][j] = thisField[i][j];
                }
            }
        }
        return new FieldState(nextField);
    }
}
