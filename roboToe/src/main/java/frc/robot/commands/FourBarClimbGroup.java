
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;

public class FourBarClimbGroup extends CommandGroup{

  public FourBarClimbGroup(boolean climb, boolean wristUp){

      addSequential(new WristCommand(Constants.wristUpSetPoint));
      addSequential(new FourBarCommand(Constants.setClimbPoint));
      
     
  }

}
