package frc.robot.commands;
import frc.robot.Constants;

import frc.robot.utilities.RobotLog;

public class WristCommand extends CommandBase {
<<<<<<< HEAD
    boolean buttonReleased;
    int leftWristEncoder;
    int rightWristEncoder;
    int wristDownSetPoint = 70;   ////////////////////////////////////
    int wristUpSetPoint = 0; /////////////////////////////////////////
    boolean wristUp = false;
    boolean wristDown = false;
    boolean moveWrist;
    double wristDistance;

  
<<<<<<< HEAD
  public WristCommand(int wristUpSetPoint) {
=======
  public WristCommand(double wristDistance) {
>>>>>>> John-Schultz
    // Use requires() here to declare subsystem dependencies
=======
  boolean buttonReleased;
  int leftWristEncoder;
  int rightWristEncoder;
  int wristDownSetPoint = 70;
  int wristUpSetPoint = 0;
  boolean wristUp = false;
  boolean wristDown = false;
  boolean moveWrist;

  public WristCommand() {
    RobotLog.putMessage("Running WristCommand");
>>>>>>> Maggie
    requires(wrist);
<<<<<<< HEAD
    leftWristEncoder = wrist.getLeftWristEncoder();
    rightWristEncoder = wrist.getRightWristEncoder();
=======
    this.wristDistance = wristDistance;

>>>>>>> John-Schultz
  }

  protected void initialize() {
<<<<<<< HEAD
    // Set point
    // Send PID to correct motors

    buttonReleased = true;
<<<<<<< HEAD
    
    wrist.ResetEncoder();
    wrist.getLeftWristPIDOutput();
    wrist.getRightWristPIDOutput();
    wrist.setWristUpSetpoint(wristUpSetPoint);
    wrist.setWristDownSetpoint(wristDownSetPoint);
=======
    moveWrist = false;

    wrist.ResetEncoder();
    wrist.getLeftWristPIDOutput();
    wrist.getRightWristPIDOutput();
    // wrist.setLeftWristSetpoint(leftWristEncoder);
    // wrist.setRightWristSetpoint(rightWristEncoder);
>>>>>>> Maggie
=======
    //Set point
    //Send PID to correct  motors
    wrist.setWristSetpoint(wristDistance + Constants.defaultWristPosition);

    //wrist.setLeftWristSetpoint(leftWristEncoder);
    //wrist.setRightWristSetpoint(rightWristEncoder);
>>>>>>> John-Schultz
  }

  @Override
  protected void execute() {
<<<<<<< HEAD
    // Two Positions (Up, Down)

<<<<<<< HEAD
    if(leftWristEncoder <= 0 && rightWristEncoder >= 0) {
      wrist.setBothWristMotor(-0.70, 0.70);
    }

    else if(leftWristEncoder >= 0 && rightWristEncoder <= 0) {
=======
    if (moveWrist && leftWristEncoder <= 0 && rightWristEncoder >= 0) {
      wrist.setBothWristMotor(-0.70, 0.70);
    }

    else if (!moveWrist && leftWristEncoder >= 0 && rightWristEncoder <= 0) {
>>>>>>> Maggie
      wrist.setBothWristMotor(0.70, -0.70);
    }

    if (wristUp && leftWristEncoder >= 0 && rightWristEncoder <= 0) {
      wrist.setWristUpSetpoint(wristUpSetPoint);

    }

    if (wristDown && rightWristEncoder >= 0 && leftWristEncoder <= 0) {
      wrist.setWristDownSetpoint(wristDownSetPoint);
    }
=======
    //Two Positions (Up, Down)
    wrist.setBothWristMotor(wrist.getLeftWristPIDOutput());
    
>>>>>>> John-Schultz
  }

  protected boolean isFinished() {
<<<<<<< HEAD
    // if needed to maintain set pont (false) stopping point (true)
    return false;
=======
    //if needed to maintain set pont (false) stopping point (true)
    return wrist.leftWristOnTarget();
>>>>>>> John-Schultz
  }

  protected void end() {
<<<<<<< HEAD
    drive.setBoth(0, 0);  
=======
    wrist.setBothWristMotor(0, 0);
>>>>>>> John-Schultz
  }

  protected void interrupted() {
    wrist.setBothWristMotor(0, 0);
  }
}