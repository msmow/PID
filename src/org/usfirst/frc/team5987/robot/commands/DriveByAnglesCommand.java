package org.usfirst.frc.team5987.robot.commands;

import org.usfirst.frc.team5987.robot.Robot;
import org.usfirst.frc.team5987.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveByAnglesCommand extends Command {
	
	public double angles;
	public double iniDisLeft;
	public double iniDisRight;

    public DriveByAnglesCommand(double a) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.tank);
    	angles=a*RobotMap.degree;
    	iniDisLeft=Robot.tank.getLeftDistance();
    	iniDisRight=Robot.tank.getRightDistance();
    	
    	if (angles>0)
    		Robot.tank.drive(0.5, -0.5);
    	if (angles<0)
    		Robot.tank.drive(-0.5, 0.5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (angles>0)
    		if (Robot.tank.getLeftDistance()>=iniDisLeft+angles)
    			return true;
    	if (angles<0)
    		if (Robot.tank.getRightDistance()>=iniDisRight+Math.abs(angles))
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
