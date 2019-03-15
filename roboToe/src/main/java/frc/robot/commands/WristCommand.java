package frc.robot.commands;

public class WristCommand extends CommandBase {

  int leftWristEncoder;
  int rightWristEncoder;
  double wristSetPoint;

  public WristCommand(double wristSetPoint) {
    requires(wrist);
    // Use requires() here to declare subsystem dependencies
    this.wristSetPoint = wristSetPoint;

  }

  protected void initialize() {

    // Set point
    // Send PID to correct motors

  }

  @Override
  protected void execute() {
    // Two Positions (Up, Down)
    //wrist.setRightWristMotorPosition(wristSetPoint);
    wrist.setLeftWristMotorPosition(wristSetPoint);
    wrist.setRightWristMotor(wrist.getLeftTalonOutput());
  }

  protected boolean isFinished() {
    // if needed to maintain set pont (false) stopping point (true)
    return false;
  } 

  protected void end() {
   // drive.setBoth(0, 0);
    wrist.setBothWristMotor(0, 0);
  }

  protected void interrupted() {
    wrist.setBothWristMotor(0, 0);
  }
}