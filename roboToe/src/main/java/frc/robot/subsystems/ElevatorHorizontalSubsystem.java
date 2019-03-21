package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class ElevatorHorizontalSubsystem extends Subsystem {
  static VictorSPX leftXElevatorMotor, rightXElevatorMotor;
  static DigitalInput fastSlowStopSensor, limitSwitch;
  static Potentiometer potentiometer;
  static AnalogInput potentiometerInput;

  public ElevatorHorizontalSubsystem(int leftXElevatorMotorPort,
      double defaultElevatorPosition, int potentiometerPort) {

        if (Constants.wristEnabled){

    leftXElevatorMotor = new WPI_VictorSPX(leftXElevatorMotorPort);
    limitSwitch = new DigitalInput(Constants.limitSwitch);
    potentiometerInput = new AnalogInput(potentiometerPort);
    potentiometer = new AnalogPotentiometer(potentiometerInput);

/*
    rightXElevatorMotor.follow(leftXElevatorMotor);
    rightXElevatorMotor.setInverted(true); //SHOULD BE HERE?
*/
    RobotLog.putMessage("Running ElevatorHorizontalSubsystem");
        }
  }

  public void setXElevatorMotors(double Speed) {
    if (Constants.wristEnabled){
    leftXElevatorMotor.set(ControlMode.PercentOutput, Speed);
    }
  }

  public double getXElevatorMotors(){
    if (Constants.wristEnabled){
    return leftXElevatorMotor.getMotorOutputPercent();
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

  public double getPotentiometer(){
    if (Constants.wristEnabled){
      return potentiometer.get();
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