package org.usfirst.frc.team5987.robot.commands;

import org.usfirst.frc.team5987.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class PIDTurnCommand extends Command {

    public PIDTurnCommand(double angles) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.navx);
    	requires (Robot.tank);
    	target=angles;
    }
    
    double target;
    double P;
	double I;
	double D;
	
	double kP=0.5;
	double kI=0.5;
	double kD=0.5;
	
	double temp=0;
	
	double delay=0.005;
	double totArea=0;
	
	Timer timer=new Timer();

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.navx.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double error=Robot.navx.getAngle()-target;
    	
    	P=kP*error;
    	
    	D=(temp-error)/delay*kD;
    	
    	double area=((temp+error)*delay)/2;
    	totArea+=area;
    	
    	I=totArea*kI;
    	
    	Robot.tank.drive(P+I+D, -(P+I+D));
    	timer.delay(delay);
    	Robot.tank.drive(0, 0);
 
    	temp = error;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (target>0)
    		if (Robot.navx.getAngle()>target)
    			return true;
    	if (target<0)
    		if (Robot.navx.getAngle()<target)
    			return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.tank.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
