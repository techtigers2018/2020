package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.util.Arrays;
import edu.wpi.first.wpilibj.Spark;


public class ColorWheelSpinner extends Subsystem {
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
    private final ColorSensorV3 colorSensor = new ColorSensorV3(i2cPort);
    private final Spark cwMotor = new Spark(4);
    public Color[] colorOrder;

    public Color currentColor = new Color(0, 0, 0);
    public Color previousColor = new Color(0 ,0 ,0);

    public Color real_red;
    public Color real_green;
    public Color real_yellow;
    public Color real_blue;
    public ColorMatch color_matcher;


    public ColorWheelSpinner() {
        //initialize colors
        color_matcher = new ColorMatch();
        real_red = ColorMatch.makeColor(0.503174, 0.353516, 0.143311);
        real_green = ColorMatch.makeColor(0.183105, 0.555908, 0.26123);
        real_blue = ColorMatch.makeColor(0.133057, 0.428711, 0.438232);
        real_yellow = ColorMatch.makeColor(0.314697, 0.55249, 0.132813);

        //Apply color match
        color_matcher.addColorMatch(real_red);
        color_matcher.addColorMatch(real_green);
        color_matcher.addColorMatch(real_yellow);
        color_matcher.addColorMatch(real_blue);
    }

    @Override
    public void initDefaultCommand() {
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }
    public void testCWMotor(boolean dir){
        double spd = 0.25;
        if (dir){
            spd*=-1;
        }
        
        cwMotor.setSpeed(spd);
    }

    public void stopCWMotor() {
        cwMotor.setSpeed(0);
    }

    public Color getMedianColor(int sample_size){
        Color sample;
        Color result;
        double[] reds = new double[sample_size];
        double[] greens = new double[sample_size];
        double[] blues = new double[sample_size];

        for (int i = 0; i < sample_size; i++){
            sample = colorSensor.getColor();
            reds[i] = sample.red;
            greens[i] = sample.green;
            blues[i] = sample.blue;
        }
        Arrays.sort(reds);
        Arrays.sort(greens);
        Arrays.sort(blues);

        result = new Color(reds[sample_size/2], greens[sample_size/2], blues[sample_size/2]);
        return result;
    }
    public void calibrateColorSensor(){
        Color result = getMedianColor(50);
        SmartDashboard.putNumber("r: ", result.red);
        SmartDashboard.putNumber("g: ", result.green);
        SmartDashboard.putNumber("b: ", result.blue);
        SmartDashboard.putString("cal_color", result.toString());
    }
    public void readColor(){
        Color col;
        String colorString;
        col = getMedianColor(10);
        ColorMatchResult closest_color = color_matcher.matchClosestColor(col);
        ColorMatchResult matched_color = color_matcher.matchColor(col);
        
        SmartDashboard.putString("matchclosestcolor", closest_color.color.toString());
        SmartDashboard.putNumber("matchclosestcolor confidence", closest_color.confidence);

        // SmartDashboard.putString("matchcolor", matched_color.toString());
        // SmartDashboard.putNumber("matchcolor confidence", matched_color.confidence);
        if (closest_color.color == real_blue) {
            colorString = "Blue";
          } else if (closest_color.color == real_red) {
            colorString = "Red";
          } else if (closest_color.color == real_green) {
            colorString = "Green";
          } else if (closest_color.color == real_yellow) {
            colorString = "Yellow";
          } else {
            colorString = "Unknown";
          }

        SmartDashboard.putString("rawcolor", col.toString());
        SmartDashboard.putString("colorString", colorString);
    }   


}
