
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;

public class FourBarBallLvlTwoGroup extends CommandGroup{

  public FourBarBallLvlTwoGroup(boolean ballLvlTwo, boolean wristUp){

      addSequential(new WristCommand(Constants.wristUpSetPoint));
      addSequential(new FourBarCommand(Constants.setStartPoint, Constants.setFloorGatherPoint,
      Constants.setHatchLvlTwoPoint, Constants.setRocketLvlTwoPoint, Constants.setRocketLvlOnePoint,
      Constants.setClimbPoint, Constants.setBallLvlOnePoint, Constants.setBallLvlTwoPoint));
     
  }

}
