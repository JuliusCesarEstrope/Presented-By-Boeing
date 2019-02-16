package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.ElevatorSetpointCommand;
import frc.robot.utilities.RobotLog;

public class ElevatorVerticalSubsystem extends Subsystem {
  static TalonSRX leftYElevatorMotor, rightYElevatorMotor;
  static Encoder leftElevatorEncoder, rightElevatorEncoder;
  private static PIDController leftElevatorEncoderPID;
  private static PIDController rightElevatorEncoderPID;
  private static PIDOutput pidOutput;

  public ElevatorVerticalSubsystem(int leftYElevatorMotorPort, int rightYElevatorMotorPort,
      int[] leftElevatorEncoderPorts, int[] rightElevatorEncoderPorts, double[] leftElevatorEncoderPIDValues,
      double[] rightElevatorEncoderPIDValues) {

    leftYElevatorMotor = new WPI_TalonSRX(leftYElevatorMotorPort);
    rightYElevatorMotor = new WPI_TalonSRX(rightYElevatorMotorPort);

    rightYElevatorMotor.follow(leftYElevatorMotor);
    rightYElevatorMotor.setInverted(true);

    leftElevatorEncoder = new Encoder(leftElevatorEncoderPorts[1], leftElevatorEncoderPorts[2]);
    rightElevatorEncoder = new Encoder(rightElevatorEncoderPorts[3], rightElevatorEncoderPorts[4]);

    leftElevatorEncoderPID = new PIDController(leftElevatorEncoderPIDValues[0], leftElevatorEncoderPIDValues[1],
        leftElevatorEncoderPIDValues[2], leftElevatorEncoderPIDValues[3], leftElevatorEncoder, pidOutput);
    leftElevatorEncoderPID.setEnabled(true);
    leftElevatorEncoderPID.setContinuous(true);
    leftElevatorEncoderPID.setAbsoluteTolerance(.3);
    // FIGURE OUT ABOVE
    leftElevatorEncoderPID.setOutputRange(-.6, .6);
    // FIGURE OUT ABOVE
    leftElevatorEncoderPID.setInputRange(0, 5);
    // FIGURE OUT ABOVE
    leftElevatorEncoderPID.enable();

    rightElevatorEncoderPID = new PIDController(rightElevatorEncoderPIDValues[0], rightElevatorEncoderPIDValues[1],
        rightElevatorEncoderPIDValues[2], rightElevatorEncoderPIDValues[3], rightElevatorEncoder, pidOutput);
    rightElevatorEncoderPID.setEnabled(true);
    rightElevatorEncoderPID.setContinuous(true);
    rightElevatorEncoderPID.setAbsoluteTolerance(.3);
    // FIGURE OUT ABOVE
    rightElevatorEncoderPID.setOutputRange(-.6, .6);
    // FIGURE OUT ABOVE
    rightElevatorEncoderPID.setInputRange(0, 5);
    // FIGURE OUT ABOVE
    rightElevatorEncoderPID.enable();

    RobotLog.putMessage("Running ElevatorVerticalSubsystem");
  }

  public void setYElevatorMotors(double Speed) {
    leftYElevatorMotor.set(ControlMode.PercentOutput, Speed);
  }

  public int getLeftElevatorEncoder() {
    return leftElevatorEncoder.get();
  }

  public int getRightElevatorEncoder() {
    return rightElevatorEncoder.get();
  }

  public void resetBothElevatorEncoders() {
    leftElevatorEncoder.reset();
    rightElevatorEncoder.reset();
  }

  public void enableBothElevatorEncoderPIDValues() {
    leftElevatorEncoderPID.enable();
    rightElevatorEncoderPID.enable();
  }

  public void setBothElevatorEncoderPIDValues(double p, double i, double d) {
    leftElevatorEncoderPID.setPID(p, i, d);
    rightElevatorEncoderPID.setPID(p, i, d);
  }

  public void setBothElevatorEncoderPIDValues(double p, double i, double d, double f) {
    leftElevatorEncoderPID.setPID(p, i, d, f);
    rightElevatorEncoderPID.setPID(p, i, d, f);
  }

  public void setLeftElevatorEncoderSetpoint(double leftElevatorEncoder) {
    leftElevatorEncoderPID.setSetpoint(leftElevatorEncoder);
  }

  public void setRightElevatorEncoderSetpoint(double rightElevatorEncoder) {
    rightElevatorEncoderPID.setSetpoint(rightElevatorEncoder);
  }

  public boolean checkOnTargetSetpoint() {
    return leftElevatorEncoderPID.onTarget();
  }

  public double getLeftElevatorEncoderPIDOutput() {
    return leftElevatorEncoderPID.get();
  }

  public double getRightElevatorEncoderPIDOutput() {
    return rightElevatorEncoderPID.get();
  }

  public void disableBothElevatorEncoderPIDValues() {
    leftElevatorEncoderPID.disable();
    rightElevatorEncoderPID.disable();
  }

  public void initDefaultCommand() {
    setDefaultCommand(new ElevatorSetpointCommand(Constants.defaultElevatorPosition));
  }

}