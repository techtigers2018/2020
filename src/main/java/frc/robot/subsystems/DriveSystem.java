package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;


public class DriveSystem extends Subsystem {
    private PWMVictorSPX leftFront, leftRear, rightFront, rightRear;
    private MecanumDrive mecanum;

    private Spark leftFrontSpark, leftRearSpark, rightFrontSpark, rightRearSpark;
    private SpeedControllerGroup leftDrive, rightDrive;
    private DifferentialDrive diffdrive;

    //Test code
    private PWMVictorSPX testMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public DriveSystem() {
        // Test motor
        testMotor = new PWMVictorSPX(8);
        addChild("test motor", testMotor);
        testMotor.setInverted(false);

        // Tank Drive:
        // leftFrontSpark = new Spark(0);
        // leftRearSpark = new Spark(1);
        // rightFrontSpark = new Spark(2);
        // rightRearSpark = new Spark(3);
        // leftDrive = new SpeedControllerGroup(leftFrontSpark, leftRearSpark);
        // rightDrive = new SpeedControllerGroup(rightFrontSpark, rightRearSpark);
        // diffdrive = new DifferentialDrive(leftDrive, rightDrive);



        // Mecanum below. Uncomment and fix when chassis is complete
        // leftFront = new PWMVictorSPX(0);
        // addChild("Left Front Motor Controller", leftFront);
        // leftFront.setInverted(false);

        // leftRear = new PWMVictorSPX(1);
        // addChild("left rear motor controller", leftRear);
        // leftRear.setInverted(false);

        // rightFront = new PWMVictorSPX(2);
        // addChild("right front motor controller", rightFront);
        // rightFront.setInverted(false);

        // rightRear = new PWMVictorSPX(3);
        // addChild("right rear motor controller", rightRear);
        // rightRear.setInverted(false);

        // mecanum = new MecanumDrive(leftFront, leftRear, rightFront, rightRear);
        // addChild("main mecanum drive system", mecanum);
        // mecanum.setSafetyEnabled(true);
        // mecanum.setExpiration(0.1);
        // mecanum.setMaxOutput(1.0);
    }

    @Override
    public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        // setDefaultCommand(new TestMotorCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    }

    public void setMecanumDrive(double y, double x, double rotation){
        mecanum.driveCartesian(y, x, rotation);
        // mecanum.driveCartesian(ySpeed, xSpeed, zRotation, gyroAngle); //For field centering
    }

    public void testMotor(){
        testMotor.set(0.25);
    }

    public void stopTest(){
        testMotor.set(0);
    }
    
}
