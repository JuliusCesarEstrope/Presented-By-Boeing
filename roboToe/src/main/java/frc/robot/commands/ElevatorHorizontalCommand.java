package frc.robot.commands;

public class ElevatorHorizontalCommand extends CommandBase {
  int tapeHit;
  
  public ElevatorHorizontalCommand() {
    requires(elevatorHorizontal);
    requires(drive);
  }

  protected void initialize() {
    drive.setBothMotor(0, 0);
  }

  protected void execute() {
    if(!elevatorHorizontal.getfastSlowStopSensor()){
      elevatorHorizontal.setXElevatorMotors(0.7);
    }
    
    if(elevatorHorizontal.getfastSlowStopSensor()){
      tapeHit++;
    }

    if (tapeHit==0){
      elevatorHorizontal.setXElevatorMotors(.6);

    } else if (tapeHit==1){
      elevatorHorizontal.setXElevatorMotors(.4);

    } else if (tapeHit==2){
      elevatorHorizontal.setXElevatorMotors(.2);
      drive.setBothMotor(.4, .4);

    } else if (tapeHit==3){
      elevatorHorizontal.setXElevatorMotors(0);

    }
  }

  protected boolean isFinished() {
    return (tapeHit == 3);
  }

  protected void end() {
    drive.setBothMotor(0, 0);
  }

  protected void interrupted() {
    drive.setBothMotor(0, 0);
  }
}
