package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;

public class LEDLightSubsystem extends Subsystem {
  static Spark LEDLight;

  public LEDLightSubsystem() {
    if (Constants.LEDLightEnabled){
    LEDLight = new Spark(0);
    }
  }

  public void setLEDLightColor(double Speed) {
    if (Constants.LEDLightEnabled){
    LEDLight.set(Speed);
    }
  }

 




  public void initDefaultCommand() {
    if (Constants.LEDLightEnabled){
    }
  }

}