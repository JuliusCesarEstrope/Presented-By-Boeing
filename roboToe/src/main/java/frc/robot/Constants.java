package frc.robot;
import edu.wpi.first.wpilibj.AnalogGyro;
public class Constants {
  //Motors
  public static final int[] motorPortsLeft = {4, 5, 6};
  public static final int[] motorPortsRight = {1, 2, 3};
  public static final int rollerMotor = 7;
  //Joysticks
  public static final int leftJoystick = 0;
  public static final int rightJoystick = 1;
  public static final int gamePad = 2;
  //Gyros
  public static final int gyroPort = 0;
  //Encoders
  public static final int[] encoderPortLeft = {0, 1};
  public static final int[] encoderPortRight = {0, 1};
  public static double ticksOfEncoder = 360;
  //Pneumatics
  public static final int[] booperPort = {0, 1};
  //Sensor
  public static final int leftSensor = 3;
  public static final int rightSensor = 4;
  public static final int frontSensor = 5;
  public static final int backSensor = 6;
  //Wheel Constants
  public static double diameterOfWheels = 7.8025;
  public static double circumferanceOfWheels = diameterOfWheels*Math.PI;
  //Sensor Constants
  public static double leftSensorToRightSensor = 7;
  public static double leftSensorToFrontSensor = 3.5;
  public static double frontSensorToBackSensor = 7;
  public static double rightSensorToBackSensor = 3.5;
  public static double rightSensorToCenterSensor = 1;
  public static double leftSensorToCenterSensor = 1;
}