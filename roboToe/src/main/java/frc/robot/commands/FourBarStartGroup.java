
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;

public class FourBarStartGroup extends CommandGroup{

  public FourBarStartGroup(){

    addSequential(new FourBarCommand(Constants.setStartPoint));
    addSequential(new WristCommand(Constants.wristUpSetPoint));
    
    }
  }
