
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;

<<<<<<< HEAD
public class FourBarStartGroup extends CommandGroup {

  public FourBarStartGroup(int setStartPoint) {

    addSequential(new WristCommand(Constants.wristUpSetPoint));
    addSequential(new FourBarCommand(Constants.setStartPoint));

=======
public class FourBarStartGroup extends CommandGroup{
    
  public FourBarStartGroup(boolean fourBarStart, boolean wristUp){
    int startPoint = 5;

    //addSequential(new FourBarCommand(Constants.level2Length));
     
    //addSequential(new Drive4Distance(Constants.level2Length));
    //addSequential(new Drive4Time(0.25, -0.5));

    //addSequential(new FourBarCommand(Constants.setStartPoint));
    //addSequential(new WristCommand(Constants.wristUpSetPoint));
>>>>>>> John-Schultz
  }
    
}
