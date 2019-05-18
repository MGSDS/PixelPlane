package com.iapstudio.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class Plane {
    private static final int MOVE=100;
    private static final int GRAVITY = -15;

    private Vector3 pos;
    private  Vector3 vel;
    private Rectangle PlaneRect;
    private Animation planeAnimation;
    private Texture plane;
    public Sound music;
    public Plane(int x, int y){
        music = Gdx.audio.newSound(Gdx.files.internal("sfx_wing.ogg"));
        plane=new Texture("planeanimation.png");
        planeAnimation =new Animation(new TextureRegion(plane),0.5f,3);
        pos=new Vector3(x,y,0);
        vel=new Vector3(0,0,0);
        PlaneRect =new Rectangle(x,y,plane.getWidth()/3,plane.getHeight());

    }
    public void update(float dt) {
        if(pos.y>=0) vel.add(0, GRAVITY, 0);
            vel.scl(dt);
            pos.add(MOVE * dt, vel.y, 0);
            vel.scl(1 / dt);
        if(pos.y<0) pos.y = 0;
        PlaneRect.setPosition(pos.x,pos.y);
        planeAnimation.update(dt);

    }


    public Vector3 getPos() {
        return pos;
    }

    public void fly(){
        music.play();
    vel.y=250;
    }
    public Rectangle birdBox(){
        return PlaneRect;
    }
    public TextureRegion getBird(){
        return planeAnimation.getFrame();
    }
    public void dispose(){
        plane.dispose();
        music.dispose();
    }

}
