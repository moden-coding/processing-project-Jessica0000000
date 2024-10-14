import processing.core.*;

public class App extends PApplet {
    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        background(119, 211, 242);

    }

    public void settings() {
        size(800, 600);
    }

    int scene = 0;
    int myHealth = 10;
    int mHealth = 10;
    int experience = 0;
    int level = 1;
    int color = 211;
    boolean isVisible = false;
    int frameWhenClicked = -30;
  

    public void draw() {

       //System.out.println("isVisible is " + isVisible);
     //  System.out.println("scene is " + scene);

        
            
            if (scene == 0) {
                background(119, color, 242);
               
                playButton();
                
                color = 10;

                if (mouseX > 200 && mouseX < 600 && mouseY < 330 && mouseY > 230) {
                    if (mousePressed) {
                        scene++;
                        isVisible = true;
                    }
                }
            
            if (scene == 1) {

                // line(x1, y1, x2, y2);
                background(119, color, 242);
                strokeWeight(5);
                line(197, 319, 140, 600);

                fill(0); // Set the text color to black
                text(mouseX + ", " + mouseY, 10, 20);

                fill(255);
                textSize(50);
             
              text("Click to attack", 409, 135);

                if (myHealth > 0 && mHealth > 0) {
                    mAttack();
                }

                if (mHealth > 0) {
                    strokeWeight(2);// this is the monster
                    fill(255);
                    ellipse(400, 280, 300, 300);
                    fill(0);
                    ellipse(348, 230, 70, 70);
                    fill(0);
                    ellipse(450, 230, 70, 70);
                }
            }
            
        }
            

            if (myHealth == 0) {
                youDied();
            }
        
    }

    public void mousePressed() {
        frameWhenClicked = frameCount;

        if (mHealth > 0 && scene == 1) {
            mHealth -= 1;

            System.out.println("Monster's health is " + mHealth);
            System.out.println("Experience is " + experience);
            System.out.println("Color is " + color);
            System.out.println("scene is " + scene);

        } else if (mHealth == 0) {

            monsterDead();
        }

    }

    public void monsterDead() {
        myHealth = 10;
        experience++;
        if (color < 250) {
            color += 20;
        } else if (color > 250) {
            color = 0;
        }
        mHealth += 5;
        isVisible = true;

    }

    public void mAttack() {
        delay(1000);

        myHealth -= 1;
        System.out.println("I attacked");
        System.out.println("Your health is " + myHealth);
    }

    public void youDied() {

        scene++;
        isVisible = false;
        background(119, 211, 242);

        fill(0); // Set the text color to black
        text(mouseX + ", " + mouseY, 10, 20);
        textSize(100);
        text("YOU DIED", 385, 237);

    }

    public void playButton() {
        fill(0);
        rect(200, 230, 400, 100);
        textSize(10);
        text(mouseX + ", " + mouseY, 10, 20);
        textSize(50);
        fill(255);
        text("Play", 360, 290);
        

    }
}
