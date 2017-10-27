package org.usfirst.frc.team5987.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    public static int frontLeftMotor = 6;
    public static int frontRightMotor = 2;
    public static int backLeftMotor = 7;
    public static int backRightMotor = 3;
    public static int leftEncoderA = 4;
    public static int leftEncoderB = 5;
    public static int rightEncoderA = 6;
    public static int rightEncoderB = 7;
    public static double pulse = 0.00133;
    public static double wheel = 66.0;
    public static double degree = (wheel*Math.PI)/360;
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
