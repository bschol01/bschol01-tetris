/*
 * TCSS 305 - Autumn 2014
 * Assignment 6 - Tetris
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Board;

/**
 * A panel that sits to the right side of the tetris game and holds
 * information for the game such as next piece and controls.
 * 
 * @author Brandon Scholer
 * @version 1.0
 */
@SuppressWarnings("serial")
public class TetrisRightPanel extends JPanel implements Observer {

    /** Color for the text. */
    private static final Color TEXT_COLOR = Color.YELLOW;
    
    /** Number used to set fond size. */
    private static final int FONT_SIZE = 24;
    
    /** Panel holding the next shape. */
    private final NextPiecePanel myNextPiece;
    
    /** The tracker for the score of the current game. */
    private final Score myScore;
    
    /** JPanel that holds the score. */
    private final JPanel myScorePanel;
    
    /** JLabel that holds the score. */
    private final JLabel myScoreLabel;
    
    /** JLabel that holds the lines cleared. */
    private final JLabel myLinesCleared;
    
    /** JLabel that holds the current Level. */
    private final JLabel myLevelLabel;
    
    /** JLabel that holds lines needed until next later. */
    private final JLabel myNextLevel;
    
    /** Holds the Current Level. */
    private int myLevel;
    
    /** Constructor that initializes instance fields. */
    public TetrisRightPanel() {
        super();
        myNextPiece = new NextPiecePanel();
        myScore = new Score();
        myScorePanel = new JPanel();
        myScoreLabel = new JLabel();
        myLinesCleared = new JLabel();
        myLevelLabel = new JLabel();
        myNextLevel = new JLabel();
        setup();
    }
    
    /** Sets up the bottom part of the panel. */
    private void setup() {
        
        setLayout(new BorderLayout());
        myScorePanel.setLayout(new BoxLayout(myScorePanel, BoxLayout.Y_AXIS));
        final JPanel north = new JPanel();
        final JPanel south = new JPanel();
        
        scorePanelSetup();
        
        north.add(myNextPiece);
        add(north, BorderLayout.NORTH);
       
        south.setOpaque(false);
        north.setOpaque(false);
        myNextPiece.setOpaque(false);
        myScorePanel.setOpaque(false);
        
        myScoreLabel.setForeground(TEXT_COLOR);
        myLinesCleared.setForeground(TEXT_COLOR);
        myLevelLabel.setForeground(TEXT_COLOR);
        myNextLevel.setForeground(TEXT_COLOR);
        myScorePanel.add(myScoreLabel);
        myScorePanel.add(myLinesCleared);
        myScorePanel.add(myLevelLabel);
        myScorePanel.add(myNextLevel);
        south.add(myScorePanel);
        add(south, BorderLayout.SOUTH);
    }
    
    /** Sets up the fonts and colors used in the Score Panel. */
    private void scorePanelSetup() {
        myScoreLabel.setForeground(TEXT_COLOR);
        myLinesCleared.setForeground(TEXT_COLOR);
        myLevelLabel.setForeground(TEXT_COLOR);
        myNextLevel.setForeground(TEXT_COLOR);
        myScoreLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, FONT_SIZE));
        myLinesCleared.setFont(new Font(Font.SANS_SERIF, Font.BOLD, FONT_SIZE));
        myLevelLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, FONT_SIZE));
        myNextLevel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, FONT_SIZE));
        myScorePanel.add(myScoreLabel);
        myScorePanel.add(myLinesCleared);
        myScorePanel.add(myLevelLabel);
        myScorePanel.add(myNextLevel);
    }
    
    /** Paints the panel with the Death Star and Space background.
     * {@inheritDoc}
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Image image = new ImageIcon("support_files/Space.jpg").getImage();
        final Image deathStar = new ImageIcon("support_files/Death_star2.png").getImage();
        theGraphics.drawImage(image, 0, 0, null);
        theGraphics.drawImage(deathStar, 0, 0, null);  
    }
    
    /**
     * Gets the current level the player is on.
     * 
     * @return The current Level.
     */
    public int getLevel() {
        return myLevel;
    }
    
    
    /**
     * Connects the NextPiecePanel to the Observable Board.
     * {@inheritDoc}
     */
    @Override
    public void update(final Observable theObservable, final Object theObject) {

        final Board tetrisBoard = (Board) theObservable;
        tetrisBoard.addObserver(myNextPiece);
        tetrisBoard.addObserver(myScore);       
        
        myScoreLabel.setText("Score = " + myScore.getScore());
        myLinesCleared.setText("Lines Cleared = " + myScore.getLinesCleared());
        myLevel = myScore.getLevel();
        myLevelLabel.setText("Level = " + myLevel);
        myNextLevel.setText("Lines until next Level = " + myScore.getNextLevel());
        
        myScorePanel.repaint();
    }

}
