package frc.robot.commands;
public class TankDrive extends CommandBase {
  boolean buttonUp;
  boolean swap;
  public TankDrive() {
    requires(drive);
  }
  @Override
  protected void initialize() {
    drive.setBoth(0, 0);
    buttonUp=true;
    swap = false;
  }
  @Override
  protected void execute() {
      drive.setBoth(oi.getleftYAxis(), oi.getrightYAxis());
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
    drive.setBoth(0, 0);
  }
}