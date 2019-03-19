package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;

public class LEDLightSubsystem extends Subsystem {
  static Spark LEDLight;

  public LEDLightSubsystem() {
    if (Constants.wristEnabled){
    //LEDLight = new Spark(-1);
    }
  }

  public void setLEDLightColor(double Speed) {
    if (Constants.wristEnabled){
    //LEDLight.set(Speed);
    }
  }

  // Blue nothing align(default), Green isfully aligned, red not aligned, yellow is close to align but not yet

  public void initDefaultCommand() {
    if (Constants.wristEnabled){
    }
  }

}