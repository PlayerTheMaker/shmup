package main;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Runner extends JPanel implements Runnable{
    final int screenWidth = 640;
    final int screenHeight = 640;
    Thread gameThread;
    KeyHandler keyHandler = new KeyHandler();
    Input input = new Input();

    ArrayList<Player> Players = new ArrayList<Player>();
    ArrayList<Projectile> Projectiles = new ArrayList<Projectile>();

    final int FPS = 60;

    public Runner(){
        setPreferredSize(new Dimension(screenWidth,screenHeight));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        addKeyListener(keyHandler);
        setFocusable(true);
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
        Players.add(new Player());
    }

    public void run(){

        double targetFrameLength = 1000000000/FPS;
        double frameTime = System.nanoTime() + targetFrameLength;

        while(gameThread != null){
            input.update(keyHandler);            

            update();
            repaint();
            
            try{
                double excessTime = frameTime - System.nanoTime();
                excessTime /= 1000000;

                if (excessTime < 0){
                    return;
                }

                Thread.sleep((long)excessTime);

                frameTime += targetFrameLength;

            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    public void update(){
        //player update
        for(int playerNum = 0; playerNum < Players.size(); playerNum++){
            Players.get(playerNum).update(input,Projectiles);
        }
        //projectile update
        for(int projectileNum = 0; projectileNum < Projectiles.size(); projectileNum++){
            Projectile projectile = Projectiles.get(projectileNum);
            projectile.update();
            if(projectile.delete)
                Projectiles.remove(projectileNum);
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);

        //player draw
        for(int playerNum = 0; playerNum < Players.size(); playerNum++){
            Players.get(playerNum).draw(g2);
        }
        //projectile draw
        for(int projectileNum = 0; projectileNum < Projectiles.size(); projectileNum++){
            Projectiles.get(projectileNum).draw(g2);
        }

        g2.dispose();
    }
}
