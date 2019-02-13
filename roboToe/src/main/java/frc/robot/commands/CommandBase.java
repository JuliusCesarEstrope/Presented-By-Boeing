package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.FourBarSubsystem;
import frc.robot.subsystems.RollerSubsystem;

public abstract class CommandBase extends Command{
  public static DriveSubsystem drive;
  public static OI oi;
  public static RollerSubsystem roller;
  public static FourBarSubsystem fourBar;

  public static void init(){
    oi = new OI();
    drive = new DriveSubsystem(Constants.motorPortsLeft, Constants.motorPortsRight, Constants.gyroPort, Constants.encoderPortLeft, Constants.encoderPortRight);
    fourBar = new FourBarSubsystem(Constants.leftFourBarMotorPort, Constants.rightFourBarMotorPort, Constants.rightBarEncoderPort, Constants.leftBarEncoderPort, Constants.gyroPort, Constants.fourBarPIDValues, Constants.setStartPoint, Constants.setFloorGatherPoint, Constants.setHatchLvlTwoPoint, Constants.setRocketLvlTwoPoint, Constants.setRocketLvlOnePoint, Constants.setClimbPoint, Constants.setBallLvlOnePoint, Constants.setBallLvlTwoPoint);
    //roller = new RollerSubsystem(Constants.rollerMotor);
  }
  public static void disable(){

  }
}
