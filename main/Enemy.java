package main;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Enemy {
    //size
    double w = 32;//width
    double h = 32;//height

    //position
    double x = 320;
    double y = -100;

    //velocity, current speed of movement
    double vx = 0;
    double vy = 0;

    //friction, slow of movement
    double xfriction = .9;
    double yfriction = .9;

    //movement stats
    double xspeed = .66;
    double yspeed = .33;

    //
    public Enemy(double xPos, double yPos){
        x = xPos;
        y = yPos;
    }
    public Enemy(){}

    //
    public void update(ArrayList<Projectile> projectiles){}

    public void basics(ArrayList<Projectile> projectiles){
        //movement
        x += vx;
        y += vy;
        vx *= xfriction;
        vy *= yfriction;
    }

    public void draw(Graphics2D g){
        g.fillRect( (int)x - (int)(w/2), (int)y - (int)(h/2), (int)w, (int)h);
    }
}
