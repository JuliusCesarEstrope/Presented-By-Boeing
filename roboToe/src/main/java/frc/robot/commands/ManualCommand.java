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
    if(((fourBar.getRawAxis(1) > 0) && (fourBar.getRightBarEncoder() >= Constants.fourBarMaxPosition))
    || ((fourBar.getRawAxis(1) < 0) && (fourBar.getRightBarEncoder() <= Constants.fourBarMinPosition)) {
      fourBar.setBothFourBarMotor(0);
    }
    else{
      fourBar.setBothFourBarMotor(oi.getFourBarAxis() * 0.4);
    }*/
    fourBar.setBothFourBarMotor(oi.getFourBarAxis() * 0.4);
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