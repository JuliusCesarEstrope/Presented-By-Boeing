package frc.robot.autonomi.components;

import frc.robot.commands.CommandBase;

public class BooperExtendCommand extends CommandBase {
  public BooperExtendCommand() {
    requires(booper);
  }
  @Override
  protected void initialize() {
    booper.setBooperForward();

  }
  @Override
  protected void execute() {
    
  }
  @Override
  protected boolean isFinished() {
    return true;
  }
  @Override
  protected void end() {
  }
  @Override
  protected void interrupted() {
  }
}
