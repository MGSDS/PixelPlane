package com.iapstudio.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Building {
    private static final int FLUCT = 130;
    private static final int GAP = 100;
    private static final int LOWGAP=120;
    public static final int BUILDINGS_WIDTH =52;
    private Texture upBuilding, lowBuilding;
    private Vector2 upBuildingPos, lowBuildingPos;
    private Random rand;
    private Rectangle rectUp,rectLow;

    public Building(float x) {
       upBuilding =new Texture("topbuilding.png");
       lowBuilding =new Texture("bottombuilding.png");
       rand=new Random();
       upBuildingPos = new Vector2(x,rand.nextInt(FLUCT)+GAP+LOWGAP);
       lowBuildingPos =new Vector2(x, upBuildingPos.y-GAP- lowBuilding.getHeight());
       rectUp=new Rectangle(upBuildingPos.x, upBuildingPos.y, upBuilding.getWidth(), upBuilding.getHeight());
       rectLow=new Rectangle(lowBuildingPos.x, lowBuildingPos.y, lowBuilding.getWidth(), lowBuilding.getHeight());
    }

    public Texture getUpBuilding() {
        return upBuilding;
    }

    public Texture getLowBuilding() {
        return lowBuilding;
    }

    public Vector2 getUpBuildingPos() {
        return upBuildingPos;
    }

    public Vector2 getLowBuildingPos() {
        return lowBuildingPos;
    }
    public void run(float x){
        upBuildingPos.set(x,rand.nextInt(FLUCT)+GAP+LOWGAP);
        lowBuildingPos.set(x, upBuildingPos.y-GAP- lowBuilding.getHeight());
        rectUp.setPosition(upBuildingPos.x, upBuildingPos.y);
        rectLow.setPosition(lowBuildingPos.x, lowBuildingPos.y);

    }
    public boolean Die(Rectangle player){
    return player.overlaps(rectUp)||player.overlaps(rectLow);
    }
    public void dispose(){
        upBuilding.dispose();
        lowBuilding.dispose();
    }
}
