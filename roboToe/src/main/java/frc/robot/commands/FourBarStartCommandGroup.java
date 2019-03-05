
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;

public class FourBarStartCommandGroup extends CommandGroup {

  public FourBarStartCommandGroup(double setStartPoint) {

    addSequential(new WristCommand(Constants.wristUpSetPoint));
    addSequential(new FourBarCommand(Constants.setStartPoint));

  }

}
