
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;

public class FourBarRocketLvlOneGroup extends CommandGroup{

  public FourBarRocketLvlOneGroup(boolean rocketLvlOne, boolean wristUp){

      addSequential(new WristCommand(Constants.wristUpSetPoint));
      addSequential(new FourBarCommand(Constants.setRocketLvlOnePoint));
     
  }

}
