package main;
import java.awt.Graphics2D;

public class Projectile {

    boolean delete = false;

    boolean player;

    //pos
    double x;
    double y;
    //size
    double w = 8;
    double h = 8;
    //velocity / speed
    double vx;
    double vy;
    //slow / friction / speed-up
    double vxMod = 1;
    double vyMod = 1;
    //if life is 0 it only is destroyed when off screen
    double life = 0;

    public Projectile(double xPos, double yPos, double velX, double velY, boolean playerShot){
        x = xPos;
        y = yPos;
        vx = velX;
        vy = velY;
        player = playerShot;
    }

    //
    public void update(){
        x += vx;
        y += vy;
        vx *= vxMod;
        vy *= vyMod;

        if(y != Funcs.mid(-100,y,740) || x != Funcs.mid(-100,x,740))
            delete = true;
    }

    public void draw(Graphics2D g){
        g.fillRect( (int)x - (int)(w/2), (int)y - (int)(h/2), (int)w, (int)h);
    }
    
}
