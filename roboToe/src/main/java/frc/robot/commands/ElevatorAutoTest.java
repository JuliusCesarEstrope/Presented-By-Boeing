package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class ElevatorAutoTest extends CommandGroup {
  public ElevatorAutoTest() {
    RobotLog.putMessage("Running ElevatorAutoTest");

  
    addSequential(new ElevatorVerticalCommand(Constants.elevatorVerticalMin));
    addSequential(new WaitCommand(0.5));
    addParallel(new ElevatorHorizontalAutoCommand());
    addSequential(new Drive4Time(3, -0.6)); 
    
  }
}