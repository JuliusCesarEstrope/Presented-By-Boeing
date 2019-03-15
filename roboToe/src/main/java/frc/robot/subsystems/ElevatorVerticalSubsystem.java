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
  static Encoder verticalYElevatorEncoder;
  private static PIDOutput pidOutput;

  static int tolerance = 5;

  public ElevatorVerticalSubsystem(int verticalYElevatorMotorPort, double[] verticalElevatorEncoderPIDValues){
      

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

    verticalYElevatorMotor.configNominalOutputForward(0);
    verticalYElevatorMotor.configNominalOutputReverse(0);
    verticalYElevatorMotor.configPeakOutputForward(.6);
    verticalYElevatorMotor.configPeakOutputReverse(.6);
    verticalYElevatorMotor.config_kP(0, verticalElevatorEncoderPIDValues[0]);
    verticalYElevatorMotor.config_kI(0, verticalElevatorEncoderPIDValues[1]);
    verticalYElevatorMotor.config_kD(0, verticalElevatorEncoderPIDValues[2]);
    verticalYElevatorMotor.config_kF(0, verticalElevatorEncoderPIDValues[3]);
    verticalYElevatorMotor.setSensorPhase(false);
    // Change above to true to invert sensor readout

    RobotLog.putMessage("Running ElevatorVerticalSubsystem");
  }

  public void setYElevatorMotor(double Speed) {
    verticalYElevatorMotor.set(ControlMode.PercentOutput, Speed);
  }

  public void setYElevatorMotorPosition(double Position){
    verticalYElevatorMotor.set(ControlMode.Position, Position);
  }

  public double getElevatorMotorsCurrent(){
    return verticalYElevatorMotor.getOutputCurrent();
  }

  public int getVerticalElevatorEncoder() {
    return verticalYElevatorMotor.getSelectedSensorPosition();
  }

  public void resetBothElevatorEncoders() {
    verticalYElevatorEncoder.reset();
  }

  public void setBothElevatorEncoderPIDValues(double p, double i, double d) {
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

  public void setBothElevatorEncoderPIDValues(double p, double i, double d, double f) {
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

  public boolean checkOnTargetSetpoint(){
    return Math.abs(verticalYElevatorMotor.getClosedLoopError()) < tolerance;
  }

  public void initDefaultCommand() {
    setDefaultCommand(new ElevatorSetpointCommand(Constants.defaultElevatorPosition));
  }

}