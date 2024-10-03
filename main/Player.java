package main;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Player {
    //size
    double w = 32;//width
    double h = 32;//height

    //position
    double x = 320;
    double y = 575;

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
    public Player(double xPos, double yPos){
        x = xPos;
        y = yPos;
    }
    public Player(){}

    //
    public void update(Input input, ArrayList<Projectile> projectiles){
        //movement
        x += vx;
        y += vy;
        vx *= xfriction;
        vy *= yfriction;
        if(input.rightHeld){
            vx += xspeed;
        }
        if(input.leftHeld){
            vx += -xspeed;
        }
        if(input.downHeld){
            vy += yspeed;
        }
        if(input.upHeld){
            vy += -yspeed;
        }
        x = Funcs.mid(0,x,640);
        y = Funcs.mid(0,y,640);

        //fire
        if(input.fire){
            projectiles.add(new Projectile(x, y-h/2, 0, -10, true));
        }
        
    }

    public void draw(Graphics2D g){
        g.fillRect( (int)x - (int)(w/2), (int)y - (int)(h/2), (int)w, (int)h);
    }
}
