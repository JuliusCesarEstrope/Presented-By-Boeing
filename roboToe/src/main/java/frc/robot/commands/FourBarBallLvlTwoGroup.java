
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;

public class FourBarBallLvlTwoGroup extends CommandGroup{

  public FourBarBallLvlTwoGroup(int setBallLvlTwoPoint){

      addSequential(new WristCommand(Constants.wristUpSetPoint));
      addSequential(new FourBarCommand(Constants.setBallLvlTwoPoint));
     
  }

}
