/*
 * TCSS 305 - Autumn 2014
 * Assignment 6 - Tetris
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.AbstractPiece;
import model.Board;
import model.Piece;

/**
 * The panel that displays the next piece.
 * 
 * @author Brandon Scholer
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class NextPiecePanel extends JPanel implements Observer {
    
    /** Default Block Size. */
    private static final int DEFAULT_BLOCK_SIZE = 30;
    
    /** Default Panel Size. */
    private static final Dimension DEFAULT_DIMENSION = new Dimension(150, 175);
    
    /** Number of Blocks in a piece. */
    private static final int BLOCKS = 4;
    
    /** Default border width. */
    private static final int BORDER_WIDTH = 3;
    
    /** Block Coordinate Adjustment for sizes. */
    private static final int ADJUSTMENT = 1;
    
    /** The Next piece to be displayed. */
    private Piece myNextPiece;
    
    /** The Block size. */
    private final int myBlockSize;
    
    /** Initializes instance fields. */
    public NextPiecePanel() {
        super();
        myBlockSize = DEFAULT_BLOCK_SIZE;
        setPreferredSize(DEFAULT_DIMENSION);
        setBorder(BorderFactory.createLineBorder(Color.YELLOW, BORDER_WIDTH));
    }
    
    /** Paints the pieces used on the board and the frozen
     * blocks at the bottom.
     * {@inheritDoc}
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        
        if (myNextPiece != null) {
            g2d.setColor(((AbstractPiece) myNextPiece).getBlock().getColor());
        
            final int[][] coord = ((AbstractPiece) myNextPiece).getRotation();
        
            for (int blocks = 0; blocks < BLOCKS; blocks++) {
                if (myBlockSize != 0) {
                    g2d.drawImage(((AbstractPiece) myNextPiece).getBlock().getImage(),
                                  (coord[blocks][0] + ADJUSTMENT) * myBlockSize, 
                           (getHeight() / myBlockSize - coord[blocks][1] - ADJUSTMENT)
                                                           * myBlockSize,
                           myBlockSize, myBlockSize, null);
                }
            }
        }
    }

    /**
     * Gets the next piece to be drawn.
     * {@inheritDoc}
     */
    @Override
    public void update(final Observable theObservable, final Object theObject) {
        
        final Board tetrisBoard = (Board) theObservable;
        myNextPiece = (AbstractPiece) tetrisBoard.getNextPiece();
        repaint();
    }
}
