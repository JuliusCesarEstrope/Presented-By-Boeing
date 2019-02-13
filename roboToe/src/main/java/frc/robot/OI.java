package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.Constants;
public class OI{
  Joystick leftJoyStick = new Joystick(Constants.leftJoystick);
  Joystick rightJoyStick = new Joystick(Constants.rightJoystick);
  Joystick gamePad = new Joystick(Constants.rightJoystick);
  JoystickButton rollerButtonIn = new JoystickButton(gamePad, 7);
  JoystickButton rollerButtonOut = new JoystickButton(gamePad, 8);
  JoystickButton swapButton = new JoystickButton(rightJoyStick, 6);
  JoystickButton booperButton = new JoystickButton(gamePad, 9);
  JoystickButton barStartingButton = new JoystickButton(gamePad, 4);
  JoystickButton floorGatherButton = new JoystickButton(gamePad, 1);
  JoystickButton hatchLvlTwoButton = new JoystickButton(gamePad, 2);
  JoystickButton rocketLvlTwoButton = new JoystickButton(gamePad, 2);

  public boolean getbooperButton(){ 
    return booperButton.get();
  } 
  public double getleftYAxis(){
    //return Math.pow(-leftJoyStick.getY(), 3.0);
    return -leftJoyStick.getY();
  }
  public double getrightYAxis(){
    //return -Math.pow(-rightJoyStick.getY(), 3.0);
    return -rightJoyStick.getY();
  }
  public double getleftXAxis(){
    //return Math.pow(-leftJoyStick.getX(), 3.0);
    return leftJoyStick.getX();
  }
  public double getrightXAxis(){
    //return Math.pow(-rightJoyStick.getX(), 3.0);
    return rightJoyStick.getX();
  }
  public boolean getSwapButton(){
    return swapButton.get();
  }
  public boolean getRollerButtonIn(){
    return rollerButtonIn.get();
  }
  public boolean getRollerButtonOut(){
    return rollerButtonOut.get();
  }
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
}
