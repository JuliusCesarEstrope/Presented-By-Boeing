package frc.robot.commands;
import frc.robot.utilities.RobotLog;

public class ZeroEncoderCommand extends CommandBase {
  public ZeroEncoderCommand() {
  }

  protected void initialize() {
    RobotLog.putMessage("Zeroing Encoder Positions");
    drive.resetEncoder();
    wrist.ResetEncoder();
    fourBar.resetEncoders();
    elevatorVertical.resetElevatorEncoder();
  }

  protected void execute() {    
  }

  protected boolean isFinished() {
    return true;
  }

  protected void end() {
  }

  protected void interrupted() {
    roller.setRollerMotor(0);
  }
}