package frc.robot.commands;
import frc.robot.utilities.RobotLog;

public class ZeroButtonCommand extends CommandBase {
  public ZeroButtonCommand() {
  }

  protected void initialize() {
    RobotLog.putMessage("Zeroing Encoder Positions");
    drive.resetEncoder();
    wrist.ResetEncoder();
    fourBar.resetEncoders();
    elevatorVertical.resetBothElevatorEncoders();
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