
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class FourBarClimbGroup extends CommandGroup{

  public FourBarClimbGroup(int setClimbPoint){
      RobotLog.putMessage("Running FourBarClimbGroup");

      addSequential(new WristCommand(Constants.wristUpSetPoint));
      addSequential(new FourBarCommand(Constants.setClimbPoint));
      
     
  }

}
