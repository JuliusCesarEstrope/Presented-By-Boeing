package frc.robot.autonomi.components;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.commands.CommandBase;
public class RollerTimeCommand extends CommandBase {
  Timer timer;
  double time;
  public RollerTimeCommand(double time){
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
    return timer.get() >= time;
  }
  @Override
  protected void end() {
    roller.setRollerMotor(0);
  }
  @Override
  protected void interrupted() {
    roller.setRollerMotor(0);
  }
}