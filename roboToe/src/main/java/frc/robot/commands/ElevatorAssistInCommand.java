package frc.robot.commands;

import frc.robot.utilities.RobotLog;

public class ElevatorAssistInCommand extends CommandBase {
  public ElevatorAssistInCommand() {
    requires(elevatorAssist);
  }

  protected void initialize() {
    RobotLog.putMessage("Running ElevatorAssistCommand");
    elevatorAssist.setBooperReverse();
  }

  protected void execute() {
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    elevatorAssist.setBooperReverse();
  }

  protected void interrupted() {
    elevatorAssist.setBooperReverse();
  }
}