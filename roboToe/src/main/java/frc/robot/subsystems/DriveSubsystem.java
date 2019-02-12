package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  static Talon[] leftMotor, rightMotor;
   
public DriveSubsystem(int[] leftMotorPorts, int[] rightMotorPorts){
  leftMotor = new Talon[leftMotorPorts.length];
  rightMotor = new Talon[rightMotorPorts.length];
  for(int i = 0; i < leftMotorPorts.length; i++){
    leftMotor[i] = new Talon(leftMotorPorts[i]);
  }
  for(int i = 0; i < rightMotorPorts.length; i++){
    rightMotor[i] = new Talon(rightMotorPorts[i]);
  }
}

public static void setLeftMotor(double Speed){
  for(int i = 0; i < leftMotor.length; i++){
    leftMotor[i].set(Speed);
  }
}

public static void setRightMotor(double Speed){
  for(int i = 0; i < rightMotor.length; i++){
    rightMotor[i].set(-Speed);
  }
}
public static void setBothMotor(double leftSpeed, double rightSpeed){
  setLeftMotor(leftSpeed);
  setRightMotor(rightSpeed);
}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

