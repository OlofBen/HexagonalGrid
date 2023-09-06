package graphics;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import hexagonalGrid.Hex;

public class Window {
	// creates the height and width variables
	// private means only Window class can access them
	private final int HEIGHT = 600;
	private final int WIDTH = 480;
    

    private HexCanvas canvas;
    private Frame frame;

	
	public Window(HexCanvas canvas) {
        frame = new Frame("Hex Grid");
        this.canvas = canvas;
        canvas.setSize(WIDTH, HEIGHT);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {    
            public void windowClosing (WindowEvent e) {    
                frame.dispose();    
            }    
        });         
	}

    public Graphics getGraphics(){
        return canvas.getGraphics();
    }

    public void paint(Graphics g) {
        canvas.paint(g);
    }

    public void repaint(){
        canvas.repaint();
    }

    public void setFillColor(int row, int col, java.awt.Color fillColor) {
        canvas.setFillColor(row, col, fillColor);
    }

    public void setFillColor(Hex hex, java.awt.Color fillColor) {
        canvas.setFillColor(hex.getRow(), hex.getCol(), fillColor);
    }
}	