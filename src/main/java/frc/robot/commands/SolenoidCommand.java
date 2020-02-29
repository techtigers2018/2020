

package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 *
 */
public class SolenoidCommand extends Command {
    public boolean dir;
    public SolenoidCommand(boolean direction) {
        dir = direction;
        requires(Robot.buddyhanger);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        if(dir) {
            Robot.buddyhanger.releaseBuddyHang();
        }
        else {
            Robot.buddyhanger.releaseSpring();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
