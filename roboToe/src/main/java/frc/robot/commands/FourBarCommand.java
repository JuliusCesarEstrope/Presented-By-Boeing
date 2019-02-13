
package frc.robot.commands;

public class FourBarCommand extends CommandBase {
  boolean buttonReleased, barDown, barLow, barHigh;
  int leftBarEncoder, rightBarEncoder;
  int downPoint = 5, lowPoint = 6, highPoint = 7;  

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
    barDown = false;

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  
  //three positions: down (cargo), low (rocket level 1), high (rocket level 2)

  //down button
  if(oi.getBarDownButton()&&buttonReleased) {
    barDown =!barDown;
    buttonReleased = !oi.getBarDownButton(); 
  }

  if(!oi.getBarDownButton()) {
    buttonReleased = true;
  }

  if(barDown) {
    fourBar.setDownpoint(downPoint);
  }

  //else if(!barDown) {
    
 // }

  //low button
  if(oi.getBarLowButton()&&buttonReleased) {
    barLow =!barLow;
    buttonReleased = !oi.getBarLowButton(); 
  }

  if(!oi.getBarLowButton()) {
    buttonReleased = true;
  }

  if(barLow) {
    fourBar.setLowpoint(lowPoint);
  }

 // else if(!barLow) {
    
 // }

  //high button
if(oi.getBarHighButton()&&buttonReleased) {
    barHigh =!barHigh;
    buttonReleased = !oi.getBarHighButton(); 
  }

  if(!oi.getBarHighButton()) {
    buttonReleased = true;
  }

  if(barHigh) {
  fourBar.setHighpoint(highPoint);
  }

  //else if(!barHigh) {
  //}
  
  }

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
