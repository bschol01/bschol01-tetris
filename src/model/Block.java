/*
 * TCSS 305 - Project Tetris
 */

package model;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * The different types of blocks that will be stored in a Board's grid.
 * 
 * @author Alan Fowler
 * @author Brandon Scholer
 * @version Autumn 2014
 */
public enum Block {
    
    // added an image value to pass alongside color.
    /** AN empty space in the grid. */
    EMPTY(Color.BLACK, null),
    /** A Block from an IPiece. */
    I(Color.CYAN, new ImageIcon("support_files/A-Wing - 02.png").getImage()),
    /** A Block from a JPiece. */
    J(Color.BLUE, new ImageIcon("support_files/B-Wing.png").getImage()),
    /** A Block from an LPiece. */
    L(Color.ORANGE, new ImageIcon("support_files/Imperial Star Destroyer.png").getImage()),
    /** A Block from an OPiece. */
    O(Color.YELLOW, new ImageIcon("support_files/Jedi StarFighter.png").getImage()),
    /** A Block from an SPiece. */
    S(Color.GREEN, new ImageIcon("support_files/Naboo Fighter.png").getImage()),
    /** A Block from a TPiece. */
    T(Color.MAGENTA, new ImageIcon("support_files/Tie Fighter - 01.png").getImage()),
    /** A Block from a ZPiece. */
    Z(Color.RED, new ImageIcon("support_files/X-Wing - 02.png").getImage());

    /**
     * The Color corresponding to a particular value of the enumeration.
     */
    private Color myColor;
    
    // added an instance field to hold the blocks image.
    /**
     * The Image corresponding to a particular value of the enumeration.
     */
    private Image myImage;

    // Constructor

    /**
     * Constructs a new Block with the specified Color and Image.
     * 
     * @param theColor The Color.
     * @param theImage The Image.
     */
    private Block(final Color theColor, final Image theImage) {
        myColor = theColor;
        myImage = theImage; //added the image file to the constructor
    }

    /**
     * Returns the Color of this Block.
     * 
     * @return the Color of this Block.
     */
    public Color getColor() {
        return myColor;
    }
    
    // added a method to access the image associated with each block.
    /**
     * Returns the Image of this Block.
     * 
     * @return The Image of this Block.
     */
    public Image getImage() {
        return myImage;
    }

}
