
package frc.robot.autonomi;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Drive4DistanceCommand;
import frc.robot.commands.TurnAngleCommand;

public class VisionAlignCommandGroup extends CommandGroup{

  public VisionAlignCommandGroup(){
    
    NetworkTableInstance tableInstance = NetworkTableInstance.getDefault();
    NetworkTable visionTable = tableInstance.getTable("SmartDashboard");

    double initialAngle = visionTable.getEntry("FirstAngle").getDouble(45);
    double distanceToPosition = visionTable.getEntry("Distance").getDouble(12);
    double angleToPosition = visionTable.getEntry("SecondAngle").getDouble(-45);
      
     addSequential(new TurnAngleCommand(initialAngle));
     addSequential(new Drive4DistanceCommand(distanceToPosition));
     addSequential(new TurnAngleCommand(angleToPosition));
     
  }

}
