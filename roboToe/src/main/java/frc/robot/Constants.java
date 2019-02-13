package frc.robot;
public class Constants {
  //Motors
  public static final int[] motorPortsLeft = {4, 5, 6};
  public static final int[] motorPortsRight = {1, 2, 3};
  public static final int rollerMotor = 7;
  public static final int leftWristMotor = 8;
  public static final int rightWristMotor = 9;
  //Joysticks
  public static final int leftJoystick = 0;
  public static final int rightJoystick = 1;
  public static final int gamePad = 2;
  public static final int gamepad = 16;
  //Gyros
  public static final int gyroPort = 0;
  //Encoders
  public static final int[] encoderPortLeft = {0, 1};
  public static final int[] encoderPortRight = {0, 1};
  public static final int[] leftWristEncoder = {6, 7};
  public static final int[] rightWristEncoder = {8, 9};
  //Pneumatics
  public static final int[] booperPort = {0, 1};
  //Wrist Stuff
  public static int wristButton = 3;
  public static int wristDownSetPoint = 70;
  public static int wristUpSetPoint = 0;
  //PID
  public static double[] driveRotationPIDValues = { 0.1, 0, 0, 0 };
}