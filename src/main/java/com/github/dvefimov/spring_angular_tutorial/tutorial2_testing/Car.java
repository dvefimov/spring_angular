package com.github.dvefimov.spring_angular_tutorial.tutorial2_testing;

/**
 * Created with IntelliJ IDEA.
 * User: техно сити
 * Date: 22.11.14
 * Time: 18:49
 * To change this template use File | Settings | File Templates.
 */
public class Car {
    private Engine engine;

    private String warningMessage;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void accelerate(){
        engine.increaseRpm();

        if(engine.getRpm() > 5000){
            warningMessage = "Slow Down!";
        }
    }

    public String getWarningMessage() {
        return warningMessage;
    }

    public void setWarningMessage(String warningMessage) {
        this.warningMessage = warningMessage;
    }
}
