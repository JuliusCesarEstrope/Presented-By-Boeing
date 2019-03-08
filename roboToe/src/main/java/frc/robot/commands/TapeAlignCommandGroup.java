package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.utilities.RobotLog;

public class TapeAlignCommandGroup extends CommandGroup {

  public TapeAlignCommandGroup() {
    RobotLog.putMessage("Running TapeAlignCommandGroup");
    
    addSequential(new TapeAlignCommand());
    addSequential(new TurnAngle(CommandBase.turnAngle));
    addSequential(new Drive4Distance(CommandBase.newDistanceToMove));

  }
}
