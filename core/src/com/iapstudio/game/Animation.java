package com.iapstudio.game;



import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;


public class Animation {
    private float currentFT;
    private float maxFT;
    private Array<TextureRegion> frames;
    private int frame;
    private int fCount;
    public Animation(TextureRegion reg, float cTime, int fCount){
       frames=new Array<TextureRegion>();
       int fWidth=reg.getRegionWidth()/fCount;
       for (int i = 0;i<fCount;i++) frames.add(new TextureRegion(reg, i*fWidth,0,fWidth,reg.getRegionHeight()));
       this.fCount= fCount;
       maxFT=cTime/fCount;
       frame=0;
    }

    public TextureRegion getFrame(){
        return frames.get(frame);
    }

    public void update(float dt){
        currentFT+=dt;
        if(currentFT>maxFT){
            currentFT=0;
            frame++;
        }
        if (frame>=fCount){
            frame=0;
        }
    }

}
