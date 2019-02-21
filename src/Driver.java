import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        System.out.println("1. Tic-Tac-Toe (Human vs. Human)");
        System.out.println("2. Tic-Tac-Toe (Human vs. Beginner AI)");
        System.out.println("3. Tic-Tac-Toe (Human vs. Pro AI)");
        System.out.println("4. Connect 4 (Human vs. Human)");
        System.out.println("5. Connect 4 (Human vs. Beginner AI)");
        System.out.println("6. Connect 4 (Human vs. Pro AI)");
        System.out.print("Select your game (1-6): ");
        Scanner in = new Scanner(System.in);
        int gameNumber = in.nextInt();
        String player1 = "";
        String player2 = "";
        Board gameBoard = new TTTBoard();
        String answer = "";
        String range = "";
        boolean human = true;
        System.out.println();
        Player ba = new BasicAI("X");
        Player baa = new TTTPlayerProAI("X");
        Player connectBAI = new BasicAIConnect4("R");
        if (gameNumber == 1  ) { //decide if TTT
            player1 = "X";
            player2 = "O";
            //gameBoard = new TTTBoard();   switch boards here
            range = "(1-9) : ";
        }
        else if(gameNumber ==2|| gameNumber == 3) {
            human = false;
            player1 = "X";
            player2 = "O";
        }

        else if(gameNumber ==4){ // decide if Connect 4
            player1 = "R";
            player2 = "Y";
            gameBoard = new Connect4Board(); //gameBoard[6][7]; switch boards here
            range = "(1-7) : ";
        }
        else if(gameNumber ==5){ // decide if Connect 4
            player1 = "R";
            player2 = "Y";
            gameBoard = new Connect4Board();
            //gameBoard[6][7]; switch boards here
            human = false;
            range = "(1-7) : ";
        }

        String currentPlayer = player1;

        while (gameBoard.isGameOver()) { // running the game
            System.out.print(gameBoard);
            if (!human){
                if (gameNumber == 2)
                    answer = ba.getMove(gameBoard);
                else if(gameNumber==3)
                    answer = baa.getMove(gameBoard);
                else if(gameNumber ==5){
                    answer = connectBAI.getMove(gameBoard);
                }

            }
            else {
                System.out.print("Enter your move: " + range);
                answer = in.next();
            }
                gameBoard.placePiece(answer, currentPlayer);


                if (currentPlayer.equals(player1)) { // switches to other player
                    currentPlayer = player2;
                    human = true;

                } else {
                    currentPlayer = player1;
                    if (gameNumber ==2 || gameNumber==3 || gameNumber==5)
                        human = false;
                }
                System.out.println();

                if (gameBoard.isWinner(player1)) {
                    System.out.println(gameBoard);
                    System.out.println("Congratulations " + player1 + " you have won!");
                    break;
                } else if (gameBoard.isWinner(player2)) {
                    System.out.println(gameBoard);
                    System.out.println("Congraulations " + player2 + " you have won!");
                    break;
                } else if (gameBoard.getEmptyLocs().size() == 0) {
                    System.out.println(gameBoard);
                    System.out.println("No more moves.");
                    break;
                }


            }

            System.out.println("-- End of Game --");
            //gameBoard.retractPiece(player1); // clears board of player1
            //gameBoard.retractPiece(player2); // clears board of player2

        }

    }

