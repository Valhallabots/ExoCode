package org.usfirst.frc.team3268.robot.commands.auton;

import org.usfirst.frc.team3268.robot.Robot;
import org.usfirst.frc.team3268.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class SimpleTraverseDefenseCommand extends Command {

	private double Kp = 0.0;
	
	private double startAngle = Double.NaN;
	
    public SimpleTraverseDefenseCommand() {
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(2.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.solenoid.set(Value.kForward);
    	
    	if (Double.isNaN(startAngle))
    		startAngle = RobotMap.gyro.getAngle();
    	
    	Robot.drive.driveHelper.drive(0.8, -(RobotMap.gyro.getAngle() - startAngle) * Kp);
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
    	Robot.drive.driveHelper.tankDrive(0, 0);
    }
}
