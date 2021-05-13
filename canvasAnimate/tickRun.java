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
public class tickRun
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
    ControlPanel control = new ControlPanel();
    render render =  new render();
    
    Ellipse2D.Double ellipse;
    private double dataCX;
    private double dataCY;
    private double dataWX;
    private double dataWY;
    boolean read = false;
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
                try {TimeUnit.MILLISECONDS.sleep(control.delay);}
                catch(InterruptedException ex) {Thread.currentThread().interrupt();}   
                render.render();
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
                render.render();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    
}
