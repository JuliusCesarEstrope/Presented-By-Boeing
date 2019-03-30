package frc.robot.subsystems;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

public class UltrasonicSubsystem extends Subsystem {
  AnalogInput ultrasonic;

  public UltrasonicSubsystem(int ultrasonicPort) {
    ultrasonic = new AnalogInput(ultrasonicPort);
  }

  public double getUltrasonic(){
    return ultrasonic.getVoltage()/0.0248;
  }

  public void initDefaultCommand() {
    
  }
}