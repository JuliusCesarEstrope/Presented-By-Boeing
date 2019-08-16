package frc.robot.commands;

import frc.robot.utilities.RobotLog;

public class ElevatorAssistAutoCommand extends CommandBase {
  public ElevatorAssistAutoCommand() {
   // requires(elevatorAssist);
  }

  protected void initialize() {
    RobotLog.putMessage("Running ElevatorAssistCommand");
   // elevatorAssist.setBooperForward();
  }

  protected void execute() {
  }

  protected boolean isFinished() {
    
    return true;
  }

  protected void end() {
  }

  protected void interrupted() {
  }
}