package org.usfirst.frc.team3268.robot.commands.auton;

import org.usfirst.frc.team3268.robot.Robot;
import org.usfirst.frc.team3268.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveToDefenseCommand extends Command {

	private double Kp = 0.0;
	
	private double startAngle = Double.NaN;
	
	boolean forceLong = false;
	
    public DriveToDefenseCommand(boolean forceLong) {
        requires(Robot.drive);
        this.forceLong = forceLong;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(2.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (SmartDashboard.getBoolean("Auto Traverse Defense?") || forceLong) {
    		setTimeout(2.5);
    	} else {
    		setTimeout(1.0);
    	}
    	
    	RobotMap.solenoid.set(Value.kForward);
    	
//    	if (Double.isNaN(startAngle))
//    		startAngle = RobotMap.gyro.getAngle();
    	
    	Robot.drive.drive(0.6, -0.01);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive.arcadeDrive(0, 0);
    }
}
