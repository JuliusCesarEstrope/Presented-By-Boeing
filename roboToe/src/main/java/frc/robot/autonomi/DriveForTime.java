package frc.robot.autonomi;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.commands.CommandBase;
public class DriveForTime extends CommandBase {
  Timer timer;
  double time;
  double leftSpeed;
  double rightSpeed;
  public DriveForTime(double time, double leftSpeed, double rightSpeed) {
    requires(drive);
    timer = new Timer();
    this.time = time;
    this.leftSpeed = leftSpeed;
    this.rightSpeed = rightSpeed;
  }
  @Override
  protected void initialize() {
    timer.start();
    drive.setBoth(leftSpeed, rightSpeed);
  }
  @Override
  protected void execute() { 
  }
  @Override
  protected boolean isFinished() {
    return timer.get() >= time;
  }

  @Override
  protected void end() {
    drive.setBoth(0, 0);
  }

  @Override
  protected void interrupted() {
    drive.setBoth(0, 0);
  }
}
