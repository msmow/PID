package org.usfirst.frc.team5987.robot.subsystems;

import org.usfirst.frc.team5987.robot.RobotMap;
import org.usfirst.frc.team5987.robot.commands.TankDriveCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TankDriveSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	RobotDrive drive=new RobotDrive(RobotMap.frontLeftMotor, RobotMap.backLeftMotor, 
			RobotMap.frontRightMotor, RobotMap.backRightMotor);
	Encoder left=new Encoder(RobotMap.leftEncoderA, RobotMap.leftEncoderB);
	Encoder right=new Encoder(RobotMap.rightEncoderA, RobotMap.rightEncoderB);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TankDriveCommand());
    }
    
    public void drive(double l, double r) {
    	drive.tankDrive(l, r);
    }
    
    public TankDriveSubsystem() {
    	left.setDistancePerPulse(RobotMap.pulse);
    	right.setDistancePerPulse(RobotMap.pulse);
    }
    
    public double getLeftDistance() {
    	return left.getDistance();
    }
    
    public double getRightDistance() {
    	return right.getDistance();
    }
}

