package model;

import controller.Controller;

public class Car {
    private Controller controller;

    public Car( Controller controller){
        this.controller = controller;
    }


    public void drive(){
        controller.showAction("Das Auto fährt gerade aus");
    }

    public void stop(){
        controller.showAction("Das Auto hält an");
    }

    public void back(){
        controller.showAction("Das Auto fährt rückwärts");
    }

    public void left(){
        controller.showAction("Das Auto fährt links");
    }

    public void right(){
        controller.showAction("Das Auto fährt rechts");
    }

}
