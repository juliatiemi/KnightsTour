package knightstour;

/**
 *
 * @author juliatiemi
 */
public class Knight {
    
    
    /**
     * 
     * Position shows where the knight is within the board
     * numberOfMovements shows how many steps the knight has taken until the current position
     */
    public Position position;
    public int numberOfMovements;
    public int numberOfAllMovements;
    
    /**
     * 
     * When a knight is created, it has not started walking
     */
    public Knight() {
        this.position = new Position();
        this.numberOfMovements = 0;
        this.numberOfAllMovements = 0;
    }
    
    /**
     * 
     * @param position is the initial position randomized before and where the knight is going to begin his tour
     */
    public void placeKnight(Position position) {
        this.position.row = position.row;
        this.position.column = position.column;
    }
    
    /**
     * 
     * @param position is the initial position randomized before
     * @param board the clean board
     */
    public void startTour(Position position, Board board) {
        if(move(position, board)) {
            board.printFinishedBoard();
        }
        else {
            System.out.println("I cannot finish mine own toureth from this starteth pointeth!");
        }
    }
    
    /**
     * 
     * @param board is the actual state of the board
     * @param position is the position the knight has just stepped in
     * @return true or false, indicating if the knight has already stepped in this square
     */
    public boolean isAlreadyStepped(Board board, Position position) {
        if(board.chessBoard[position.row][position.column] != 0) {
            return true;
        }
        else {
            return false;
        }
    }    
    
    /**
     * 
     * @param position is the position the knight has just stepped in
     * @param boardDimension is the length of the board
     * @return true or false, indicating if the move is within the board
     */
    public boolean isMoveAvailable(Position position, int boardDimension) {
        if(position.row >= 0 && position.column >= 0 &&
           position.row < boardDimension && position.column < boardDimension) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Adds in one the number of steps taken by the knight
     */
    public void countSteps() {
        this.numberOfMovements = this.numberOfMovements + 1;
        this.numberOfAllMovements = this.numberOfAllMovements + 1; 
    }
    
    /**
     * 
     * @param position is the position the knight has just stepped in
     * @param board is the actual state of the board, given that the knight made a step that did not work
     * 
     * Subtract in one the number of steps taken by the knight, given that the knight made a step that did not work
     */
        public void undoStep(Position position, Board board) {
        this.numberOfMovements = this.numberOfMovements - 1;
        board.unregisterMovement(position);
    }
    
    /**
     * 
     * @param size the number of squares in the board
     * @return is the knight has made the same number of moves as the number of squares in the board a.k.a has finished the tour
     */
    public boolean isFinishedMoving(int size) {
        if(this.numberOfMovements == size) {
            System.out.println("Total number of Movements: " + this.numberOfAllMovements);
            System.out.println();
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * 
     * @param position is the position the knight has just stepped in
     * @param board is the actual state of the board
     * @return true or false, indicating if the move was made succesufully or if the knight will have to backtrack
     */
    public boolean move(Position position, Board board) {
        
        //Have I already stepped in this square?
        if(isAlreadyStepped(board, position)) {
            return false;
        }
        
        //No? Great. Which step is this?
        this.countSteps();
        board.registerMovement(position, this.numberOfMovements);
        
        //Is this my final step for completing my tour?
        if(this.isFinishedMoving(board.SIZE)) {
            return true;
        }
        
        //No? So lets continue my walk
        if(checkNextMove(board, Enumerations.movementDirection.topLeft, position)) {
            return true;
        }
        if(checkNextMove(board, Enumerations.movementDirection.topRight, position)) {
            return true;
        }
        if(checkNextMove(board, Enumerations.movementDirection.bottomLeft, position)) {
            return true;
        }
        if(checkNextMove(board, Enumerations.movementDirection.bottomRight, position)) {
            return true;
        }
        if(checkNextMove(board, Enumerations.movementDirection.midTopLeft, position)) {
            return true;
        }
        if(checkNextMove(board, Enumerations.movementDirection.midTopRight, position)) {
            return true;
        }
        if(checkNextMove(board, Enumerations.movementDirection.midBottomLeft, position)) {
            return true;
        }
        if(checkNextMove(board, Enumerations.movementDirection.midBottomRight, position)) {
            return true;
        }
        
        //Hmm, can´t keep going. I shall move backwards and retry.
        undoStep(position, board);
        return false;
    }
    
    /**
     * 
     * @param board is the actual state of the board
     * @param direction is which of the eight possible knight's moviment he is trying to do
     * @param position is the position the knight has just stepped in
     * @return true or false, indicating if the next move is a possibility
     */
    public boolean checkNextMove(Board board, Enumerations.movementDirection direction, Position position) {
        position.row = position.row + direction.nextRowDistance;
        position.column = position.column + direction.nextColumnDistance;
        if(isMoveAvailable(position, board.DIMENSION) && move(position, board)) {
            return true;
        }
        else {
            position.row = position.row - direction.nextRowDistance;
            position.column = position.column - direction.nextColumnDistance;
            return false;
        }
    }
}
