package frc.robot.commands;

import frc.robot.utilities.RobotLog;

public class BooperRetractCommand extends CommandBase {
  public BooperRetractCommand() {
    requires(booper);
  }

  protected void initialize() {
    RobotLog.putMessage("Running BooperRetractCommand");
    booper.setBooperReverse();
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