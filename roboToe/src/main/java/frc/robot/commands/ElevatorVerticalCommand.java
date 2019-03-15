package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class ElevatorVerticalCommand extends CommandBase {
  double elevatorVerticalSetpoint;
  double elevatorDistance;

  public ElevatorVerticalCommand(double elevatorDistance) {
    requires(elevatorVertical);
    this.elevatorDistance = elevatorDistance;
  }

  protected void initialize() {
    RobotLog.putMessage("Running ElevatorVerticalCommand");

    drive.setBoth(0, 0);
  }

  protected void execute() {
    elevatorVertical.setYElevatorMotorPosition(elevatorDistance + Constants.defaultElevatorPosition);
    elevatorVertical.setYElevatorMotorPosition(elevatorVerticalSetpoint);
    SmartDashboard.putNumber("Position of the elevator:", elevatorVertical.getVerticalElevatorEncoder());
    SmartDashboard.putNumber("Elevator current:", elevatorVertical.getElevatorMotorsCurrent());
    SmartDashboard.putBoolean("Emergency Stop Button Pressed:", oi.getElevatorEmergencyStopButton());
  }

  protected boolean isFinished() {
    return (elevatorVertical.checkOnTargetSetpoint() || oi.getElevatorEmergencyStopButton());
  }

  protected void end() {
    drive.setBoth(0, 0);
  }

  protected void interrupted() {
    drive.setBoth(0, 0);
    // elevatorButton.whenPressed(new ElevatorCommandGroup());
  }
}