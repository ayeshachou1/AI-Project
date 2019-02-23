import java.util.ArrayList;
import java.util.Random;

/**
 * Created by ayeshachou on 2/1/19.
 */
public class BasicAIConnect4 extends Player {
    private String moveToWin;
    private String moveToBlock;
    public BasicAIConnect4 (String name){
        super(name);
    }

    public String getMove(Board board) {
        ArrayList<String>b = board.getEmptyLocs();
        for (int i = 0; i<b.size();i++){
            board.placePiece(b.get(i), "R");
            if (board.isWinner("R")){
                board.retractPiece(b.get(i));
                return b.get(i);
            }
            else
                board.retractPiece(b.get(i));
        }

        for (int i = 0; i<b.size();i++){
            board.placePiece(b.get(i), "Y");
            if (board.isWinner("Y")){
                board.retractPiece(b.get(i));
                return b.get(i);
            }
            else
                board.retractPiece(b.get(i));
        }

        Random r = new Random();
        int num = r.nextInt(b.size());
        return b.get(num);
    }

   /* private boolean canWin(Board gameBoard) {
        boolean answer = false;
        for (int c = gameBoard.getCols()-1; c > 0; c--) {
           // if (avaliableMoves(c, gameBoard)){
                String num = Integer.toString(c);
                gameBoard.placePiece(num, "R");
                if (gameBoard.isWinner("R")) {
                    moveToWin = num;
                    c = -1;
                }
                gameBoard.retractPiece(num);
            //}
        }
        if(!moveToWin.equals("none"))
            answer = true;
        return answer;
    }

    public boolean blockOpponent(Board gameBoard) {
        boolean answer = false;
        for (int c = gameBoard.getCols()-1; c > 0; c--) {
                String num = Integer.toString(c);
                gameBoard.placePiece(num, "Y");
                if (gameBoard.isWinner("Y")) {
                    moveToBlock = num;
                    c= -1;
                }
                gameBoard.retractPiece(num);
        }
        if(!moveToBlock.equals("none"))
            answer = true;
        return answer;
    }*/
}