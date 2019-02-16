package frc.robot.commands;

public class TurnAngle extends CommandBase {
  public double angle;
	private double speed;
 
	public TurnAngle(double angle) {
		requires(drive);
		this.angle = angle;

  }

  protected void initialize() {
        drive.resetGyro();
        drive.setGyroSetpoint(angle);
      }

  @Override
  protected void execute() {
		drive.setBoth(drive.getGyroPIDOutput(), -drive.getGyroPIDOutput());
  }

  @Override
  protected boolean isFinished() {
    return drive.gyroPIDOnSetpoint();
  }

  @Override
  protected void end() {
		drive.setBoth(0, 0);
		drive.setGyroSetpoint(0);
  }

  @Override
  protected void interrupted() {
		drive.setBoth(0, 0);
		drive.setGyroSetpoint(0);
  }
}
