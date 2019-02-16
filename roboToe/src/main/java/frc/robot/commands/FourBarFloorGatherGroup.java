
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;

public class FourBarFloorGatherGroup extends CommandGroup{

  public FourBarFloorGatherGroup(int setFloorGatherPoint){

      addSequential(new FourBarCommand(Constants.setFloorGatherPoint));
      addSequential(new WristCommand(Constants.wristDownSetPoint));
     

  
  }

}
