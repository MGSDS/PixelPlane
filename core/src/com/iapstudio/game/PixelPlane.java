package com.iapstudio.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class PixelPlane extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "PixelPlane";
	private GameStateManager gsm;
	private SpriteBatch sb;
	private SpriteBatch s;
	private Music music;

	public void create () {
		sb = new SpriteBatch();
		s = new SpriteBatch();
		music=Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setVolume(0.2f);
		music.setLooping(true);
		music.play();
		gsm=new GameStateManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(sb);
		gsm.render(s);

	}

	@Override
	public void dispose() {
		super.dispose();
		music.dispose();
	}
}
