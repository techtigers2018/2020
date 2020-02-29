

package frc.robot.commands;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

/**
 *
 */
public class MotorHangCommand extends Command {
    public boolean l, r, u, d;
    public MotorHangCommand() {
        requires(Robot.motorbuddy);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        boolean l, r, u, d;
        l = false;
        r = false;
        u = false;
        d = false;
        int axis = Robot.oi.js1.getPOV();
        SmartDashboard.putNumber("axis", axis);

        switch(axis){
            case 0 :
                l = true;
                r = true;
                u = true;
                break;
            case 45:
                r = true;
                u = true;
                break;

            case 135:
                r = true;
                d = true;
                break;

            case 180:
                r = true;
                l = true;
                d = true;
                break;

            case 225:
                l = true;
                d = true;
                break;

            case 315:
                l = true;
                u = true;
                break;

                
            // default :
            //     l = false;
            //     r = false;
            //     u = false;
            //     d = false;
        }
        SmartDashboard.putBoolean("l", l);
        SmartDashboard.putBoolean("r", r);
        SmartDashboard.putBoolean("u", u);
        SmartDashboard.putBoolean("d", d);
        Robot.motorbuddy.setBuddyMotors(l, r, u, d);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        // Robot.motorbuddy.setBuddyMotors(false, false, false, false);
    }

    @Override
    protected void interrupted() {
        // Robot.motorbuddy.setBuddyMotors(false, false, false, false);
    }
}
