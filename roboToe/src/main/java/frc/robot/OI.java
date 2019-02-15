package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.Constants;
import frc.robot.commands.ElevatorCommandGroup;
public class OI{
  
  //Joysticks
  Joystick leftJoyStick = new Joystick(Constants.leftJoystick);
  Joystick rightJoyStick = new Joystick(Constants.rightJoystick);
  Joystick gamePad = new Joystick(Constants.rightJoystick);
  
  //Roller Buttons
  JoystickButton rollerButtonIn = new JoystickButton(gamePad, 7);
  JoystickButton rollerButtonOut = new JoystickButton(gamePad, 8);
  
  //Gather Buttons
  JoystickButton booperButton = new JoystickButton(gamePad, 9);
  
  //Fourbar and Wrist button positions
  JoystickButton barStartingButton = new JoystickButton(gamePad, 4);
  JoystickButton floorGatherButton = new JoystickButton(gamePad, 1);
  JoystickButton hatchLvlTwoButton = new JoystickButton(gamePad, 2);
  JoystickButton rocketLvlTwoButton = new JoystickButton(gamePad, 3);
  JoystickButton rocketLvlOneButton = new JoystickButton(gamePad, 5);
  JoystickButton barClimbPositionButton = new JoystickButton(gamePad, 6);
  JoystickButton ballLvlOneButton = new JoystickButton(gamePad, 10);
  JoystickButton ballLvlTwoButton = new JoystickButton(gamePad, 11);
  
  //Elevator Buttons
  JoystickButton elevatorButton = new JoystickButton(gamePad, 10);

  public OI(){

    elevatorButton.whenPressed(new ElevatorCommandGroup());
  }

  public boolean getBooperButton(){ 
    return booperButton.get();
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

  public double getrightXAxis() {
    // return Math.pow(-rightJoyStick.getX(), 3.0);
    return -rightJoyStick.getX() * Math.abs(rightJoyStick.getX());
  }

  
  //fourbar position buttons
  public boolean getFloorGatherButton() {
    return floorGatherButton.get();
  }

  public boolean getBarStartingButton() {
    return barStartingButton.get();
  }

  public boolean getHatchLvlTwoButton() {
    return hatchLvlTwoButton.get();
  }

  public boolean getRocketLvlTwoButton() {
    return rocketLvlTwoButton.get();
  }

  public boolean getRocketLvlOneButton() {
    return rocketLvlOneButton.get();
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
}
