package io.rjnsh.summer.designpatterns.adapter.squaretorectangle;

public class RectangleImpl implements Rectangle {
    int height;
    int width;

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }
    
}
