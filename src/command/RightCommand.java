package command;

import model.Car;

public class RightCommand implements Command{
    private Car car;
    public RightCommand( Car car ){
        this.car = car;
    }
    @Override
    public void execute() {
        car.right();
    }
}
