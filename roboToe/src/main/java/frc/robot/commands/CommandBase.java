package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.OI;
import frc.robot.RobotMap;

/**
 * An example command.  You can replace me with your own command.
 */
public abstract class CommandBase extends Command {
  public static DriveSubsystem drive;
  public static OI oi;
  public void init() {
    oi = new OI();
    drive = new DriveSubsystem(RobotMap.leftMotor, RobotMap.rightMotor);
  }
  public void disable(){

  }
}
