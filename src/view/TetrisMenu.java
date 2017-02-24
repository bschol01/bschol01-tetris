/*
 * TCSS 305 - Autumn 2014
 * Assignment 6 - Tetris
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Class that holds all of the menu options for Tetris.
 * 
 * @author Brandon Scholer
 * @version 1.0
 *
 */
public class TetrisMenu extends Observable {
    
    /** Capacity for the StringBuilder used in the About section. */
    private static final int CAPACITY = 500;
    
    /** The frame the menu will be attached to. */
    private final JFrame myFrame;
    
    /** The JMenu that is added to. */
    private final JMenuBar myMenuBar;
    
    /** Initializes instance fields.
     * 
     * @param theFrame Frame to attach the menu to.
     */
    public TetrisMenu(final JFrame theFrame) {
        super();
        myMenuBar = new JMenuBar();
        myFrame = theFrame;
        setup();
    }
    
    /** Sets up the MenuBar. */
    private void setup() {
        final JMenu file = new JMenu("File");
        final JMenu help = new JMenu("Help");
        
        setupFileMenu(file);
        setupHelpMenu(help);
        
        myMenuBar.add(file);
        myMenuBar.add(help);
        myFrame.setJMenuBar(myMenuBar);
    }
    
    /**
     * Sets up the File Menu of the MenuBar.
     *
     * @param theFile The file menu.
     */
    private void setupFileMenu(final JMenu theFile) {
        final JMenuItem exit = new JMenuItem("Exit");
        final JMenuItem startGame = new JMenuItem("New Game");
        final JMenuItem finishGame = new JMenuItem("End Game");
        
        startGame.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theAction) {
                final String newGame = "NewGame";
                setChanged();
                notifyObservers(newGame);
            }
        });
        
        finishGame.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theAction) {
                final String endGame = "EndGame";
                setChanged();
                notifyObservers(endGame);
            }
        });
        
        
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theAction) {
                myFrame.dispatchEvent(new WindowEvent(myFrame, WindowEvent.WINDOW_CLOSING));
            }
        });
        theFile.add(startGame);
        theFile.add(finishGame);
        theFile.addSeparator();
        theFile.add(exit);
    }
    
    /**
     * Sets up the help menu.
     * 
     * @param theHelp The menu items are added to.
     */
    private void setupHelpMenu(final JMenu theHelp) {
        final JMenuItem about = new JMenuItem("About...");
        final JMenuItem credits = new JMenuItem("Credits...");
        final StringBuilder aboutText = new StringBuilder(CAPACITY);
        
        aboutText.append("Controls: \nMove Right = Right Arrow Key"
                                        + "\nMove Left = Left Arrow Key"
                                        + "\nMove Down = Down Arrow Key"
                                        + "\nRotate = Up Arrow Key"
                                        + "\nHard Drop = Ctrl Key"
                                        + "\nPause = Spacebar");
        aboutText.append("\n\nScoring:"
                                        + "\nLevels are advanced by clearing Lines."
                                        + "\nThe number of points earned vary by the number"
                                        + "\nof lines cleared."
                                        + "\nOne line = 100 points"
                                        + "\nTwo lines = 200 points"
                                        + "\nThree lines = 400 points"
                                        + "\nFour lines = 800 points"
                                        + "\n\nEach time a piece moves down it "
                                        + "is worth 10 points."
                                        + "\nA Hard Drop is only worth 10 points total");
        
        about.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theAction) {
                JOptionPane.showMessageDialog(null, aboutText.toString());
            }
        });
        
        addCredits(credits);
        
        theHelp.add(about);
        theHelp.add(credits);
    }
    
    /** puts together the credits for outside sources of the program.
     * 
     * @param theCredits The MenuItem to be added to.
     */
    private void addCredits(final JMenuItem theCredits) {
        final StringBuilder creditsText = new StringBuilder(CAPACITY);
        
        creditsText.append("Death Star Image courtesy of Wikepedia "
                                        + "(edited by Brandon Scholer).");
        creditsText.append("\n\nSpace Image courtesy of www.truthinsideofyou.org (SPACE.TGA)");
        creditsText.append("\n\nThe Imperial March (Darth Vaders Theme).mp3 and "
                                        + "\nYodas Theme.mp3 by John Williams "
                                        + "available through Amazon.com.");
        creditsText.append("\n\nThe Icons used for the Tetris pieces courtesy of"
                                        + "\nIconArchive.com created by Jonathan Rey.");
        creditsText.append("\n\nThe Icon used for the title bar courtesy of of Wikepedia"
                                        + "(Galactic Empire).");
        
        theCredits.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theAction) {
                JOptionPane.showMessageDialog(null, creditsText.toString());
            }
        });
        
    }

}
