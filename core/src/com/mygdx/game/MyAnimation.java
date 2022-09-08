package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyAnimation {

  private Texture image;
  private Animation<TextureRegion> animation;
  private float time;

  public MyAnimation(String imageName, int columns, int rows, PlayMode playMode) {
    image = new Texture(imageName);
    TextureRegion sourceRegion = new TextureRegion(image);
    int xCenter = sourceRegion.getRegionWidth() / columns;
    int yCenter = sourceRegion.getRegionHeight() / rows;
    TextureRegion[][] sourceRegions = sourceRegion.split(xCenter, yCenter);
    TextureRegion[] resultRegions = new TextureRegion[(sourceRegions.length
        * sourceRegions[0].length)];

    int count = 0;
    for (int i = 0; i < sourceRegions.length; i++) {
      for (int j = 0; j < sourceRegions[0].length; j++) {
        resultRegions[count++] = sourceRegions[i][j];
      }
    }

    animation = new Animation<>(1 / 7f, resultRegions);
    animation.setPlayMode(playMode);
  }

  public TextureRegion getFrame() {
    return animation.getKeyFrame(time);
  }

  public void setTime(float time) {
    this.time += time;
  }

  public void setPlayMode(PlayMode playMode) {
    animation.setPlayMode(playMode);
  }

  public boolean isAnimationOver() {
    return animation.isAnimationFinished(time);
  }

  public void zeroTime() {
    this.time = 0;
  }

  public void dispose() {
    image.dispose();
  }

}
