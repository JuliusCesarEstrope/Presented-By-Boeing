package frc.robot.commands;

public class TankDrive extends CommandBase {
  public TankDrive() {
    requires(drive);
  }

  @Override
  protected void initialize() {
    drive.setBothMotor(0, 0);
  }

  @Override
  protected void execute() {
    drive.setBothMotor(oi.getleftYAxis(), oi.getrightYAxis());
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    drive.setBothMotor(0, 0);
  }

  @Override
  protected void interrupted() {
    drive.setBothMotor(0, 0);
  }
}
