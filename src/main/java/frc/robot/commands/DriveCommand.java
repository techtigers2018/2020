// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import java.lang.Math.*;

/**
 *
 */
public class DriveCommand extends Command {
    private double x,y,z;
    public DriveCommand() {
        // this.y = y;
        // this.x = x;
        // this.z = z;
        requires(Robot.drive);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        // Robot.drive.setMecanumDrive(y, x, z);
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
