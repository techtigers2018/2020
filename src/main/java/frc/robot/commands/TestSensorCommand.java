

package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 *
 */
public class TestSensorCommand extends Command {
    public boolean calibrate, readSensor;
    public TestSensorCommand(boolean cal, boolean read) {
        calibrate = cal;
        readSensor = read;
        requires(Robot.spinner);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        if(calibrate){
            Robot.spinner.calibrateColorSensor();
        }
        else if (readSensor){
            Robot.spinner.readColor();
        }
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
