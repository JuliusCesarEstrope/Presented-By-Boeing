package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.utilities.RobotLog;

public class CounterWeightForwardCommand extends CommandBase {
  public CounterWeightForwardCommand() {
    requires(CounterWeight);
  }

  protected void initialize() {
    RobotLog.putMessage("Running CounterWeightForwardCommand");
    SmartDashboard.putString("DB/String 8", "Running CounterWeightForward");
    CounterWeight.setCounterWeightMotor(0);
  }

  protected void execute() {
    CounterWeight.setCounterWeightMotor(0.5);
  }


  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    CounterWeight.setCounterWeightMotor(0);
    SmartDashboard.putString("DB/String 8", "Ended CounterWeightForward");
  }

  protected void interrupted() {
    CounterWeight.setCounterWeightMotor(0);
    SmartDashboard.putString("DB/String 8", "Interrupted CounterWeightForward");
  }
}