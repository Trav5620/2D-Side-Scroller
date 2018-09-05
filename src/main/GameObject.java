package main;

import java.awt.*;

public abstract class GameObject {

    protected int x, y;
    protected ID id;
    protected int volX, volY;

    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setID(ID id){
        this.id = id;
    }

    public void setVolX(int volX){
        this.volX = volX;
    }

    public void setVolY(int volY){
        this.volY = volY;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public ID getID(){
        return id;
    }

    public int getVolX(){
        return volX;
    }

    public int getVolY(){
        return volX;
    }

}
