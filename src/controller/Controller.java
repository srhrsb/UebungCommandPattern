package controller;

import command.*;
import model.Car;
import view.MainView;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private MainView view;

    private List<Command> commands;
    private DriveCommand driveCmd;
    private StopCommand stopCmd;
    private BackCommand backCmd;
    private LeftCommand leftCmd;
    private RightCommand rightCmd;

    private Invoker invoker;

    public Controller(){
        view = new MainView(450,700);
        commands = new ArrayList<>();
        invoker = new Invoker();
        Car car = new Car(this);

        driveCmd = new DriveCommand( car );
        stopCmd = new StopCommand( car );
        backCmd = new BackCommand( car );
        leftCmd = new LeftCommand( car );
        rightCmd = new RightCommand( car );

        view.addCmdButtonHandler(this::performCommand);
        view.addReplayButtonHandler(this::repeatCommands);
        view.addClearButtonHandler(this::clearActionList);
    }

  public  void  performCommand(ActionEvent event){

        String cmdString = event.getActionCommand();
        Command cmd;

        switch(cmdString){
            case "Drive": cmd = driveCmd; break;
            case "Back": cmd = backCmd; break;
            case "Left": cmd = leftCmd; break;
            case "Right": cmd = rightCmd; break;
            default: cmd = stopCmd;
        }

      invoker.invoke( cmd );
      commands.add(cmd);
  }



  public void showAction( String action ){
      view.addActionToList(action);
  }

  public void repeatCommands( ActionEvent event){
        for (var cmd : commands){
            invoker.invoke(cmd);
        }
  }

  public void clearActionList( ActionEvent event ){
        view.clearActionList();
  }

    public static void main(String[] args) {
        new Controller();
    }
}