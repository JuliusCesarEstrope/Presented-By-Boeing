package frc.robot.commands;

import frc.robot.utilities.RobotLog;

public class ElevatorInPlaceCommand extends CommandBase {

  public ElevatorInPlaceCommand() {
    requires(elevatorHorizontal);
    requires(drive);
  }

  protected void initialize() {
    RobotLog.putMessage("Running ElevatorInPlaceCommand");
    drive.setBoth(0, 0);
  }

  protected void execute() {
    if (!elevatorHorizontal.getfastSlowStopSensor()) {
      elevatorHorizontal.setXElevatorMotors(-.4);
    } else {
      elevatorHorizontal.setXElevatorMotors(0);
    }

  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    drive.setBoth(0, 0);
  }

  protected void interrupted() {
    drive.setBoth(0, 0);
  }
}