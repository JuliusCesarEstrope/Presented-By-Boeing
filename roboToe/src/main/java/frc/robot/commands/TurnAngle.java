package frc.robot.commands;

import frc.robot.utilities.RobotLog;

public class TurnAngle extends CommandBase {
  public double angle;

	public TurnAngle(double angle) {
		requires(drive);
		this.angle = angle;
  }

  protected void initialize() {
    RobotLog.putMessage("Running TurnAngle");
    drive.resetGyro();
    drive.setGyroSetpoint(angle);
  }

  protected void execute() {
		drive.setBoth(drive.getGyroPIDOutput(), -drive.getGyroPIDOutput());
  }

  protected boolean isFinished() {
    return drive.gyroPIDOnSetpoint();
  }

  protected void end() {
		drive.setBoth(0, 0);
		drive.setGyroSetpoint(0);
  }

  protected void interrupted() {
		drive.setBoth(0, 0);
		drive.setGyroSetpoint(0);
  }
}
