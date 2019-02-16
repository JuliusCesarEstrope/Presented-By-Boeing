package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.BooperSubsystem;
import frc.robot.subsystems.DriveSubsystem;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import frc.robot.subsystems.ElevatorHorizontalSubsystem;
import frc.robot.subsystems.ElevatorVerticalSubsystem;
>>>>>>> Maggie
=======
import frc.robot.subsystems.ElevatorHorizontalSubsystem;
import frc.robot.subsystems.ElevatorVerticalSubsystem;
>>>>>>> Maggie
import frc.robot.subsystems.FourBarSubsystem;
import frc.robot.subsystems.RollerSubsystem;
import frc.robot.subsystems.WristSubsystem;
import frc.robot.utilities.RobotLog;

public abstract class CommandBase extends Command {

  public static OI oi;
  public static DriveSubsystem drive;
  public static WristSubsystem wrist;
  public static FourBarSubsystem fourBar;
  public static BooperSubsystem booper;
  public static RollerSubsystem roller;
  public static ElevatorVerticalSubsystem elevatorVertical;
  public static ElevatorHorizontalSubsystem elevatorHorizontal;

  public static void init() {
    RobotLog.putMessage("Running CommandBase");
    oi = new OI();
    drive = new DriveSubsystem(Constants.motorPortsLeft, Constants.motorPortsRight, Constants.gyroPort,
        Constants.driveEncoderPortLeft, Constants.driveEncoderPortRight, Constants.leftSensor, Constants.frontSensor,
        Constants.rightSensor, Constants.backSensor, Constants.circumferenceOfWheels, Constants.ticksOfEncoder);
    fourBar = new FourBarSubsystem(Constants.leftFourBarMotorPort, Constants.rightFourBarMotorPort,
        Constants.rightBarEncoderPort, Constants.leftBarEncoderPort, Constants.gyroPort, Constants.fourBarPIDValues,
        Constants.setStartPoint, Constants.setFloorGatherPoint, Constants.setHatchLvlTwoPoint,
        Constants.setRocketLvlTwoPoint, Constants.setRocketLvlOnePoint, Constants.setClimbPoint,
        Constants.setBallLvlOnePoint, Constants.setBallLvlTwoPoint);
    roller = new RollerSubsystem(Constants.rollerMotor);
    booper = new BooperSubsystem(Constants.booperPorts);
    wrist = new WristSubsystem(Constants.leftWristMotor, Constants.rightWristMotor, Constants.leftWristEncoder, Constants.rightWristEncoder,  Constants.driveRotationPIDValues);
    elevatorVertical = new ElevatorVerticalSubsystem(Constants.leftVerticalElevatorMotor, Constants.rightVerticalElevatorMotor, Constants.leftElevatorEncoder, Constants.rightElevatorEncoder, Constants.leftElevatorEncoderPIDValues, Constants.rightElevatorEncoderPIDValues);
    elevatorHorizontal = new ElevatorHorizontalSubsystem(Constants.leftHorizontalElevatorMotor, Constants.rightHorizontalElevatorMotor, Constants.defaultElevatorPosition);
  }

  public static void disable() {

  }
}
