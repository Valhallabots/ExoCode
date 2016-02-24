package org.usfirst.frc.team3268.robot.commands.firing;

import org.usfirst.frc.team3268.robot.Robot;
import org.usfirst.frc.team3268.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class FireCommand extends Command {

	double speed;
	
    public FireCommand(double speed) {
        requires(Robot.firingWheels);
        this.speed = speed;
    }

    protected void initialize() {
    }

    protected void execute() {
    	RobotMap.firingLeft.set(-speed);
    	RobotMap.firingRight.set(speed);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	RobotMap.firingLeft.set(0);
    	RobotMap.firingRight.set(0);
    }

    protected void interrupted() {
    	RobotMap.firingLeft.set(0);
    	RobotMap.firingRight.set(0);
    }
}
