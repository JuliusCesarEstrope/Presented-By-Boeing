package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class ElevatorWristCommandGroup extends CommandGroup {
  public ElevatorWristCommandGroup() {
    RobotLog.putMessage("Running ElevatorWristCommandGroup");

    addSequential(new ElevatorManualCommand());
    addParallel(new WristCommand(Constants.wristUpSetPoint));
    
  }
}