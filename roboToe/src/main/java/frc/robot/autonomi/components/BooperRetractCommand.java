<<<<<<< HEAD:roboToe/src/main/java/frc/robot/commands/BooperRetractCommand.java
package frc.robot.commands;

import frc.robot.utilities.RobotLog;
=======
package frc.robot.autonomi.components;

import frc.robot.commands.CommandBase;
>>>>>>> Salvatore:roboToe/src/main/java/frc/robot/autonomi/components/BooperRetractCommand.java

public class BooperRetractCommand extends CommandBase {
  public BooperRetractCommand() {
    requires(booper);
  }

  protected void initialize() {
    RobotLog.putMessage("Running BooperRetractCommand");
    booper.setBooperReverse();
  }

  protected void execute() {

  }

  protected boolean isFinished() {
    return true;
  }

  protected void end() {
  }

  protected void interrupted() {
  }
}