package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class WristCommand extends CommandBase {

  int leftWristEncoder;
  int rightWristEncoder;
  double wristSetPoint;

  public WristCommand(double wristSetPoint) {
    requires(wrist);
    // Use requires() here to declare subsystem dependencies
    RobotLog.putMessage("Running WristCommand");
    leftWristEncoder = wrist.getLeftWristEncoder();
    rightWristEncoder = wrist.getRightWristEncoder();
    this.wristSetPoint = wristSetPoint;
  }

  protected void initialize() {

  }

  @Override
  protected void execute() {
    // Two Positions (Up, Down)
    wrist.setBothWristMotor(wrist.getLeftWristPIDOutput());
    SmartDashboard.putNumber("LeftWristEncoder", wrist.getLeftWristEncoder());
    SmartDashboard.putNumber("RightWristEncoder", wrist.getRightWristEncoder());
    
  }

  protected boolean isFinished() {
    // if needed to maintain set pont (false) stopping point (true)
    return wrist.leftWristOnTarget();
  }

  protected void end() {
    //drive.setBoth(0, 0);
    wrist.setBothWristMotor(0, 0);
  }

  protected void interrupted() {
    wrist.setBothWristMotor(0, 0);
  }
}