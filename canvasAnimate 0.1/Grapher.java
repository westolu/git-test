import java.io.*;
import java.awt.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;
import java.applet.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.concurrent.*;

/**
 * Write a description of class Grapher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Grapher implements Runnable{
    private Display display;
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
    ControlPanel control = new ControlPanel();
    
    Ellipse2D.Double ellipse;
    private double dataCX;
    private double dataCY;
    private double dataWX;
    private double dataWY;
    boolean read = false;
        
    public Grapher(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
    }
    
    private void initialize(){
        display = new Display(title, width, height);
    }
    
    public void tickRun(){
        try {
            File myObj = new File("SimDataDump.txt");
            File myObj2 = new File("TrackerDataDump.txt");
            Scanner dataReader = new Scanner(myObj);
            EllipseA = dataReader.nextDouble();
            EllipseA = EllipseA * 5000;
            EllipseB = dataReader.nextDouble();
            EllipseB = EllipseB * 5000;
            Scanner dataReader2 = new Scanner(myObj2);
            while (read = true && dataReader.hasNextDouble()) {
                EllipseX = dataReader.nextDouble();
                EllipseX = EllipseX * 2000;
                EllipseY = dataReader.nextDouble();
                EllipseY = EllipseY * 2000;
                EllipseRotation = dataReader.nextDouble() * (Math.PI/180);
                if (control.delay>100){control.delay = 1000;};
                if (control.delay<1){control.delay = 1;};
                try {TimeUnit.MILLISECONDS.sleep(control.delay);}
                catch(InterruptedException ex) {Thread.currentThread().interrupt();}   
                render();
            }
            while (read = true && dataReader2.hasNextDouble()) {
                dataCX = dataReader2.nextDouble();
                dataWX = dataReader2.nextDouble();
                EllipseX = dataWX + dataCX;
                EllipseX = EllipseX / 2; //get average
                EllipseX = EllipseX * 1000; //scale up
                dataCY = dataReader2.nextDouble();
                dataWY = dataReader2.nextDouble();
                EllipseY = dataWY + dataCY;
                EllipseY = EllipseY / 2; //get average
                EllipseY = EllipseY * 1000; //scale up
                EllipseA = dataReader.nextDouble();
                EllipseA = EllipseA * 5000;
                EllipseB = dataReader.nextDouble();
                EllipseB = EllipseB * 5000;
                EllipseRotation = Math.atan2(dataCY - dataWY, dataCX - dataWX);
                render();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
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
    
    public void run(){
        initialize();
        
        while(running){
            tickRun();
            
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
