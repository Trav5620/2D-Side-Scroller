package main;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {


    private static final long serialVersionUID = 6691247796639148462L;
    public static final int width = 640, height = width / 12 * 9;
    private Thread thread;
    private boolean running = false;
    private Handler handler;

    public Game(){
        handler = new Handler();

        new Window(width, height, "Wave Version 1.0", this);
    }

    public static void main(String args[]){
        new Game();
    }

    @Override
    public void run() {
        //THE GAME WILL NOT WORK WITHOUT A GAME LOOOP (updates the game etc)
        long lastTime = System.nanoTime();
        double amountofTicks = 60.0;
        double ns = 1000000000 / amountofTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void tick(){
        handler.tick();
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy(); //starts with value of null
        if(bs == null){
            this.createBufferStrategy(3); //Try not to go over 3
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, width, height);

        handler.render(g);

        g.dispose();
        bs.show();
    }
}
