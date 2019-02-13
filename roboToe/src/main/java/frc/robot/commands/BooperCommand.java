package frc.robot.commands;
public class BooperCommand extends CommandBase {
  public BooperCommand() {
    requires(booper);
  }
  @Override
  protected void initialize() {
    booper.setBooperReverse();
  }
  @Override
  protected void execute() {
    if(oi.getBooperButton()){
      booper.setBooperForward();
    }
    else{
      booper.setBooperReverse();
    }
  }
  @Override
  protected boolean isFinished() {
    return false;
  }
  @Override
  protected void end() {
  }
  @Override
  protected void interrupted() {
  }
}
