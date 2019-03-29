package frc.robot.commands;

import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;

public class ElevatorHorizontalAutoCommand extends CommandBase {

  public ElevatorHorizontalAutoCommand() {
    requires(elevatorHorizontal);
    
  }

  protected void initialize() {
    RobotLog.putMessage("Running ElevatorHorizontalAutoCommand");
    drive.setBoth(0, 0);
 
  }

  protected void execute() {
   elevatorHorizontal.setXElevatorMotor(.4);

  if (Constants.elevatorHorizontalNone == elevatorHorizontal.getXElevatorEncoder()) {
    elevatorHorizontal.setXElevatorMotor(.6);

  } else if (Constants.elevatorHorizontalFast == elevatorHorizontal.getXElevatorEncoder()) {
    elevatorHorizontal.setXElevatorMotor(.4);

  } else if (Constants.elevatorHorizontalSlow == elevatorHorizontal.getXElevatorEncoder()) {
    elevatorHorizontal.setXElevatorMotor(.2);
    drive.setBoth(.4, .4);

  } else if (Constants.elevatorHorizontalStop == elevatorHorizontal.getXElevatorEncoder()) {
    elevatorHorizontal.setXElevatorMotor(0);

   } SmartDashboard.putBoolean("X Elevator Sensor:", elevatorHorizontal.getlimitSwitch());
    SmartDashboard.putNumber("Speed of Horizontal Wheels:", elevatorHorizontal.getXElevatorMotor());
  }

  protected boolean isFinished() {
    return (elevatorHorizontal.getlimitSwitch() || oi.getElevatorEmergencyStopButton() || (elevatorHorizontal.getXElevatorEncoder() == 0));
  }

  protected void end() {
    drive.setBoth(0, 0);
  }

  protected void interrupted() {
    drive.setBoth(0, 0);
  }
}