package com.iapstudio.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class GameState extends State {
    private static final int BUILDINGS_SPACE = 125;
    private static final int BUILDINGS_CNT = 4;

    private Plane plane;
    private Texture bg;
    private Array<Building> buildings;
    private Texture ground;
    private Vector2 gr1tex, gr2tex;




    public GameState(GameStateManager gsm) {
        super(gsm);
        plane = new Plane(50, 300);
        cam.setToOrtho(false, PixelPlane.WIDTH / 2, PixelPlane.HEIGHT / 2);
        bg = new Texture("bg.png");
        buildings = new Array<Building>();
        ground = new Texture("ground.png");
        gr1tex = new Vector2(cam.position.x - cam.viewportWidth / 2, 0);
        gr2tex = new Vector2((cam.position.x - cam.viewportWidth / 2) + ground.getWidth(), 0);
        for (int i = 0; i < BUILDINGS_CNT; i++) {
            buildings.add(new Building(i * (BUILDINGS_SPACE + Building.BUILDINGS_WIDTH)));

        }
    }

    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            plane.fly();
        }
    }
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
        sb.draw(plane.getBird(), plane.getPos().x, plane.getPos().y);
        for (Building building : buildings) {
            sb.draw(building.getLowBuilding(), building.getLowBuildingPos().x, building.getLowBuildingPos().y);
            sb.draw(building.getUpBuilding(), building.getUpBuildingPos().x, building.getUpBuildingPos().y);
        }
        sb.draw(ground, gr1tex.x, -60);
        sb.draw(ground, gr2tex.x, -60);
        sb.end();
    }

    public void update(float dt) {
        plane.update(dt);
        handleInput();
        cam.position.x = plane.getPos().x + 80;
        for (int i = 0; i < buildings.size; i++) {
            Building building = buildings.get(i);
            if (cam.position.x - (cam.viewportWidth / 2) > building.getUpBuildingPos().x + building.getUpBuilding().getWidth()) {
                building.run(building.getUpBuildingPos().x + ((Building.BUILDINGS_WIDTH + BUILDINGS_SPACE) * BUILDINGS_CNT));
            }
            if (building.Die(plane.birdBox())) gsm.set(new GameOver(gsm));
        }
        cam.update();
        updateGround();
    }


    private void updateGround() {
        if (cam.position.x - (cam.viewportWidth / 2) > gr1tex.x + ground.getWidth())
            gr1tex.add(ground.getWidth() * 2, 0);
        if (cam.position.x - (cam.viewportWidth / 2) > gr2tex.x + ground.getWidth())
            gr2tex.add(ground.getWidth() * 2, 0);

    }
    public void dispose() {
        bg.dispose();
        ground.dispose();
        plane.dispose();
        for (Building building : buildings)
            building.dispose();
    }


}
