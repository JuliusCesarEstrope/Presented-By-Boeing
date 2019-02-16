package frc.robot.commands;

import frc.robot.utilities.RobotLog;

public class WristCommand extends CommandBase {
  boolean buttonReleased;
  int leftWristEncoder;
  int rightWristEncoder;
  int wristDownSetPoint = 70;
  int wristUpSetPoint = 0;
  boolean wristUp = false;
  boolean wristDown = false;
  boolean moveWrist;

  public WristCommand() {
    RobotLog.putMessage("Running WristCommand");
    requires(wrist);
    leftWristEncoder = wrist.getLeftWristEncoder();
    rightWristEncoder = wrist.getRightWristEncoder();
  }

  protected void initialize() {
    // Set point
    // Send PID to correct motors

    buttonReleased = true;
    moveWrist = false;

    wrist.ResetEncoder();
    wrist.getLeftWristPIDOutput();
    wrist.getRightWristPIDOutput();
    // wrist.setLeftWristSetpoint(leftWristEncoder);
    // wrist.setRightWristSetpoint(rightWristEncoder);
  }

  @Override
  protected void execute() {
    // Two Positions (Up, Down)

    if (moveWrist && leftWristEncoder <= 0 && rightWristEncoder >= 0) {
      wrist.setBothWristMotor(-0.70, 0.70);
    }

    else if (!moveWrist && leftWristEncoder >= 0 && rightWristEncoder <= 0) {
      wrist.setBothWristMotor(0.70, -0.70);
    }

    if (wristUp && leftWristEncoder >= 0 && rightWristEncoder <= 0) {
      wrist.setWristUpSetpoint(wristUpSetPoint);

    }

    if (wristDown && rightWristEncoder >= 0 && leftWristEncoder <= 0) {
      wrist.setWristDownSetpoint(wristDownSetPoint);
    }
  }

  protected boolean isFinished() {
    // if needed to maintain set pont (false) stopping point (true)
    return false;
  }

  protected void end() {
  }

  protected void interrupted() {
  }
}