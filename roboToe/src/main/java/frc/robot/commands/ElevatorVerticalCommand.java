package frc.robot.commands;

// 6 motors for driving wheels in COMMAND, 2 motors for vertical motion of elevator, 2 horizontal motion (TalonSRX)

public class ElevatorCommand extends CommandBase {
  int tapeHit;
  int leftElevatorEncoderTick;
  int rightElevatorEncoderTick;
  double distanceYToTravel;
  double distanceYInch;

  public ElevatorCommand() {
    requires(elevator);
    requires(drive);
  }

  @Override
  protected void initialize() {
    tapeHit = 0;
    elevator.setYElevatorMotors(.5);
    drive.setBothMotor(0, 0);
    leftElevatorEncoderTick = elevator.getLeftElevatorEncoder();
    rightElevatorEncoderTick = elevator.getRightElevatorEncoder();
  }

// HAVE TO CODE PID DURING MATCH TO MAKE SURE ELEVATOR STAYS IN ROBOT AND ON THE 1ST SENSOR 
  @Override
  protected void execute() {
    // Vertical shift upwards
    if((elevator.getLeftElevatorEncoder && elevator.getRightElevatorEncoder) == distanceYToTravel){
      elevator.setYElevatorMotors(0);
      // make sure it stays in PLACE!
    } else if {
      elevator.setYElevatorMotors(.2);
      elevator.setleftElevatorEncoderSetpoint(leftElevatorEncoderTick + distanceYToTravel);
      elevator.setrightElevatorEncoderSetpoint(rightElevatorEncoderTick + distanceYToTravel);
    }
    // Horizontal shift onto platform
    if(!elevator.fastSlowStopSensor()){
      elevator.setXElevatorMotors(0.7);
    }
    
    if(elevator.fastSlowStopSensor()){
      tapeHit++;
    }

    if (tapeHit==0){
      elevator.setXElevatorMotors(.4);

    } else if (tapeHit==1){
      elevator.setXElevatorMotors(.3);

    } else if (tapeHit==2){
      elevator.setXElevatorMotors(.1);
      drive.setBothMotor(.4, .4);
  // lower 1 inch
    elevator.setYElevatorMotors(-.2);
    elevator.setleftElevatorEncoderSetpoint(elevator.getleftElevatorEncoderSetpoint() - distanceYInch);
    elevator.setYElevatorMotors(elevator.getleftElevatorEncoderPIDOutput());
// and HOLD
    } else if (tapeHit==3){
      elevator.setXElevatorMotors(0);
// motors robo on to drive on & stop
    }
    // Bring up Vertical Elevator to 3rd Platform (NEGATATE SPEED)
    
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    //drive.setBothMotor(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    //drive.setBothMotor(0, 0);
    // if EMERG STOP button pressed, slowly...
  }
}
