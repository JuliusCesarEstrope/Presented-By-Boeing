package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.ElevatorInPlaceCommand;
import frc.robot.utilities.RobotLog;

public class ElevatorHorizontalSubsystem extends Subsystem {
  static TalonSRX leftXElevatorMotor, rightXElevatorMotor;
  static DigitalInput fastSlowStopSensor;

  public ElevatorHorizontalSubsystem(int leftXElevatorMotorPort, int rightXElevatorMotorPort,
      double defaultElevatorPosition) {

    leftXElevatorMotor = new WPI_TalonSRX(leftXElevatorMotorPort);
    rightXElevatorMotor = new WPI_TalonSRX(rightXElevatorMotorPort);

    rightXElevatorMotor.follow(leftXElevatorMotor);
    rightXElevatorMotor.setInverted(true);

    RobotLog.putMessage("Running ElevatorHorizontalSubsystem");
  }

  public void setXElevatorMotors(double Speed) {
    leftXElevatorMotor.set(ControlMode.PercentOutput, Speed);
  }

  public boolean getfastSlowStopSensor() {
    return fastSlowStopSensor.get();
  }

  public void initDefaultCommand() {
    setDefaultCommand(new ElevatorInPlaceCommand());
  }

}