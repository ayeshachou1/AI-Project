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

         if (canWin(board) && !board.get(1,Integer.parseInt(moveToWin)-1).equals("R") && !board.get(1,Integer.parseInt(moveToWin)-1).equals("Y")){
            location = moveToWin;
            System.out.println("win");

        }
        else if(blockOpponent(board) && !board.get(1,Integer.parseInt(moveToBlock)-1).equals("R") && !board.get(1,Integer.parseInt(moveToBlock)-1).equals("Y")) {
            location = moveToBlock;
            System.out.println("block");
        }
        else{
            int length = 7;
            int rand = r.nextInt(length);
             while (!board.get(1, rand).equals("-"))
                 rand = r.nextInt(length);
            location = Integer.toString(rand+1);
             //homie
        }
        return location;
    }

    private boolean canWin(Board gameBoard){
        boolean answer = false;
        for (int c = gameBoard.getCols(); c > 0; c--) {


            String num = Integer.toString(c);
            gameBoard.placePiece(num,"R");
            if(gameBoard.isWinner("R")) {
                moveToWin = num;
                c = -1;
            }
            gameBoard.retractPiece(num);

        }
        if(!moveToWin.equals("none"))
            answer = true;
        return answer;
    }

    public boolean blockOpponent(Board gameBoard) {
        boolean answer = false;
        for (int c = gameBoard.getCols(); c > 0; c--) {
            if(getTopRow(c,gameBoard)==-1)
                c--;
            String num = Integer.toString(c);

            gameBoard.placePiece(num,"Y");
            if(gameBoard.isWinner("Y")) {
                moveToBlock = num;
                c =-1;
            }
            gameBoard.retractPiece(num);
        }
        if(!moveToBlock.equals("none"))
            answer = true;
        return answer;
    }
    public int getTopRow(int c, Board gameBoard){
        for (int r = 0; r > gameBoard.getRows(); r++) {
            if(gameBoard.get(r,c).equals("-"))
                return r;
        }
        return -1;
    }
}
