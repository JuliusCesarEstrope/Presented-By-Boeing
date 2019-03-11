
package frc.robot.autonomi;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;

public class AutonInput extends CommandGroup{

  private static boolean onLevel2, crossField, invertTurns, targetMiddle, startMiddle, NEI; //NEI = not enough information
  private static double distanceToTarget;
  private static char targetSide; //'l' for left, 'm' for mid, and 'r' for right
  
  public AutonInput(){

    boolean temp = false;
    onLevel2 = false; //onPlatform
    startMiddle = false;
    crossField = false;
    invertTurns = false;
    targetMiddle = false;
    NEI = false;

    if(temp/*targetLeftFar*/){
      distanceToTarget = Constants.setpointToFar; //add distance from setpoint to far left
      targetSide = 'l';
    } else if(temp/*targetLeftMid*/){
      distanceToTarget = Constants.setpointToMid; //add distance from setpoint to mid left
      targetSide = 'l';
    } else if(temp/*targetLeftClose*/){
      distanceToTarget = Constants.setpointToClose; //add distance from setpoint to close left
      targetSide = 'l';
    } else if(temp/*targetRightFar*/){
      distanceToTarget = Constants.setpointToFar; //add distance from setpoint to far right
      targetSide = 'r';
    } else if(temp/*targetRightMid*/){
      distanceToTarget = Constants.setpointToMid; //add distance from setpoint to mid right
      targetSide = 'r';
    } else if(temp/*targetRightClose*/){
      distanceToTarget = Constants.setpointToClose; //add distance from setpoint to close right
      targetSide = 'r';
    } else if(temp/*targetMidLeft*/){
      distanceToTarget = 0;
      targetSide = 'm';
    } else if(temp/*targetMidRight*/){
      distanceToTarget = 1;
      targetSide = 'm';
    } else NEI = true;

    if(temp /*startLeft*/){

      if(targetSide == 'm')
        targetMiddle = true;
      else if(targetSide == 'r')
        crossField = true;

    } else if(temp /*startMid*/){

      startMiddle = true;

      if(targetSide == 'm')
        targetMiddle = true;
      else if(targetSide == 'l')
        crossField = true;

    } else if(temp /*startRight*/){

      invertTurns = true;

      if(targetSide == 'm')
        targetMiddle = true;
      else if(targetSide == 'l')
        crossField = true;

    } else NEI = true;

    if(NEI){
      //auton = new DoNothingCommand();
    }else{
      addSequential(new Auton(onLevel2, startMiddle, invertTurns, targetMiddle, crossField, distanceToTarget));
    }

  }

}
