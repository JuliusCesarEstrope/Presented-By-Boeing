
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class FourBarCommandGroup extends CommandGroup {

  public FourBarCommandGroup(boolean buttonReleased, boolean fourBarStart, boolean floorGather, boolean hatchLvlTwo,
      boolean rocketLvlTwo, boolean rocketLvlOne, boolean climbPoint, boolean ballLvlOnePoint,
      boolean ballLvlTwoPoint) {

        // starting position button (getBarStartingButton)
    if (oi.getBarStartingButton() && buttonReleased) {
      fourBarStart = !fourBarStart;
      buttonReleased = !oi.getBarStartingButton();
    }

    if (!oi.getBarStartingButton()) {
      buttonReleased = true;
    }

    if (fourBarStart) {
      fourBar.setStartPoint(startPoint);
      fourBar.setBothFourBarMotor(0.5, 0.5);
    }

  }

}
