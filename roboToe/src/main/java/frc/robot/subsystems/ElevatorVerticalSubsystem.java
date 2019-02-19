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

    /*
    leftElevatorEncoderPID = new PIDController(leftElevatorEncoderPIDValues[0], leftElevatorEncoderPIDValues[1],
        leftElevatorEncoderPIDValues[2], leftElevatorEncoderPIDValues[3], leftElevatorEncoder, pidOutput);
    leftElevatorEncoderPID.setEnabled(true);
    leftElevatorEncoderPID.setContinuous(true);
    leftElevatorEncoderPID.setAbsoluteTolerance(1);
    leftElevatorEncoderPID.setOutputRange(-.6, .6);
    leftElevatorEncoderPID.setInputRange(-Double.MAX_VALUE, Double.MAX_VALUE);
    leftElevatorEncoderPID.enable();
    leftYElevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

    rightElevatorEncoderPID = new PIDController(rightElevatorEncoderPIDValues[0], rightElevatorEncoderPIDValues[1],
        rightElevatorEncoderPIDValues[2], rightElevatorEncoderPIDValues[3], rightElevatorEncoder, pidOutput);
    rightElevatorEncoderPID.setEnabled(true);
    rightElevatorEncoderPID.setContinuous(true);
    rightElevatorEncoderPID.setAbsoluteTolerance(1);
    rightElevatorEncoderPID.setOutputRange(-.6, .6);
    rightElevatorEncoderPID.setInputRange(-Double.MAX_VALUE, Double.MAX_VALUE);
    rightElevatorEncoderPID.enable();
    rightYElevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute); 
    */

    leftYElevatorMotor.configNominalOutputForward(0);
    leftYElevatorMotor.configNominalOutputReverse(0);
    leftYElevatorMotor.configPeakOutputForward(.6);
    leftYElevatorMotor.configPeakOutputReverse(.6);
    leftYElevatorMotor.config_kP(0, leftElevatorEncoderPIDValues[0]);
    leftYElevatorMotor.config_kI(0, leftElevatorEncoderPIDValues[1]);
    leftYElevatorMotor.config_kD(0, leftElevatorEncoderPIDValues[2]);
    leftYElevatorMotor.config_kF(0, leftElevatorEncoderPIDValues[3]);

    rightYElevatorMotor.configNominalOutputForward(0);
    rightYElevatorMotor.configNominalOutputReverse(0);
    rightYElevatorMotor.configPeakOutputForward(.6);
    rightYElevatorMotor.configPeakOutputReverse(-.6);
    rightYElevatorMotor.config_kP(0, rightElevatorEncoderPIDValues[0]);
    rightYElevatorMotor.config_kI(0, rightElevatorEncoderPIDValues[1]);
    rightYElevatorMotor.config_kD(0, rightElevatorEncoderPIDValues[2]);
    rightYElevatorMotor.config_kF(0, rightElevatorEncoderPIDValues[3]);

    RobotLog.putMessage("Running ElevatorVerticalSubsystem");
  }

  public void setYElevatorMotors(double Speed) {
    leftYElevatorMotor.set(ControlMode.PercentOutput, Speed);
  }

  public double getElevatorMotorsCurrent(){
    return leftYElevatorMotor.getOutputCurrent();
  }

  public int getLeftElevatorEncoder() {
    return leftYElevatorMotor.getSelectedSensorPosition();
  }

  public int getRightElevatorEncoder() {
    return rightYElevatorMotor.getSelectedSensorPosition();
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
    // leftElevatorEncoderPID.setPID(p, i, d);
    // leftElevatorEncoderPID.setP(p);
    // leftElevatorEncoderPID.setI(i);
    // leftElevatorEncoderPID.setD(d);

    // rightElevatorEncoderPID.setPID(p, i, d);
    // rightElevatorEncoderPID.setP(p);
    // rightElevatorEncoderPID.setI(i);
    // rightElevatorEncoderPID.setD(d);

    leftYElevatorMotor.config_kP(0, p);
    leftYElevatorMotor.config_kI(0, i);
    leftYElevatorMotor.config_kD(0, d);

    rightYElevatorMotor.config_kP(0, p);
    rightYElevatorMotor.config_kI(0, i);
    rightYElevatorMotor.config_kD(0, d);
  }

  public void setBothElevatorEncoderPIDValues(double p, double i, double d, double f) {
    // leftElevatorEncoderPID.setPID(p, i, d, f);
    // leftElevatorEncoderPID.setP(p);
    // leftElevatorEncoderPID.setI(i);
    // leftElevatorEncoderPID.setD(d);
    // leftElevatorEncoderPID.setF(f);

    // rightElevatorEncoderPID.setPID(p, i, d, f);
    // rightElevatorEncoderPID.setP(p);
    // rightElevatorEncoderPID.setI(i);
    // rightElevatorEncoderPID.setD(d);
    // rightElevatorEncoderPID.setF(f);

    leftYElevatorMotor.config_kP(0, p);
    leftYElevatorMotor.config_kI(0, i);
    leftYElevatorMotor.config_kD(0, d);
    leftYElevatorMotor.config_kF(0, f);

    rightYElevatorMotor.config_kP(0, p);
    rightYElevatorMotor.config_kI(0, i);
    rightYElevatorMotor.config_kD(0, d);
    rightYElevatorMotor.config_kF(0, f);
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