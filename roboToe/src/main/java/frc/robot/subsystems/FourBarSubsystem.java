package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.utilities.RobotLog;
import frc.robot.commands.FourBarCommand;

public class FourBarSubsystem extends Subsystem {

  static TalonSRX rightFourBarMotor;
  static VictorSPX  leftFourBarMotor;
  static Encoder leftBarEncoder, rightBarEncoder;
  static int fourbarSetPoint;

  static int tolerance = 1;

  public FourBarSubsystem(int leftFourBarMotorPort, int rightFourBarMotorPort, int[] leftBarEncoderPort,
      int[] rightBarEncoderPort, int gyroPort, double[] fourBarPIDValues) {

    leftFourBarMotor = new WPI_VictorSPX(leftFourBarMotorPort);
    rightFourBarMotor = new WPI_TalonSRX(rightFourBarMotorPort);

    leftBarEncoder = new Encoder(leftBarEncoderPort[0], leftBarEncoderPort[1]);
    rightBarEncoder = new Encoder(rightBarEncoderPort[0], rightBarEncoderPort[1]);

    leftFourBarMotor.configFactoryDefault();
    rightFourBarMotor.configFactoryDefault();
    
    leftFourBarMotor.follow(rightFourBarMotor);
    leftFourBarMotor.setInverted(InvertType.OpposeMaster);

    rightFourBarMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

    rightFourBarMotor.configNominalOutputForward(0);
    rightFourBarMotor.configNominalOutputReverse(0);
    rightFourBarMotor.configPeakOutputForward(1);
    rightFourBarMotor.configPeakOutputReverse(-1);
    rightFourBarMotor.config_kP(0, fourBarPIDValues[0]);
    rightFourBarMotor.config_kI(0, fourBarPIDValues[1]);
    rightFourBarMotor.config_kD(0, fourBarPIDValues[2]);
    rightFourBarMotor.config_kF(0, fourBarPIDValues[3]);

    /** PID **/
    /*fourBarPID = new PIDController(fourBarPIDValues[0], fourBarPIDValues[1], fourBarPIDValues[2], leftBarEncoder,
        pidOutput);
    fourBarPID.setEnabled(true);
*/
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
    leftFourBarMotor.setSelectedSensorPosition(0);
    rightFourBarMotor.setSelectedSensorPosition(0);
  }

  /*//PID Outputs
  public double getFourBarPIDOutput(){
    return fourBarPID.get();
  }*/

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
    //fourBarPID.setPID(p, i, d);
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
/*
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
*/
  public void initDefaultCommand() {
    //setDefaultCommand(new FourBarCommand(Constants.setStartPoint));
  }
}