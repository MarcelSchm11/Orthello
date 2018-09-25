public class Scoreboard {

        public static void main(String[] args) {
        /*
    final static int BLACK = 1;
    final static int WHITE = 2;
    final static int EMPTY = 0;
    final static int OFFBOARD = -1;
 */
            // Scorebord while playing
            private void displayStatus(char turn)

            if (turn==BLACK_UP)
            {
                this.gameBoard.displayMessage("**black** has " +'recall array list black'+ " pieces up --- white has " + 'recall array list white' + " pieces up");
            }else if(turn==WHITE_UP)
            {
                this.gameBoard.displayMessage("black has " +blackCunt+ " pieces up --- **white** has " +whiteCount+ " pieces up");
            }
        }
        // Scorebord at the end of the game
    if (blackCunt>whiteCount)
        {
            this.gameBoard.displayMessage("Game over. The winner is black.");
        }else if (whiteCount>blackCunt)
        {
            this.gameBoard.displayMessage("Game over. The winner is white.");
        }else
        {
            this.gameBoard.displayMessage("Game over. It is a tie game.");
        }

}
}
