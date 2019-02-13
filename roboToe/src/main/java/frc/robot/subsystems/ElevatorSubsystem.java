package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

// 6 motors for driving wheels in COMMAND, 2 motors for vertical motion of elevator, 2 horizontal motion (TalonSRX), 1 sensor for tape, 1 sensor for vertical height

public class ElevatorSubsystem extends Subsystem {
  static TalonSRX leftYElevatorMotor, rightYElevatorMotor, leftXElevatorMotor, rightXElevatorMotor;
  static Encoder leftElevatorEncoder, rightElevatorEncoder;
  static DigitalInput fastSlowStopSensor;
  private static PIDController leftElevatorEncoderPID;
  private static PIDController rightElevatorEncoderPID;
  private static PIDOutput pidOutput;
  
  public ElevatorSubsystem (int leftYElevatorMotorPort, int rightYElevatorMotorPort, int leftXElevatorMotorPort, int rightXElevatorMotorPort, int[] leftElevatorEncoderPorts, int[] rightElevatorEncoderPorts, int fastSlowStopSensorPort, double[] heightSensorPIDValues, double[] leftElevatorEncoderPIDValues, double[] rightElevatorEncoderPIDValues){
    
    leftYElevatorMotor = new WPI_TalonSRX(leftYElevatorMotorPort);
    rightYElevatorMotor = new WPI_TalonSRX(rightYElevatorMotorPort);
    leftXElevatorMotor = new WPI_TalonSRX(leftXElevatorMotorPort);
    rightXElevatorMotor = new WPI_TalonSRX(rightXElevatorMotorPort);

    rightYElevatorMotor.follow(leftYElevatorMotor);
    rightYElevatorMotor.setInverted(true);
    rightXElevatorMotor.follow(leftXElevatorMotor);
    rightXElevatorMotor.setInverted(true);

    leftElevatorEncoder = new Encoder(leftElevatorEncoderPorts[1], leftElevatorEncoderPorts[2]);
    rightElevatorEncoder = new Encoder(rightElevatorEncoderPorts[3], rightElevatorEncoderPorts[4]);

    leftElevatorEncoderPID = new PIDController(leftElevatorEncoderPIDValues[0], leftElevatorEncoderPIDValues[1],
    leftElevatorEncoderPIDValues[2], leftElevatorEncoderPIDValues[3], leftElevatorEncoder, pidOutput);
    leftElevatorEncoderPID.setEnabled(true);
    leftElevatorEncoderPID.setContinuous(true);
    leftElevatorEncoderPID.setAbsoluteTolerance(.3);
    // FIGURE OUT ABOVE
    leftElevatorEncoderPID.setOutputRange(-1, 1);
    // FIGURE OUT ABOVE
    leftElevatorEncoderPID.setInputRange(0, 5);
    // FIGURE OUT ABOVE
    leftElevatorEncoderPID.enable();

    rightElevatorEncoderPID = new PIDController(rightElevatorEncoderPIDValues[0], rightElevatorEncoderPIDValues[1],
    rightElevatorEncoderPIDValues[2], rightElevatorEncoderPIDValues[3], rightElevatorEncoder, pidOutput);
    rightElevatorEncoderPID.setEnabled(true);
    rightElevatorEncoderPID.setContinuous(true);
    rightElevatorEncoderPID.setAbsoluteTolerance(.3);
    // FIGURE OUT ABOVE
    rightElevatorEncoderPID.setOutputRange(-1, 1);
    // FIGURE OUT ABOVE
    rightElevatorEncoderPID.setInputRange(0, 5);
    // FIGURE OUT ABOVE
    rightElevatorEncoderPID.enable();
    
    }

    public void setYElevatorMotors(double Speed) {
     leftYElevatorMotor.set(ControlMode.PercentOutput, Speed);
    }
  
    public void setXElevatorMotors(double Speed) {
      leftXElevatorMotor.set(ControlMode.PercentOutput, Speed);
    }
  
    public int getLeftElevatorEncoder(){
      return leftElevatorEncoder.get();
    }

    public int getRightElevatorEncoder(){
      return rightElevatorEncoder.get();
    }

    public void resetBothElevatorEncoders(){
      leftElevatorEncoder.reset();
      rightElevatorEncoder.reset();
    }

    public boolean fastSlowStopSensor() {
      return fastSlowStopSensor.get();
    }

    public static void setbothElevatorEncoderPIDValues(double p, double i, double d) {
      leftElevatorEncoderPID.setPID(p, i, d);
      rightElevatorEncoderPID.setPID(p, i, d);
    }
  
    public static void setbothElevatorEncoderPIDValues(double p, double i, double d, double f) {
      leftElevatorEncoderPID.setPID(p, i, d, f);
      rightElevatorEncoderPID.setPID(p, i, d, f);
    }

    public static void setleftElevatorEncoderSetpoint(double leftElevatorEncoder) {
      leftElevatorEncoderPID.setSetpoint(leftElevatorEncoder);
    }

    public static void setrightElevatorEncoderSetpoint(double rightElevatorEncoder) {
      rightElevatorEncoderPID.setSetpoint(rightElevatorEncoder);
    }

    public static void getleftElevatorEncoderSetpoint(double leftElevatorEncoder){
      leftElevatorEncoderPID.getSetpoint();
    }
  
    public double getleftElevatorEncoderPIDOutput() {
      return leftElevatorEncoderPID.get();
    }  

    public double getrightElevatorEncoderPIDOutput() {
      return rightElevatorEncoderPID.get();
    }  

    public void initDefaultCommand() {
    // Required to be here if empty. Insert program you want to run for this subsystem when robot first turned on
    }

}