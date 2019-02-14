package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.BooperSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.FourBarSubsystem;
import frc.robot.subsystems.RollerSubsystem;
import frc.robot.subsystems.WristSubsystem;

public abstract class CommandBase extends Command {
  public static OI oi;
  public static DriveSubsystem drive;
  public static WristSubsystem wrist;
  public static FourBarSubsystem fourBar;
  public static BooperSubsystem booper;
  public static RollerSubsystem roller;
  public static ElevatorSubsystem elevator;
  
  public static void init(){
    oi = new OI();
    drive = new DriveSubsystem(Constants.motorPortsLeft, Constants.motorPortsRight, Constants.gyroPort, Constants.driveEncoderPortLeft, Constants.driveEncoderPortRight, Constants.leftSensor, Constants.frontSensor, Constants.rightSensor , Constants.backSensor );
    fourBar = new FourBarSubsystem(Constants.leftFourBarMotorPort, Constants.rightFourBarMotorPort, Constants.rightBarEncoderPort, Constants.leftBarEncoderPort, Constants.gyroPort, Constants.fourBarPIDValues, Constants.setStartPoint, Constants.setFloorGatherPoint, Constants.setHatchLvlTwoPoint, Constants.setRocketLvlTwoPoint, Constants.setRocketLvlOnePoint, Constants.setClimbPoint, Constants.setBallLvlOnePoint, Constants.setBallLvlTwoPoint);
    roller = new RollerSubsystem(Constants.rollerMotor);
    booper = new BooperSubsystem(Constants.booperPort);
    wrist = new WristSubsystem(Constants.leftWristMotor, Constants.rightWristMotor, Constants.leftWristEncoder, Constants.rightWristEncoder,  Constants.driveRotationPIDValues);
    elevator = new ElevatorSubsystem(Constants.leftVerticalElevatorMotor, Constants.rightVerticalElevatorMotor, Constants.leftHorizontalElevatorMotor, Constants.rightHorizontalElevatorMotor, Constants.fastSlowStopSensor, Constants.verticalHeightSensor);

  }
  
  public static void disable(){

  }
}
