

package frc.robot.commands;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 *
 */
public class BuddyHangCommand extends Command {
    public boolean dir;
    public boolean liftRobot;
    public BuddyHangCommand(boolean direction, boolean lift) {
        dir = direction;
        liftRobot = lift;
        requires(Robot.buddyhanger);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.buddyhanger.runMotor(dir,liftRobot);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.buddyhanger.stopMotor();
    }

    @Override
    protected void interrupted() {
        Robot.buddyhanger.stopMotor();
    }
}
