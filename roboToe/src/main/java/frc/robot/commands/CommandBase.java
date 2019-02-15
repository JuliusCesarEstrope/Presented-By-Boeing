package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ElevatorVerticalSubsystem;
import frc.robot.subsystems.ElevatorHorizontalSubsystem;

public abstract class CommandBase extends Command {
  public static DriveSubsystem drive;
  public static OI oi;
  public static ElevatorVerticalSubsystem elevatorVertical;
  public static ElevatorHorizontalSubsystem elevatorHorizontal;

  public static void init() {
    oi = new OI();
    drive = new DriveSubsystem(Constants.leftMotor, Constants.rightMotor, Constants.gyro);
    elevatorVertical = new ElevatorVerticalSubsystem(Constants.leftVerticalElevatorMotor, Constants.rightVerticalElevatorMotor, Constants.leftElevatorEncoder, Constants.rightElevatorEncoder, Constants.leftElevatorEncoderPIDValues, Constants.rightElevatorEncoderPIDValues);
    elevatorHorizontal = new ElevatorHorizontalSubsystem(Constants.leftHorizontalElevatorMotor, Constants.rightHorizontalElevatorMotor, Constants.defaultElevatorPosition);
  }

  public static void disable() {

  }
}
