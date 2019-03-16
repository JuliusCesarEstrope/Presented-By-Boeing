package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;


public class ElevatorManualCommand extends CommandBase {
  public ElevatorManualCommand() {
    requires(elevatorHorizontal);
    requires(elevatorVertical);
  }

  protected void initialize() {
    RobotLog.putMessage("Running Elevator Manual Command");
    SmartDashboard.putString("DB/String 6", "Running Elevator");
  }

  protected void execute() {
    
    if (((oi.getElevatorVerticalAxis()) < 0) && (elevatorVertical.getVerticalElevatorEncoder() >= Constants.elevatorVerticalMax)
    || (((oi.getElevatorVerticalAxis()) > 0) && (elevatorVertical.getVerticalElevatorEncoder() <= Constants.elevatorVerticalMin))) {
      elevatorVertical.setYElevatorMotor(0);
} else {
    elevatorHorizontal.setXElevatorMotors(oi.getElevatorHorizontalAxis());
    elevatorVertical.setYElevatorMotor(oi.getElevatorVerticalAxis());
    }
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    RobotLog.putMessage("Ended Elevator Manual Command");
    SmartDashboard.putString("DB/String 6", "Ending Elevator");
    elevatorHorizontal.setXElevatorMotors(0);
    elevatorVertical.setYElevatorMotor(0);
  }

  protected void interrupted() {
    RobotLog.putMessage("Interrupted Elevator Manual Command");
    SmartDashboard.putString("DB/String 6", "Interrupted Elevator");
    elevatorHorizontal.setXElevatorMotors(0);
    elevatorVertical.setYElevatorMotor(0);
  }
}
