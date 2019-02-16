package frc.robot.commands;

public class TurnAngleCommand extends CommandBase {
  public double angle;
<<<<<<< HEAD:roboToe/src/main/java/frc/robot/commands/TurnAngle.java


	public TurnAngle(double angle) {
=======
	private double speed;
 
	public TurnAngleCommand(double angle) {
>>>>>>> Salvatore:roboToe/src/main/java/frc/robot/commands/TurnAngleCommand.java
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
