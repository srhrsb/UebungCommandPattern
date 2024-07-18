import java.util.ArrayList;
import java.util.List;

public class Main {

    private List<Command> commands;

    public Main(){
        commands = new ArrayList<>();
        Invoker invoker = new Invoker();
        Car car = new Car();

        DriveCommand drive = new DriveCommand( car );
        StopCommand stop = new StopCommand( car );
        BackCommand back = new BackCommand( car );

        invoker.invoke( drive );
        commands.add(drive);

        invoker.invoke( stop );
        commands.add(stop);

        invoker.invoke( back );
        commands.add(back);


        for(var command : commands){
            invoker.invoke(command);
        }

    }

    public static void main(String[] args) {
        new Main();
    }
}