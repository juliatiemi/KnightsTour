package knightstour;

/**
 *
 * @author juliatiemi
 */
public class Enumerations {
    public enum movementDirection {
        /**
         * . 1 . . .
         * . . . . . 
         * . . 0 . .
         * . . . . .
         * . . . . .
         */
        topLeft (-2, -1),
        /**
         * . . . 1 .
         * . . . . . 
         * . . 0 . .
         * . . . . .
         * . . . . .
         */
        topRight (-2, 1),
        /**
         * . . . . .
         * . . . . . 
         * . . 0 . .
         * . . . . .
         * . 1 . . .
         */
        bottomLeft (2, -1),
        /**
         * . . . . .
         * . . . . . 
         * . . 0 . .
         * . . . . .
         * . . . 1 .
         */
        bottomRight (2, 1),
        /**
         * . . . . .
         * 1 . . . . 
         * . . 0 . .
         * . . . . .
         * . . . . .
         */
        midTopLeft (-1, -2),
        /**
         * . . . . .
         * . . . . 1 
         * . . 0 . .
         * . . . . .
         * . . . . .
         */
        midTopRight (-1, 2),
        /**
         * . . . . .
         * . . . . . 
         * . . 0 . .
         * 1 . . . .
         * . . . . .
         */
        midBottomLeft (1, -2),
        /**
         * . . . . .
         * . . . . . 
         * . . 0 . .
         * . . . . 1
         * . . . . .
         */
        midBottomRight (1, 2);
    
        /**
         *
         * Constructor
         */
        movementDirection(int rows, int columns) {
            nextRowDistance = rows;
            nextColumnDistance = columns;
        }
        
        /**
         * Represents how many squares the knight has to move vertically and horizontally.
         */
        public final int nextRowDistance;
        public final int nextColumnDistance;

    }
    
    
}
