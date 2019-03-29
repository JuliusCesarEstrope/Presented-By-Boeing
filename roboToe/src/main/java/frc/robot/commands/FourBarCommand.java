package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.utilities.RobotLog;

public class FourBarCommand extends CommandBase {
  double fourBarSetPoint;

  public FourBarCommand(double fourBarSetPoint) {
    // Use requires() here to declare subsystem dependencies
   // requires(fourBar);
    this.fourBarSetPoint = fourBarSetPoint;

  }

  protected void initialize() {
    RobotLog.putMessage("Running FourBarCommand");
    // send pid to correct motors
    //fourBar.setBothFourBarMotor(0, 0);

  }

  protected void execute() {
    //fourBar.setFourBarSetPoint(fourBarSetPoint); 
    //fourBar.setBothFourBarMotor(fourBar.getFourBarPIDOutput());//still need this??
   // fourBar.setBothFourBarMotorPosition(fourBarSetPoint);

    
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
  }

  protected void interrupted() {
  }
}