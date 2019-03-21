package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.utilities.RobotLog;

public class CounterWeightReverseCommand extends CommandBase {
  public CounterWeightReverseCommand() {
    requires(CounterWeight);
  }

  protected void initialize() {
    RobotLog.putMessage("Running CounterWeightReverseCommand");
    SmartDashboard.putString("DB/String 8", "Running CounterWeightReverse");
    CounterWeight.setCounterWeightMotor(0);
  }

  protected void execute() {
    CounterWeight.setCounterWeightMotor(-0.5);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    CounterWeight.setCounterWeightMotor(0);
    SmartDashboard.putString("DB/String 8", "Ended CounterWeightReverse");
  }

  protected void interrupted() {
    CounterWeight.setCounterWeightMotor(0);
    SmartDashboard.putString("DB/String 8", "Interrupted CounterWeightReverse");
  }
}