package frc.robot.commands;

public class ElevatorInPlaceCommand extends CommandBase {
 
  public ElevatorInPlaceCommand() {
    requires(elevatorHorizontal);
    requires(drive);
  }

  protected void initialize() {
    drive.setBothMotor(0, 0);
  }

  protected void execute() {
    if(!elevatorHorizontal.getfastSlowStopSensor()){
      elevatorHorizontal.setXElevatorMotors(-.4);
    } else {
      elevatorHorizontal.setXElevatorMotors(0);
    }
    
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    drive.setBothMotor(0, 0);
  }

  protected void interrupted() {
    drive.setBothMotor(0, 0);
  }
}
