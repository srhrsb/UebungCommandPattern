import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<Command> commands;
    private DriveCommand drive;
    private StopCommand stop;
    private BackCommand back;

    private Invoker invoker;

    public Controller(){
        commands = new ArrayList<>();
        invoker = new Invoker();
        Car car = new Car();

        drive = new DriveCommand( car );
        stop = new StopCommand( car );
        back = new BackCommand( car );

        drive();
        stop();
        back();

        replay();

        doStep(2);
    }

    private void back(){
        invoker.invoke( back );
        commands.add(back);
    }

    private void stop(){
        invoker.invoke( stop );
        commands.add(stop);
    }

    private void drive(){
        invoker.invoke( drive );
        commands.add(drive);
    }

    private void replay(){
        for(var command : commands){
            invoker.invoke(command);
        }
    }

    private void doStep( int step ){
        invoker.invoke(commands.get(step));
    }

    public static void main(String[] args) {
        new Controller();
    }
}