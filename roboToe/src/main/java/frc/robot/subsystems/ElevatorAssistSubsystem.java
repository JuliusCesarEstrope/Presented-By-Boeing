package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.ElevatorAssistInCommand;
import frc.robot.utilities.RobotLog;

public class ElevatorAssistSubsystem extends Subsystem {
  static DoubleSolenoid booper;

  public ElevatorAssistSubsystem(int[] booperPorts) {
    if (Constants.elevatorVerticalEnabled){
    booper = new DoubleSolenoid(booperPorts[0], booperPorts[1]);
    RobotLog.putMessage("Running ElevatorAssistSubsystem");
    
    }
  }

  public void setBooperForward() {
    if (Constants.elevatorVerticalEnabled){
    booper.set(DoubleSolenoid.Value.kForward);
    }
  }

  public void setBooperReverse() {
    if (Constants.elevatorVerticalEnabled){
    booper.set(DoubleSolenoid.Value.kReverse);
    }
  }
 
  public void initDefaultCommand() {
    setDefaultCommand(new ElevatorAssistInCommand());
  }
}