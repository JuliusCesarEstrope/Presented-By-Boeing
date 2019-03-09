package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;
import frc.robot.commands.WristCommand;

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

      leftWristMotor.configNominalOutputForward(0);
      leftWristMotor.configNominalOutputReverse(0);
      leftWristMotor.configPeakOutputForward(1);
      leftWristMotor.configPeakOutputReverse(-1);
      leftWristMotor.config_kP(0, wristPIDValues[0]);
      leftWristMotor.config_kI(0, wristPIDValues[1]);
      leftWristMotor.config_kD(0, wristPIDValues[2]);
      leftWristMotor.config_kF(0, wristPIDValues[3]);

      rightWristMotor.configNominalOutputForward(0);
      rightWristMotor.configNominalOutputReverse(0);
      rightWristMotor.configPeakOutputForward(1);
      rightWristMotor.configPeakOutputReverse(-1);
      rightWristMotor.config_kP(0, wristPIDValues[0]);
      rightWristMotor.config_kI(0, wristPIDValues[1]);
      rightWristMotor.config_kD(0, wristPIDValues[2]);
      rightWristMotor.config_kF(0, wristPIDValues[3]);

    /*leftWristPID = new PIDController(wristPIDValues[0], wristPIDValues[1], wristPIDValues[2], wristPIDValues[3],
        leftWristEncoder, pidWristOutput);
    leftWristPID.setEnabled(true);

   /* rightWristPID = new PIDController(wristPIDValues[0], wristPIDValues[1], wristPIDValues[2], wristPIDValues[3],
        leftWristEncoder, pidWristOutput);
    leftWristPID.setEnabled(true);*/

    RobotLog.putMessage("Running WristSubsystem");
    }

  public void setLeftWristMotor(double Speed) {
    leftWristMotor.set(ControlMode.PercentOutput, Speed);
  }

  public void setRightWristMotor(double Speed) {
    rightWristMotor.set(ControlMode.PercentOutput, Speed);
  }

  public void setRightWristPosition(double setpoint) {
    leftWristMotor.set(ControlMode.Position, setpoint);
  }

  public void setLeftWristPosition(double setpoint) {
    rightWristMotor.set(ControlMode.Position, setpoint);
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

  public void setLeftWristPIDValues(double p, double i, double d) {
    //setLeftWristPIDValues(p, i, d);
    //leftWristPID.setP(p);
    //leftWristPID.setI(i);
    //leftWristPID.setD(d);

      leftWristMotor.config_kP(0, p);
      leftWristMotor.config_kI(0, i);
      leftWristMotor.config_kD(0, d);
 

  }

  public void setLeftWristPIDValues(double p, double i, double d, double f) {
    setLeftWristPIDValues(p, i, d);
    //leftWristPID.setP(p);
    //leftWristPID.setI(i);
    //leftWristPID.setD(d);
    //leftWristPID.setF(f);

    leftWristMotor.config_kF(0, f);
  }

  public boolean leftWristOnTarget() {
    return leftWristPID.onTarget();
  }

  public void setRightWristPIDValues(double p, double i, double d) {
    //rightWristPID.setPID(p, i, d);
    //rightWristPID.setP(p);
    //rightWristPID.setI(i);
    //rightWristPID.setD(d);

    rightWristMotor.config_kP(0, p);
    rightWristMotor.config_kI(0, i);
    rightWristMotor.config_kD(0, d);
  }

  public void setRightWristPIDValues(double p, double i, double d, double f) {
    setRightWristPIDValues(p, i, d);
    //rightWristPID.setP(p);
    //rightWristPID.setI(i);
    //rightWristPID.setD(d);
    //rightWristPID.setF(f);

    rightWristMotor.config_kF(0, f);
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
  
  public double getLeftWristPIDOutput() {
    return leftWristPID.get();
    
  }

  public double getRightWristPIDOutput() {
    return rightWristPID.get();
    
  }

  public void initDefaultCommand() {
    setDefaultCommand(new WristCommand(Constants.wristUpSetPoint));
  }

}

