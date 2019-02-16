package frc.robot.commands;
public class RollerCommand extends CommandBase {
  public RollerCommand() {
    requires(roller);
  }
  @Override
  protected void initialize() {
    roller.setRollerMotor(0);
  }
  @Override
  protected void execute() {
    if(oi.getRollerButtonIn()){
      roller.setRollerMotor(-0.70);
    }
    else if(oi.getRollerButtonOut()) {
      roller.setRollerMotor(0.70);
    }
    else{
      roller.setRollerMotor(0);
    }
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
    roller.setRollerMotor(0);
  }
}