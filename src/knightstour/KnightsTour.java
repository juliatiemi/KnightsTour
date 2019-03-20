package knightstour;

/**
 *
 * @author julia
 */
public class KnightsTour {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Board board = new Board();        
        Knight knight = new Knight();
        
        Position initialPosition = board.decideInitialKnightPosition();
        
        knight.placeKnight(initialPosition);
        
        knight.startTour(initialPosition, board);
    }
    
}
