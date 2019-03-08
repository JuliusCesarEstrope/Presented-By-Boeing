package frc.robot.commands;

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

    // Set point
    // Send PID to correct motors
    wrist.setWristSetpoint(wristSetPoint);

  }

  @Override
  protected void execute() {
    // Two Positions (Up, Down)
    wrist.setBothWristMotor(wrist.getLeftWristPIDOutput());

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