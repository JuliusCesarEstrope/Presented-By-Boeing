package frc.robot.commands;

import frc.robot.utilities.RobotLog;


public class ElevatorManualCommand extends CommandBase {
  public ElevatorManualCommand() {
    requires(elevatorHorizontal);
    requires(elevatorVertical);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    RobotLog.putMessage("Running Elevator Manual Command");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    elevatorHorizontal.setXElevatorMotors(oi.getElevatorHorizontalAxis()*0.5);
    elevatorVertical.setYElevatorMotors(oi.getElevatorVerticalAxis()*0.5);
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
