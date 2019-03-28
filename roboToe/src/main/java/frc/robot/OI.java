package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import frc.robot.commands.CommandBase;
import frc.robot.commands.DriveStraight;
import frc.robot.commands.ElevatorCommandGroup;
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

  // Gather Buttons
  JoystickButton booperButton;

  // Tape Alignment Button
  JoystickButton alignButton;

  //Drive Straight Button
  JoystickButton driveStraightButton;

  // Elevator Buttons
  JoystickButton elevatorButton;
  JoystickButton elevatorEmergencyStopButton;
  JoystickButton manualElevatorButton;
  Trigger elevatorAutoClimb;
  Trigger elevatorAssistButton;

  // Fourbar and Wrist button positions
  Trigger startPosition;
  Trigger floorGather;
  Trigger counterWeightReverse;
  Trigger counterWeightForward;
  Trigger counterWeightAutomatic;
  JoystickButton hatchLvlTwoButton;
  Trigger rocketLvlTwoHatch;
  Trigger rocketLvlOneHatch;
  JoystickButton barClimbPositionButton;
  JoystickButton ballLvlOneButton;
  JoystickButton ballLvlTwoButton;
  JoystickButton wristAngleButton;
  JoystickButton fourBarAngleButton;

  JoystickButton wristUpButton;
  JoystickButton wristStartButton;
  JoystickButton wristDownButton;
  Trigger ballShoot;

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

    // Manual Motor Overide Button
    manualOverrideButton = new JoystickButton(gamePad, 1);
    // Gather Buttons
    booperButton = new JoystickButton(gamePad, 8);

    // Elevator Buttons
    elevatorButton = new JoystickButton(gamePad, 10);
    elevatorEmergencyStopButton = new JoystickButton(leftJoyStick, 11);
    manualElevatorButton = new JoystickButton(gamePad, 12);

    // Test Buttons
    fourBarTestButton = new JoystickButton(rightJoyStick, 8);
    wristTestButton = new JoystickButton(rightJoyStick, 9);

    //Vision ALign Button
    visionAlignButton = new JoystickButton(leftJoyStick, 2);

    // Fourbar and Wrist + Elevator button positions
    // fourBarAngleButton = new JoystickButton(gamePad, 22); //22 = temporary
    // number, MUST CHANGE!!
    // Zero Encoders Button
    wristDownButton = new JoystickButton(gamePad, 2);
    wristUpButton = new JoystickButton(gamePad, 3);
    wristStartButton = new JoystickButton(gamePad, 4);

    zeroEncoderTrigger = new Trigger() {
      public boolean get() {
        return (rightJoyStick.getRawButton(6) && rightJoyStick.getRawButton(11));
      }
    };

    ballShoot = new Trigger() {

      public boolean get() {
        return (gamePad.getPOV() == 90);
      }
    };

    elevatorAutoClimb = new Trigger() {
      public boolean get() {
        return (rightJoyStick.getRawButton(7) && gamePad.getRawButton(7));
      }
    };

    elevatorAssistButton = new Trigger() {
      public boolean get() {
        return (gamePad.getPOV() == 270);
      }
    };

    elevatorAutoClimb.whenActive(new ElevatorCommandGroup());
    manualOverrideButton.whileHeld(new ManualCommand());
    zeroEncoderTrigger.whenActive(new ZeroEncoderCommand());
    manualElevatorButton.toggleWhenPressed(new ElevatorWristCommandGroup());
    wristUpButton.whileHeld(new WristCommand(Constants.wristUpSetPoint));
    wristStartButton.whileHeld(new WristCommand(Constants.defaultWristPosition));
    wristDownButton.whileHeld(new WristCommand(Constants.wristDownSetPoint));
    ballShoot.whileActive(new WristCommand(Constants.wristShootSetPoint));
    driveStraightButton.whileHeld(new DriveStraight());
    elevatorAssistButton.toggleWhenActive(new );
    //visionAlignButton.whenPressed(new VisionAlignCommandGroup());

    // fourBarTestButton.whenPressed(new
    // FourBarCommand(Constants.setFloorGatherPoint));
    // wristTestButton.whileHeld(new WristCommand(Constants.wristUpSetPoint));
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

  // fourbar vert. axis
  public double getFourBarAxis() {
    return (Math.abs(gamePad.getRawAxis(1)) > 0.25) ? -gamePad.getRawAxis(1) : 0;
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
