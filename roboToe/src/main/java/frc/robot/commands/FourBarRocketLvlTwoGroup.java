
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class FourBarRocketLvlTwoGroup extends CommandGroup{

  public FourBarRocketLvlTwoGroup(int setRocketLvlTwoPoint){
      RobotLog.putMessage("Running FourBarRocketLvlTwoGroup");

      addSequential(new WristCommand(Constants.wristUpSetPoint));
      addSequential(new FourBarCommand(Constants.setRocketLvlTwoPoint));
     
  }

}