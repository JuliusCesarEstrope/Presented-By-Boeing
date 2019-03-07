package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.utilities.RobotLog;

public class FourBarSubsystem extends Subsystem {

  static TalonSRX leftFourBarMotor, rightFourBarMotor;
  static Encoder leftBarEncoder, rightBarEncoder;
  static int fourbarSetPoint;
  private static PIDController fourBarPID;
  private static PIDOutput pidOutput;

  public FourBarSubsystem(int leftFourBarMotorPort, int rightFourBarMotorPort, int[] leftBarEncoderPort,
      int[] rightBarEncoderPort, int gyroPort, double[] fourBarPIDValues) {

    leftFourBarMotor = new WPI_TalonSRX(leftFourBarMotorPort);
    rightFourBarMotor = new WPI_TalonSRX(rightFourBarMotorPort);

    leftBarEncoder = new Encoder(leftBarEncoderPort[0], leftBarEncoderPort[1]);
    rightBarEncoder = new Encoder(rightBarEncoderPort[0], rightBarEncoderPort[1]);

    leftFourBarMotor.follow(rightFourBarMotor);
    leftFourBarMotor.setInverted(true);

    leftFourBarMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
    rightFourBarMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

    leftFourBarMotor.configNominalOutputForward(0);
    leftFourBarMotor.configNominalOutputReverse(0);
    leftFourBarMotor.configPeakOutputForward(1);
    leftFourBarMotor.configPeakOutputReverse(-1);
    leftFourBarMotor.config_kP(0, fourBarPIDValues[0]);
    leftFourBarMotor.config_kI(0, fourBarPIDValues[1]);
    leftFourBarMotor.config_kD(0, fourBarPIDValues[2]);
    leftFourBarMotor.config_kF(0, fourBarPIDValues[3]);

    rightFourBarMotor.configNominalOutputForward(0);
    rightFourBarMotor.configNominalOutputReverse(0);
    rightFourBarMotor.configPeakOutputForward(1);
    rightFourBarMotor.configPeakOutputReverse(-1);
    rightFourBarMotor.config_kP(0, fourBarPIDValues[0]);
    rightFourBarMotor.config_kI(0, fourBarPIDValues[1]);
    rightFourBarMotor.config_kD(0, fourBarPIDValues[2]);
    rightFourBarMotor.config_kF(0, fourBarPIDValues[3]);

    /** PID **/
    fourBarPID = new PIDController(fourBarPIDValues[0], fourBarPIDValues[1], fourBarPIDValues[2], leftBarEncoder,
        pidOutput);
    fourBarPID.setEnabled(true);

    RobotLog.putMessage("Running FourBarSubsystem");
  }

  // set motors
  public void setLeftFourBarMotor(double leftFourBarSpeed) {
    leftFourBarMotor.set(ControlMode.PercentOutput, leftFourBarSpeed);
  }

  public void setRightFourBarMotor(double rightFourBarSpeed) {
    rightFourBarMotor.set(ControlMode.PercentOutput, rightFourBarSpeed);
  }

  public void setBothFourBarMotor(double leftFourBarSpeed, double rightFourBarSpeed) {
    setLeftFourBarMotor(leftFourBarSpeed);
    setRightFourBarMotor(rightFourBarSpeed);
  }

  public void setBothFourBarMotor(double FourBarSpeed) {
    setLeftFourBarMotor(FourBarSpeed);
    setRightFourBarMotor(FourBarSpeed);
  }

  // encoder
  public int getLeftBarEncoder() {
    return leftFourBarMotor.getSelectedSensorPosition();
  }

  public int getRightBarEncoder() {
    return rightFourBarMotor.getSelectedSensorPosition();
  }

  public void resetEncoders() {
    rightBarEncoder.reset();
    leftBarEncoder.reset();
  }

  //PID Outputs
  public double getFourBarPIDOutput(){
    return fourBarPID.get();
  }

  /** PID RELATED METHODS **/
  public  void setFourBarPIDValues(double p, double i, double d) {
    //fourBarPID.setPID(p, i, d);
    leftFourBarMotor.config_kP(0, p);
    leftFourBarMotor.config_kI(0, i);
    leftFourBarMotor.config_kD(0, d);
    //fourBarPID.setP(p);
    //fourBarPID.setI(i);
    //fourBarPID.setD(d);
  }

  public void setFourBarPIDValues(double p, double i, double d, double f) {
    fourBarPID.setPID(p, i, d);
    leftFourBarMotor.config_kF(0, f);
    //fourBarPID.setP(p);
    //fourBarPID.setI(i);
    //fourBarPID.setD(d);
    //fourBarPID.setF(f);
  }

  //setpoint
  public void setFourBarSetPoint(double fourBarSetPoint) {
    fourBarPID.setSetpoint(fourbarSetPoint);
  }

  public void setStartPoint(int startPoint) {
    fourBarPID.setSetpoint(startPoint);
  }

  public void setHatchLvlTwoPoint(int hatchLvlTwoPoint) {
    fourBarPID.setSetpoint(hatchLvlTwoPoint);
  }

  public void setRocketLvlTwoPoint(int rocketLvlTwoPoint) {
    fourBarPID.setSetpoint(rocketLvlTwoPoint);
  }

  public void setRocketLvlOnePoint(int rocketLvlOnePoint) {
    fourBarPID.setSetpoint(rocketLvlOnePoint);
  }

  public void setClimbPoint(int climbPoint) {
    fourBarPID.setSetpoint(climbPoint);
  }

  public void setBallLvlOnePoint(int ballLvlOnePoint) {
    fourBarPID.setSetpoint(ballLvlOnePoint);
  }

  public void setBallLvlTwoPoint(int ballLvlTwoPoint) {
    fourBarPID.setSetpoint(ballLvlTwoPoint);
  }

  public void setFloorGatherPoint(int floorGatherPoint) {
    fourBarPID.setSetpoint(floorGatherPoint);
  }

  public void initDefaultCommand() {

  }
}