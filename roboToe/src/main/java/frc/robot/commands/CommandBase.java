package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.RollerSubsystem;
import frc.robot.subsystems.WristSubsystem;

public abstract class CommandBase extends Command {
  public static DriveSubsystem drive;
  public static OI oi;
  public static RollerSubsystem roller;
  public static WristSubsystem wrist;
  public static void init(){
    oi = new OI();
    drive = new DriveSubsystem(Constants.motorPortsLeft, Constants.motorPortsRight, Constants.gyroPort, Constants.encoderPortLeft, Constants.encoderPortRight);
    wrist = new WristSubsystem(Constants.leftWristMotor, Constants.rightWristMotor, Constants.leftWristEncoder, Constants.rightWristEncoder,  Constants.driveRotationPIDValues);
    //roller = new RollerSubsystem(Constants.rollerMotor);
  }
  public static void disable(){

  }
}
