package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import frc.robot.commands.ElevatorCommandGroup;
import frc.robot.commands.FourBarBallLvlOneGroup;
import frc.robot.commands.FourBarBallLvlTwoGroup;
import frc.robot.commands.FourBarFloorGatherGroup;
import frc.robot.commands.FourBarHatchLvlTwoGroup;
import frc.robot.commands.FourBarRocketLvlOneGroup;
import frc.robot.commands.FourBarRocketLvlTwoGroup;
import frc.robot.commands.FourBarStartCommandGroup;
import frc.robot.commands.ManualCommand;

public class OI {

  // Joysticks
  Joystick leftJoyStick;
  Joystick rightJoyStick;

  Joystick gamePad;

  // Roller Buttons
  JoystickButton rollerButtonIn;
  JoystickButton rollerButtonOut;

  // Gather Buttons
  JoystickButton booperButton;

  // Tape Alignment Button
  JoystickButton alignButton;
  
  //Elevator Buttons
  JoystickButton elevatorButton;
  JoystickButton elevatorEmergencyStopButton;

  // Fourbar and Wrist button positions
  Trigger startPosition;
  Trigger floorGather;
  JoystickButton hatchLvlTwoButton;
  Trigger rocketLvlTwoHatch;
  Trigger rocketLvlOneHatch;
  JoystickButton barClimbPositionButton;
  JoystickButton ballLvlOneButton;
  JoystickButton ballLvlTwoButton;
  JoystickButton wristAngleButton;
  JoystickButton fourBarAngleButton;
  JoystickButton manualOverrideButton;

  public OI() {
    leftJoyStick = new Joystick(Constants.leftJoystick);
    rightJoyStick = new Joystick(Constants.rightJoystick);
    gamePad = new Joystick(Constants.rightJoystick);
  
  //Roller Buttons
  rollerButtonIn = new JoystickButton(gamePad, 7);
  rollerButtonOut = new JoystickButton(gamePad, 8);
  
  //Manual Motor Overide Button
  manualOverrideButton = new JoystickButton(gamePad, 1);
  //Gather Buttons
  booperButton = new JoystickButton(gamePad, 9);

  //Elevator Buttons
  elevatorButton = new JoystickButton(gamePad, 10);
  elevatorEmergencyStopButton = new JoystickButton(leftJoyStick,  9);
  
  //Fourbar and Wrist + Elevator button positions
  hatchLvlTwoButton = new JoystickButton(gamePad, 2);
  ballLvlOneButton = new JoystickButton(gamePad, 10);
  ballLvlTwoButton = new JoystickButton(gamePad, 11);
  wristAngleButton = new JoystickButton(gamePad, 5);
  fourBarAngleButton = new JoystickButton(gamePad, 22); //22 = temporary number, MUST CHANGE!!
  
  rocketLvlOneHatch = new Trigger(){

    public boolean get(){
      return (gamePad.getPOV() == 2);
    }
  };
 
  rocketLvlTwoHatch = new Trigger(){

    public boolean get(){
      return (gamePad.getPOV() == 0);
    }
  };

  floorGather = new Trigger(){

    public boolean get(){
      return (gamePad.getPOV() == 6);
    }
  };

  startPosition = new Trigger(){

    public boolean get(){
      return (gamePad.getPOV() == 4);
    }
  };

  startPosition.whenActive(new FourBarStartCommandGroup(Constants.setStartPoint));
  floorGather.whenActive(new FourBarFloorGatherGroup(Constants.setFloorGatherPoint));
  hatchLvlTwoButton.whenPressed(new FourBarHatchLvlTwoGroup(Constants.setRocketLvlTwoPoint)); //unneeded?
  rocketLvlTwoHatch.whenActive(new FourBarRocketLvlTwoGroup(Constants.setRocketLvlTwoPoint));
  rocketLvlOneHatch.whenActive(new FourBarRocketLvlOneGroup(Constants.setRocketLvlOnePoint));
  ballLvlOneButton.whenPressed(new FourBarBallLvlOneGroup(Constants.setBallLvlOnePoint));
  ballLvlTwoButton.whenPressed(new FourBarBallLvlTwoGroup(Constants.setBallLvlTwoPoint));
  elevatorButton.whenPressed(new ElevatorCommandGroup());
  manualOverrideButton.whileHeld(new ManualCommand());

  }

  public double getleftYAxis() {
    // return Math.pow(-leftJoyStick.getY(), 3.0);
    return -leftJoyStick.getY() * Math.abs(leftJoyStick.getY());
  }

  public double getrightYAxis() {
    // return -Math.pow(-rightJoyStick.getY(), 3.0);
    return -rightJoyStick.getY() * Math.abs(rightJoyStick.getY());
  }

  public double getleftXAxis() {
    // return Math.pow(-leftJoyStick.getX(), 3.0);
    return -leftJoyStick.getX() * Math.abs(leftJoyStick.getX());
  }
  
  public boolean getRollerButtonIn(){
    return rollerButtonIn.get();
  }
  
  public boolean getRollerButtonOut(){
    return rollerButtonOut.get();
  }

  public boolean getBooperButton(){
    return booperButton.get();
  }

  public double getrightXAxis() {
    // return Math.pow(-rightJoyStick.getX(), 3.0);
    return -rightJoyStick.getX() * Math.abs(rightJoyStick.getX());
  }

  //wrist axis
  public double getWristAxis() {
    return -gamePad.getRawAxis(1);
  }

  //fourbar vert. axis
  public double getFourBarAxis() {
    return -gamePad.getRawAxis(0); 
  }
  
  public boolean getRightTrigger() {
    return alignButton.get();
  }

  // fourbar position buttons
  public boolean getHatchLvlTwoButton() {
    return hatchLvlTwoButton.get();
  }

  public boolean getBarClimbPositionButton() {
    return barClimbPositionButton.get();
  }

  public boolean getBallLvlOneButton() {
    return ballLvlOneButton.get();
  }

  public boolean getBallLvlTwoButton() {
    return ballLvlTwoButton.get();
  }

  public boolean getElevatorEmergencyStopButton(){
    return elevatorEmergencyStopButton.get();
  }

  public boolean getManualOverrideButton(){
    return manualOverrideButton.get();
  }

}
