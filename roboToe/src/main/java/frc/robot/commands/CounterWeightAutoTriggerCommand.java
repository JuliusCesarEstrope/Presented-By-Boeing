package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.utilities.RobotLog;

public class CounterWeightAutoTriggerCommand extends CommandBase {
  Timer timer;
  public CounterWeightAutoTriggerCommand() {
    requires(CounterWeight);
    timer = new Timer();
  }

  protected void initialize() {
    RobotLog.putMessage("Running CounterWeightReverseCommand");
    SmartDashboard.putString("DB/String 8", "Running CounterWeightAuto");
    CounterWeight.setCounterWeightMotor(0);
    timer.start();
  }

  protected void execute() {
    CounterWeight.setCounterWeightMotor(-0.5);
  }

  protected boolean isFinished() {
    return timer.hasPeriodPassed(1);
  }

  protected void end() {
    CounterWeight.setCounterWeightMotor(0);
    SmartDashboard.putString("DB/String 8", "Ended CounterWeightAuto");
  }

  protected void interrupted() {
    CounterWeight.setCounterWeightMotor(0);
    SmartDashboard.putString("DB/String 8", "Interrupted CounterWeightAuto");
  }
}