package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.ElevatorSetpointCommand;
import frc.robot.utilities.RobotLog;

public class ElevatorVerticalSubsystem extends Subsystem {
  static TalonSRX verticalYElevatorMotor;
  private static PIDOutput pidOutput;

  static int tolerance = 5;

  public ElevatorVerticalSubsystem(int verticalYElevatorMotorPort, double[] verticalElevatorEncoderPIDValues){
    if (Constants.wristEnabled){

    verticalYElevatorMotor = new WPI_TalonSRX(verticalYElevatorMotorPort);

    /*
    verticalElevatorEncoderPID = new PIDController(verticalElevatorEncoderPIDValues[0], verticalElevatorEncoderPIDValues[1],
        verticalElevatorEncoderPIDValues[2], verticalElevatorEncoderPIDValues[3], verticalElevatorEncoder, pidOutput);
    verticalElevatorEncoderPID.setEnabled(true);
    verticalElevatorEncoderPID.setContinuous(true);
    verticalElevatorEncoderPID.setAbsoluteTolerance(1);
    verticalElevatorEncoderPID.setOutputRange(-.6, .6);
    verticalElevatorEncoderPID.setInputRange(-Double.MAX_VALUE, Double.MAX_VALUE);
    verticalElevatorEncoderPID.enable();
    verticalYElevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

    rightElevatorEncoderPID = new PIDController(rightElevatorEncoderPIDValues[0], rightElevatorEncoderPIDValues[1],
        rightElevatorEncoderPIDValues[2], rightElevatorEncoderPIDValues[3], rightElevatorEncoder, pidOutput);
    rightElevatorEncoderPID.setEnabled(true);
    rightElevatorEncoderPID.setContinuous(true);
    rightElevatorEncoderPID.setAbsoluteTolerance(1);
    rightElevatorEncoderPID.setOutputRange(-.6, .6);
    rightElevatorEncoderPID.setInputRange(-Double.MAX_VALUE, Double.MAX_VALUE);
    rightElevatorEncoderPID.enable();
    rightYElevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute); 
    */

    verticalYElevatorMotor.configPeakOutputForward(1);
    verticalYElevatorMotor.configPeakOutputReverse(-1);
    verticalYElevatorMotor.config_kP(0, verticalElevatorEncoderPIDValues[0]);
    verticalYElevatorMotor.config_kI(0, verticalElevatorEncoderPIDValues[1]);
    verticalYElevatorMotor.config_kD(0, verticalElevatorEncoderPIDValues[2]);
    verticalYElevatorMotor.config_kF(0, verticalElevatorEncoderPIDValues[3]);
    verticalYElevatorMotor.setSensorPhase(false);
    // Change above to true to invert sensor readout

    RobotLog.putMessage("Running ElevatorVerticalSubsystem");
    }
  }

  public void setYElevatorMotor(double Speed) {
    if (Constants.wristEnabled){
    verticalYElevatorMotor.set(ControlMode.PercentOutput, Speed);
    }
  }

  public void setYElevatorMotorPosition(double Position){
    if (Constants.wristEnabled){
    verticalYElevatorMotor.set(ControlMode.Position, Position);
    }
  }

  public double getElevatorMotorsCurrent(){
    if (Constants.wristEnabled){
    return verticalYElevatorMotor.getOutputCurrent();
    } else {
      return 0;
    }
  }

  public int getVerticalElevatorEncoder() {
    if (Constants.wristEnabled){
    return verticalYElevatorMotor.getSelectedSensorPosition();
    } else {
      return 0;
    }
  }

  public void resetBothElevatorEncoders() {
    if (Constants.wristEnabled){
    verticalYElevatorMotor.setSelectedSensorPosition(0);
    }
  }

  public void setBothElevatorEncoderPIDValues(double p, double i, double d) {
    if (Constants.wristEnabled){
    // verticalElevatorEncoderPID.setPID(p, i, d);
    // verticalElevatorEncoderPID.setP(p);
    // verticalElevatorEncoderPID.setI(i);
    // verticalElevatorEncoderPID.setD(d);

    // rightElevatorEncoderPID.setPID(p, i, d);
    // rightElevatorEncoderPID.setP(p);
    // rightElevatorEncoderPID.setI(i);
    // rightElevatorEncoderPID.setD(d);

    verticalYElevatorMotor.config_kP(0, p);
    verticalYElevatorMotor.config_kI(0, i);
    verticalYElevatorMotor.config_kD(0, d);
    }
  }

  public void setBothElevatorEncoderPIDValues(double p, double i, double d, double f) {
    if (Constants.wristEnabled){
    // verticalElevatorEncoderPID.setPID(p, i, d, f);
    // verticalElevatorEncoderPID.setP(p);
    // verticalElevatorEncoderPID.setI(i);
    // verticalElevatorEncoderPID.setD(d);
    // verticalElevatorEncoderPID.setF(f);

    // rightElevatorEncoderPID.setPID(p, i, d, f);
    // rightElevatorEncoderPID.setP(p);
    // rightElevatorEncoderPID.setI(i);
    // rightElevatorEncoderPID.setD(d);
    // rightElevatorEncoderPID.setF(f);

    verticalYElevatorMotor.config_kP(0, p);
    verticalYElevatorMotor.config_kI(0, i);
    verticalYElevatorMotor.config_kD(0, d);
    verticalYElevatorMotor.config_kF(0, f);
    }
  }

  public boolean checkOnTargetSetpoint(){
    if (Constants.wristEnabled){
    return Math.abs(verticalYElevatorMotor.getClosedLoopError()) < tolerance;
    } else {
      return false;
    }
  }

  public void initDefaultCommand() {
    if (Constants.wristEnabled){
    //setDefaultCommand(new ElevatorSetpointCommand(Constants.defaultElevatorPosition));
    }
  }

}