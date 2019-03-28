package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.BooperCommand;
import frc.robot.utilities.RobotLog;

public class BooperSubsystem extends Subsystem {
  static DoubleSolenoid booper;

  public BooperSubsystem(int[] booperPorts) {
    if (Constants.booperEnabled){
    booper = new DoubleSolenoid(booperPorts[0], booperPorts[1]);
    RobotLog.putMessage("Running BooperSubsystem");
    }
  }

  public void setBooperForward() {
    if (Constants.booperEnabled){
    booper.set(DoubleSolenoid.Value.kForward);
    }
  }

  public void setBooperReverse() {
    if (Constants.booperEnabled){
    booper.set(DoubleSolenoid.Value.kReverse);
    }
  }
 
  public void initDefaultCommand() {
    if (Constants.booperEnabled){
    setDefaultCommand(new BooperCommand());
    }
  }
}