package org.usfirst.frc.team5987.robot.commands;

import org.usfirst.frc.team5987.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveByMetersCommand extends Command {
	
	public double distance;
	public double iniDistance;

    public DriveByMetersCommand(double d) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.tank);
    	distance=d;
    	iniDistance=Robot.tank.getLeftDistance();
    	
    	Robot.tank.drive(0.5, 0.5);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Robot.tank.getLeftDistance()>=iniDistance+distance)
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
