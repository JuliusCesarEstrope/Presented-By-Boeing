package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.utilities.RobotLog;
import frc.robot.commands.FourBarCommand;

public class FourBarSubsystem extends Subsystem {

  static TalonSRX leftFourBarMotor, rightFourBarMotor;
  static Encoder leftBarEncoder, rightBarEncoder;
  static int fourbarSetPoint;

  static int tolerance = 1;

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

  public void setBothFourBarMotor(double FourBarSpeed) {//do i need this and/or the above method? they have the same name
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
    leftFourBarMotor.config_kP(0, p);
    leftFourBarMotor.config_kI(0, i);
    leftFourBarMotor.config_kD(0, d);
    leftFourBarMotor.config_kF(0, f);
    //fourBarPID.setP(p);
    //fourBarPID.setI(i);
    //fourBarPID.setD(d);
    //fourBarPID.setF(f);
  }

  public void setBothFourBarMotorPosition(double position) {
    leftFourBarMotor.set(ControlMode.Position, position);
    rightFourBarMotor.set(ControlMode.Position, position);
  }

  public boolean checkOnTargetSetpoint(){ //needed?
    return Math.abs(rightFourBarMotor.getClosedLoopError()) < tolerance;
  }

  public void initDefaultCommand() {
    setDefaultCommand(new FourBarCommand(Constants.setStartPoint));
  }
}