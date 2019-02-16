package frc.robot.commands;

import frc.robot.utilities.RobotLog;

public class BooperExtendCommand extends CommandBase {
  public BooperExtendCommand() {
    requires(booper);
  }

  protected void initialize() {
    RobotLog.putMessage("Running BooperExtendCommand");
    booper.setBooperForward();

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