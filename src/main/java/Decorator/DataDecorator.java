package Decorator;

public class DataDecorator implements DecoratorInterface {

    private final DecoratorInterface dec;

    public DataDecorator(DecoratorInterface dec) {
        this.dec = dec;
    }

    @Override
    public void writeData() throws Exception {
        dec.writeData();
    }

    @Override
    public String readData() {
        return dec.readData();
    }
}