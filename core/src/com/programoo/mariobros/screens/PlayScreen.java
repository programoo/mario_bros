package com.programoo.mariobros.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.programoo.mariobros.MarioBros;
import com.programoo.mariobros.scenes.Hud;

public class PlayScreen implements Screen {
    private MarioBros game;

    private OrthographicCamera gamecam;
    private Viewport gamePort;
    private Hud hud;

    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    public PlayScreen(MarioBros game){
        // GAME CAM
        this.game = game;
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(MarioBros.V_WIDTH, MarioBros.V_HEIGHT, gamecam);
        // HUD for scores, info
        hud = new Hud(game.batch);

        //MAP LOADER
        mapLoader = new TmxMapLoader();
        map = mapLoader.load("level1.tmx");

        renderer = new OrthogonalTiledMapRenderer(map);

        gamecam.position.set(gamePort.getWorldWidth()/2, gamePort.getWorldHeight()/2, 0);
    }
    public void handleInput(float dt){
        if(Gdx.input.isTouched()){
            gamecam.position.x += 100 * dt;
        }
    }

    public void update(float dt){
        handleInput(dt);
        gamecam.update();
        renderer.setView(gamecam);
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update((delta));

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
