package org.usfirst.frc.team3268.robot.commands.pickup;

import org.usfirst.frc.team3268.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class SpitCommand extends Command {

    public SpitCommand() {
    	
    }

    protected void initialize() {
    }

    protected void execute() {
    	RobotMap.intake.set(-1.0);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	RobotMap.intake.set(0.0);
    }

    protected void interrupted() {
    	RobotMap.intake.set(0.0);
    }
}
