package frc.robot.commands;

import frc.robot.utilities.RobotLog;

public class ElevatorAssistCommand extends CommandBase {
  public ElevatorAssistCommand() {
    requires(booper);
  }

  protected void initialize() {
    RobotLog.putMessage("Running ");
    booper.setBooperReverse();
  }

  protected void execute() {
    if (oi.getBooperButton()) {
      booper.setBooperForward();
    } else {
      booper.setBooperReverse();
    }
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
  }

  protected void interrupted() {
  }
}