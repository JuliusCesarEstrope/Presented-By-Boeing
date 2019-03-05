package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class ElevatorCommandGroup extends CommandGroup {
  public ElevatorCommandGroup() {
    RobotLog.putMessage("Running ElevatorCommandGroup");

    addSequential(new ElevatorVerticalCommand(Constants.distanceToTicks * 22));
    addSequential(new ElevatorHorizontalCommand());
    addSequential(new ElevatorVerticalCommand((Constants.distanceToTicks * 22) - (Constants.distanceToTicks * 1)));
    // add at same time for 2 above??????????????????
    addSequential(new ElevatorVerticalCommand(Constants.distanceToTicks * 5));

  }
}