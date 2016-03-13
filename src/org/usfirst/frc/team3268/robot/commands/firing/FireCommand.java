package org.usfirst.frc.team3268.robot.commands.firing;

import org.usfirst.frc.team3268.robot.Robot;
import org.usfirst.frc.team3268.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FireCommand extends Command {

	double speed;
	
	long startTime = -1;
	
    public FireCommand(double speed) {
        requires(Robot.firingWheels);
        this.speed = speed;
    }

    protected void initialize() {
    	SmartDashboard.putNumber("Time Warming Up", 0);
    }

    protected void execute() {
    	if (startTime == -1) {
    		startTime = System.currentTimeMillis();
    	}
    	
    	SmartDashboard.putNumber("Time Warming Up", (double) (System.currentTimeMillis() - startTime) / 1000);
    	
    	RobotMap.firingLeft.set(-speed);
    	RobotMap.firingRight.set(speed);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	startTime = -1;
    	SmartDashboard.putNumber("Time Warming Up", 0);
    	RobotMap.firingLeft.set(0);
    	RobotMap.firingRight.set(0);
    }

    protected void interrupted() {
    	startTime = -1;
    	SmartDashboard.putNumber("Time Warming Up", 0);
    	RobotMap.firingLeft.set(0);
    	RobotMap.firingRight.set(0);
    }
}
