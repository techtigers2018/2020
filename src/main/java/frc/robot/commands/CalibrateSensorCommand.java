

package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 *
 */
public class CalibrateSensorCommand extends Command {
    public CalibrateSensorCommand() {
        requires(Robot.spinner);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.spinner.calibrateColorSensor();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        
    }

    @Override
    protected void interrupted() {
        
    }
}
