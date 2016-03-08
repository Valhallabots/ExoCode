package org.usfirst.frc.team3268.robot.commands.auton;

import org.usfirst.frc.team3268.robot.Robot;
import org.usfirst.frc.team3268.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DriveToDefenseCommand extends Command {

	private double Kp = 0.03;
	
	private double startAngle = Double.NaN;
	
    public DriveToDefenseCommand() {
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(1.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Double.isNaN(startAngle))
    		startAngle = RobotMap.gyro.getAngle();
    	
    	Robot.drive.driveHelper.drive(-0.6, -(RobotMap.gyro.getAngle() - startAngle) * Kp);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.driveHelper.tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
