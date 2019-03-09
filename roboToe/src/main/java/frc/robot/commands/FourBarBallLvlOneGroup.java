package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class FourBarBallLvlOneGroup extends CommandGroup{

  public FourBarBallLvlOneGroup(double setBallLvlOnePoint){
      RobotLog.putMessage("Running FourBarBallLvlOneGroup");

      addSequential(new WristCommand(Constants.wristUpSetPoint));
      addSequential(new FourBarCommand(Constants.setBallLvlOnePoint));
      addSequential(new WristCommand(Constants.wristDownSetPoint));
     
  }

}