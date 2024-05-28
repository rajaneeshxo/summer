package io.rjnsh.summer.designpatterns.adapter.squaretorectangle;

// adaptee
public class SquareImpl implements Square{
    private int size;
    public SquareImpl(int size){
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }

}
