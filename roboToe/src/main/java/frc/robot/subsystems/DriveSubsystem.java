package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.TankDrive;
public class DriveSubsystem extends Subsystem {
  TalonSRX talonLeft, talonRight;
  VictorSPX[] victorsLeft, victorsRight;
  AnalogGyro gyroDrive;
  Encoder encoderLeft, encoderRight;
  static AnalogGyro gyro;
  static DigitalInput leftSensor;
  static DigitalInput frontSensor;
  static DigitalInput rightSensor;
  static DigitalInput backSensor;

public DriveSubsystem(int[] motorPortsLeft, int[] motorPortsRight, int gyroPort, int driveEncoderPortLeft[], int driveEncoderPortRight[],int leftSensor, int frontSensor, int rightSensor, int backSensor, int[] leftEncoderPorts, int[] rightEncoderPorts, double circumferanceOfWheels, double ticksOfEncoder){
  gyroDrive = new AnalogGyro(gyroPort);
  encoderLeft = new Encoder(driveEncoderPortLeft[0],driveEncoderPortLeft[1]);
  encoderRight = new Encoder(driveEncoderPortRight[0],driveEncoderPortRight[1]);
  talonLeft = new WPI_TalonSRX(motorPortsLeft[0]);
  talonRight = new WPI_TalonSRX(motorPortsRight[0]);
  victorsLeft = new WPI_VictorSPX[motorPortsLeft.length - 1];
  victorsRight = new WPI_VictorSPX[motorPortsRight.length - 1];
  for(int i = 0; i < victorsLeft.length; i++){
    victorsLeft[i] = new WPI_VictorSPX(motorPortsLeft[i]); 
  for(i = 0; i < victorsRight.length; i++){
    victorsRight[i] = new WPI_VictorSPX(motorPortsRight[i]);
  
    talonLeft = new WPI_TalonSRX(motorPortsLeft[0]);
    }
    talonRight = new WPI_TalonSRX(motorPortsRight[0]);
    }
      encoderLeft.setDistancePerPulse(circumferanceOfWheels/ticksOfEncoder);
      
  }


public void setLeft(double speed){
  talonLeft.set(ControlMode.PercentOutput, Math.max(Math.min(speed, -1), 1));
  for(VictorSPX i: victorsLeft)
    i.set(ControlMode.PercentOutput, Math.max(Math.min(speed, -1), 1));
}
public void setRight(double speed){
  talonRight.set(ControlMode.PercentOutput, Math.max(Math.min(-speed, -1), 1));
  for(VictorSPX i: victorsRight)
    i.set(ControlMode.PercentOutput, Math.max(Math.min(-speed, -1), 1));
}
public void setBoth(double speedLeft, double speedRight){
  setLeft(speedLeft);
  setRight(speedRight);
}
public void setBoth(double speed){
  setLeft(speed);
  setRight(speed);    
}
public void calibrateGyro(){
  gyroDrive.calibrate();
}
public void resetGyro(){
    gyroDrive.reset();
}
public double getAngle(){
    return gyroDrive.getAngle() % 360;
}
public void resetEncoder(){
  encoderLeft.reset();
  encoderRight.reset();
}
public int getEncderLeft(){
  return encoderLeft.get();
}

public int getEncderRight(){
  return encoderRight.get();
}

@Override
public void initDefaultCommand() {
  setDefaultCommand(new TankDrive());
  }

// gives Gyro degree

public void resetAngle() {
  gyro.reset();
}

public double getWheelDistanceLeft() {
  return encoderLeft.getDistance();
}

public double getWheelDistanceRight() {
  return encoderRight.getDistance();
}

public boolean getLeftSensor(){
  return leftSensor.get();
}
//sets leftSensor to a boolean value of true being it is seeing the tape 
public boolean getFrontSensor(){
  return frontSensor.get();
}
//sets frontSensor to a boolean value of true being it is seeing the tape
public boolean getRightSensor(){
  return rightSensor.get();
}
//sets rightSensor to a boolean value of true being it is seeing the tape
}