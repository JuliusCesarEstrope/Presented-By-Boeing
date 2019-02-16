
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;

public class FourBarHatchLvlTwoGroup extends CommandGroup{

  public FourBarHatchLvlTwoGroup(int setHatchLvlTwoPoint){

      addSequential(new WristCommand(Constants.wristUpSetPoint));
      addSequential(new FourBarCommand(Constants.setHatchLvlTwoPoint));
      


  
  }

}
