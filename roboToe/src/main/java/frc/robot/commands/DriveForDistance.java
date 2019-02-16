package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.utilities.RobotLog;

public class BooperCommand extends Command {
  public BooperCommand() {
    requires(Robot.m_subsystem);
  }

  protected void initialize() {
    RobotLog.putMessage("Running Drive4Distance");
  }

  protected void execute() {
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
  }

  protected void interrupted() {
  }
}