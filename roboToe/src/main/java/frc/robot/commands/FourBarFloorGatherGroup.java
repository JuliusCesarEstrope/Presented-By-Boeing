
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;

public class FourBarFloorGatherGroup extends CommandGroup{

  public FourBarFloorGatherGroup(boolean floorGather, boolean wristDown){

      addSequential(new FourBarCommand(Constants.setStartPoint, Constants.setFloorGatherPoint,
      Constants.setHatchLvlTwoPoint, Constants.setRocketLvlTwoPoint, Constants.setRocketLvlOnePoint,
      Constants.setClimbPoint, Constants.setBallLvlOnePoint, Constants.setBallLvlTwoPoint));
      addSequential(new WristCommand(Constants.wristDownSetPoint));
     

  
  }

}
