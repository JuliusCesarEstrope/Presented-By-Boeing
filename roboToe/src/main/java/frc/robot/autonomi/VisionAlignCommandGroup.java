
package frc.robot.autonomi;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.TurnAngleCommand;
import frc.robot.commands.Drive4DistanceCommand;

public class VisionAlignCommandGroup extends CommandGroup{

  public VisionAlignCommandGroup(){

      double initialAngle = 45;
      double distanceToPosition = 12;
      double angleToPosition = -45;
      
     addSequential(new TurnAngleCommand(initialAngle));
     addSequential(new Drive4DistanceCommand(distanceToPosition));
     addSequential(new TurnAngleCommand(angleToPosition));
     
  
  }

}
