package frc.robot.commands;

import frc.robot.Utilities;

public class TapeAlignCommand extends CommandBase {

  private boolean endCommand;

  public TapeAlignCommand() {

    requires(drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() { 
    drive.setBoth(0, 0);
    endCommand = false;

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    drive.getWheelDistanceLeft();
    Utilities.AngleFinder(drive.getWheelDistanceLeft());
  }
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return endCommand;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    drive.setBoth(0, 0);
   
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    drive.setBoth(0, 0);
    
  }
}
