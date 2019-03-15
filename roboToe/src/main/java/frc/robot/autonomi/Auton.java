
package frc.robot.autonomi;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;
import frc.robot.commands.BooperExtendCommand;
import frc.robot.commands.BooperRetractCommand;
import frc.robot.commands.Drive4DistanceCommand;
import frc.robot.commands.Drive4Time;
import frc.robot.commands.TurnAngleCommand;

public class Auton extends CommandGroup{

  public Auton(boolean onLevel2, boolean startMiddle, boolean invertTurns, boolean targetMiddle, boolean crossField, double distanceToTarget){

    int angleModifier, angleModifier2;
    
    if(invertTurns)
      angleModifier = -1;
    else 
      angleModifier = 1;

    if(onLevel2){

      addSequential(new Drive4DistanceCommand(Constants.level2Length));
      addSequential(new Drive4Time(0.25, -0.5));

    }

    addSequential(new Drive4Distance(Constants.level1Length + Constants.firstExtra));
    addSequential(new Drive4DistanceCommand(Constants.level1Length + Constants.firstExtra));

    if(startMiddle){
      
      if(targetMiddle){

        if(distanceToTarget == 1)
        angleModifier = -1;

        addSequential(new TurnAngleCommand(Constants.midToMidAngle * angleModifier));
        addSequential(new Drive4DistanceCommand(Constants.midToMidDistance));
        addSequential(new TurnAngleCommand(-Constants.midToMidAngle * angleModifier));

      } else{

        addSequential(new TurnAngleCommand(Constants.midToSideAngle * angleModifier));
        addSequential(new Drive4DistanceCommand(Constants.midToSideDistance));
        addSequential(new TurnAngleCommand(-Constants.midToSideAngle * angleModifier));
        addSequential(new Drive4DistanceCommand(distanceToTarget));
        addSequential(new TurnAngleCommand(90 * angleModifier));

      }

    } else {

      if(targetMiddle){

        if(invertTurns)
          distanceToTarget = Math.abs(distanceToTarget - 1);

        if(distanceToTarget == 0){

          addSequential(new TurnAngleCommand(Constants.sideToCloseMidAngle * angleModifier));
          addSequential(new Drive4DistanceCommand(Constants.sideToCloseMidDistance));
          addSequential(new TurnAngleCommand(-Constants.sideToCloseMidAngle * angleModifier));

        } else {
          
          addSequential(new TurnAngleCommand(Constants.sideToFarMidAngle * angleModifier));
          addSequential(new Drive4DistanceCommand(Constants.sideToFarMidDistance));
          addSequential(new TurnAngleCommand(-Constants.sideToFarMidAngle * angleModifier));

        }

      } else {

        if(crossField){

          angleModifier2 = -1;
          addSequential(new TurnAngleCommand(Constants.crossAngle * angleModifier));
          addSequential(new Drive4DistanceCommand(Constants.crossDistance));
          addSequential(new TurnAngleCommand(-Constants.crossAngle * angleModifier));

        } else {

          angleModifier2 = 1;
          addSequential(new TurnAngleCommand(Constants.sameSideAngle * angleModifier));
          addSequential(new Drive4DistanceCommand(Constants.sameSidesDistance));
          addSequential(new TurnAngleCommand(-Constants.sameSideAngle * angleModifier));

        }

        addSequential(new Drive4DistanceCommand(distanceToTarget));
        addSequential(new TurnAngleCommand(90 * angleModifier * angleModifier2));

      }
        
    }

    addSequential(new Drive4DistanceCommand(Constants.distanceToHatch));
    addSequential(new BooperExtendCommand());
    addSequential(new BooperRetractCommand());

  }

}
