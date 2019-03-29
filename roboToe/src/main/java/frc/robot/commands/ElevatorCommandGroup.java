package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class ElevatorCommandGroup extends CommandGroup {
  public ElevatorCommandGroup() {
    RobotLog.putMessage("Running ElevatorCommandGroup");

  
    addSequential(new ElevatorVerticalCommand(Constants.elevatorVerticalMin));
    addSequential(new WaitCommand(0.5));
    addParallel(new ElevatorHorizontalAutoCommand());
    addSequential(new Drive4Time(3, -0.6)); 
    addSequential(new WaitCommand(0.5));
    addSequential(new Drive4DistanceCommand(1)); 
    addSequential(new WaitCommand(0.5));
    addSequential(new ElevatorAssistAutoCommand());
    addSequential(new WaitCommand(0.5));
    addSequential(new ElevatorVerticalCommand(Constants.elevatorVerticalMin + 
      Constants.distanceToTicks * 5));
  }
}