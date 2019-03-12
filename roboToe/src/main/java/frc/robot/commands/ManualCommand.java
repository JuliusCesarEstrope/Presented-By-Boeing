package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.utilities.RobotLog;

public class ManualCommand extends CommandBase {

  public ManualCommand() {
    // Use requires() here to declare subsystem dependencies
    requires(fourBar);
    requires(wrist);
  }

  protected void initialize() {
    RobotLog.putMessage("Running ManualCommand");
    // send pid to correct motors
    fourBar.setBothFourBarMotor(0, 0);
    wrist.setBothWristMotor(0, 0);
  }

  protected void execute() {
    fourBar.setBothFourBarMotor(oi.getFourBarAxis());
    wrist.setBothWristMotor(oi.getWristAxis(), oi.getWristAxis());
  }

  protected boolean isFinished() {
    return !oi.getManualOverrideButton();
  }

  protected void end() {
  }

  protected void interrupted() {
  }
}