package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.utilities.RobotLog;


public class ElevatorManualCommand extends CommandBase {
  Timer blinkTimer;
  public ElevatorManualCommand() {
    requires(elevatorHorizontal);
    requires(elevatorVertical);

    blinkTimer = new Timer();
  }

  protected void initialize() {
    blinkTimer.start();
    RobotLog.putMessage("Running Elevator Manual Command");
    SmartDashboard.putString("DB/String 6", "Running Elevator");
  }

  protected void execute() {
    if (blinkTimer.hasPeriodPassed(0)){
      led.setLEDLightColor(0.65); // orange
    } else if(blinkTimer.hasPeriodPassed(0.5)){
      led.setLEDLightColor(0);
      if(blinkTimer.hasPeriodPassed(1)){
        blinkTimer.reset();
      }
    }

    if (((oi.getElevatorVerticalAxis()) < 0) && (elevatorVertical.getVerticalElevatorEncoder() >= Constants.elevatorVerticalMax)
    || (((oi.getElevatorVerticalAxis()) > 0) && (elevatorVertical.getVerticalElevatorEncoder() <= Constants.elevatorVerticalMin))) {
      elevatorVertical.setYElevatorMotor(0);
} else {
    if(elevatorHorizontal.getlimitSwitch() && oi.getElevatorHorizontalAxis() < 0)
      elevatorHorizontal.setXElevatorMotor(0);
    else
      elevatorHorizontal.setXElevatorMotor(oi.getElevatorHorizontalAxis());
    elevatorVertical.setYElevatorMotor(oi.getElevatorVerticalAxis());
    }
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    RobotLog.putMessage("Ended Elevator Manual Command");
    SmartDashboard.putString("DB/String 6", "Ending Elevator");
    elevatorHorizontal.setXElevatorMotor(0);
    elevatorVertical.setYElevatorMotor(0);
  }

  protected void interrupted() {
    RobotLog.putMessage("Interrupted Elevator Manual Command");
    SmartDashboard.putString("DB/String 6", "Interrupted Elevator");
    elevatorHorizontal.setXElevatorMotor(0);
    elevatorVertical.setYElevatorMotor(0);
  }
}
