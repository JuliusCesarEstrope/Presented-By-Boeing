package frc.robot.commands;

import frc.robot.utilities.RobotLog;

public class TankDriveCommand extends CommandBase {
  public TankDriveCommand() {
    requires(drive);
  }

  protected void initialize() {
    RobotLog.putMessage("Running TankDriveCommand");
    drive.setBoth(0, 0);
  }

  protected void execute() {
    drive.setBoth(oi.getleftYAxis(), oi.getrightYAxis());
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