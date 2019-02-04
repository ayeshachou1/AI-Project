import java.util.Random;

/**
 * Created by ayeshachou on 2/1/19.
 */
public class BasicAI extends Player {
    public BasicAI (String name){
        super(name);
    }

    public String getMove(Board board) {
        String location = "";
        Random r = new Random();
        if (canWin(board)){

        }
       // else if (!(blockOpponent((TTTBoard) board).equals("0"))){

        // }
        else{
            // random
        }
        return location;
    }

    private boolean canWin(Board gameBoard){
        boolean answer = false;
        int count = 0;
        for (int r = 0; r<gameBoard.getRows();r++){
            for (int c = 0; c<gameBoard.getCols();c++){
                if (gameBoard.get(r, c).equals("X") || gameBoard.get(r, c).equals("R")){
                    count++;
                }
            }
            if (count == 2){
                answer = true;
                break;
            }
        }
        return answer;
    }

    public boolean blockOpponent(Board gameBoard){
        boolean answer = false;
        for (int r = 0; r<gameBoard.getRows();r++){
            for (int c = 0; r<gameBoard.getCols();c++){

            }
        }
        return answer;
    }
}
