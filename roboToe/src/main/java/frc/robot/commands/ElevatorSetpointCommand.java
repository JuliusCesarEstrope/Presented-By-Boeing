package frc.robot.commands;

import frc.robot.utilities.RobotLog;

public class ElevatorSetpointCommand extends CommandBase {
  double elevatorVerticalSetpoint;

  public ElevatorSetpointCommand(double elevatorVerticalSetpoint) {
    requires(elevatorVertical);
    requires(drive);
    this.elevatorVerticalSetpoint = elevatorVerticalSetpoint;
  }

  protected void initialize() {
    RobotLog.putMessage("Running ElevatorSetpointCommand");
    drive.setBoth(0, 0);
  }

  protected void execute() {
   elevatorVertical.setYElevatorMotorsPosition(elevatorVerticalSetpoint);
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