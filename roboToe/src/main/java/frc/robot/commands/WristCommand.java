/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.Constants;

public class WristCommand extends CommandBase {
    boolean buttonReleased;
    int leftWristEncoder;
    int rightWristEncoder;
    int wristDownSetPoint = 70;   ////////////////////////////////////
    int wristUpSetPoint = 0; /////////////////////////////////////////
    boolean wristUp = false;
    boolean wristDown = false;
    boolean moveWrist;
    double wristDistance;

  
  public WristCommand(double wristDistance) {
    // Use requires() here to declare subsystem dependencies
    requires(wrist);
    this.wristDistance = wristDistance;

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Set point
    //Send PID to correct  motors
    wrist.setWristSetpoint(wristDistance + Constants.defaultWristPosition);

    //wrist.setLeftWristSetpoint(leftWristEncoder);
    //wrist.setRightWristSetpoint(rightWristEncoder);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //Two Positions (Up, Down)
    wrist.setBothWristMotor(wrist.getLeftWristPIDOutput());
    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    //if needed to maintain set pont (false) stopping point (true)
    return wrist.leftWristOnTarget();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    wrist.setBothWristMotor(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    wrist.setBothWristMotor(0, 0);
  }
}
