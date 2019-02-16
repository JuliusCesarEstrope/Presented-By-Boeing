
package frc.robot.commands;

public class FourBarCommand extends CommandBase {
  int leftBarEncoder, rightBarEncoder; //change
  double fourBarSetPoint;

  public FourBarCommand(int fourBarSetPoint) {
    // Use requires() here to declare subsystem dependencies
    requires(fourBar);
    leftBarEncoder = fourBar.getLeftBarEncoder();
    rightBarEncoder = fourBar.getRightBarEncoder();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // send pid to correct motors
    fourBar.setBothFourBarMotor(0, 0);
    //fourBar.resetEncoders();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    fourBar.setFourBarSetPoint(fourBarSetPoint);
    fourBar.setBothFourBarMotor(fourBar.getFourBarPIDOutput());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
