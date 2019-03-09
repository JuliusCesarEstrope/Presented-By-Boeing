package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LEDLightSubsystem extends Subsystem {
  static Spark LEDLight;

  public LEDLightSubsystem() {
  }

  public void setLEDLightColor(double Speed) {
    LEDLight.set(Speed);
  }

  // Blue nothing align(default), Green isfully aligned, red not aligned, yellow is close to align but not yet

  public void initDefaultCommand() {
  }

}