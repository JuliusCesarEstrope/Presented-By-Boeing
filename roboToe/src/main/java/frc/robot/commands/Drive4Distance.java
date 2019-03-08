package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants;


public class Drive4Distance extends CommandBase {
  
  double distance, distanceToTravel, pLeft, pRight, leftDistance, rightDistance, leftEndDistance, rightEndDistance;
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
    
		//RobotLog.putMessage("Running Drive4Distance: " + distanceToTravel);
		
		distance = distanceToTravel * Constants.ticksToInches;
		drive.setBoth(0);
		drive.resetEncoder();
		drive.resetGyro();
		timer.start();
		onTargetTimer.start();
		
		pLeft = 0;
		pRight = 0;

    drive.enableGyroPID();
    drive.enableleftEncoderControllerPID();
    drive.enablerightEncoderPIDController();
    drive.setGyroSetpoint(0);
    drive.setrightEncoderPIDController(distanceToTravel);
    drive.setleftEncoderPIDController(distanceToTravel);
    }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    pLeft = drive.getLeftEncoderControllerPIDOutput();
		pRight = frc.robot.MathUtil.setLimits(drive.getRightEncoderControllerPIDOutput() - drive.getGyroPIDOutput(), -1, 1);
		drive.setBoth(pLeft * 0.6, pRight * 0.6);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (drive.distanceOnTarget()) {
			return onTargetTimer.hasPeriodPassed(0.5);
		} else {
			onTargetTimer.reset();
			return timer.hasPeriodPassed(2);
		} 
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {

		//RobotLog.putMessage("Finished Drive4Distance: " + distanceToTravel);
		//RobotLog.putMessage("Distance traveled: " + leftEndDistance + ", " + rightEndDistance);
		drive.setBoth(0);
    drive.disableLeftEncoderPIDController();
    drive.disableRightEncoderPIDController();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    //RobotLog.putMessage("Interrupted Drive4Distance: " + distanceToTravel);
		drive.setBoth(0);
		drive.disableLeftEncoderPIDController();
    drive.disableRightEncoderPIDController();
  }
}
