package com.iapstudio.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameOver extends State {
    private Texture bg;
    private Texture over;

    public GameOver(GameStateManager gsm) {
        super(gsm);
        bg = new Texture("bg.png");
        over = new Texture("gameover.png");
        cam.setToOrtho(false, PixelPlane.WIDTH/2, PixelPlane.HEIGHT/2);

    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new GameState(gsm));
        }
    }

    @Override
    public void update(float data) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, 0, 0);
        sb.draw(over, cam.position.x-over.getWidth()/2,cam.position.y);


        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        over.dispose();
    }
}
