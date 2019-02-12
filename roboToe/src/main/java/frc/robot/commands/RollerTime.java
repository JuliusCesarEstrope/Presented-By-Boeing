package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
public class RollerTime extends CommandBase {
  Timer timer;
  double time;
  public RollerTime(double speed, double time) {
    requires(roller);
    timer = new Timer();
    this.time = time;
  }
  @Override
  protected void initialize() {
    roller.setRollerMotor(0);
    timer.start();
    roller.setRollerMotor(-0.70);
  }
  @Override
  protected void execute() {
  }
  @Override
  protected boolean isFinished() {
    return timer.get() > time;
  }
  @Override
  protected void end() {
  }
  @Override
  protected void interrupted() {
    roller.setRollerMotor(0);
  }
}