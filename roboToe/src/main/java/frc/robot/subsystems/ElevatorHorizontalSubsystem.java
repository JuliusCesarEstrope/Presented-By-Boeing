package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.utilities.RobotLog;

public class ElevatorHorizontalSubsystem extends Subsystem {
  static VictorSPX leftXElevatorMotor, rightXElevatorMotor;
  static DigitalInput fastSlowStopSensor;

  public ElevatorHorizontalSubsystem(int leftXElevatorMotorPort,
      double defaultElevatorPosition) {

    leftXElevatorMotor = new WPI_VictorSPX(leftXElevatorMotorPort);
/*
    rightXElevatorMotor.follow(leftXElevatorMotor);
    rightXElevatorMotor.setInverted(true); //SHOULD BE HERE?
*/
    RobotLog.putMessage("Running ElevatorHorizontalSubsystem");
  }

  public void setXElevatorMotors(double Speed) {
    leftXElevatorMotor.set(ControlMode.PercentOutput, Speed);
  }

  public double getXElevatorMotors(){
    return leftXElevatorMotor.getMotorOutputPercent();
  }

  public boolean getfastSlowStopSensor() {
    return fastSlowStopSensor.get();
  }

  public void initDefaultCommand() {
    //setDefaultCommand(new ElevatorInPlaceCommand());
  }

}