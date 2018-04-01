package com.programoo.mariobros.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.programoo.mariobros.MarioBros;

public class Hud {
    public Stage stage;
    private Viewport viewport;

    private Integer worldTimer;
    private float timeCount;
    private Integer score;
    Label countdownLabel;
    Label scoreLabel;
    Label timeLable;
    Label levelLable;
    Label worldLable;
    Label marioLable;

    public Hud(SpriteBatch sb){
        worldTimer = 300;
        timeCount = 0;
        score = 0;

        viewport = new FitViewport(MarioBros.V_WIDTH, MarioBros.V_HEIGHT, new OrthographicCamera());

        stage = new Stage(viewport, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        countdownLabel = new Label(String.format("%03d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLabel = new Label(String.format("%06d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        timeLable = new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        levelLable = new Label("1-1", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        worldLable = new Label("WORLD", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        marioLable = new Label("MARIO", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(marioLable).expandX().padTop(10);
        table.add(worldLable).expandX().padTop(10);
        table.add(timeLable).expandX().padTop(10);
        table.row();
        table.add(scoreLabel).expandX();
        table.add(levelLable).expandX();
        table.add(countdownLabel).expandX();

        stage.addActor(table);
    }
}
