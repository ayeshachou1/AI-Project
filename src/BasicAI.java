import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ayeshachou on 2/1/19.
 */
public class BasicAI extends Player {
    private String moveToWin;
    public BasicAI (String name){
        super(name); moveToWin ="none";
    }

    public String getMove(Board board) {
        String location = "";
        Random r = new Random();
        if (canWin(board)){
            location = moveToWin;

        }
       // else if (!(blockOpponent((TTTBoard) board).equals("0"))){

        // }
        else{
            int length = board.getEmptyLocs().size();

            int rand = r.nextInt(length);
            ArrayList<String> nums = board.getEmptyLocs();
            location = nums.get(rand);
        }
        return location;
    }

    private boolean canWin(Board gameBoard){
        boolean answer = false;
        int count = 0;
        Board copy = gameBoard;

        ArrayList<String> a = copy.getEmptyLocs();

        for(int i =0; i<a.size();i++){
            copy.placePiece(a.get(i),"X");
            if(copy.isWinner("X"))
                moveToWin= a.get(i);
            copy.retractPiece(a.get(i));

        }
        if(!moveToWin.equals("none"))
            answer = true;


        /*for (int r = 0; r<gameBoard.getRows();r++){
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
        */
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
