package frc.robot.commands;

import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class ElevatorHorizontalAutoCommand extends CommandBase {
  Potentiometer potentiometer;

  public ElevatorHorizontalAutoCommand() {
    requires(elevatorHorizontal);
    
  }

  protected void initialize() {
    RobotLog.putMessage("Running ElevatorHorizontalAutoCommand");
    drive.setBoth(0, 0);
 
  }

  protected void execute() {
   elevatorHorizontal.setXElevatorMotors(.4);

  if (Constants.elevatorHorizontalNone == elevatorHorizontal.getPotentiometer()) {
    elevatorHorizontal.setXElevatorMotors(.6);

          // USE RANGE OF VALUES

  } else if (Constants.elevatorHorizontalFast == elevatorHorizontal.getPotentiometer()) {
    elevatorHorizontal.setXElevatorMotors(.4);

  } else if (Constants.elevatorHorizontalSlow == elevatorHorizontal.getPotentiometer()) {
    elevatorHorizontal.setXElevatorMotors(.2);
    drive.setBoth(.4, .4);

  } else if (Constants.elevatorHorizontalStop == elevatorHorizontal.getPotentiometer()) {
    elevatorHorizontal.setXElevatorMotors(0);

   } SmartDashboard.putBoolean("X Elevator Sensor:", elevatorHorizontal.getlimitSwitch());
    SmartDashboard.putNumber("Speed of Horizontal Wheels:", elevatorHorizontal.getXElevatorMotors());
  }

  protected boolean isFinished() {
    return (elevatorHorizontal.getlimitSwitch() || oi.getElevatorEmergencyStopButton() || (elevatorHorizontal.getPotentiometer() == 0));
  }

  protected void end() {
    drive.setBoth(0, 0);
  }

  protected void interrupted() {
    drive.setBoth(0, 0);
  }
}