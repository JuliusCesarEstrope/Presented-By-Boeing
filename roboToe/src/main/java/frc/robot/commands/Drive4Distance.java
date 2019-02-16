package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants;


public class Drive4Distance extends CommandBase {
  
  double distance, distanceToTravel, pLeft, pRight, leftDistance, rightDistance, leftEndDistance, rightEndDistance;
	Timer timer;
	Timer tarTimer;
  
  public Drive4Distance() {
    requires(drive);
		timer = new Timer();
		tarTimer = new Timer();
		this.distanceToTravel = distanceToTravel;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
		RobotLog.putMessage("Running Drive4Distance: " + distanceToTravel);
		
		distance = distanceToTravel * Constants.ticksToInches;
		drive.setBoth(0);
		drive.resetBothEncoders();
		drive.resetGyro();
		timer.start();
		tarTimer.start();
		
		pLeft = 0;
		pRight = 0;

		drive.enablePID("driveDistance");
		drive.setRotatePoint(0);
		drive.setDistanceSetpoint(distance);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
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
