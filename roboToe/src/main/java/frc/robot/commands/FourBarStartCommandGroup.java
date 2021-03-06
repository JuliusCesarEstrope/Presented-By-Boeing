package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class FourBarStartCommandGroup extends CommandGroup {

  public FourBarStartCommandGroup(double setStartPoint) {
    RobotLog.putMessage("Running FourBarStartCommandGroup");

    addSequential(new WristCommand(Constants.wristUpSetPoint));
    addSequential(new FourBarCommand(Constants.setStartPoint));

  }
    
}
