package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.WristAngleCommand;
import frc.robot.utilities.RobotLog;

public class WristSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  static TalonSRX rightWristMotor;
  static VictorSPX leftWristMotor;
  static Encoder leftWristEncoder, rightWristEncoder;

  public WristSubsystem(int leftWristMotorPort, int rightWristMotorPort, int[] leftWristEncoderPort,
      int[] rightWristEncoderPort, double[] wristPIDValues) {
    leftWristMotor = new VictorSPX(leftWristMotorPort);
    rightWristMotor = new WPI_TalonSRX(rightWristMotorPort);

    leftWristMotor.configFactoryDefault();
    rightWristMotor.configFactoryDefault();

    leftWristMotor.follow(rightWristMotor); // :)
    leftWristMotor.setInverted(true);
    leftWristMotor.configPeakOutputForward(0.4);
    leftWristMotor.configPeakOutputReverse(-0.4);
    leftWristMotor.configClosedLoopPeakOutput(0, 0.4);
    
    rightWristMotor.configPeakOutputForward(0.4);
    rightWristMotor.configPeakOutputReverse(-0.4);
    rightWristMotor.configClosedLoopPeakOutput(0, 0.4);
    rightWristMotor.config_kP(0, wristPIDValues[0]);
    rightWristMotor.config_kI(0, wristPIDValues[1]);
    rightWristMotor.config_kD(0, wristPIDValues[2]);
    rightWristMotor.config_kF(0, wristPIDValues[3]);

    // leftWristMotor.limit
    /*
     * leftWristPID = new PIDController(wristPIDValues[0], wristPIDValues[1],
     * wristPIDValues[2], wristPIDValues[3], leftWristEncoder, pidWristOutput);
     * leftWristPID.setEnabled(true);
     * 
     * /* rightWristPID = new PIDController(wristPIDValues[0], wristPIDValues[1],
     * wristPIDValues[2], wristPIDValues[3], leftWristEncoder, pidWristOutput);
     * leftWristPID.setEnabled(true);
     */

    RobotLog.putMessage("Running WristSubsystem");
  }

  public void setLeftWristMotor(double Speed) {
    leftWristMotor.set(ControlMode.PercentOutput, Speed);
  }

  public void setRightWristMotor(double Speed) {
    rightWristMotor.set(ControlMode.PercentOutput, Speed);
  }

  public void setRightWristPosition(double setpoint) {
    rightWristMotor.set(ControlMode.Position, setpoint);
  }

  public void setLeftWristPosition(double setpoint) {
    leftWristMotor.set(ControlMode.Position, setpoint);
  }

  public void ResetEncoder() {
    leftWristEncoder.reset();
    rightWristEncoder.reset();
  }

  public int getLeftWristEncoder() {
    return leftWristMotor.getSelectedSensorPosition();
  }

  public int getRightWristEncoder() {
    return rightWristMotor.getSelectedSensorPosition();
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
    // setLeftWristPIDValues(p, i, d);
    // leftWristPID.setP(p);
    // leftWristPID.setI(i);
    // leftWristPID.setD(d);

    leftWristMotor.config_kP(0, p);
    leftWristMotor.config_kI(0, i);
    leftWristMotor.config_kD(0, d);

  }

  public void setLeftWristPIDValues(double p, double i, double d, double f) {
    setLeftWristPIDValues(p, i, d);
    // leftWristPID.setP(p);
    // leftWristPID.setI(i);
    // leftWristPID.setD(d);
    // leftWristPID.setF(f);

    leftWristMotor.config_kF(0, f);
  }

  public void setRightWristPIDValues(double p, double i, double d) {
    // rightWristPID.setPID(p, i, d);
    // rightWristPID.setP(p);
    // rightWristPID.setI(i);
    // rightWristPID.setD(d);

    rightWristMotor.config_kP(0, p);
    rightWristMotor.config_kI(0, i);
    rightWristMotor.config_kD(0, d);
  }

  public void setRightWristPIDValues(double p, double i, double d, double f) {
    setRightWristPIDValues(p, i, d);
    // rightWristPID.setP(p);
    // rightWristPID.setI(i);
    // rightWristPID.setD(d);
    // rightWristPID.setF(f);

    rightWristMotor.config_kF(0, f);
  }

  public void setBothWristMotorPosition(double position) {
    leftWristMotor.set(ControlMode.Position, position);
    rightWristMotor.set(ControlMode.Position, position);
  }

  public void initDefaultCommand() {
    setDefaultCommand(new WristAngleCommand());
  }

}
