package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class ElevatorHorizontalSubsystem extends Subsystem {
  static TalonSRX XElevatorMotor;
  static DigitalInput fastSlowStopSensor, limitSwitch;
  static Encoder XElevatorEncoder;
  private static PIDController XElevatorPID;
  private static PIDOutput encoderPIDOutput;
  private static int tolerance = 70;

  public ElevatorHorizontalSubsystem(int XElevatorMotorPort,
      double defaultElevatorPosition, int XElevatorEncoderPort, double[] XElevatorEncoderPIDValues) {
        if (Constants.wristEnabled){

    XElevatorMotor = new WPI_TalonSRX(XElevatorMotorPort);
    limitSwitch = new DigitalInput(Constants.limitSwitch);
    XElevatorMotor.configFactoryDefault();
    XElevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

    XElevatorMotor.config_kP(0, XElevatorEncoderPIDValues[0]);
    XElevatorMotor.config_kI(0, XElevatorEncoderPIDValues[1]);
    XElevatorMotor.config_kD(0, XElevatorEncoderPIDValues[2]);
    XElevatorMotor.config_kF(0, XElevatorEncoderPIDValues[3]);

   // XElevatorEncoder.configPeakOutputForward(1);
   // XElevatorEncoder.configPeakOutputReverse(-1);
   // XElevatorEncoder.configClosedloopRamp(ramp);

   // XElevatorEncoder.setInverted(true);
   
    XElevatorPID = new PIDController(0.05, 0, 0, XElevatorEncoder, encoderPIDOutput);

    XElevatorMotor.setNeutralMode(NeutralMode.Brake);

    RobotLog.putMessage("Running ElevatorHorizontalSubsystem");
        }
  }

  public void setXElevatorMotor(double Speed) {
    if (Constants.wristEnabled){
    XElevatorMotor.set(ControlMode.PercentOutput, Speed);
    }
  }

  public double getXElevatorMotor(){
    if (Constants.wristEnabled){
    return XElevatorMotor.getMotorOutputPercent();
    } else {
      return 0;
    }
  }

  public double getXElevatorEncoder(){
    if (Constants.wristEnabled){
      return XElevatorEncoder.get();
      } else {
        return 0;
      }
  }

  public void setEncoder(double speed) {
    if (Constants.wristEnabled) {
      XElevatorMotor.set(ControlMode.PercentOutput, speed);
    }
  }

  public void setLeftMotorPosition(double position) {
    if (Constants.wristEnabled) {
      XElevatorMotor.set(ControlMode.Position, position);
    }
  }

  public boolean encoderOnTarget() {
    if (Constants.wristEnabled) {
      return Math.abs(XElevatorMotor.getClosedLoopError()) < tolerance;
    } else {
      return false;
    }
  }

  public void encoderReset(){
    XElevatorEncoder.reset();
  }

  public boolean getfastSlowStopSensor() {
    if (Constants.wristEnabled){
    return fastSlowStopSensor.get();
    } else {
      return false;
    }
  }

  public boolean getlimitSwitch(){
    if (Constants.wristEnabled){
    return limitSwitch.get();
    } else {
      return false;
    }
  }

  public void initDefaultCommand() {
    if (Constants.wristEnabled){
    //setDefaultCommand(new ElevatorInPlaceCommand());
    }
  }

}