package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.Robot;

public class LEDLightSubsystem extends Subsystem {
  static Spark LEDLight;
  double matchTime;

  public LEDLightSubsystem() {
    if (Constants.LEDLightEnabled){
      LEDLight = new Spark(0);
    }
  }

  public void setLEDLightColor(double color) {
    if (Constants.LEDLightEnabled){

      matchTime = Robot.matchTimer.get();
      if(matchTime > 90 && matchTime < 93){
        LEDLight.set(0.67);
        if(matchTime > 91 && matchTime < 92)
        LEDLight.set(0);
      }else if(matchTime > 105 && matchTime < 108){
        LEDLight.set(0.61);
        if(matchTime > 106 && matchTime < 107)
        LEDLight.set(0);
      }else if(matchTime > 130){
        if(matchTime % 1 < 0.5)
          LEDLight.set(0.61);
        else if (matchTime - 0.5 % 1 < 0.5)
          LEDLight.set(0);
      }else
        LEDLight.set(0.61);
    }
  }

 




  public void initDefaultCommand() {
    if (Constants.LEDLightEnabled){
    }
  }

}