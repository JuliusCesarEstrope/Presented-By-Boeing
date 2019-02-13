package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.BooperCommand;
public class BooperSubsystem extends Subsystem {
  static DoubleSolenoid booper;
public BooperSubsystem(int[] booperPort){
  booper = new DoubleSolenoid(booperPort[0], booperPort[1]);
}
public void setBooperForward(){
  booper.set(DoubleSolenoid.Value.kForward);
}  
public void setBooperReverse(){
  booper.set(DoubleSolenoid.Value.kReverse);
}
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new BooperCommand());
  }
}