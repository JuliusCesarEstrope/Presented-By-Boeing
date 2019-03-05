package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.utilities.RobotLog;
import frc.robot.Constants;

public class FourBarCommand extends CommandBase {
  int leftBarEncoder, rightBarEncoder; // change
  double fourBarSetPoint;

  public FourBarCommand(double fourBarSetPoint) {
    // Use requires() here to declare subsystem dependencies
    requires(fourBar);
    leftBarEncoder = fourBar.getLeftBarEncoder();
    rightBarEncoder = fourBar.getRightBarEncoder();
    this.fourBarSetPoint = fourBarSetPoint;
    
  }

  protected void initialize() {
    RobotLog.putMessage("Running FourBarCommand");
    // send pid to correct motors
    fourBar.setBothFourBarMotor(0, 0);
   
  }

  protected void execute() {
    fourBar.setFourBarSetPoint(fourBarSetPoint);
    fourBar.setBothFourBarMotor(fourBar.getFourBarPIDOutput());

    SmartDashboard.putNumber("LeftFourBarEncoder", fourBar.getLeftBarEncoder());
    SmartDashboard.putNumber("RightFourBarEncoder", fourBar.getRightBarEncoder());
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
  }

  protected void interrupted() {
  }
}