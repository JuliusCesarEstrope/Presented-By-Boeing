package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.BooperSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorHorizontalSubsystem;
import frc.robot.subsystems.ElevatorVerticalSubsystem;
import frc.robot.subsystems.FourBarSubsystem;
import frc.robot.subsystems.LEDLightSubsystem;
import frc.robot.subsystems.RollerSubsystem;
import frc.robot.subsystems.WristSubsystem;
import frc.robot.utilities.RobotLog;

public abstract class CommandBase extends Command {

  public static OI oi;
  public static LEDLightSubsystem led;
  public static DriveSubsystem drive;
  public static WristSubsystem wrist;
  public static FourBarSubsystem fourBar;
  public static BooperSubsystem booper;
  public static RollerSubsystem roller;
  public static ElevatorVerticalSubsystem elevatorVertical;
  public static ElevatorHorizontalSubsystem elevatorHorizontal;
  public static double newDistanceToMove;
  public static double turnAngle;

  public static void init() {
    RobotLog.putMessage("Running CommandBase");
    oi = new OI();
    led = new LEDLightSubsystem();
    drive = new DriveSubsystem(Constants.motorPortsLeft, Constants.motorPortsRight, Constants.gyroPort, Constants.driveEncoderPortLeft, Constants.driveEncoderPortRight, Constants.frontSensor, Constants.rightSensor, 
    Constants.backSensor, Constants.leftSensor, Constants.driveEncoderPortLeft, Constants.driveEncoderPortRight, Constants.circumferenceOfWheels, Constants.ticksOfEncoder);
    fourBar = new FourBarSubsystem(Constants.leftFourBarMotorPort, Constants.rightFourBarMotorPort,
        Constants.rightBarEncoderPort, Constants.leftBarEncoderPort, Constants.gyroPort, Constants.fourBarPIDValues);
    roller = new RollerSubsystem(Constants.rollerMotor);
    booper = new BooperSubsystem(Constants.booperPorts);
    wrist = new WristSubsystem(Constants.leftWristMotor, Constants.rightWristMotor, Constants.leftWristEncoder, Constants.rightWristEncoder,  Constants.driveRotationPIDValues);
    elevatorVertical = new ElevatorVerticalSubsystem(Constants.leftVerticalElevatorMotor, Constants.rightVerticalElevatorMotor, Constants.leftElevatorEncoder, Constants.rightElevatorEncoder, Constants.leftElevatorEncoderPIDValues, Constants.rightElevatorEncoderPIDValues);
    elevatorHorizontal = new ElevatorHorizontalSubsystem(Constants.leftHorizontalElevatorMotor, Constants.rightHorizontalElevatorMotor, Constants.defaultElevatorPosition);

    led.setLEDLightColor(.87); // Blue
  }

  public static void disable() {

  }
}
