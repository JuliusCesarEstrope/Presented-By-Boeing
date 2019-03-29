package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.commands.TankDriveCommand;
import frc.robot.utilities.DoublePIDOutput;
import frc.robot.utilities.RobotLog;

public class DriveSubsystem extends Subsystem {
  TalonSRX talonLeft, talonRight;
  DoublePIDOutput gyroOutput;
  VictorSPX[] victorsLeft, victorsRight;
  AnalogGyro gyroDrive;
  double pidTolerance = 70;
  double ramp = .25;
  static DigitalInput leftSensor;
  static DigitalInput frontSensor;
  static DigitalInput rightSensor;
  static DigitalInput backSensor;
  private static PIDController gyroPID;
  private static int tolerance = 70;

  public DriveSubsystem(int[] motorPortsLeft, int[] motorPortsRight, int gyroPort, 
      int frontSensor, int rightSensor, int backSensor, int leftSensor,
      double circumferanceOfWheels, double ticksOfEncoder,
      double[] leftPIDValues, double[] rightPIDValues, double[] drivePIDValues) {
    if (Constants.driveEnabled) {

      gyroDrive = new AnalogGyro(gyroPort);
      talonLeft = new WPI_TalonSRX(motorPortsLeft[0]);
      talonRight = new WPI_TalonSRX(motorPortsRight[0]);
      gyroOutput = new DoublePIDOutput();

      talonLeft.configFactoryDefault();
      talonRight.configFactoryDefault();
      talonLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);
      talonRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

      talonLeft.configPeakOutputForward(1);
      talonLeft.configPeakOutputReverse(-1);
      talonLeft.configClosedloopRamp(ramp);
      talonLeft.config_kP(0, leftPIDValues[0]);
      talonLeft.config_kI(0, leftPIDValues[1]);
      talonLeft.config_kD(0, leftPIDValues[2]);
      talonLeft.config_kF(0, leftPIDValues[3]);
      talonLeft.setSensorPhase(true);
      talonLeft.setInverted(false);

      talonRight.configPeakOutputForward(1);
      talonRight.configPeakOutputReverse(-1);
      talonRight.configClosedloopRamp(ramp);
      talonRight.config_kP(0, rightPIDValues[0]);
      talonRight.config_kI(0, rightPIDValues[1]);
      talonRight.config_kD(0, rightPIDValues[2]);
      talonRight.config_kF(0, rightPIDValues[3]);
      talonRight.setSensorPhase(false);
      talonRight.setInverted(true);

      talonLeft.setNeutralMode(NeutralMode.Brake);
      talonRight.setNeutralMode(NeutralMode.Brake);

      gyroPID = new PIDController(0.05, 0, 0, gyroDrive, gyroOutput);
      gyroPID.setAbsoluteTolerance(1);
      gyroPID.setInputRange(-Integer.MAX_VALUE, Integer.MAX_VALUE);
      gyroPID.setOutputRange(-1, 1);
      gyroPID.setEnabled(true);

      RobotLog.putMessage("Running DriveSubsystem");
      victorsLeft = new WPI_VictorSPX[motorPortsLeft.length - 1];
      victorsRight = new WPI_VictorSPX[motorPortsRight.length - 1];

      for (int i = 0; i < victorsLeft.length; i++)
        victorsLeft[i] = new WPI_VictorSPX(motorPortsLeft[i + 1]);
      for (int i = 0; i < victorsRight.length; i++)
        victorsRight[i] = new WPI_VictorSPX(motorPortsRight[i + 1]);

      for (int i = 0; i < victorsLeft.length; i++) {
        victorsLeft[i].follow(talonLeft);
        victorsLeft[i].setNeutralMode(NeutralMode.Brake);
        victorsLeft[i].setInverted(InvertType.FollowMaster);
      }

      for (int i = 0; i < victorsRight.length; i++) {
        victorsRight[i].follow(talonRight);
        victorsRight[i].setNeutralMode(NeutralMode.Brake);
        victorsRight[i].setInverted(InvertType.FollowMaster);
      }

    }

  }

  public void resetGyro() {
    if (Constants.driveEnabled) {
      gyroDrive.reset();
    }
  }

  public void setgyroPIDValues(double p, double i, double d) {
    if (Constants.driveEnabled) {
      gyroPID.setPID(p, i, d);
    }
  }

  public void enableGyroPID() {
    if (Constants.driveEnabled) {
      gyroPID.enable();
    }
  }

  public double getGyroPIDError() {
    if (Constants.driveEnabled) {
      return gyroPID.getError();
    } else {
      return 0;
    }
  }

  public void setGyroSetpoint(double setpoint) {
    if (Constants.driveEnabled) {
      gyroPID.setSetpoint(setpoint);
    }
  }

  public boolean gyroPIDOnSetpoint() {
    if (Constants.driveEnabled) {
      return gyroPID.onTarget();
    } else {
      return false;
    }
  }

  public boolean rightOnTarget() {
    if (Constants.driveEnabled) {
      return Math.abs(talonRight.getClosedLoopError()) < tolerance;
    } else {
      return false;
    }
  }

  public boolean leftOnTarget() {
    if (Constants.driveEnabled) {
      return Math.abs(talonLeft.getClosedLoopError()) < tolerance;
    } else {
      return false;
    }
  }

  public boolean distanceOnTarget() {
    if (Constants.driveEnabled) {
      return leftOnTarget() || rightOnTarget();
    } else {
      return false;
    }
  }

  public double getGyroPIDOutput() {
    if (Constants.driveEnabled) {
      return gyroPID.get();
    } else {
      return 0;
    }
  }

  public void disableGyroPID() {
    if (Constants.driveEnabled) {
      gyroPID.disable();
    }
  }

  public void setLeft(double speed) {
    if (Constants.driveEnabled) {
      talonLeft.set(ControlMode.PercentOutput, speed);
      // for (VictorSPX i : victorsLeft)
      // i.set(ControlMode.PercentOutput, Math.min(Math.max(speed, -1), 1));
    }
  }

  public void setRight(double speed) {
    if (Constants.driveEnabled) {
      talonRight.set(ControlMode.PercentOutput, speed);
      // for (VictorSPX i : victorsRight)
      // i.set(ControlMode.PercentOutput, Math.max(Math.min(-speed, -1), 1));
    }
  }

  public void setLeftMotorPosition(double position) {
    if (Constants.driveEnabled) {
      talonLeft.set(ControlMode.Position, position);
    }
  }

  public void setRightMotorPosition(double position) {
    if (Constants.driveEnabled) {
      talonRight.set(ControlMode.Position, position);
    }
  }

  public void setBothPositions(double talonLeftPosition, double talonRightPosition) {
    if (Constants.driveEnabled) {
      setBothPositions(talonLeftPosition, talonRightPosition, 0);
    }
  }

  public void setBothPositions(double talonLeftPosition, double talonRightPosition, double gyroCorrection) {
    if (Constants.driveEnabled) {
      talonLeftPosition *= Constants.ticksOfEncoder / Constants.circumferenceOfWheels;
      talonRightPosition *= Constants.ticksOfEncoder / Constants.circumferenceOfWheels;
      setLeftMotorPosition(talonLeftPosition);
      //setRightMotorPosition(talonRightPosition);
      talonRight.set(ControlMode.Position, talonRightPosition, DemandType.AuxPID,
        gyroCorrection);
    }
  }

  public void setBoth(double speedLeft, double speedRight) {
    if (Constants.driveEnabled) {
      setLeft(speedLeft);
      setRight(speedRight);
    }
  }

  public void setBoth(double speed) {
    if (Constants.driveEnabled) {
      setLeft(speed);
      setRight(speed);
    }
  }

  public void resetEncoder() {
    if (Constants.driveEnabled) {
      talonLeft.setSelectedSensorPosition(0);
      talonRight.setSelectedSensorPosition(0);
    }
  }

  public void calibrateGyro() {
    if (Constants.driveEnabled) {
      gyroDrive.calibrate();
    }
  }

  public double getAngle() {
    if (Constants.driveEnabled) {
      return gyroDrive.getAngle() % 360;
    } else {
      return 0;
    }
  }

  public int getEncoderLeft() {
    if (Constants.driveEnabled) {
      return talonLeft.getSelectedSensorPosition();
    } else {
      return 0;
    }
  }

  public int getEncoderRight() {
    if (Constants.driveEnabled) {
      return talonRight.getSelectedSensorPosition();
    } else {
      return 0;
    }
  }

  public void setDrivePIDValues(double p, double i, double d) {
    if (Constants.driveEnabled) {
      talonLeft.config_kP(0, p);
      talonLeft.config_kI(0, i);
      talonLeft.config_kD(0, d);
    }
  }

  public void setDrivePIDValues(double p, double i, double d, double f) {
    if (Constants.driveEnabled) {
      setDrivePIDValues(p, i, d);
      talonLeft.config_kF(0, f);
    }
  }

  public double getRightError() {
    if (Constants.driveEnabled) {
      return talonRight.getClosedLoopError();
    } else {
      return 0;
    }
  }

  public boolean getLeftSensor() {
    if (Constants.driveEnabled) {
      return leftSensor.get();
    } else {
      return false;
    }
  }

  // sets leftSensor to a boolean value of true being it is seeing the tape
  public boolean getFrontSensor() {
    if (Constants.driveEnabled) {
      return frontSensor.get();
    } else {
      return false;
    }
  }

  // sets frontSensor to a boolean value of true being it is seeing the tape
  public boolean getRightSensor() {
    if (Constants.driveEnabled) {
      return rightSensor.get();
    } else {
      return false;
    }
  }

  public boolean getBackSensor() {
    if (Constants.driveEnabled) {
      return backSensor.get();
    } else {
      return false;
    }
  }

  public void initDefaultCommand() {
    if (Constants.driveEnabled) {
      setDefaultCommand(new TankDriveCommand());
    }
  }

}
