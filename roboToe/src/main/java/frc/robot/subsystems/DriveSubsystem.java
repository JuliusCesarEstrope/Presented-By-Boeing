package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.TankDrive;

public class DriveSubsystem extends Subsystem {
  static TalonSRX[] leftMotor, rightMotor;
  static AnalogGyro gyro;

  public DriveSubsystem(int[] leftMotorPorts, int[] rightMotorPorts, int gyro) {
    leftMotor = new WPI_TalonSRX[leftMotorPorts.length];
    rightMotor = new WPI_TalonSRX[rightMotorPorts.length];
    this.gyro = new AnalogGyro(gyro);
    for (int i = 0; i < leftMotorPorts.length; i++) {
      leftMotor[i] = new WPI_TalonSRX(leftMotorPorts[i]);
    }
    for (int i = 0; i < rightMotorPorts.length; i++) {
      rightMotor[i] = new WPI_TalonSRX(rightMotorPorts[i]);
    }
  }

  public void setLeftMotor(double Speed) {
    for (int i = 0; i < leftMotor.length; i++) {
      leftMotor[i].set(ControlMode.PercentOutput, Speed);
    }
  }

  public void setRightMotor(double Speed) {
    for (int i = 0; i < rightMotor.length; i++) {
      rightMotor[i].set(ControlMode.PercentOutput, -Speed);
    }
  }

  public void setBothMotor(double leftSpeed, double rightSpeed) {
    setLeftMotor(leftSpeed);
    setRightMotor(rightSpeed);
  }

  public double getAngle() {
    return gyro.getAngle();
  }

  public void resetAngle() {
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TankDrive());
  }
}
