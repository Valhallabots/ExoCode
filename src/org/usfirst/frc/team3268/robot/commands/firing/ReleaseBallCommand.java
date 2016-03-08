package org.usfirst.frc.team3268.robot.commands.firing;

import org.usfirst.frc.team3268.robot.Robot;
import org.usfirst.frc.team3268.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ReleaseBallCommand extends Command {

    public ReleaseBallCommand() {
    	requires(Robot.firingServo);
    }

    protected void initialize() {
    	setTimeout(0.25);
    }

    protected void execute() {
    	RobotMap.firingServo.set(1.0);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
