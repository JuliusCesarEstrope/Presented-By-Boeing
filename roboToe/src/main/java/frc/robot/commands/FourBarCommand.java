
package frc.robot.commands;

public class FourBarCommand extends CommandBase {
  boolean buttonReleased, fourBarStart, floorGather, barHigh;
  int leftBarEncoder, rightBarEncoder;
  int startPoint = 5, floorGatherPoint = 6, highPoint = 7;  

  public FourBarCommand() {
  // Use requires() here to declare subsystem dependencies
    requires(fourBar);
    leftBarEncoder = fourBar.getLeftBarEncoder();
    rightBarEncoder = fourBar.getRightBarEncoder();
    
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //send pid to correct motors
    fourBar.setBothFourBarMotor(0, 0);
    fourBar.resetEncoders();
    buttonReleased = true;
    fourBarStart = false;

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  
  //Eight positions: starting/lvl 1 hatch, floor gather, hatch lvl 2, rocket lvl 2, rocket lvl 1, climb position, lvl 1 ball, lvl 2 ball

  //starting position button (getBarStartingButton)
  if(oi.getBarStartingButton()&&buttonReleased) {
    fourBarStart =!fourBarStart;
    buttonReleased = !oi.getBarStartingButton(); 
  }

  if(!oi.getBarStartingButton()) {
    buttonReleased = true;
  }

  if(fourBarStart) {
    fourBar.setStartpoint(startPoint);
    fourBar.setBothFourBarMotor(0.5, 0.5);
  }

  //floor gather button
  if(oi.getFloorGatherButton()&&buttonReleased) {
  floorGather =!floorGather;
    buttonReleased = !oi.getFloorGatherButton(); 
  }

  if(!oi.getFloorGatherButton()) {
    buttonReleased = true;
  }

  if(floorGather) {
    fourBar.setFloorGatherPoint(floorGatherPoint);
    fourBar.setBothFourBarMotor(0.5, 0.5);
   }
  }


  //hatch level 2 button- also gather + cargo ship level


  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
