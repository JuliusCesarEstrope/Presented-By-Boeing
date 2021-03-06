package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import frc.robot.commands.DriveStraight;
import frc.robot.commands.DynamicBrakingCommand;
import frc.robot.commands.ElevatorAssistCommand;
import frc.robot.commands.ElevatorAutoTest;
import frc.robot.commands.ElevatorWristCommandGroup;
import frc.robot.commands.ManualCommand;
import frc.robot.commands.WristCommand;
import frc.robot.commands.ZeroEncoderCommand;

public class OI {

  Joystick setZeroPositionButton;
  // Joysticks
  Joystick leftJoyStick;
  Joystick rightJoyStick;

  Joystick gamePad;

  // Roller Buttons
  JoystickButton rollerButtonIn;
  JoystickButton rollerButtonOut;
  JoystickButton ballShootButton;

  // Gather Buttons
  JoystickButton booperButton;

  // Tape Alignment Button
  JoystickButton alignButton;

  //Drive Straight Button
  JoystickButton driveStraightButton;
  JoystickButton dynamicBraking;

  // Elevator Buttons
  Trigger elevatorOverrideButton;
  JoystickButton elevatorEmergencyStopButton;
  JoystickButton manualElevatorButton;
  Trigger elevatorAutoClimb;
  Trigger elevatorAssistButton;
  JoystickButton elevatorTest;

  // Fourbar and Wrist button positions
  Trigger jogRollerHatchUp;
  Trigger jogRollerHatchDown;
  
  JoystickButton wristUpButton;
  JoystickButton wristStartButton;
  JoystickButton wristDownButton;
  Trigger ballShoot;

  JoystickButton wristTurboButton;

  // Miss Elaineous
  JoystickButton manualOverrideButton;
  Trigger zeroEncoderTrigger;

  // Test Buttons
  JoystickButton fourBarTestButton;
  JoystickButton wristTestButton;

  // Vision Align Button
  JoystickButton visionAlignButton;

  public OI() {
    leftJoyStick = new Joystick(Constants.leftJoystick);
    rightJoyStick = new Joystick(Constants.rightJoystick);
    gamePad = new Joystick(Constants.gamePad);
    

    // Roller Buttons
    rollerButtonIn = new JoystickButton(gamePad, 5);
    rollerButtonOut = new JoystickButton(gamePad, 6);
    ballShootButton = new JoystickButton(gamePad, 7);

    // Manual Motor Overide Button
    manualOverrideButton = new JoystickButton(gamePad, 1);
    // Gather Buttons
    booperButton = new JoystickButton(gamePad, 8);

    // Elevator Buttons
    elevatorEmergencyStopButton = new JoystickButton(leftJoyStick, 11);
    manualElevatorButton = new JoystickButton(gamePad, 12);
    elevatorTest = new JoystickButton(gamePad, 10);

    // Test Buttons
    fourBarTestButton = new JoystickButton(rightJoyStick, 8);
    wristTestButton = new JoystickButton(rightJoyStick, 9);

    //Vision ALign Button
    visionAlignButton = new JoystickButton(leftJoyStick, 2);

    dynamicBraking = new JoystickButton(leftJoyStick, 1);
    driveStraightButton = new JoystickButton(rightJoyStick, 1);

    // Fourbar and Wrist + Elevator button positions
    // fourBarAngleButton = new JoystickButton(gamePad, 22); //22 = temporary
    // number, MUST CHANGE!!
    // Zero Encoders Button
    wristDownButton = new JoystickButton(gamePad, 2);
    wristUpButton = new JoystickButton(gamePad, 3);
    wristStartButton = new JoystickButton(gamePad, 4);
    wristTurboButton = new JoystickButton(gamePad, 11);

    zeroEncoderTrigger = new Trigger() {
      public boolean get() {
        return (rightJoyStick.getRawButton(6) && rightJoyStick.getRawButton(11));
      }
    };

    elevatorOverrideButton = new Trigger() {
      public boolean get() {
        return (leftJoyStick.getRawButton(8) && leftJoyStick.getRawButton(9));
      }
    };

    ballShoot = new Trigger() {

      public boolean get() {
        return (gamePad.getPOV() == 90);
      }
    };

    jogRollerHatchUp = new Trigger() {
      public boolean get() {
        return (gamePad.getPOV() == 0);
      }
    };

    jogRollerHatchDown = new Trigger() {
      public boolean get() {
        return (gamePad.getPOV() == 180);
      }
    };

    elevatorAutoClimb = new Trigger() {
      public boolean get() {
        return (rightJoyStick.getRawButton(7) && gamePad.getRawButton(9));
      }
    };

    elevatorAssistButton = new Trigger() {
      public boolean get() {
        return (gamePad.getPOV() == 270);
      }
    };

    //elevatorAutoClimb.whenActive(new ElevatorCommandGroup());
    //elevatorTest.toggleWhenPressed(new ElevatorAutoTest());
    manualOverrideButton.whileHeld(new ManualCommand());
    zeroEncoderTrigger.whenActive(new ZeroEncoderCommand());
    manualElevatorButton.toggleWhenPressed(new ElevatorWristCommandGroup());
    wristUpButton.whileHeld(new WristCommand(Constants.wristUpSetPoint));
    wristStartButton.whileHeld(new WristCommand(Constants.defaultWristPosition));
    wristDownButton.whileHeld(new WristCommand(Constants.wristDownSetPoint));
    ballShoot.whileActive(new WristCommand(Constants.wristShootSetPoint));
    driveStraightButton.whileHeld(new DriveStraight());
    elevatorAssistButton.toggleWhenActive(new ElevatorAssistCommand());
    dynamicBraking.whileHeld(new DynamicBrakingCommand());
    //visionAlignButton.whenPressed(new VisionAlignCommandGroup());

  }

  public boolean getBallShootButton() {
    return ballShootButton.get();
  }

  public boolean getElevatorOverride(){
    return elevatorOverrideButton.get();
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

  public boolean getRollerButtonIn() {
    return rollerButtonIn.get();
  }

  public boolean getRollerButtonOut() {
    return rollerButtonOut.get();
  }
  public boolean getJogRollerHatchUp() {
    return jogRollerHatchUp.get();
  }
  public boolean getJogRollerHatchDown() {
    return jogRollerHatchDown.get();
  }

  public boolean getBooperButton() {
    return booperButton.get();
  }

  public double getrightXAxis() {
    // return Math.pow(-rightJoyStick.getX(), 3.0);
    return -rightJoyStick.getX() * Math.abs(rightJoyStick.getX());
  }

  // wrist axis
  public double getWristAxis() {
    return (Math.abs(gamePad.getRawAxis(0)) > 0.25) ? -gamePad.getRawAxis(0) : 0;
  }

  public boolean getWristTurboButton(){
    return wristTurboButton.get();
  }

  public boolean getRightTrigger() {
    return alignButton.get();
  }

  public boolean getElevatorEmergencyStopButton() {
    return elevatorEmergencyStopButton.get();
  }

  public boolean getManualOverrideButton() {
    return manualOverrideButton.get();
  }

  public double getElevatorHorizontalAxis() {
    return (Math.abs(gamePad.getRawAxis(2)) > 0.3) ? gamePad.getRawAxis(2) : 0;
  }

  public double getElevatorVerticalAxis() {
    return (Math.abs(gamePad.getRawAxis(3)) > 0.3) ? gamePad.getRawAxis(3) : 0;
  }

}
