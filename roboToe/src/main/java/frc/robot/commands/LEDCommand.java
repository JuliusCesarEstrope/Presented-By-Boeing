package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class LEDCommand extends CommandBase {
  Timer matchTimer;
  boolean turnBlue;
  boolean otherColor;
  Timer blinkTimer;
  public LEDCommand(Timer matchTimer) {
    requires(led);
    this.matchTimer = matchTimer;
    blinkTimer = new Timer();
  }

  protected void initialize() {
    led.setLEDLightColor(0.87);
    blinkTimer.start();
    turnBlue = false;
    otherColor = true;
  }

  protected void execute() {
    if(matchTimer.get() >= 60 && matchTimer.get() <=65) {
      if(turnBlue) {
        led.setLEDLightColor(0.87);
      } else if(otherColor) {
        led.setLEDLightColor(0.69);
      }
      if(blinkTimer.hasPeriodPassed(0.5)) {
        if(turnBlue && !otherColor) {
          turnBlue = false;
          otherColor = true;
        } else if(!turnBlue && otherColor) {
          turnBlue = true;
          otherColor = false;
        }

        blinkTimer.reset();
      }
      
    } else if(matchTimer.get() >= 120 && matchTimer.get() <=125) {
      if(turnBlue) {
        led.setLEDLightColor(0.87);
      } else if(otherColor) {
        led.setLEDLightColor(0.65);
      }

      if(blinkTimer.hasPeriodPassed(0.5)) {
        if(turnBlue && !otherColor) {
          turnBlue = false;
          otherColor = true;
        } else if(!turnBlue && otherColor) {
          turnBlue = true;
          otherColor = false;
        }
        blinkTimer.reset();
      }
    } else if(matchTimer.get() >= 120 && matchTimer.get() <=125) {
      if(turnBlue) {
        led.setLEDLightColor(0.87);
      } else if(otherColor) {
        led.setLEDLightColor(0.61);
      }

      if(blinkTimer.hasPeriodPassed(0.5)) {
        if(turnBlue && !otherColor) {
          turnBlue = false;
          otherColor = true;
        } else if(!turnBlue && otherColor) {
          turnBlue = true;
          otherColor = false;
        }
        blinkTimer.reset();
      }
    } else {
      led.setLEDLightColor(0.87);
      turnBlue = false;
      otherColor = true;
    }
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    led.setLEDLightColor(0);
  }

  protected void interrupted() {
    led.setLEDLightColor(0);
  }
}
