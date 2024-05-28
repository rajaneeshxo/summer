package io.rjnsh.summer.designpatterns.adapter.squaretorectangle;

// Adapter implementation
// target : Rectangle
// adaptee interface : Square
public class SquareToRectangleAdapter implements Rectangle {
    // adapter has an adaptee instance
    private Square square;
    public SquareToRectangleAdapter(Square square) {
        this.square = square;
    }
    
    public int getWidth() {
        return square.getSize();
    }

    @Override
    public int getHeight() {
        return square.getSize();
    }

}
