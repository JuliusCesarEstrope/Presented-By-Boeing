package frc.robot.commands;

import frc.robot.utilities.RobotLog;

public class ElevatorHorizontalCommand extends CommandBase {
  int tapeHit;
  boolean tapeToggle;

  public ElevatorHorizontalCommand() {
    requires(elevatorHorizontal);
    requires(drive);
  }

  protected void initialize() {
    RobotLog.putMessage("Running ElevatorHorizontalCommand");
    drive.setBoth(0, 0);
    tapeToggle = true;
  }

  protected void execute() {
    if (elevatorHorizontal.getfastSlowStopSensor() && tapeToggle) {
      tapeHit++;
      tapeToggle = false;
    } else if (!elevatorHorizontal.getfastSlowStopSensor()){
      tapeToggle = true;
    }

    if (tapeHit == 0) {
      elevatorHorizontal.setXElevatorMotors(.6);

    } else if (tapeHit == 1) {
      elevatorHorizontal.setXElevatorMotors(.4);

    } else if (tapeHit == 2) {
      elevatorHorizontal.setXElevatorMotors(.2);
      drive.setBoth(.4, .4);

    } else if (tapeHit == 3) {
      elevatorHorizontal.setXElevatorMotors(0);

    }
  }

  protected boolean isFinished() {
    return ((tapeHit == 3) || oi.getElevatorEmergencyStopButton());
  }

  protected void end() {
    drive.setBoth(0, 0);
  }

  protected void interrupted() {
    drive.setBoth(0, 0);
  }
}