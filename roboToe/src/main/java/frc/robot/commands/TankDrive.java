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
    /*if(oi.getSwapButton()&&buttonUp) {
      swap = !swap;
      buttonUp = !oi.getSwapButton();
    }
    if(!oi.getSwapButton()) {
      buttonUp = true;
    }
    if(swap) {
      drive.setBoth(oi.getleftYAxis()*Math.abs(oi.getleftYAxis()), oi.getrightYAxis()*Math.abs(oi.getrightYAxis()));
    }*/
    //else if(!swap) {
      drive.setBoth(oi.getleftYAxis(), oi.getrightYAxis());
    //}
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