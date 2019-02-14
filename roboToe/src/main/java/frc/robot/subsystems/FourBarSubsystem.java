package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class FourBarSubsystem extends Subsystem {

  static TalonSRX leftFourBarMotor, rightFourBarMotor;
  static Encoder leftBarEncoder, rightBarEncoder;

  private static PIDController fourBarPID;
  private static PIDOutput pidOutput;

  public FourBarSubsystem(int leftFourBarMotorPort, int rightFourBarMotorPort, int[] leftBarEncoderPort, int[] rightBarEncoderPort, int gyroPort, double[] fourBarPIDValues, int setStartPoint, int setFloorGatherPoint, int setHatchLvlTwoPoint, int setRocketLvlTwoPoint, int setRocketLvlOnePoint, int setClimbPoint, int setBallLvlOnePoint, int setBallLvlTwoPoint) {
    leftFourBarMotor = new WPI_TalonSRX(leftFourBarMotorPort);
    rightFourBarMotor = new WPI_TalonSRX(rightFourBarMotorPort);

    leftBarEncoder = new Encoder(leftBarEncoderPort[0], leftBarEncoderPort[1]);
    rightBarEncoder = new Encoder(rightBarEncoderPort[0], rightBarEncoderPort[1]);

    leftFourBarMotor.follow(rightFourBarMotor);
    leftFourBarMotor.setInverted(true);

    /** PID **/
    fourBarPID = new PIDController(fourBarPIDValues[0], fourBarPIDValues[1], fourBarPIDValues[2], leftBarEncoder, pidOutput);
    fourBarPID.setEnabled(true);
  }
  
   //set motors
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

    //encoder
    public int getLeftBarEncoder() {
      return leftBarEncoder.get();
    }

    public int getRightBarEncoder() {
      return rightBarEncoder.get();
    }

    public void resetEncoders() {
      rightBarEncoder.reset();
      leftBarEncoder.reset();
    }

     /** PID RELATED METHODS **/
  public static void setFourBarPIDValues(double p, double i, double d) {
    fourBarPID.setPID(p, i, d);
  }

  public static void setFourBarPIDValues(double p, double i, double d, double f) {
    fourBarPID.setPID(p, i, d, f);
  }

  public static void setFloorGatherPoint(int floorGatherPoint) {
    fourBarPID.setSetpoint(floorGatherPoint);
  }

  public static void setStartpoint(int startPoint) {
    fourBarPID.setSetpoint(startPoint);
  }

  public static void setHighpoint(int highPoint) {
    fourBarPID.setSetpoint(highPoint);
  }

 

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
