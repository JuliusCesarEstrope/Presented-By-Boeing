
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class FourBarStartGroup extends CommandGroup{

  public FourBarStartGroup(boolean fourBarStart, boolean wristUp){
    
    


    
  
      addSequential(new (Constants.level2Length));
      addSequential(new Drive4Time(0.25, -0.5));

  
  }

}
