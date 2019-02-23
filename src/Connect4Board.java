/**
 * Created by alissahonigford on 2/19/19.
 */
import java.util.ArrayList;

public class Connect4Board extends Board {
    // Constants
    public static final int ROWS = 7;
    public static final int COLS = 7;

    /**
     * Constructs a 3x3 board for Tic Tac Toe and initializes
     * the board in the following format:
     * 123
     * 456
     * 789
     */
    public Connect4Board() {
        super(ROWS, COLS);

        int count = 1;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if(r==0)
                    set(r,c, ""+ count);
                else
                    set(r, c, "-");
                count++;
            }
        }
    }

    /**
     * Places a player piece on the board at the given location.
     * @param loc the location to place the piece
     * @param player the player making the move
     */
    public void placePiece(String loc, String player) {
        int num = Integer.parseInt(loc) -1;


            for (int c = COLS - 1; c > 0; c--) {
                if (theBoard[c][num].equals("-")) {
                    theBoard[c][num] = player;
                    c = -1;
                }
            }


    }

    /**
     * Retracts the piece at the given location.
     * @param loc the location to reset
     */
    public void retractPiece(String loc) {
        int num = Integer.parseInt(loc);


        for (int r = 1; r <ROWS; r++) {
            if(!theBoard[r][num-1].equals("-")) {
                theBoard[r][num - 1]= ("-");
                r= ROWS;
            }

            }

    }

    /**
     * Returns the empty locations on the
     */
    public ArrayList<String> getEmptyLocs() {
        ArrayList<String> empty = new ArrayList<>();
        int num =0;
        for(int c = 0; c < COLS; c++) {
            for(int r = 0; r < ROWS; r++) {
                if(get(r,c).equals("-"))
                    num++;
            }
            if(num>0)
                empty.add(Integer.toString(c+1));
            num =0;
        }

        return empty;
    }

    /**
     * Returns true if the given player wins the game in the
     * current state, false otherwise
     * @param player the player to check for a win
     */
    public boolean isWinner(String player) {

        // check rows for streak
        for(int i = 0; i < getRows(); i++) {
            if (streakInRow(i, player, 4) || streakInCol(i, player, 4)) {
                return true;
            }
            else{
                for(int n =0; n<getCols();n++) {
                  if (streakInNorthEastDiag(i, n, player, 4) || streakInSouthEastDiag(i, n, player, 4))
                        return true;
                }
            }
            }



        return false;
    }

    /**
     * Returns true if the game is over, false otherwise
     * @return true if the game is over, false otherwise
     */
    public boolean isGameOver() {
        if(isWinner("R") || !isWinner("Y") || getEmptyLocs().size() == 0)
            return true;
        else
            return false;
    }

}
