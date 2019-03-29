package frc.robot.commands;

import frc.robot.utilities.RobotLog;
import edu.wpi.first.wpilibj.Timer;

public class TurnAngleCommand extends CommandBase {
  public double angle;
  Timer timer;

  public TurnAngleCommand(double angle) {
    requires(drive);
    this.angle = angle;
    timer = new Timer();
  }

  protected void initialize() {
    RobotLog.putMessage("Running TurnAngleCommand");
    drive.resetGyro();
    drive.setGyroSetpoint(angle);
    timer.start();
  }

  protected void execute() {
    drive.setBoth(drive.getGyroPIDOutput(), -drive.getGyroPIDOutput());
  }

  protected boolean isFinished() {
    if (!drive.gyroPIDOnSetpoint()) {
      timer.reset();
      return false;
    } else {
      return timer.hasPeriodPassed(0.5);
    }
    
  }

  protected void end() {
    drive.setBoth(0, 0);
  }

  protected void interrupted() {
    drive.setBoth(0, 0);
  }
}