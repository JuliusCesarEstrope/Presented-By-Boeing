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
<<<<<<< HEAD
  static int fourbarSetPoint;
=======
  static int hatchLvlTwoPoint, rocketLvlTwoPoint, rocketLvlOnePoint, ballLvlTwoPoint, ballLvlOnePoint;
>>>>>>> Maggie

  private static PIDController fourBarPID;
  private static PIDOutput pidOutput;
<<<<<<< HEAD
  // private static int startingPoint, floorGatherPoint, highPoint;
=======
  //private static int startingPoint, floorGatherPoint, highPoint;
>>>>>>> John-Schultz

  public FourBarSubsystem(int leftFourBarMotorPort, int rightFourBarMotorPort, int[] leftBarEncoderPort,
      int[] rightBarEncoderPort, int gyroPort, double[] fourBarPIDValues, int setStartPoint, int setFloorGatherPoint,
      int setHatchLvlTwoPoint, int setRocketLvlTwoPoint, int setRocketLvlOnePoint, int setClimbPoint,
      int setBallLvlOnePoint, int setBallLvlTwoPoint) {
<<<<<<< HEAD

=======
        
>>>>>>> John-Schultz
    leftFourBarMotor = new WPI_TalonSRX(leftFourBarMotorPort);
    rightFourBarMotor = new WPI_TalonSRX(rightFourBarMotorPort);

    leftBarEncoder = new Encoder(leftBarEncoderPort[0], leftBarEncoderPort[1]);
    rightBarEncoder = new Encoder(rightBarEncoderPort[0], rightBarEncoderPort[1]);

    leftFourBarMotor.follow(rightFourBarMotor);
    leftFourBarMotor.setInverted(true);

    leftFourBarMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
    rightFourBarMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

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

<<<<<<< HEAD
<<<<<<< HEAD
  public void setBothFourBarMotor(double FourBarSpeed) {
    setLeftFourBarMotor(FourBarSpeed);
    setRightFourBarMotor(FourBarSpeed);
  }
=======

>>>>>>> John-Schultz

=======
>>>>>>> Maggie
  public void resetAngle() {
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
<<<<<<< HEAD
  public void setFourBarPIDValues(double p, double i, double d) {
=======
  public  void setFourBarPIDValues(double p, double i, double d) {
>>>>>>> John-Schultz
    fourBarPID.setPID(p, i, d);
  }

  public void setFourBarPIDValues(double p, double i, double d, double f) {
    fourBarPID.setPID(p, i, d, f);
  }

  //setpoint
  public void setFourBarSetPoint(double fourBarSetPoint) {
    fourBarPID.setSetpoint(fourbarSetPoint);
  }

<<<<<<< HEAD
=======
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
<<<<<<< HEAD

=======
  
>>>>>>> John-Schultz
  public void setClimbPoint(int climbPoint) {
    fourBarPID.setSetpoint(climbPoint);
  }

  public void setBallLvlOnePoint(int ballLvlOnePoint) {
    fourBarPID.setSetpoint(ballLvlOnePoint);
  }

  public void setBallLvlTwoPoint(int ballLvlTwoPoint) {
    fourBarPID.setSetpoint(ballLvlTwoPoint);
  }
>>>>>>> Maggie

  public void initDefaultCommand() {

  }
}