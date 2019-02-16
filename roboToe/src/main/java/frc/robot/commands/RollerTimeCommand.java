package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.utilities.RobotLog;

public class RollerTimeCommand extends CommandBase {
  Timer timer;
  double time;

  public RollerTimeCommand(double speed, double time) {
    RobotLog.putMessage("Running RollerTimeCommand");
    requires(roller);
    timer = new Timer();
    this.time = time;
  }

  protected void initialize() {
    roller.setRollerMotor(0);
    timer.start();
    roller.setRollerMotor(-0.70);
  }

  protected void execute() {
  }

  protected boolean isFinished() {
    return timer.get() > time;
  }

  protected void end() {
  }

  protected void interrupted() {
    roller.setRollerMotor(0);
  }
}