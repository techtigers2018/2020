

package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 *
 */
public class TestCWCommand extends Command {
    public boolean dir;
    public TestCWCommand(boolean direction) {
        dir = direction;
        requires(Robot.spinner);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.spinner.testCWMotor(dir);
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
        Robot.drive.stopTest();
    }
}
