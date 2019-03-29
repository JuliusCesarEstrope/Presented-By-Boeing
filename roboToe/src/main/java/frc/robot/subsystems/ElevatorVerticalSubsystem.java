package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class ElevatorVerticalSubsystem extends Subsystem {
  static TalonSRX verticalYElevatorMotor;

  static int tolerance = 5;

  public ElevatorVerticalSubsystem(int verticalYElevatorMotorPort, double[] YElevatorEncoderPIDValues){
    if (Constants.elevatorVerticalEnabled){

    verticalYElevatorMotor = new WPI_TalonSRX(verticalYElevatorMotorPort);

    verticalYElevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

    verticalYElevatorMotor.configPeakOutputForward(1);
    verticalYElevatorMotor.configPeakOutputReverse(-1);
    verticalYElevatorMotor.config_kP(0, YElevatorEncoderPIDValues[0]);
    verticalYElevatorMotor.config_kI(0, YElevatorEncoderPIDValues[1]);
    verticalYElevatorMotor.config_kD(0, YElevatorEncoderPIDValues[2]);
    verticalYElevatorMotor.config_kF(0, YElevatorEncoderPIDValues[3]);
    verticalYElevatorMotor.setSensorPhase(true);
    // Change above to true to invert sensor readout

    RobotLog.putMessage("Running ElevatorVerticalSubsystem");
    }
  }

  public void setYElevatorMotor(double Speed) {
    if (Constants.elevatorVerticalEnabled){
    verticalYElevatorMotor.set(ControlMode.PercentOutput, Speed);
    }
  }

  public void setYElevatorMotorPosition(double Position){
    if (Constants.elevatorVerticalEnabled){
    verticalYElevatorMotor.set(ControlMode.Position, Position);
    }
  }

  public double getElevatorMotorsCurrent(){
    if (Constants.elevatorVerticalEnabled){
    return verticalYElevatorMotor.getOutputCurrent();
    } else {
      return 0;
    }
  }

  public int getVerticalElevatorEncoder() {
    if (Constants.elevatorVerticalEnabled){
    return verticalYElevatorMotor.getSelectedSensorPosition();
    } else {
      return 0;
    }
  }

  public void resetElevatorEncoder() {
    if (Constants.elevatorVerticalEnabled){
    verticalYElevatorMotor.setSelectedSensorPosition(0);
    }
  }

  public void setBothElevatorEncoderPIDValues(double p, double i, double d, double f) {
    if (Constants.elevatorVerticalEnabled) {
      verticalYElevatorMotor.config_kP(0, p);
      verticalYElevatorMotor.config_kI(0, i);
      verticalYElevatorMotor.config_kD(0, d);
      verticalYElevatorMotor.config_kF(0, f);
    }
  }

  public boolean checkOnTargetSetpoint(){
    if (Constants.elevatorVerticalEnabled){
    return Math.abs(verticalYElevatorMotor.getClosedLoopError()) < tolerance;
    } else {
      return false;
    }
  }

  public void initDefaultCommand() {
    if (Constants.elevatorVerticalEnabled){
    //setDefaultCommand(new ElevatorSetpointCommand(Constants.defaultElevatorPosition));
    }
  }

}