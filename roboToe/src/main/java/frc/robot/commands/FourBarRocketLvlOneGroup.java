
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class FourBarRocketLvlOneGroup extends CommandGroup{

  public FourBarRocketLvlOneGroup(int setRocketLvlOnePoint){
      RobotLog.putMessage("Running FourBarRocketLvlOneGroup");

      addSequential(new WristCommand(Constants.wristUpSetPoint));
      addSequential(new FourBarCommand(Constants.setRocketLvlOnePoint));
     
  }

}
