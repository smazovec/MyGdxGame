package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {

  private SpriteBatch batch;
  private MyAnimation animatedSprite;
  private int xCoordinate;
  int direction = 1;

  @Override
  public void create() {
    batch = new SpriteBatch();
    animatedSprite = new MyAnimation("assets/animation-sprite.jpg", 6, 1, PlayMode.LOOP);
  }

  @Override
  public void render() {
    ScreenUtils.clear(1, 1, 1, 1);
    animatedSprite.setTime(Gdx.graphics.getDeltaTime());
    xCoordinate = xCoordinate + direction;

    if (xCoordinate > (Gdx.graphics.getHeight())) {
      direction = -1;
    } else if (xCoordinate < 0) {
      direction = 1;
    }

    if (direction == -1 && !animatedSprite.getFrame().isFlipX()) {
      animatedSprite.getFrame().flip(true, false);
    } else if (direction == 1 && animatedSprite.getFrame().isFlipX()) {
      animatedSprite.getFrame().flip(true, false);
    }

    batch.begin();
    batch.draw(animatedSprite.getFrame(), xCoordinate, 0);
    batch.end();
  }

  @Override
  public void dispose() {
    animatedSprite.dispose();
  }

}
