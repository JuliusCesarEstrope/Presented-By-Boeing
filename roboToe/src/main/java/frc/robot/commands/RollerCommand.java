package frc.robot.commands;

import frc.robot.utilities.RobotLog;

public class RollerCommand extends CommandBase {
  public RollerCommand() {
    requires(roller);
  }

  protected void initialize() {
    RobotLog.putMessage("Running RollerCommand");
    roller.setRollerMotor(0);
  }

  protected void execute() {
    if (oi.getRollerButtonIn()) {
      roller.setRollerMotor(-0.70);
    } else if (oi.getRollerButtonOut()) {
      roller.setRollerMotor(0.70);
    } else {
      roller.setRollerMotor(0);
    }
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
  }

  protected void interrupted() {
    roller.setRollerMotor(0);
  }
}