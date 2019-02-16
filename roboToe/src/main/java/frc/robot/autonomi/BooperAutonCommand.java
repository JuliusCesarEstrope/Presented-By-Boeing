
package frc.robot.autonomi;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.autonomi.components.BooperExtendCommand;
import frc.robot.autonomi.components.BooperRetractCommand;

public class BooperAutonCommand extends CommandGroup{

  public BooperAutonCommand(){

    addSequential(new BooperExtendCommand());
    addSequential(new WaitForTimeCommand(0.5));
    addSequential(new BooperRetractCommand());

  }

}
