package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class ElevatorHorizontalSubsystem extends Subsystem {
  static VictorSPX leftXElevatorMotor, rightXElevatorMotor;
  static DigitalInput fastSlowStopSensor, limitSwitch;

  public ElevatorHorizontalSubsystem(int leftXElevatorMotorPort,
      double defaultElevatorPosition) {

        if (Constants.wristEnabled){

    leftXElevatorMotor = new WPI_VictorSPX(leftXElevatorMotorPort);
    limitSwitch = new DigitalInput(Constants.limitSwitch);
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

  public void initDefaultCommand() {
    if (Constants.wristEnabled){
    //setDefaultCommand(new ElevatorInPlaceCommand());
    }
  }

}