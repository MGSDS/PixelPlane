package com.iapstudio.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuState extends State {
    private Texture bg;
    private Texture PlayBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        bg = new Texture("bg.png");
        PlayBtn = new Texture("playbtn.png");
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
        sb.draw(PlayBtn, cam.position.x-PlayBtn.getWidth()/2,cam.position.y);
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        PlayBtn.dispose();
    }
}
