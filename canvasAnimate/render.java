import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.FontMetrics;
import java.awt.Font;
import java.awt.BasicStroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import javax.swing.JComponent;
import java.awt.geom.AffineTransform;
import javax.swing.*;
import java.applet.*;
import java.lang.Object;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
public class render
{
    //private Display display;
    public int width, height;
    public String title;
    
    private boolean running = false;
    private Thread thread;
    long TimeStep;
    
    private BufferStrategy bs;
    private Graphics g;
    
    double EllipseRotation;
    double EllipseX;
    double EllipseY;
    double EllipseA = 40;
    double EllipseB = 20;
    double boundY = 400 - EllipseA;
    double boundX = 400 - EllipseB;
    double delay = 10;
    //ControlPanel control = new ControlPanel();
    //tickRun tickRun = new tickRun();
    
    Ellipse2D.Double ellipse;
    private double dataCX;
    private double dataCY;
    private double dataWX;
    private double dataWY;
    boolean read = false;
    public void render(){
        bs = Grapher.display.getCanvas().getBufferStrategy();
        if(bs == null){
            Grapher.display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //clear screen
        g.clearRect(0, 0, width, height);
        
        //draw bounds
        g.drawLine(10, 400, 600, 400);
        g.setColor(Color.red);
        
        //draw ellipse
        Graphics2D g2d = (Graphics2D)g;
        AffineTransform transform = new AffineTransform(); //make new affinetransform
        //EllipseX = boundX - EllipseX;
        EllipseY = boundY - EllipseY;
        EllipseY = EllipseY + 40;
        ellipse = new Ellipse2D.Double(Math.abs(EllipseX), Math.abs(EllipseY), EllipseA, EllipseB); // create new ellipse of dimensions (x, y, width, height)
        //System.out.println(EllipseRotation);
        transform.rotate(EllipseRotation,ellipse.getX() + ellipse.width/2, ellipse.getY() + ellipse.height/2);
        Shape transformed = transform.createTransformedShape(ellipse);
        g2d.fill(transformed);
        bs.show();
        g.dispose();
    }
}

