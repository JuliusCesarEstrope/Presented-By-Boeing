package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.TankDriveCommand;
import frc.robot.utilities.RobotLog;

public class DriveSubsystem extends Subsystem {
  TalonSRX talonLeft, talonRight;
  VictorSPX[] victorsLeft, victorsRight;
  AnalogGyro gyroDrive;
  Encoder encoderLeft, encoderRight;
  static DigitalInput leftSensor;
  static DigitalInput frontSensor;
  static DigitalInput rightSensor;
  static DigitalInput backSensor;
  static Encoder enablePID;
  private static PIDController gyroPID;
  private static PIDController leftEncoderPIDController;
  private static PIDController rightEncoderPIDController;
  private static PIDOutput gyroPIDOutput, rightEncoderControllerPidOutput, leftEncoderControllerPidOutput;

  public DriveSubsystem(int[] motorPortsLeft, int[] motorPortsRight, int gyroPort, int encoderPortLeft[],
      int encoderPortRight[], int frontSensor, int rightSensor, int backSensor, int leftSensor,
      int[] driveEncoderPortLeft, int[] driveEncoderPortRight, double circumferanceOfWheels, double ticksOfEncoder) {

    gyroDrive = new AnalogGyro(gyroPort);
    encoderLeft = new Encoder(driveEncoderPortLeft[0], driveEncoderPortLeft[1]);
    encoderRight = new Encoder(driveEncoderPortRight[0], driveEncoderPortRight[1]);
    talonLeft = new WPI_TalonSRX(motorPortsLeft[0]);
    talonRight = new WPI_TalonSRX(motorPortsRight[0]);
    talonLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
    talonRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

    talonLeft = new WPI_TalonSRX(motorPortsLeft[0]);
    talonRight = new WPI_TalonSRX(motorPortsRight[0]);

    encoderLeft.setDistancePerPulse(360 / ticksOfEncoder * Constants.circumferenceOfWheels);
    RobotLog.putMessage("Running DriveSubsystem");
    victorsLeft = new WPI_VictorSPX[motorPortsLeft.length - 1];
    victorsRight = new WPI_VictorSPX[motorPortsRight.length - 1];

    for (int i = 0; i < victorsLeft.length; i++)
      victorsLeft[i] = new WPI_VictorSPX(motorPortsLeft[i + 1]);
    for (int i = 0; i < victorsRight.length; i++)
      victorsRight[i] = new WPI_VictorSPX(motorPortsRight[i + 1]);

    talonLeft = new WPI_TalonSRX(motorPortsLeft[0]);
    talonRight = new WPI_TalonSRX(motorPortsRight[0]);

    encoderLeft.setDistancePerPulse(circumferanceOfWheels / ticksOfEncoder);

    gyroPID = new PIDController(Constants.driveRotationPIDValues[0], Constants.driveRotationPIDValues[1],
        Constants.driveRotationPIDValues[2], gyroDrive, gyroPIDOutput);
    leftEncoderPIDController = new PIDController(Constants.rightEncoderPIDValues[0], Constants.rightEncoderPIDValues[1],
        Constants.rightEncoderPIDValues[2], gyroDrive, leftEncoderControllerPidOutput);
    rightEncoderPIDController = new PIDController(Constants.leftEncoderPIDValues[0], Constants.leftEncoderPIDValues[1],
        Constants.leftEncoderPIDValues[2], gyroDrive, rightEncoderControllerPidOutput);

  }

  public void resetGyro() {
    gyroDrive.reset();
  }

  public void setgyroPIDValues(double p, double i, double d) {
    gyroPID.setPID(p, i, d);
  }

  public void setBothWheelEncoders(double p, double i, double d){
    //talonLeft.setPID (p, i, d);
    talonLeft.config_kP(0, p);
    talonLeft.config_kI(0, i);
    talonLeft.config_kD(0, d);
  
   // talonRight.setPID (p, i, d);
    talonRight.config_kP(0, p);
    talonRight.config_kI(0, i);
    talonRight.config_kD(0, d);
  }

  
  /* public void setBothWheelEncoders(double p, double i, double d) {
    leftWheelEncoderPID.setPID (p, i, d);
    leftWheelEncoderPID.setP(p);
    leftWheelEncoderPID.setI(i);
    leftWheelEncoderPID.setD(d);
    leftWheelEncoderPID.setF(f);
  
    rightWheelEncoderPID.setPID (p, i, d);
    rightWheelEncoderPID.setP(p);
    rightWheelEncoderPID.setI(i);
    rightWheelEncoderPID.setD(d);
    rightWheelEncoderPID.setF(f);
  }
  */

  public void enableGyroPID() {
    gyroPID.enable();
  }

  public void enableleftEncoderControllerPID() {
    gyroPID.enable();
  }

  public void enablerightEncoderPIDController() {
    gyroPID.enable();
  }

  public void setGyroSetpoint(double setpoint) {
    gyroPID.setSetpoint(setpoint);
  }

  public void setleftEncoderPIDController(double setpoint) {
    leftEncoderPIDController.setSetpoint(setpoint);
  }

  public void setrightEncoderPIDController(double setpoint) {
    rightEncoderPIDController.setSetpoint(setpoint);
  }

  public boolean gyroPIDOnSetpoint() {
    return gyroPID.onTarget();
  }

  public boolean distanceOnTarget() {
    return rightEncoderPIDController.onTarget() || leftEncoderPIDController.onTarget();
  }

  public double getGyroPIDOutput() {
    return gyroPID.get();
  }

  public double getLeftEncoderControllerPIDOutput() {
    return leftEncoderPIDController.get();
  }

  public double getRightEncoderControllerPIDOutput() {
    return rightEncoderPIDController.get();
  }

  public void disableLeftEncoderPIDController() {
    leftEncoderPIDController.disable();
  }
/* public void setBothWheelEncoders(double p, double i, double d) {
  leftWheelEncoderPID.setPID (p, i, d);
  leftWheelEncoderPID.setP(p);
  leftWheelEncoderPID.setI(i);
  leftWheelEncoderPID.setD(d);

  rightWheelEncoderPID.setPID (p, i, d);
  rightWheelEncoderPID.setP(p);
  rightWheelEncoderPID.setI(i);
  rightWheelEncoderPID.setD(d);
}
*/

/* public void setBothWheelEncoders(double p, double i, double d) {
  leftWheelEncoderPID.setPID (p, i, d);
  leftWheelEncoderPID.setP(p);
  leftWheelEncoderPID.setI(i);
  leftWheelEncoderPID.setD(d);
  leftWheelEncoderPID.setF(f);

  rightWheelEncoderPID.setPID (p, i, d);
  rightWheelEncoderPID.setP(p);
  rightWheelEncoderPID.setI(i);
  rightWheelEncoderPID.setD(d);
  rightWheelEncoderPID.setF(f);
}
*/


  public void disableRightEncoderPIDController() {
    rightEncoderPIDController.disable();
  }

  public void disableGyroPID() {
    gyroPID.disable();
  }

  public void setLeft(double speed) {
    talonLeft.set(ControlMode.PercentOutput, Math.max(Math.min(speed, -1), 1));
    for (VictorSPX i : victorsLeft)
      i.set(ControlMode.PercentOutput, Math.max(Math.min(speed, -1), 1));
  }

  public void setRight(double speed) {
    talonRight.set(ControlMode.PercentOutput, Math.max(Math.min(-speed, -1), 1));
    for (VictorSPX i : victorsRight)
      i.set(ControlMode.PercentOutput, Math.max(Math.min(-speed, -1), 1));
  }

  public void setBoth(double speedLeft, double speedRight) {
    setLeft(speedLeft);
    setRight(speedRight);
  }

  public void setBoth(double speed) {
    setLeft(speed);
    setRight(speed);
  }

  public void calibrateGyro() {
    gyroDrive.calibrate();
  }

  public double getAngle() {
    return gyroDrive.getAngle() % 360;
  }

  public void resetEncoder() {
    encoderLeft.reset();
    encoderRight.reset();
  }

  public int getEncoderLeft() {
    return talonLeft.getSelectedSensorPosition();
  }

  public int getEncoderRight() {
    return talonRight.getSelectedSensorPosition();
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new TankDriveCommand());
  }

  public double getWheelDistanceLeft() {
    return encoderLeft.getDistance();
  }

  public double getWheelDistanceRight() {
    return encoderRight.getDistance();
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

  // sets rightSensor to a boolean value of true being it is seeing the tape
}
