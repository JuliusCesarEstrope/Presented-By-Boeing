package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ElevatorCommandGroup;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Emily
import frc.robot.commands.FourBarBallLvlOneGroup;
import frc.robot.commands.FourBarBallLvlTwoGroup;
import frc.robot.commands.FourBarClimbGroup;
import frc.robot.commands.FourBarFloorGatherGroup;
import frc.robot.commands.FourBarHatchLvlTwoGroup;
import frc.robot.commands.FourBarRocketLvlOneGroup;
import frc.robot.commands.FourBarRocketLvlTwoGroup;
import frc.robot.commands.FourBarStartGroup;
<<<<<<< HEAD
=======
import frc.robot.commands.FourBarCommand;
<<<<<<< HEAD
>>>>>>> John-Schultz
=======
>>>>>>> Emily
=======
>>>>>>> John-Schultz

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
  JoystickButton barStartingButton;
  JoystickButton floorGatherButton;
  JoystickButton hatchLvlTwoButton;
  JoystickButton rocketLvlTwoButton;
  JoystickButton rocketLvlOneButton;
  JoystickButton barClimbPositionButton;
  JoystickButton ballLvlOneButton;
  JoystickButton ballLvlTwoButton;

  public OI() {
    leftJoyStick = new Joystick(Constants.leftJoystick);
    rightJoyStick = new Joystick(Constants.rightJoystick);
    gamePad = new Joystick(Constants.rightJoystick);
  
  //Roller Buttons
  rollerButtonIn = new JoystickButton(gamePad, 7);
  rollerButtonOut = new JoystickButton(gamePad, 8);
  
  //Gather Buttons
  booperButton = new JoystickButton(gamePad, 9);

  //Elevator Buttons
  elevatorButton = new JoystickButton(gamePad, 10);
  elevatorEmergencyStopButton = new JoystickButton(leftJoyStick,  9);
  
  //Fourbar and Wrist button positions
  barStartingButton = new JoystickButton(gamePad, 4);
  floorGatherButton = new JoystickButton(gamePad, 1);
  hatchLvlTwoButton = new JoystickButton(gamePad, 2);
  rocketLvlTwoButton = new JoystickButton(gamePad, 3);
  rocketLvlOneButton = new JoystickButton(gamePad, 5);
  barClimbPositionButton = new JoystickButton(gamePad, 6);
  ballLvlOneButton = new JoystickButton(gamePad, 10);
  ballLvlTwoButton = new JoystickButton(gamePad, 11);

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> Emily
  barStartingButton.whenPressed(new FourBarStartGroup(Constants.setStartPoint));
  floorGatherButton.whenPressed(new FourBarFloorGatherGroup(Constants.setFloorGatherPoint));
  hatchLvlTwoButton.whenPressed(new FourBarHatchLvlTwoGroup(Constants.setHatchLvlTwoPoint));
  rocketLvlTwoButton.whenPressed(new FourBarRocketLvlTwoGroup(Constants.setRocketLvlTwoPoint));
  rocketLvlOneButton.whenPressed(new FourBarRocketLvlOneGroup(Constants.setRocketLvlOnePoint));
  barClimbPositionButton.whenPressed(new FourBarClimbGroup(Constants.setClimbPoint));
  ballLvlOneButton.whenPressed(new FourBarBallLvlOneGroup(Constants.setBallLvlOnePoint));
  ballLvlTwoButton.whenPressed(new FourBarBallLvlTwoGroup(Constants.setBallLvlTwoPoint));
<<<<<<< HEAD
=======
  barStartingButton.whenPressed(new FourBarCommand());
  floorGatherButton.whenPressed(new FourBarCommand());
  hatchLvlTwoButton.whenPressed(new FourBarCommand());
  rocketLvlTwoButton.whenPressed(new FourBarCommand());
  rocketLvlOneButton.whenPressed(new FourBarCommand());
  barClimbPositionButton.whenPressed(new FourBarCommand());
  ballLvlOneButton.whenPressed(new FourBarCommand());
  ballLvlTwoButton.whenPressed(new FourBarCommand());
<<<<<<< HEAD
>>>>>>> John-Schultz
=======
>>>>>>> Emily
=======
>>>>>>> John-Schultz
  elevatorButton.whenPressed(new ElevatorCommandGroup());

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
  
  public boolean getRightTrigger() {
    return alignButton.get();
  }

  // fourbar position buttons
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

  public boolean getElevatorEmergencyStopButton(){
    return elevatorEmergencyStopButton.get();
  }

}
