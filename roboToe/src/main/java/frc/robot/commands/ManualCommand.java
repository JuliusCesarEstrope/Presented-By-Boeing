package frc.robot.commands;

import frc.robot.utilities.RobotLog;

public class ManualCommand extends CommandBase {

  public ManualCommand() {
    // Use requires() here to declare subsystem dependencies
    
    requires(wrist);
  }

  protected void initialize() {
    RobotLog.putMessage("Running ManualCommand");
    // send pid to correct motors
    
    wrist.setBothWristMotor(0, 0);
  }

  protected void execute() {
  
    
    /*
    if(((wrist.getWristAxis > 0) && (wrist.getLeftWristEncoder() >= Constants.wristMaxPosition))
    || ((wrist.getWristAxis < 0) && (wrist.getLeftWristEncoder() <= Constants.wristMinPosition))){
    wrist.setBothWristMotor(0, 0);
    */
       wrist.setBothWristMotor(oi.getWristAxis(), oi.getWristAxis());
    // }
    // else{
    //   wrist.setBothWristMotor(oi.getWristAxis(), oi.getWristAxis());
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