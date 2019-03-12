package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;

public class Drive4Distance extends CommandBase {

  double distanceToTravel, pLeft, pRight, leftDistance, rightDistance, leftEndDistance, rightEndDistance;
  Timer timer;
  Timer onTargetTimer;

  public Drive4Distance(double distanceToTravel) {
    requires(drive);
    timer = new Timer();
    onTargetTimer = new Timer();
    this.distanceToTravel = distanceToTravel;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    // RobotLog.putMessage("Running Drive4Distance: " + distanceToTravel);
    drive.setBoth(0);
    drive.resetGyro();
    timer.start();
    onTargetTimer.start();

    pLeft = 0;
    pRight = 0;

    drive.enableGyroPID();
    drive.setGyroSetpoint(0);
  }

  protected void execute() {
    drive.setTalonMotorPositions (distanceToTravel);
  }

  protected boolean isFinished() {
    if (drive.distanceOnTarget()) {
      return onTargetTimer.hasPeriodPassed(0.5);
    } else {
      onTargetTimer.reset();
      return timer.hasPeriodPassed(2);
    }
  }

  protected void end() {

    // RobotLog.putMessage("Finished Drive4Distance: " + distanceToTravel);
    // RobotLog.putMessage("Distance traveled: " + leftEndDistance + ", " +
    // rightEndDistance);
    drive.setBoth(0);
  }

  protected void interrupted() {
    // RobotLog.putMessage("Interrupted Drive4Distance: " + distanceToTravel);
    drive.setBoth(0);
  }
}
