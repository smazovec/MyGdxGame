package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyAnimation {

  private TextureAtlas atlas;
  private Texture image;
  private Animation<TextureRegion> textureRegionAnimation;
  private Animation<AtlasRegion> atlasRegionAnimation;
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

    textureRegionAnimation = new Animation<>(1 / 7f, resultRegions);
    textureRegionAnimation.setPlayMode(playMode);
  }

  public MyAnimation(String atlasName, PlayMode playMode, String regionName) {
    this.atlas = new TextureAtlas(atlasName);
    atlasRegionAnimation = new Animation<>(1 / 7f, this.atlas.findRegions(regionName));
    atlasRegionAnimation.setPlayMode(playMode);
  }

  public TextureRegion getFrame() {
    return textureRegionAnimation.getKeyFrame(time);
  }

  public void setTime(float time) {
    this.time += time;
  }

  public void setPlayMode(PlayMode playMode) {
    textureRegionAnimation.setPlayMode(playMode);
  }

  public boolean isAnimationOver() {
    return textureRegionAnimation.isAnimationFinished(time);
  }

  public void zeroTime() {
    this.time = 0;
  }

  public void dispose() {
    image.dispose();
    atlas.dispose();
  }

}
