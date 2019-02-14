
package frc.robot.autonomi;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auton extends CommandGroup{

  public Auton(boolean onLevel2, boolean startMiddle, boolean invertTurns, boolean targetMiddle, boolean crossField, double distanceToTarget){

    int angleModifier, angleModifier2;
    
    if(invertTurns)
      angleModifier = -1;
    else 
      angleModifier = 1;

    if(onLevel2){

      //addSequential(new Drive4Distance(Constants.level2Length));
      //addSequential(new Drive4Time(0.25, -0.5));

    }

    //addSequential(new Drive4Distance(Constants.level1Length + Constants.firstExtra));

    if(startMiddle){
      
      if(targetMiddle){

        if(distanceToTarget == 1)
        angleModifier = -1;

        //addSequential(new TurnAngle(Constants.midToMidAngle * angleModifyer));
        //addSequential(new Drive4Distance(Constants.midToMidDistance));
        //addSequential(new TurnAngle(-Constants.midToMidAngle * angleModifyer));

      } else{

        //addSequential(new turnAngle(Constants.midToSideAngle * angleModifier));
        //addSequential(new Drive4Distance(Constants.midToSideDistance));
        //addSequential(new turnAngle(-Constants.midToSideAngle * angleModifier));
        //addSequential(new Drive4Distance(distanceToTarget));
        //addSequential(new turnAngle(90 * angleModifier));

      }

    } else {

      if(targetMiddle){

        if(invertTurns)
          distanceToTarget = Math.abs(distanceToTarget - 1);

        if(distanceToTarget == 0){

          //addSequential(new turnAngle(Constants.sideToCloseMidAngle * angleModifier));
          //addSequential(new Drive4Distance(Constants.sideToCloseMidDistance));
          //addSequential(new turnAngle(-Constants.sideToCloseMidAngle * angleModifier));

        } else {
          
          //addSequential(new turnAngle(Constants.sideToFarMidAngle * angleModifier));
          //addSequential(new Drive4Distance(Constants.sideToFarMidDistance));
          //addSequential(new turnAngle(-Constants.sideToFarMidAngle * angleModifier));

        }

      } else {

        if(crossField){

          angleModifier2 = -1;
          //addSequential(new turnAngle(Constants.crossAngle * angleModifier));
          //addSequential(new Drive4Distance(Constants.crossDistance));
          //addSequential(new turnAngle(-Constants.crossAngle * angleModifier));

        } else {

          angleModifier2 = 1;
          //addSequential(new turnAngle(Constants.sameSideAngle * angleModifier));
          //addSequential(new Drive4Distance(Constants.sameSidesDistance));
          //addSequential(new turnAngle(-Constants.sameSideAngle * angleModifier));

        }

        //addSequential(new Drive4Distance(distanceToTarget));
        //addSequential(new turnAngle(90 * angleModifier * angleModifier2));

      }
        
    }

    //addSequential(new Drive4Distance(Constants.distanceToHatch));
    //addSequential(new ReleaseHatchPanel());

  }

}
