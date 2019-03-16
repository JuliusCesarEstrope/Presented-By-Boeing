package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
    SmartDashboard.putString("DB/String 6", "Running Elevator");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    elevatorHorizontal.setXElevatorMotors(oi.getElevatorHorizontalAxis());
    elevatorVertical.setYElevatorMotor(oi.getElevatorVerticalAxis());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    RobotLog.putMessage("Ended Elevator Manual Command");
    SmartDashboard.putString("DB/String 6", "Ending Elevator");
    elevatorHorizontal.setXElevatorMotors(0);
    elevatorVertical.setYElevatorMotor(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    RobotLog.putMessage("Interrupted Elevator Manual Command");
    SmartDashboard.putString("DB/String 6", "Interrupted Elevator");
    elevatorHorizontal.setXElevatorMotors(0);
    elevatorVertical.setYElevatorMotor(0);
  }
}
