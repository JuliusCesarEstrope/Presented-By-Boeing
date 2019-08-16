package frc.robot.commands;

import frc.robot.utilities.RobotLog;

public class ElevatorAssistCommand extends CommandBase {
  public ElevatorAssistCommand() {
    requires(elevatorAssist);
  }

  protected void initialize() {
  
    RobotLog.putMessage("Running ElevatorAssistCommand");
    elevatorAssist.setBooperForward();
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