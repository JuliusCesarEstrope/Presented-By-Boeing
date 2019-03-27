/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class LEDCommand extends CommandBase {
  Timer matchTimer;
  boolean turnBlue;
  boolean otherColor;
  Timer blinkTimer;
  public LEDCommand(Timer matchTimer) {
    requires(led);
    this.matchTimer = new Timer();
    this.matchTimer = matchTimer;
    blinkTimer = new Timer();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    led.setLEDLightColor(0.87);
    blinkTimer.start();
    turnBlue = false;
    otherColor = true;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
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
      
    } else if(matchTimer.get() >= 105 && matchTimer.get() <=110) {
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

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    led.setLEDLightColor(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    led.setLEDLightColor(0);
  }
}
