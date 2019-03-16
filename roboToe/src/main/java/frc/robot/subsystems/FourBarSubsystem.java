package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class FourBarSubsystem extends Subsystem {

  static TalonSRX rightFourBarMotor;
  static VictorSPX  leftFourBarMotor;
  static Encoder leftBarEncoder, rightBarEncoder;
  static int fourbarSetPoint;

  static int tolerance = 1;

  public FourBarSubsystem(int leftFourBarMotorPort, int rightFourBarMotorPort, int[] leftBarEncoderPort,
      int[] rightBarEncoderPort, int gyroPort, double[] fourBarPIDValues) {
      if (Constants.wristEnabled){

    leftFourBarMotor = new WPI_VictorSPX(leftFourBarMotorPort);
    rightFourBarMotor = new WPI_TalonSRX(rightFourBarMotorPort);

    leftBarEncoder = new Encoder(leftBarEncoderPort[0], leftBarEncoderPort[1]);
    rightBarEncoder = new Encoder(rightBarEncoderPort[0], rightBarEncoderPort[1]);

    leftFourBarMotor.configFactoryDefault();
    rightFourBarMotor.configFactoryDefault();
    
    leftFourBarMotor.follow(rightFourBarMotor);
    leftFourBarMotor.setInverted(InvertType.OpposeMaster);

    rightFourBarMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

    rightFourBarMotor.configPeakOutputForward(0.4);
    rightFourBarMotor.configPeakOutputReverse(-0.4);
    rightFourBarMotor.config_kP(0, fourBarPIDValues[0]);
    rightFourBarMotor.config_kI(0, fourBarPIDValues[1]);
    rightFourBarMotor.config_kD(0, fourBarPIDValues[2]);
    rightFourBarMotor.config_kF(0, fourBarPIDValues[3]);

    RobotLog.putMessage("Running FourBarSubsystem");
      }
  }

  // set motors
  public void setLeftFourBarMotor(double leftFourBarSpeed) {
    if (Constants.wristEnabled){
    leftFourBarMotor.set(ControlMode.PercentOutput, leftFourBarSpeed);
    }
  }

  public void setRightFourBarMotor(double rightFourBarSpeed) {
    if (Constants.wristEnabled){
    rightFourBarMotor.set(ControlMode.PercentOutput, rightFourBarSpeed);
    }
  }

  public void setBothFourBarMotor(double leftFourBarSpeed, double rightFourBarSpeed) {
    if (Constants.wristEnabled){
    setLeftFourBarMotor(leftFourBarSpeed);
    setRightFourBarMotor(rightFourBarSpeed);
    }
  }

  public void setBothFourBarMotor(double FourBarSpeed) {//do i need this and/or the above method? they have the same name
    if (Constants.wristEnabled){
    setLeftFourBarMotor(FourBarSpeed);
    setRightFourBarMotor(FourBarSpeed);
    }
  }

  // encoder
  public int getLeftBarEncoder() {
    if (Constants.wristEnabled){
    return leftFourBarMotor.getSelectedSensorPosition();
    } else {
      return 0;
    }
  }

  public int getRightBarEncoder() {
    if (Constants.wristEnabled){
    return rightFourBarMotor.getSelectedSensorPosition();
    } else {
      return 0;
    }
  }

  public void resetEncoders() {
    if (Constants.wristEnabled){
    leftFourBarMotor.setSelectedSensorPosition(0);
    rightFourBarMotor.setSelectedSensorPosition(0);
    }
  }

  /** PID RELATED METHODS **/
  public  void setFourBarPIDValues(double p, double i, double d) {
    if (Constants.wristEnabled){
    //fourBarPID.setPID(p, i, d);
    rightFourBarMotor.config_kP(0, p);
    rightFourBarMotor.config_kI(0, i);
    rightFourBarMotor.config_kD(0, d);
    //fourBarPID.setP(p);
    //fourBarPID.setI(i);
    //fourBarPID.setD(d);
    }
  }


  public void setFourBarPIDValues(double p, double i, double d, double f) {
    if (Constants.wristEnabled){
    setFourBarPIDValues(p, i, d);
    rightFourBarMotor.config_kF(0, f);
    //fourBarPID.setP(p);
    //fourBarPID.setI(i);
    //fourBarPID.setD(d);
    //fourBarPID.setF(f);
    }
  }

  public void setBothFourBarMotorPosition(double position) {
    if (Constants.wristEnabled){
    leftFourBarMotor.set(ControlMode.Position, position);
    rightFourBarMotor.set(ControlMode.PercentOutput, leftFourBarMotor.getMotorOutputPercent());
    }
  }

  public boolean checkOnTargetSetpoint(){ //needed?
    if (Constants.wristEnabled){
    return Math.abs(rightFourBarMotor.getClosedLoopError()) < tolerance;
    } else {
      return false;
    }
  }

  public void initDefaultCommand() {
    if (Constants.wristEnabled){
    //setDefaultCommand(new FourBarCommand(Constants.setStartPoint));
    }
  }
}