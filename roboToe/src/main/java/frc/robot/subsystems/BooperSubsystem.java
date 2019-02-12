package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
public class BooperSubsystem extends Subsystem {
  static DoubleSolenoid booper;
public BooperSubsystem(int[] booperPort){
  booper = new DoubleSolenoid(booperPort[0], booperPort[1]);
}
public static void setBooperForward(boolean extend){
  booper.set(DoubleSolenoid.Value.kForward);
}  
public static void setBooperReverse(boolean contract){
  booper.set(DoubleSolenoid.Value.kReverse);
}
  @Override
  public void initDefaultCommand() {
  }
}