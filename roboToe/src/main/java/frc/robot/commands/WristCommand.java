package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class WristCommand extends CommandBase {
  boolean buttonReleased;
  int leftWristEncoder;
  int rightWristEncoder;
  int wristDownSetPoint; 
  int wristUpSetPoint;
  boolean wristUp;
  boolean wristDown;
  boolean moveWrist;
  double wristDistance;

  public WristCommand(double wristDistance) {
    requires(wrist);
    // Use requires() here to declare subsystem dependencies
    wristDownSetPoint = 70;
    wristUpSetPoint = 0;
    wristUp = false;
    wristDown = false;
    // moveWrist;
    this.wristDistance = wristDistance;

    RobotLog.putMessage("Running WristCommand");
    leftWristEncoder = wrist.getLeftWristEncoder();
    rightWristEncoder = wrist.getRightWristEncoder();
    this.wristDistance = wristDistance;
  }

  protected void initialize() {

    // Set point
    // Send PID to correct motors
    wrist.setWristSetpoint(wristDistance + Constants.defaultWristPosition);

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
    drive.setBoth(0, 0);
    wrist.setBothWristMotor(0, 0);
  }

  protected void interrupted() {
    wrist.setBothWristMotor(0, 0);
  }
}