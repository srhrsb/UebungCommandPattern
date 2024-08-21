package command;

import model.Car;

public class LeftCommand implements Command {

    private Car car;
    public LeftCommand( Car car){
        this.car = car;
    }
    @Override
    public void execute() {
        car.left();
    }
}
