package org.usfirst.frc.team3268.robot.commands.drive;

import org.usfirst.frc.team3268.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StandardDrive extends Command {

    public StandardDrive() {
        requires(Robot.drive);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.drive.driveHelper.tankDrive(-Robot.oi.lStick.getY(), -Robot.oi.rStick.getY());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.drive.driveHelper.tankDrive(0, 0);
    }

    protected void interrupted() {
    	Robot.drive.driveHelper.tankDrive(0, 0);
    }
}
