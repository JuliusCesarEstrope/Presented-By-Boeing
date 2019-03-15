package frc.robot.commands;

import frc.robot.utilities.RobotLog;
import edu.wpi.first.wpilibj.Timer;

public class TurnAngleCommand extends CommandBase {
  public double angle;
  Timer timer;
  boolean endCommand;

  public TurnAngleCommand(double angle) {
    requires(drive);
    this.angle = angle;
    timer = new Timer();
  }

  protected void initialize() {
    RobotLog.putMessage("Running TurnAngleCommand");
    drive.resetGyro();
    drive.setGyroSetpoint(angle);
  }

  protected void execute() {
    drive.setBoth(drive.getGyroPIDOutput(), -drive.getGyroPIDOutput());
  }

  protected boolean isFinished() {
    if (!drive.gyroPIDOnSetpoint()) {
      timer.reset();
    } else {
      if (timer.get() > 0.5) {
        return true;

      }
    }
    return false;
  }

  protected void end() {
    drive.setBoth(0, 0);
    drive.setGyroSetpoint(0);
    endCommand = true;
  }

  protected void interrupted() {
    drive.setBoth(0, 0);
    drive.setGyroSetpoint(0);
  }
}