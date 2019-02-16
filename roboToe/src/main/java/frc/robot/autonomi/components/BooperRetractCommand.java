package frc.robot.autonomi.components;

import frc.robot.commands.CommandBase;

public class BooperRetractCommand extends CommandBase {
  public BooperRetractCommand() {
    requires(booper);
  }
  @Override
  protected void initialize() {
     booper.setBooperReverse();
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
