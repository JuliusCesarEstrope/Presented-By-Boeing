package frc.robot.commands;

import frc.robot.utilities.RobotLog;

public class BooperExtendCommand extends CommandBase {
  public BooperExtendCommand() {
    requires(booper);
  }

  protected void initialize() {
    booper.setBooperForward();
    RobotLog.putMessage("Running BooperExtendCommand");
    
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