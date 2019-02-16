
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;

public class FourBarRocketLvlTwoGroup extends CommandGroup{

  public FourBarRocketLvlTwoGroup(boolean rocketLvlTwo, boolean wristUp){

      addSequential(new WristCommand(Constants.wristUpSetPoint));
      addSequential(new FourBarCommand(Constants.setRocketLvlTwoPoint));
     
  }

}
