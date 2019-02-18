
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class FourBarBallLvlTwoGroup extends CommandGroup{

  public FourBarBallLvlTwoGroup(int setBallLvlTwoPoint){
      RobotLog.putMessage("Running FourBarBallLvlTwoGroup");

      addSequential(new WristCommand(Constants.wristUpSetPoint));
      addSequential(new FourBarCommand(Constants.setBallLvlTwoPoint));
     
  }

}
