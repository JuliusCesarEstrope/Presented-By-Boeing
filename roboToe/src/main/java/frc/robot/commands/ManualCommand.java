package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class ManualCommand extends CommandBase {

  public ManualCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(fourBar);
    requires(wrist);
  }

  protected void initialize() {
    RobotLog.putMessage("Running ManualCommand");
    // send pid to correct motors
    fourBar.setBothFourBarMotor(0, 0);
    wrist.setBothWristMotor(0, 0);
  }

  protected void execute() {
    /*
    if(fourBar.getRightBarEncoder() < Constants.fourbarMaxPosition  fourBar.getRightBarEncoder() > Constants.fourbarMinPosition){
      fourBar.setBothFourBarMotor(oi.getFourBarAxis() * 0.4);
    }
    else{
      fourBar.setBothFourBarMotor(0);
    }*/
    fourBar.setBothFourBarMotor(oi.getFourBarAxis() * 0.4);
    // if(wrist.getLeftWristEncoder() < Constants.wristMaxPosition && wrist.getLeftWristEncoder() > Constants.wristMinPosition && fourBar.getLeftBarEncoder() > Constants.fourbarSafeWristPosition){
       wrist.setBothWristMotor(oi.getWristAxis(), oi.getWristAxis());
    // }
    // else{
    //   wrist.setBothWristMotor(0, 0);
    // }

  }

  protected boolean isFinished() {
    return !oi.getManualOverrideButton();
  }

  protected void end() {
  }

  protected void interrupted() {
  }
}