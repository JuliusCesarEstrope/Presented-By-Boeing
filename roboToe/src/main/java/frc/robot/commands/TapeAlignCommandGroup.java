package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Drive4Distance;
import frc.robot.commands.TurnAngle;

public class TapeAlignCommandGroup extends CommandGroup {
  public TapeAlignCommandGroup() {
    
    addSequential(new TapeAlignCommand());
    addSequential(new TurnAngle(CommandBase.turnAngle));
    addSequential(new Drive4Distance(CommandBase.newDistanceToMove));

  }
}
