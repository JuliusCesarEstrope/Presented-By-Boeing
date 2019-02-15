package frc.robot;

public class Constants {
  // Motors
  public static final int[] leftMotor = { 4, 5, 6};
  public static final int[] rightMotor = { 1, 2, 3 };
  public static final int leftVerticalElevatorMotor = 11;
  public static final int rightVerticalElevatorMotor = 12;
  public static final int leftHorizontalElevatorMotor = 13;
  public static final int rightHorizontalElevatorMotor = 14;
  // Encoders
  public static final int[] leftElevatorEncoder = {1, 2};
  public static final int[] rightElevatorEncoder = {3, 4};
  // Joysticks
  public static final int leftJoystick = 0;
  public static final int rightJoystick = 1;
  public static final int gamePad = 2;
  // Gyro
  public static final int gyro = 0;
  // Sensor
  public static final int fastSlowStopSensor = 1;
  // PID
  public static final double[] leftElevatorEncoderPIDValues = {0, 0, 0, 0};
  public static final double[] rightElevatorEncoderPIDValues = {0, 0, 0, 0};
  // Constant Number
  public static final double defaultElevatorPosition = 0;
      // FIGURE OUT WHAT VALUE IS SUPPOSED TO BE
  public static final double distanceToTicks = (360 / (Math.PI*1.432));
  public static final double distanceYToTravel = distanceToTicks * 22;
  public static final double distanceYInch = distanceToTicks * 1;
  public static final double distanceYFiveInch = distanceToTicks * 5;
}
