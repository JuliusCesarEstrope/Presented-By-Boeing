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
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class ElevatorHorizontalSubsystem extends Subsystem {
  static TalonSRX XElevatorMotor;
  static DigitalInput fastSlowStopSensor, limitSwitch;
  static Encoder XElevatorEncoder;

  public ElevatorHorizontalSubsystem(int XElevatorMotorPort,
      double defaultElevatorPosition, int XElevatorEncoderPort) {

        if (Constants.wristEnabled){

    XElevatorMotor = new WPI_TalonSRX(XElevatorMotorPort);
    limitSwitch = new DigitalInput(Constants.limitSwitch);
    XElevatorMotor.configFactoryDefault();
    XElevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

   // XElevatorEncoder.configPeakOutputForward(1);
   // XElevatorEncoder.configPeakOutputReverse(-1);
   // XElevatorEncoder.configClosedloopRamp(ramp);

   // XElevatorEncoder.setInverted(true);

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

  public double getXElevatorEncoder(){
    if (Constants.wristEnabled){
      return XElevatorEncoder.get();
      } else {
        return 0;
      }
  }

  public void initDefaultCommand() {
    if (Constants.wristEnabled){
    //setDefaultCommand(new ElevatorInPlaceCommand());
    }
  }

}