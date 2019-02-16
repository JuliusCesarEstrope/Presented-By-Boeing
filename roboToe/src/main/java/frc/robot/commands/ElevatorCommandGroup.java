package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class ElevatorCommandGroup extends CommandGroup {
  public ElevatorCommandGroup() {
    RobotLog.putMessage("Running ElevatorCommandGroup");

    addSequential(new ElevatorVerticalCommand(Constants.distanceYToTravel));
    addSequential(new ElevatorHorizontalCommand());
    addSequential(new ElevatorVerticalCommand(Constants.distanceYToTravel - Constants.distanceYInch));
    addSequential(new ElevatorVerticalCommand(Constants.distanceYFiveInch));

  }
}