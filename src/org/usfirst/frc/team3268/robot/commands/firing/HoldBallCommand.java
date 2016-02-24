package org.usfirst.frc.team3268.robot.commands.firing;

import org.usfirst.frc.team3268.robot.Robot;
import org.usfirst.frc.team3268.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class HoldBallCommand extends Command {

    public HoldBallCommand() {
    	requires(Robot.firingServo);
    }

    protected void initialize() {
    }

    protected void execute() {
    	RobotMap.firingServo.set(0.0);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
