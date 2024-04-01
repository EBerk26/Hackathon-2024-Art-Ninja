//Basic Game Application
//Version 2
// Basic Object, Image, Movement
// Astronaut moves to the right.
// Threaded

//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.*;
import java.awt.FontMetrics;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.Random;
//*******************************************************************************
// Class Definition Section

public class Main implements Runnable,MouseListener, MouseMotionListener{
    int RandomInt(int LowerBound, int UpperBound){
       return((int)(Math.random()*(UpperBound-LowerBound+1))+LowerBound);
    }
    boolean mouseDown = false;

    //Variable Definition Section
    //game window definitions
    Point mousePosition = MouseInfo.getPointerInfo().getLocation();
    int mouseX = mousePosition.x;
    int mouseY = mousePosition.y;
    int previousMouseX = mouseX;
    int previousMouseY = mouseY;
    final int WIDTH = 1000;
    final int HEIGHT = 700;
    double distanceMoved = 0;
    Painting[] paintingArray = new Painting[4];
    //Graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
    public BufferStrategy bufferStrategy;
    int numberOfLoops =0;

    //Menu Images
    public Image startScreen;
    public Image endScreen;
    public Image background;
    public Image startButton;
    //Art Images

    //In game variables
    public Boolean isPlayerAlive = true;
    public Boolean isStartScreen = true;
    public boolean isPlaying = false;
    public int playerLives = 10;
    int score = 0;


    boolean insidePainting(int paintingNumber){
        if(paintingArray[paintingNumber].xpos<=mouseX&&paintingArray[paintingNumber].xpos+paintingArray[paintingNumber].width>=mouseX&&paintingArray[paintingNumber].ypos<=mouseY&&paintingArray[paintingNumber].ypos+paintingArray[paintingNumber].height>=mouseY){
            return true;
        } else {
            return false;
        }
    }
    public Image painting1 = Toolkit.getDefaultToolkit().getImage("1.jpeg");
    public Image painting2 = Toolkit.getDefaultToolkit().getImage("2.jpeg");
    public Image painting3 = Toolkit.getDefaultToolkit().getImage("3.jpeg");
    public Image painting4 = Toolkit.getDefaultToolkit().getImage("4.jpeg");
    public Image painting5 = Toolkit.getDefaultToolkit().getImage("5.jpeg");
    public Image painting6 = Toolkit.getDefaultToolkit().getImage("6.jpeg");
    public Image painting7 = Toolkit.getDefaultToolkit().getImage("7.jpeg");
    public Image painting8 = Toolkit.getDefaultToolkit().getImage("8.jpeg");
    public Image painting9 = Toolkit.getDefaultToolkit().getImage("9.jpeg");
    public Image painting10 = Toolkit.getDefaultToolkit().getImage("10.jpeg");
    public Image painting11 = Toolkit.getDefaultToolkit().getImage("11.jpeg");
    public Image painting12 = Toolkit.getDefaultToolkit().getImage("12.jpeg");
    public Image painting13 = Toolkit.getDefaultToolkit().getImage("13.jpeg");
    public Image painting14 = Toolkit.getDefaultToolkit().getImage("14.jpeg");
    public Image painting15 = Toolkit.getDefaultToolkit().getImage("15.jpeg");
    public Image painting16 = Toolkit.getDefaultToolkit().getImage("16.jpeg");
    public Image painting17 = Toolkit.getDefaultToolkit().getImage("17.jpeg");
    public Image painting18 = Toolkit.getDefaultToolkit().getImage("18.jpeg");
    public Image painting19 = Toolkit.getDefaultToolkit().getImage("19.jpeg");
    public Image painting20 = Toolkit.getDefaultToolkit().getImage("20.jpeg");
    public Image painting21 = Toolkit.getDefaultToolkit().getImage("21.jpeg");
    public Image painting22 = Toolkit.getDefaultToolkit().getImage("22.jpeg");
    public Image painting23 = Toolkit.getDefaultToolkit().getImage("23.jpeg");
    public Image painting24 = Toolkit.getDefaultToolkit().getImage("24.jpeg");
    public Image painting25 = Toolkit.getDefaultToolkit().getImage("25.jpeg");
    public Image painting26 = Toolkit.getDefaultToolkit().getImage("26.jpeg");
    public Image painting27 = Toolkit.getDefaultToolkit().getImage("27.jpeg");
    public Image painting28 = Toolkit.getDefaultToolkit().getImage("28.jpeg");
    public Image painting29 = Toolkit.getDefaultToolkit().getImage("29.jpeg");
    public Image painting30 = Toolkit.getDefaultToolkit().getImage("30.jpeg");
    public Image painting31 = Toolkit.getDefaultToolkit().getImage("31.jpeg");
    public Image painting32 = Toolkit.getDefaultToolkit().getImage("32.jpeg");
    public Image painting33 = Toolkit.getDefaultToolkit().getImage("33.jpeg");



    // Main method definition
    // This is the code that runs first and automatically
    public static void main(String[] args) {
        Main ex = new Main();
        new Thread(ex).start();
    }

    // Constructor Method
    // This has the same name as the class
    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public Main() {
        setUpGraphics();
        for(int x =0;x<paintingArray.length;x++){
            paintingArray[x] = new Painting(0,0,0,0);
        }
        //image stuff
        startButton = Toolkit.getDefaultToolkit().getImage("playButton.png");
        startScreen = Toolkit.getDefaultToolkit().getImage("start screen.png");
        endScreen = Toolkit.getDefaultToolkit().getImage("end screen.png");
        background = Toolkit.getDefaultToolkit().getImage("background.jpg");



        //Mouse stuff
        canvas.addMouseListener(this);
    }


//*******************************************************************************
//User Method Section
//
// put your code to do things here.

    // main thread
    // this is the code that plays the game after you set things up
    public void run() {
        paintingArray[1].image=painting33;
        paintingArray[1].set(0,700,100,100,4,20);
        paintingArray[1].stopped = false;
        while (true) {
            previousMouseX = mouseX;
            previousMouseY = mouseY;
            mousePosition = MouseInfo.getPointerInfo().getLocation();
            mouseX = mousePosition.x;
            mouseY = mousePosition.y-65;
            distanceMoved=Math.sqrt(Math.pow(mouseX-previousMouseX,2)+Math.pow(mouseY-previousMouseY,2));
            if(isPlaying) {
                moveThings();
            }//move all the game objects
            render();  // paint the graphics
            pause(16); // sleep for 10 ms
            if(isPlaying){
                numberOfLoops++;
            }
            if(numberOfLoops==125){
                //send out more paintings
                numberOfLoops=0;

                int numberOfPaintings = RandomInt(0,3);
                if(numberOfPaintings==0){

                } else {
                    for(int x =0;x<numberOfPaintings;x++){
                        int paintingChoice = RandomInt(1,33);
                        if(paintingChoice==1){paintingArray[x].image=painting1;}
                        if(paintingChoice==2){paintingArray[x].image=painting2;}
                        if(paintingChoice==3){paintingArray[x].image=painting3;}
                        if(paintingChoice==4){paintingArray[x].image=painting4;}
                        if(paintingChoice==5){paintingArray[x].image=painting5;}
                        if(paintingChoice==6){paintingArray[x].image=painting6;}
                        if(paintingChoice==7){paintingArray[x].image=painting7;}
                        if(paintingChoice==8){paintingArray[x].image=painting8;}
                        if(paintingChoice==9){paintingArray[x].image=painting9;}
                        if(paintingChoice==10){paintingArray[x].image=painting10;}
                        if(paintingChoice==11){paintingArray[x].image=painting11;}
                        if(paintingChoice==12){paintingArray[x].image=painting12;}
                        if(paintingChoice==13){paintingArray[x].image=painting13;}
                        if(paintingChoice==14){paintingArray[x].image=painting14;}
                        if(paintingChoice==15){paintingArray[x].image=painting15;}
                        if(paintingChoice==16){paintingArray[x].image=painting16;}
                        if(paintingChoice==17){paintingArray[x].image=painting17;}
                        if(paintingChoice==18){paintingArray[x].image=painting18;}
                        if(paintingChoice==19){paintingArray[x].image=painting19;}
                        if(paintingChoice==20){paintingArray[x].image=painting20;}
                        if(paintingChoice==21){paintingArray[x].image=painting21;}
                        if(paintingChoice==22){paintingArray[x].image=painting22;}
                        if(paintingChoice==23){paintingArray[x].image=painting23;}
                        if(paintingChoice==24){paintingArray[x].image=painting24;}
                        if(paintingChoice==25){paintingArray[x].image=painting25;}
                        if(paintingChoice==26){paintingArray[x].image=painting26;}
                        if(paintingChoice==27){paintingArray[x].image=painting27;}
                        if(paintingChoice==28){paintingArray[x].image=painting28;}
                        if(paintingChoice==29){paintingArray[x].image=painting29;}
                        if(paintingChoice==30){paintingArray[x].image=painting30;}
                        if(paintingChoice==31){paintingArray[x].image=painting31;}
                        if(paintingChoice==32){paintingArray[x].image=painting32;}
                        if(paintingChoice==33){paintingArray[x].image=painting33;}
                        int param_xpos = RandomInt(0,1000);
                        if(param_xpos>=500){
                            paintingArray[x].set(param_xpos,700,RandomInt(30,100), RandomInt(75,150),RandomInt(-5,1),RandomInt(15,30));
                        } else {
                            paintingArray[x].set(param_xpos,700,RandomInt(30,100), RandomInt(75,150),RandomInt(1,5),RandomInt(15,30));
                        }
                        paintingArray[x].stopped=false;
                    }
                }
            }
        }
    }


    public void moveThings() {
        for(int x = 0;x<paintingArray.length;x++){
            paintingArray[x].move();
            if(paintingArray[x].dy<0&&paintingArray[x].ypos>700&&!paintingArray[x].stopped){
                paintingArray[x].dy=5;
                if(playerLives !=0) {
                    playerLives--;
                }
                paintingArray[x].xpos=2000;
                paintingArray[x].stop();
            }
            if(insidePainting(x)&&distanceMoved>=40){
                paintingArray[x].stop();
                paintingArray[x].ypos=10000;
                score+=10;
            }
        }

    }

    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time ){
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
    }
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setFont(new Font("Arial",Font.PLAIN,24));
        //start screen
        if(isStartScreen) {
            g.drawImage(startScreen,0,0,WIDTH,HEIGHT,null);
            g.drawImage(startButton, 1000/2-150/2, 700/2-150/2+250, 150, 150, null);
        }

        //game screen
        if(isPlaying && isPlayerAlive) {
            g.setColor(Color.BLACK);
            g.drawImage(background,0,0,WIDTH,HEIGHT,null);
            g.drawString("Lives: " + playerLives, 800, 95);
            g.drawString("Score: " + score, 800, 125);
            g.setColor(Color.darkGray);
            g.drawRect(801-5,83-10,100,25);
            g.drawRect(801-5,83+20,125,25);
            //render pictures
        }

        //end screen
        if(playerLives == 0) {
            isPlaying = false;
            isPlayerAlive = false;
            g.drawImage(endScreen,0,0,WIDTH,HEIGHT,null);
            g.drawImage(startButton, 1000/2-150/2, 700/2-150/2+250, 150, 150, null);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial",Font.PLAIN,100));
            g.setColor(Color.RED);
            g.drawString(String.valueOf(score),500-g.getFontMetrics().stringWidth(String.valueOf(score))/2,300);
            for (int x =0;x<4;x++){
                paintingArray[x].stop();
                paintingArray[x].ypos = 800;
            }

        }
        System.out.println();

        if(playerLives != 0) {
            for(int x = 0;x<paintingArray.length;x++){
                if(!paintingArray[x].stopped) {
                    g.drawImage(paintingArray[x].image,(int)paintingArray[x].xpos,(int)paintingArray[x].ypos,(int)paintingArray[x].width,(int)paintingArray[x].height,null);
                }
            }
        }

        g.dispose();
        bufferStrategy.show();
    }

    @Override
    public void mousePressed (MouseEvent e){
        mouseDown = true;
    }
    @Override
    public void mouseDragged (MouseEvent e){

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseReleased (MouseEvent e){
        mouseDown = false;
    }

    @Override
    public void mouseEntered (MouseEvent e){

    }

    @Override
    public void mouseExited (MouseEvent e){

    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int x,y;
        x = e.getX();
        y = e.getY();

        if(isStartScreen) {
            if(x > 1000/2-150/2 && x<1000/2-150/2+150 && y>700/2-150/2+250 && y<700/2-150/2+250+150) {
                isStartScreen = false;
                isPlayerAlive = true;
                isPlaying = true;
                long startTime = System.currentTimeMillis();
            }
        }
        //end screen
        if(isPlayerAlive == false) {
            if(x > 1000/2-150/2 && x<1000/2-150/2+150 && y>700/2-150/2+250 && y<700/2-150/2+250+150) {
                isPlaying = true;
                isPlayerAlive = true;
                playerLives = 10;
                score = 0;
            }


        }
    }
}

