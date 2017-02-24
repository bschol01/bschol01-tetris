/*
 * TCSS 305 - Autumn 2014
 * Assignment 6 - tetris
 */

package view;

import com.sun.media.codec.audio.mp3.JavaDecoder;
import java.awt.EventQueue;

import javax.media.Codec;
import javax.media.PlugInManager;



/**
 * Creates an instance of a Tetris game.
 * 
 * @author Brandon Scholer
 * @version 1.0
 */
public final class TetrisMain {
    
    /**
     * Private constructor to prevent instances.
     */
    private TetrisMain() {
    }

    /**
     * Main method that runs the program.
     * 
     * @param theArgs Command line arguments.
     */
    public static void main(final String...theArgs) {

        final Codec c = new JavaDecoder();
        PlugInManager.addPlugIn("com.sun.media.codec.audio.mp3.JavaDecoder",
                                c.getSupportedInputFormats(),
                                c.getSupportedOutputFormats(null),
                                PlugInManager.CODEC);

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                final TetrisFrame tetris = new TetrisFrame();
                tetris.start();
            }
        });
        
    }

}
