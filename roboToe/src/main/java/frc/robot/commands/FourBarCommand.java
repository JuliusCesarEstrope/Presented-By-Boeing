
package frc.robot.commands;

public class FourBarCommand extends CommandBase {
  boolean buttonReleased, fourBarStart, floorGather, hatchLvlTwo, rocketLvlTwo, rocketLvlOne, climb, ballLvlOne,
      ballLvlTwo;
  int leftBarEncoder, rightBarEncoder;//change
  double fourBarSetPoint;
  /*int startPoint = 5, floorGatherPoint = 6, hatchLvlTwoPoint = 7, rocketLvlTwoPoint = 8, rocketLvlOnePoint = 9,
      climbPoint = 10, ballLvlOnePoint = 11, ballLvlTwoPoint = 12, wristDownSetPoint = 70;*/

  public FourBarCommand(int fourBarSetPoint/*int setStartPoint, int setFloorGatherPoint, int setHatchLvlTwoPoint, int rocketLevelTwoPoint,
      int rocketLvlOnePoint, int climbPoint, int ballLvlOnePoint, int ballLvlTwoPoint*/) {
    // Use requires() here to declare subsystem dependencies
    requires(fourBar);
    requires(wrist);
    leftBarEncoder = fourBar.getLeftBarEncoder();
    rightBarEncoder = fourBar.getRightBarEncoder();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // send pid to correct motors
    fourBar.setBothFourBarMotor(0, 0);
    fourBar.resetEncoders();
    buttonReleased = true;
    fourBarStart = false;

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
