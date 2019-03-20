package knightstour;

import java.text.DecimalFormat;
import java.util.Random;

/**
 *
 * @author julia
 */


/**
 * 
 * DIMENSION determinates 
 */
public class Board {
    public static final int DIMENSION = 8;
    public static final int SIZE = DIMENSION * DIMENSION;
    public int[][] chessBoard;
    
    public Board() {
        this.chessBoard = new int[DIMENSION][DIMENSION];
        for(int i = 0; i < DIMENSION; i++) {
            for(int j = 0; j < DIMENSION; j++) {
                this.chessBoard[i][j] = 0;
            }
        }
    }
    
    public Position decideInitialKnightPosition() {
        Position initialPosition = new Position();
        Random rng = new Random();
        int index = rng.nextInt();
        initialPosition.row = index < 0 ? (index*-1)%DIMENSION : index%DIMENSION;
        index = rng.nextInt();
        initialPosition.column = index < 0 ? (index*-1)%DIMENSION : index%DIMENSION;
        System.out.print("Initial Position: [" + initialPosition.row + "][" + initialPosition.column + "]");
        System.out.println();
        return initialPosition;
    }
    
    public void registerMovement(Position position, int movementNumber) {
        this.chessBoard[position.row][position.column] = movementNumber;
    }
    
    public void unregisterMovement(Position position) {
        this.chessBoard[position.row][position.column] = 0;
    }
    
    public void printFinishedBoard() {
        DecimalFormat twoDigitsNumber = new DecimalFormat("00");
        for(int i = 0; i < this.DIMENSION; i++) {
            for(int j = 0; j < this.DIMENSION; j++) {
                System.out.print("   " + twoDigitsNumber.format(this.chessBoard[i][j]));
            }
            System.out.println();
        }
    }
}
