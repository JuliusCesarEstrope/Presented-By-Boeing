
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;

public class FourBarRocketLvlOneGroup extends CommandGroup {

  public FourBarRocketLvlOneGroup(double setRocketLvlOnePoint) {

    addSequential(new WristCommand(Constants.wristUpSetPoint));
    addSequential(new FourBarCommand(Constants.setRocketLvlOnePoint));

  }

}
