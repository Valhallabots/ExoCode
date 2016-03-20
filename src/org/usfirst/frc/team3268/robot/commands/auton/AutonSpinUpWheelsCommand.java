package org.usfirst.frc.team3268.robot.commands.auton;

import org.usfirst.frc.team3268.robot.Robot;
import org.usfirst.frc.team3268.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class AutonSpinUpWheelsCommand extends Command {

	public static boolean done;
	
    public AutonSpinUpWheelsCommand() {
        requires(Robot.firingWheels);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.firingLeft.set(-0.5);
    	RobotMap.firingRight.set(0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.firingLeft.set(0);
    	RobotMap.firingRight.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	RobotMap.firingLeft.set(0);
    	RobotMap.firingRight.set(0);
    }
}
