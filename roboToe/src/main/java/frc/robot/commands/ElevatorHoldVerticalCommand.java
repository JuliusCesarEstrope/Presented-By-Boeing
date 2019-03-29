package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class ElevatorHoldVerticalCommand extends CommandBase {
  double elevatorDistance;

  public ElevatorHoldVerticalCommand() {
    requires(elevatorVertical);
    this.elevatorDistance = elevatorHoldPosition;
  }

  protected void initialize() {
    RobotLog.putMessage("Running ElevatorVerticalCommand");
    SmartDashboard.putString("DB/String 1", "Running Elevator Command");
    led.setLEDLightColor(0.87); // blue
    drive.setBoth(0, 0);
  }

  protected void execute() {
    elevatorVertical.setYElevatorMotorPosition(elevatorDistance + Constants.defaultElevatorPosition);
    //elevatorVertical.setYElevatorMotorPosition(elevatorVerticalSetpoint);
    SmartDashboard.putNumber("Position of the elevator:", elevatorVertical.getVerticalElevatorEncoder());
    SmartDashboard.putNumber("Elevator current:", elevatorVertical.getElevatorMotorsCurrent());
    SmartDashboard.putBoolean("Emergency Stop Button Pressed:", oi.getElevatorEmergencyStopButton());
   
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    SmartDashboard.putString("DB/String 1", "Running Elevator Command");
    elevatorVertical.setYElevatorMotor(0);
  }

  protected void interrupted() {
    SmartDashboard.putString("DB/String 1", "Running Elevator Command");
    elevatorVertical.setYElevatorMotor(0);
    // elevatorButton.whenPressed(new ElevatorCommandGroup());
  }
}