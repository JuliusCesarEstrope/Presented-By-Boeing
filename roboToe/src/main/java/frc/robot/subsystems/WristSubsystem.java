package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class WristSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  static TalonSRX leftWristMotor, rightWristMotor;
  static Encoder leftWristEncoder, rightWristEncoder;
  private static PIDController leftWristPID, rightWristPID;
  private static PIDOutput pidWristOutput;

  
  public WristSubsystem(int leftWristMotorPort, int rightWristMotorPort, int[] leftWristEncoderPort, int[] rightWristEncoderPort, double[] wristPIDValues) {
    leftWristMotor = new WPI_TalonSRX(leftWristMotorPort);
    rightWristMotor = new WPI_TalonSRX(rightWristMotorPort);
    leftWristEncoder = new Encoder(leftWristEncoderPort[0], leftWristEncoderPort[1]);
    rightWristEncoder = new Encoder(rightWristEncoderPort[0], rightWristEncoderPort[1]);
    leftWristMotor.follow(rightWristMotor);  //:)
    leftWristMotor.setInverted(true);

    leftWristPID = new PIDController(wristPIDValues[0], wristPIDValues[1], wristPIDValues[2], wristPIDValues[3], leftWristEncoder, pidWristOutput);
leftWristPID.setEnabled(true);

    rightWristPID = new PIDController(wristPIDValues[0], wristPIDValues[1], wristPIDValues[2], wristPIDValues[3], leftWristEncoder, pidWristOutput);
    leftWristPID.setAbsoluteTolerance(3);
    rightWristPID = new PIDController(wristPIDValues[0], wristPIDValues[1], wristPIDValues[2], wristPIDValues[3],
        leftWristEncoder, pidWristOutput);
    leftWristPID.setEnabled(true);

    RobotLog.putMessage("Running WristSubsystem");
    leftWristPID.setEnabled(true);
  }
  
  public void setLeftWristMotor(double Speed) {
    leftWristMotor.set(ControlMode.PercentOutput, Speed);
  }

  public void setRightWristMotor(double Speed) {
    rightWristMotor.set(ControlMode.PercentOutput, Speed);
  }

  public void ResetEncoder() {
    leftWristEncoder.reset();
    rightWristEncoder.reset();
  }

  public int getLeftWristEncoder() {
    return leftWristEncoder.get();
  }

  public int getRightWristEncoder() {
    return rightWristEncoder.get();
  }

  public void setBothWristMotor(double pidWristOutput) {
    setLeftWristMotor(pidWristOutput);
    setRightWristMotor(pidWristOutput);
  }

  public void setBothWristMotor(double Speed, double Speed1) {
    setLeftWristMotor(Speed);
    setRightWristMotor(Speed1);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void setLeftWristPIDValues(double p, double i, double d) {
    leftWristPID.setPID(p, i, d);
  }

  public void setLeftWristPIDValues(double p, double i, double d, double f) {
    leftWristPID.setPID(p, i, d, f);
  }

  

  public void setRightWristPIDValues(double p, double i, double d) {
    leftWristPID.setPID(p, i, d);
  }

  public void setWristRightPIDValues(double p, double i, double d, double f) {
    leftWristPID.setPID(p, i, d, f);
  }

  public void setWristDownSetpoint(int wristDownSetPoint) {
    leftWristPID.setSetpoint(wristDownSetPoint);
  }

  public void setWristUpSetpoint(int wristUpSetPoint) {
    leftWristPID.setSetpoint(wristUpSetPoint);
  }

  public void setWristMidSetpoint(int wristMidSetPoint) {
    leftWristPID.setSetpoint(wristMidSetPoint);
  }

  public void setWristDownSetpoint(int wristDownSetPoint) {
    leftWristPID.setSetpoint(wristDownSetPoint);
  }
  
  public double getLeftWristPIDOutput() {
    return leftWristPID.get();
    
  }

  public double getRightWristPIDOutput() {
    return rightWristPID.get();
    
  }
 
 
}