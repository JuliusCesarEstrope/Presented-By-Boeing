package frc.robot.commands;

<<<<<<< HEAD
import frc.robot.utilities.RobotLog;

=======
>>>>>>> John-Schultz
public class ElevatorSetpointCommand extends CommandBase {
  double elevatorVerticalSetpoint;

  public ElevatorSetpointCommand(double elevatorVerticalSetpoint) {
    requires(elevatorVertical);
    requires(drive);
  }

  protected void initialize() {
<<<<<<< HEAD
    RobotLog.putMessage("Running ElevatorSetpointCommand");
=======
>>>>>>> John-Schultz
    drive.setBoth(0, 0);
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
    drive.setBoth(0, 0);
    elevatorVertical.disableBothElevatorEncoderPIDValues();
  }

  protected void interrupted() {
    drive.setBoth(0, 0);
    elevatorVertical.disableBothElevatorEncoderPIDValues();
  }
}