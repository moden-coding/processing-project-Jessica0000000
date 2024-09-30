import processing.core.*;

public class App extends PApplet{
    public static void main(String[] args)  {
        PApplet.main("App");
    }

    public void setup(){
        background(119, 211, 242);
    }

    public void settings(){
        size(800, 600);  
    }

    int myHealth = 100;
    int mHealth =10;

    public void draw(){
        background(119, 211, 242);
    fill(0);
        ellipse(400,280,300,300);

        fill(0);  // Set the text color to black
        text(mouseX + ", " + mouseY, 10, 20);

    }
}
