package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {

  SpriteBatch batch;
  Texture img;
  Texture ufo;
  int clicker;

  @Override
  public void create() {
    batch = new SpriteBatch();
    img = new Texture("space.png");
    ufo = new Texture("ufo.png");
  }

  @Override
  public void render() {
    ScreenUtils.clear(1, 0, 0, 1);

    float x = Gdx.input.getX() - 50;
    float y = Gdx.graphics.getHeight() - Gdx.input.getY() - 50;

    if (Gdx.input.isButtonJustPressed(Buttons.LEFT)) {
      clicker++;
      Gdx.graphics.setTitle("Clicked " + clicker);
    }

    batch.begin();
    batch.draw(img, 0, 0);
    batch.draw(ufo, x, y, 100, 100);
    batch.end();
  }

  @Override
  public void dispose() {
    batch.dispose();
    img.dispose();
  }

}
