package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.TurnAngleCommand;;

public class TapeAlignCommandGroup extends CommandGroup {
  public TapeAlignCommandGroup() {
    
    addSequential(new TapeAlignCommand());
    addSequential(new TurnAngleCommand(CommandBase.turnAngle));
    addSequential(new Drive4Distance(CommandBase.newDistanceToMove));

  }
}
