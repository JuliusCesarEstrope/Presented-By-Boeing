package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Timer;

public class LEDLightSubsystem extends Subsystem {
  static Spark LEDLight;
  static Timer timer;

  public LEDLightSubsystem() {
    timer = new Timer();
    if (Constants.wristEnabled){
    //LEDLight = new Spark(-1);
    }
  }

  public void setLEDLightColor(double Speed) {
    if (Constants.wristEnabled){
    //LEDLight.set(Speed);
    }
  }

  public static double getMatchTime() { 
    return LEDLightSubsystem.getMatchTime();

  }

  // Blue nothing align(default), Green isfully aligned, red not aligned, yellow is close to align but not yet

  public void initDefaultCommand() {
    if (Constants.wristEnabled){
    }
  }

}