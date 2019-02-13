package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.RollerSubsystem;
import frc.robot.OI;
import frc.robot.Constants;
public abstract class CommandBase extends Command{
  public static DriveSubsystem drive;
  public static OI oi;
  public static RollerSubsystem roller;
  public static ElevatorSubsystem elevator;

  public static void init(){
    oi = new OI();
    drive = new DriveSubsystem(Constants.motorPortsLeft, Constants.motorPortsRight, Constants.gyroPort, Constants.encoderPortLeft, Constants.encoderPortRight);
    //roller = new RollerSubsystem(Constants.rollerMotor);
    elevator = new ElevatorSubsystem(Constants.leftVerticalElevatorMotor, Constants.rightVerticalElevatorMotor, Constants.leftHorizontalElevatorMotor, Constants.rightHorizontalElevatorMotor, Constants.fastSlowStopSensor, Constants.verticalHeightSensor);
  }
  public static void disable(){

  }
}
