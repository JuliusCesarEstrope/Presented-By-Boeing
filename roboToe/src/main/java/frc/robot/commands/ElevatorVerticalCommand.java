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
    
    elevatorVertical.enableBothElevatorEncoderPIDValues();
    drive.setBoth(0, 0);
    elevatorVertical.setLeftElevatorEncoderSetpoint(elevatorDistance + Constants.defaultElevatorPosition);
    elevatorVertical.setRightElevatorEncoderSetpoint(elevatorDistance + Constants.defaultElevatorPosition);
  }

  protected void execute() {
    elevatorVertical.setYElevatorMotors(elevatorVertical.getLeftElevatorEncoderPIDOutput());
    SmartDashboard.putNumber("Position of the elevator:", elevatorVertical.getLeftElevatorEncoder());
    SmartDashboard.putNumber("Elevator current:", elevatorVertical.getElevatorMotorsCurrent());
    SmartDashboard.putBoolean("Emergency Stop Button Pressed:", oi.getElevatorEmergencyStopButton());
  }

  protected boolean isFinished() {
    return (elevatorVertical.checkOnTargetSetpoint() || oi.getElevatorEmergencyStopButton());
  }

  protected void end() {
    drive.setBoth(0, 0);
    elevatorVertical.disableBothElevatorEncoderPIDValues();
  }

  protected void interrupted() {
    drive.setBoth(0, 0);
    elevatorVertical.disableBothElevatorEncoderPIDValues();
    // elevatorButton.whenPressed(new ElevatorCommandGroup());
  }
}