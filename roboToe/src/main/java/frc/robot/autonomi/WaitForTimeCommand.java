package frc.robot.autonomi;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.commands.CommandBase;
public class WaitForTimeCommand extends CommandBase {
  Timer timer;
  double time;
  public WaitForTimeCommand(double time) {
    timer = new Timer();
    this.time = time;
  }
  @Override
  protected void initialize() {
    timer.start();
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
  }

  @Override
  protected void interrupted() {
  }
}
