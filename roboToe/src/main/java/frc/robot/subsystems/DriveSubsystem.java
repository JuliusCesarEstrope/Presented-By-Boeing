package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.TankDriveCommand;
import frc.robot.utilities.DoublePIDOutput;
import frc.robot.utilities.RobotLog;

public class DriveSubsystem extends Subsystem {
  TalonSRX talonLeft, talonRight;
  DoublePIDOutput gyroOutput;
  VictorSPX[] victorsLeft, victorsRight;
  AnalogGyro gyroDrive;
  double pidTolerance = 70;
  double ramp = 0;
  static DigitalInput leftSensor;
  static DigitalInput frontSensor;
  static DigitalInput rightSensor;
  static DigitalInput backSensor;
  private static PIDController gyroPID;
  private static int tolerance = 70;
  

  public DriveSubsystem(int[] motorPortsLeft, int[] motorPortsRight, int gyroPort, int encoderPortLeft[],
      int encoderPortRight[], int frontSensor, int rightSensor, int backSensor, int leftSensor,
      int[] driveEncoderPortLeft, int[] driveEncoderPortRight, double circumferanceOfWheels, double ticksOfEncoder, double[] drivePIDValues) {

    gyroDrive = new AnalogGyro(gyroPort);
    talonLeft = new WPI_TalonSRX(motorPortsLeft[0]);
    talonRight = new WPI_TalonSRX(motorPortsRight[0]);
    gyroOutput = new DoublePIDOutput();

    talonLeft.configFactoryDefault();
    talonRight.configFactoryDefault();
    talonLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
    talonRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

    talonLeft.configPeakOutputForward(0.5);
    talonLeft.configPeakOutputReverse(-0.5);
    talonLeft.configClosedloopRamp(ramp);
    talonLeft.config_kP(0, drivePIDValues[0]);
    talonLeft.config_kI(0, drivePIDValues[1]);
    talonLeft.config_kD(0, drivePIDValues[2]);
    talonLeft.config_kF(0, drivePIDValues[3]);
    talonLeft.setSensorPhase(true);

    talonRight.configPeakOutputForward(0.5);
    talonRight.configPeakOutputReverse(-0.5);
    talonRight.configClosedloopRamp(ramp);
    talonRight.config_kP(0, drivePIDValues[0]);
    talonRight.config_kI(0, drivePIDValues[1]);
    talonRight.config_kD(0, drivePIDValues[2]);
    talonRight.config_kF(0, drivePIDValues[3]);
    talonRight.setSensorPhase(true);
    talonRight.setInverted(true);

    talonLeft.setNeutralMode(NeutralMode.Brake);
    talonRight.setNeutralMode(NeutralMode.Brake);

    gyroPID = new PIDController(0.05, 0, 0, gyroDrive, gyroOutput);
    gyroPID.setAbsoluteTolerance(1);
    gyroPID.setInputRange(-Integer.MAX_VALUE, Integer.MAX_VALUE);
    gyroPID.setOutputRange(-1, 1);
    gyroPID.setEnabled(true);

    RobotLog.putMessage("Running DriveSubsystem");
    victorsLeft = new WPI_VictorSPX[motorPortsLeft.length - 1];
    victorsRight = new WPI_VictorSPX[motorPortsRight.length - 1];

    for (int i = 0; i < victorsLeft.length; i++)
      victorsLeft[i] = new WPI_VictorSPX(motorPortsLeft[i + 1]);
    for (int i = 0; i < victorsRight.length; i++)
      victorsRight[i] = new WPI_VictorSPX(motorPortsRight[i + 1]);
      for (int i = 0; i < victorsLeft.length; i++){
        victorsLeft[i].follow(talonLeft);
        victorsLeft[i].setNeutralMode(NeutralMode.Brake);
      }
  
      for (int i = 0; i < victorsRight.length; i++){
        victorsRight[i].follow(talonRight);
        victorsRight[i].setNeutralMode(NeutralMode.Brake);
      }
      
      for (int i = 0; i < victorsRight.length; i++)
        victorsRight[i].setInverted(true);
    
    }

  public void resetGyro() {
    gyroDrive.reset();
  }

  public void setgyroPIDValues(double p, double i, double d) {
    gyroPID.setPID(p, i, d);
  }

  public void setBothWheelEncoders(double p, double i, double d) {
    // talonLeft.setPID (p, i, d);
    talonLeft.config_kP(0, p);
    talonLeft.config_kI(0, i);
    talonLeft.config_kD(0, d);

    // talonRight.setPID (p, i, d);
    talonRight.config_kP(0, p);
    talonRight.config_kI(0, i);
    talonRight.config_kD(0, d);
  }

  /*
   * public void setBothWheelEncoders(double p, double i, double d) {
   * leftWheelEncoderPID.setPID (p, i, d); leftWheelEncoderPID.setP(p);
   * leftWheelEncoderPID.setI(i); leftWheelEncoderPID.setD(d);
   * leftWheelEncoderPID.setF(f);
   * 
   * rightWheelEncoderPID.setPID (p, i, d); rightWheelEncoderPID.setP(p);
   * rightWheelEncoderPID.setI(i); rightWheelEncoderPID.setD(d);
   * rightWheelEncoderPID.setF(f); }
   */

  public void enableGyroPID() {
    gyroPID.enable();
  }

  public double getGyroPIDError(){
    return gyroPID.getError();
  }

  public void setGyroSetpoint(double setpoint) {
    gyroPID.setSetpoint(setpoint);
  }

  public boolean gyroPIDOnSetpoint() {
    return gyroPID.onTarget();
  }

  public boolean rightOnTarget() {
    return Math.abs(talonRight.getClosedLoopError()) < tolerance;
  }

  public boolean leftOnTarget() {
    return Math.abs(talonLeft.getClosedLoopError()) < tolerance;
  }

  public boolean distanceOnTarget() {
    return leftOnTarget() || rightOnTarget();
  }

  public double getGyroPIDOutput() {
    return gyroPID.get();
  }

  public void setBothWheelPIDValues(double p, double i, double d) {
    // leftWheelEncoderPID.setPID (p, i, d);
    // leftWheelEncoderPID.setP(p);
    // leftWheelEncoderPID.setI(i);
    // leftWheelEncoderPID.setD(d);

    // rightWheelEncoderPID.setPID (p, i, d);
    // rightWheelEncoderPID.setP(p);
    // rightWheelEncoderPID.setI(i);
    // rightWheelEncoderPID.setD(d);

    talonLeft.config_kP(0, p);
    talonLeft.config_kI(0, i);
    talonLeft.config_kD(0, d);

    talonRight.config_kP(0, p);
    talonRight.config_kI(0, i);
    talonRight.config_kD(0, d);
  }

  /*
   * public void setBothWheelEncoders(double p, double i, double d) {
   * leftWheelEncoderPID.setPID (p, i, d); leftWheelEncoderPID.setP(p);
   * leftWheelEncoderPID.setI(i); leftWheelEncoderPID.setD(d);
   * leftWheelEncoderPID.setF(f);
   * 
   * rightWheelEncoderPID.setPID (p, i, d); rightWheelEncoderPID.setP(p);
   * rightWheelEncoderPID.setI(i); rightWheelEncoderPID.setD(d);
   * rightWheelEncoderPID.setF(f); }
   */

  public void disableGyroPID() {
    gyroPID.disable();
  }

  public void setLeft(double speed) {
    talonLeft.set(ControlMode.PercentOutput, Math.min(Math.max(speed, -1), 1));
    for (VictorSPX i : victorsLeft)
      i.set(ControlMode.PercentOutput, Math.min(Math.max(speed, -1), 1));
  }

  public void setRight(double speed) {
    talonRight.set(ControlMode.PercentOutput, Math.max(Math.min(-speed, -1), 1));
    for (VictorSPX i : victorsRight)
      i.set(ControlMode.PercentOutput, Math.max(Math.min(-speed, -1), 1));
  }

  public void setLeftMotorPosition(double position) {
    talonLeft.set(ControlMode.Position, position);
  }

  public void setRightMotorPosition(double position) {
    talonRight.set(ControlMode.Position, position);
  }

  public void setBothPositions(double talonLeftPosition, double talonRightPosition) {
    setBothPositions(talonLeftPosition, talonRightPosition, 0);
  }

  public void setBothPositions(double talonLeftPosition, double talonRightPosition, double gyroCorrection) {
    talonLeftPosition *= Constants.ticksOfEncoder / Constants.circumferenceOfWheels;
    talonRightPosition *= Constants.ticksOfEncoder / Constants.circumferenceOfWheels;
    setLeftMotorPosition(talonLeftPosition);
    setRightMotorPosition(talonRightPosition);
    //talonRight.set(ControlMode.Position, talonRightPosition, DemandType.AuxPID, gyroCorrection);
  }
  
  public double getWheelDistanceLeft(){
    return talonLeft.getSelectedSensorPosition();
  }

  public double getWheelDistanceRight(){
    return talonRight.getSelectedSensorPosition();
  }

  public void setBoth(double speedLeft, double speedRight) {
    setLeft(speedLeft);
    setRight(speedRight);
  }

  public void setBoth(double speed) {
    setLeft(speed);
    setRight(speed);
  }

  public void setTalonMotorPositions(double position) {
    talonLeft.set(ControlMode.Position, position / Constants.circumferenceOfWheels * Constants.ticksOfEncoder);
    talonRight.set(ControlMode.Position, position / Constants.circumferenceOfWheels * Constants.ticksOfEncoder);
  }

  public void resetEncoder(){
    talonLeft.setSelectedSensorPosition(0);
    talonRight.setSelectedSensorPosition(0);
  }
  
  public void resetSensorPositions(){
    talonLeft.setSelectedSensorPosition(0);
    talonRight.setSelectedSensorPosition(0);
  }

  public void calibrateGyro() {
    gyroDrive.calibrate();
  }

  public double getAngle() {
    return gyroDrive.getAngle() % 360;
  }

  public int getEncoderLeft() {
    return talonLeft.getSelectedSensorPosition();
  }

  public int getEncoderRight() {
    return talonRight.getSelectedSensorPosition();
  }

  public void setdrivePIDValues(double p, double i, double d) {
    // fourBarPID.setPID(p, i, d);
    talonLeft.config_kP(0, p);
    talonLeft.config_kI(0, i);
    talonLeft.config_kD(0, d);
    // fourBarPID.setP(p);
    // fourBarPID.setI(i);
    // fourBarPID.setD(d);
  }

  public void setdrivePIDValues(double p, double i, double d, double f) {
    setdrivePIDValues(p, i, d);
    talonLeft.config_kF(0, f);
    // fourBarPID.setP(p);
    // fourBarPID.setI(i);
    // fourBarPID.setD(d);
    // fourBarPID.setF(f);
  }

  public double getRightSensorPosition(){
    return talonRight.getSelectedSensorPosition();
  }

  public double getRightError(){
    return talonRight.getClosedLoopError();
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TankDriveCommand());
  }

  public boolean getLeftSensor() {
    return leftSensor.get();
  }

  // sets leftSensor to a boolean value of true being it is seeing the tape
  public boolean getFrontSensor() {
    return frontSensor.get();
  }

  // sets frontSensor to a boolean value of true being it is seeing the tape
  public boolean getRightSensor() {
    return rightSensor.get();
  }

  public boolean getBackSensor() {
    return backSensor.get();
  }

}
