package frc.robot.commands;

import frc.robot.utilities.RobotLog;

public class BooperCommand extends CommandBase {
  public BooperCommand() {
    requires(booper);
  }

  protected void initialize() {
    RobotLog.putMessage("Running BooperCommand");
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