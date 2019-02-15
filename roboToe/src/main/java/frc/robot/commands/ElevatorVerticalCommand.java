package frc.robot.commands;

import frc.robot.Constants;

public class ElevatorVerticalCommand extends CommandBase {
  double elevatorVerticalSetpoint;
  double elevatorDistance;

  public ElevatorVerticalCommand(double elevatorDistance) {
    requires(elevatorVertical);
    this.elevatorDistance = elevatorDistance;
  }

  protected void initialize() {
    elevatorVertical.enableBothElevatorEncoderPIDValues();
    drive.setBothMotor(0, 0);
    elevatorVertical.setleftElevatorEncoderSetpoint(elevatorDistance + Constants.defaultElevatorPosition);
    elevatorVertical.setrightElevatorEncoderSetpoint(elevatorDistance + Constants.defaultElevatorPosition);
  }

  protected void execute() {
    elevatorVertical.setYElevatorMotors(elevatorVertical.getleftElevatorEncoderPIDOutput());
  }

  protected boolean isFinished() {
    return elevatorVertical.checkOnTargetSetpoint();
  }

  protected void end() {
    drive.setBothMotor(0, 0);
    elevatorVertical.disableBothElevatorEncoderPIDValues();
  }

  protected void interrupted() {
    drive.setBothMotor(0, 0);
    elevatorVertical.disableBothElevatorEncoderPIDValues();
  }
}
