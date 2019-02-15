package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.ElevatorVerticalSubsystem;

public class ElevatorSetpointCommand extends CommandBase {
  double elevatorVerticalSetpoint;

  public ElevatorSetpointCommand(double elevatorVerticalSetpoint) {
    requires(elevatorVertical);
    requires(drive);
  }

  protected void initialize() {
    drive.setBothMotor(0, 0);
    elevatorVertical.enableBothElevatorEncoderPIDValues();
    elevatorVertical.setLeftElevatorEncoderSetpoint(elevatorVerticalSetpoint);
    elevatorVertical.setRightElevatorEncoderSetpoint(elevatorVerticalSetpoint);
  }

  protected void execute() {
    elevatorVertical.setYElevatorMotors(elevatorVertical.getLeftElevatorEncoderPIDOutput());
  }

  protected boolean isFinished() {
    return false;
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
