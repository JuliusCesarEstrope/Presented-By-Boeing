package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;

public class ElevatorCommandGroup extends CommandGroup {
  public ElevatorCommandGroup() {
    
    addSequential(new ElevatorVerticalCommand(Constants.distanceYToTravel));
    addSequential(new ElevatorHorizontalCommand());
    addSequential(new ElevatorVerticalCommand(Constants.distanceYToTravel - Constants.distanceYInch));
    addSequential(new ElevatorVerticalCommand(Constants.distanceYFiveInch));

  }
}
