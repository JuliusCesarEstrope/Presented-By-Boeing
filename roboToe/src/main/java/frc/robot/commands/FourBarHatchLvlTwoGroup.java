
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class FourBarHatchLvlTwoGroup extends CommandGroup{

  public FourBarHatchLvlTwoGroup(int setHatchLvlTwoPoint){
      RobotLog.putMessage("Running FourBarHatchLvlTwoGroup");

      addSequential(new WristCommand(Constants.wristUpSetPoint));
      addSequential(new FourBarCommand(Constants.setHatchLvlTwoPoint));
      


  
  }

}
