
package frc.robot.autonomi;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.autonomi.components.BooperExtendCommand;
import frc.robot.autonomi.components.BooperRetractCommand;

public class BooperAuton extends CommandGroup{

  public BooperAuton(){

    addSequential(new BooperExtendCommand());
    addSequential(new WaitForTime(0.5));
    addSequential(new BooperRetractCommand());

  }

}
