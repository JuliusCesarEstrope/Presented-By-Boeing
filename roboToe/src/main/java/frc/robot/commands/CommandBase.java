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
import frc.robot.subsystems.ElevatorAssistSubsystem;
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
  public static double turnAngle;
  public static ElevatorAssistSubsystem elevatorAssist;

  public static void init() {
    RobotLog.init();
    RobotLog.putMessage("Running CommandBase");
    led = new LEDLightSubsystem();
    drive = new DriveSubsystem(Constants.motorPortsLeft, Constants.motorPortsRight,
      Constants.gyroPort, Constants.frontSensor, Constants.rightSensor, Constants.backSensor,
      Constants.leftSensor, Constants.circumferenceOfWheels, Constants.ticksOfEncoder,
      Constants.driveRotationPIDValues);
    fourBar = new FourBarSubsystem(Constants.leftFourBarMotorPort, Constants.rightFourBarMotorPort,
        Constants.rightBarEncoderPort, Constants.leftBarEncoderPort, Constants.gyroPort, Constants.fourBarPIDValues);
    roller = new RollerSubsystem(Constants.rollerMotor);
    booper = new BooperSubsystem(Constants.booperPorts);
    wrist = new WristSubsystem(Constants.leftWristMotorPort, Constants.rightWristMotorPort, Constants.wristPIDValues);
    elevatorVertical = new ElevatorVerticalSubsystem(Constants.verticalElevatorMotor, Constants.elevatorEncoderPIDValues);
    elevatorHorizontal = new ElevatorHorizontalSubsystem(Constants.XElevatorMotorPort, Constants.defaultElevatorPosition, Constants.XElevatorEncoderPIDValues);
    elevatorAssist = new ElevatorAssistSubsystem(Constants.elevatorAssistPorts);
    oi = new OI();
    
    //led.setLEDLightColor(.87); // Blue
    wrist.ResetEncoder();
    elevatorVertical.resetElevatorEncoder();
    
  }

  public static void disable() {

  }
}
