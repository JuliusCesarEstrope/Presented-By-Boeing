package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class ElevatorAutoTest extends CommandGroup {
  public ElevatorAutoTest() {
    RobotLog.putMessage("Running ElevatorAutoTest");

  
    addSequential(new ElevatorVerticalCommand(Constants.elevatorVerticalMin));
  }
}