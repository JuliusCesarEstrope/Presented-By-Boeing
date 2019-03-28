package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class ElevatorHorizontalSubsystem extends Subsystem {
  static TalonSRX XElevatorMotor;
  static DigitalInput fastSlowStopSensor, limitSwitch;
  private static int tolerance = 70;

  public ElevatorHorizontalSubsystem(int XElevatorMotorPort,
      double defaultElevatorPosition, double[] XElevatorEncoderPIDValues) {
        if (Constants.elevatorHorizontalEnabled){

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

    XElevatorMotor.setNeutralMode(NeutralMode.Brake);

    RobotLog.putMessage("Running ElevatorHorizontalSubsystem");
        }
  }

  public void setXElevatorMotor(double Speed) {
    if (Constants.elevatorHorizontalEnabled){
    XElevatorMotor.set(ControlMode.PercentOutput, Speed);
    }
  }

  public double getXElevatorMotor(){
    if (Constants.elevatorHorizontalEnabled){
    return XElevatorMotor.getMotorOutputPercent();
    } else {
      return 0;
    }
  }

  public double getXElevatorEncoder(){
    if (Constants.elevatorHorizontalEnabled){
      return XElevatorMotor.getSelectedSensorPosition();
      } else {
        return 0;
      }
  }

  public void setXElevatorMotorPosition(double position) {
    if (Constants.elevatorHorizontalEnabled) {
      XElevatorMotor.set(ControlMode.Position, position);
    }
  }

  public boolean encoderOnTarget() {
    if (Constants.elevatorHorizontalEnabled) {
      return Math.abs(XElevatorMotor.getClosedLoopError()) < tolerance;
    } else {
      return false;
    }
  }

  public void resetEncoders(){
    if(Constants.elevatorHorizontalEnabled) {
      XElevatorMotor.setSelectedSensorPosition(0);
    }
  }

  public boolean getfastSlowStopSensor() {
    if (Constants.elevatorHorizontalEnabled){
    return fastSlowStopSensor.get();
    } else {
      return false;
    }
  }

  public boolean getlimitSwitch(){
    if (Constants.elevatorHorizontalEnabled){
    return limitSwitch.get();
    } else {
      return false;
    }
  }

  public void initDefaultCommand() {
    if (Constants.elevatorHorizontalEnabled){
    //setDefaultCommand(new ElevatorInPlaceCommand());
    }
  }

}