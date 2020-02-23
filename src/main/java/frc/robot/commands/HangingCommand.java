

package frc.robot.commands;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 *
 */
public class HangingCommand extends Command {
    public boolean dir;
    public HangingCommand(boolean direction) {
        dir = direction;
        requires(Robot.hanger);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.hanger.runMotor(dir);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.hanger.stopMotor();
    }

    @Override
    protected void interrupted() {
        Robot.hanger.stopMotor();
    }
}
