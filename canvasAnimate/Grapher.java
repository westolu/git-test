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

/**
 * Write a description of class Grapher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Grapher implements Runnable{
    public Display display;
    public int width, height;
    public String title;
    
    public boolean running = false;
    public Thread thread;
    long TimeStep;
    
    public BufferStrategy bs;
    public Graphics g;
    
    double EllipseRotation;
    double EllipseX;
    double EllipseY;
    double EllipseA = 40;
    double EllipseB = 20;
    double boundY = 400 - EllipseA;
    double boundX = 400 - EllipseB;
    double delay = 10;
    //ControlPanel control = new ControlPanel();
    tickRun tickRun = new tickRun();
    
    Ellipse2D.Double ellipse;
    public double dataCX;
    public double dataCY;
    public double dataWX;
    public double dataWY;
    boolean read = false;
        
    public Grapher(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }
    
    public void initialize(){
        display = new Display(title, width, height);
    }
    
    
    
    public void run(){
        initialize();
        
        while(running){
            tickRun.tickRun();
            
            //render();
        }
        
        stop();
    }
    
    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try{
            thread.join();
        }
        catch (InterruptedException ie){
            ie.printStackTrace();
        }
    }
}
