package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class ElevatorCommandGroup extends CommandGroup {
  public ElevatorCommandGroup() {
    RobotLog.putMessage("Running ElevatorCommandGroup");

  
    addSequential(new ElevatorVerticalCommand(Constants.elevatorVerticalMin));
    addParallel(new ElevatorHorizontalAutoCommand());
    addSequential(new Drive4DistanceCommand(12)); 
    addSequential(new ElevatorVerticalCommand(Constants.distanceToTicks * 5));
  }
}