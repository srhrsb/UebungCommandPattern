package command;

import model.Car;

public class BackCommand implements Command {
    private Car car;
    public BackCommand( Car car){
        this.car = car;
    }
    @Override
    public void execute() {
        car.back();
    }
}
