
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class FourBarFloorGatherGroup extends CommandGroup {

  public FourBarFloorGatherGroup(double setFloorGatherPoint){
      RobotLog.putMessage("Running FourBarFloorGatherGroup");

    addSequential(new WristCommand(Constants.wristUpSetPoint));
    addSequential(new FourBarCommand(Constants.setFloorGatherPoint));
    addSequential(new WristCommand(Constants.wristDownSetPoint));

  }

}
