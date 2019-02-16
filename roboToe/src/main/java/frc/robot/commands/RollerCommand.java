package frc.robot.commands;
<<<<<<< HEAD:roboToe/src/main/java/frc/robot/commands/RollerCommand.java

import frc.robot.utilities.RobotLog;

=======
>>>>>>> Salvatore:roboToe/src/main/java/frc/robot/commands/RollerCommand.java
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