
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;

public class FourBarStartGroup extends CommandGroup{

  public FourBarStartGroup(boolean fourBarStart, boolean wristUp){

      addSequential(new WristCommand(Constants.wristUpSetPoint));
      addSequential(new FourBarCommand(Constants.setStartPoint));
      
     
  }

}
