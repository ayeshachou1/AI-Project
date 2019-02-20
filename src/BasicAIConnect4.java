import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ayeshachou on 2/1/19.
 */
public class BasicAIConnect4 extends Player {
    private String moveToWin;
    private String moveToBlock;
    public BasicAIConnect4 (String name){
        super(name); moveToWin ="none"; moveToBlock="none";
    }

    public String getMove(Board board) {
        String location = "";
        Random r = new Random();
        ArrayList<String> nums = board.getEmptyLocs();
        if(board.getEmptyLocs().size()==1){
            location= nums.get(0);
        }else if (canWin(board)){
            location = moveToWin;
            System.out.println("win");

        }
        else if(blockOpponent(board)) {
            location = moveToBlock;
            System.out.println("block");
        }
        else{
            int length = board.getEmptyLocs().size();
            int rand = r.nextInt(length);
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
            copy.placePiece(a.get(i),"R");
            if(copy.isWinner("R"))
                moveToWin= a.get(i);
            copy.retractPiece(a.get(i));

        }
        if(!moveToWin.equals("none"))
            answer = true;
        return answer;
    }

    public boolean blockOpponent(Board gameBoard) {
        boolean answer = false;
        Board copy = gameBoard;

        ArrayList<String> a = copy.getEmptyLocs();

        if (a.size() > 1) {
            for (int i = 0; i < a.size(); i++) {
                copy.placePiece(a.get(i), "Y");
                if (copy.isWinner("Y"))
                    moveToBlock = a.get(i);
                copy.retractPiece(a.get(i));

            }
        }
        if(!moveToBlock.equals("none"))
            answer = true;

        return answer;
    }
}
