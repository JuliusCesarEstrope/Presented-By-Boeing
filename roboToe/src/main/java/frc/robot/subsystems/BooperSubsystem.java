package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.BooperCommand;
import frc.robot.utilities.RobotLog;

public class BooperSubsystem extends Subsystem {
  static DoubleSolenoid booper;

  public BooperSubsystem(int[] booperPorts) {
    booper = new DoubleSolenoid(booperPorts[0], booperPorts[1]);
    RobotLog.putMessage("Running BooperSubsystem");
  }

  public void setBooperForward() {
    booper.set(DoubleSolenoid.Value.kForward);
  }

  public void setBooperReverse() {
    booper.set(DoubleSolenoid.Value.kReverse);
  }

  public void initDefaultCommand() {
    setDefaultCommand(new BooperCommand());
  }
}