<<<<<<< HEAD:roboToe/src/main/java/frc/robot/commands/BooperExtendCommand.java
package frc.robot.commands;

import frc.robot.utilities.RobotLog;
=======
package frc.robot.autonomi.components;

import frc.robot.commands.CommandBase;
>>>>>>> Salvatore:roboToe/src/main/java/frc/robot/autonomi/components/BooperExtendCommand.java

public class BooperExtendCommand extends CommandBase {
  public BooperExtendCommand() {
    requires(booper);
  }

  protected void initialize() {
    RobotLog.putMessage("Running BooperExtendCommand");
    booper.setBooperForward();

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