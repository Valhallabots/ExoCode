package org.usfirst.frc.team3268.robot.commands.drive;

import org.usfirst.frc.team3268.robot.Robot;
import org.usfirst.frc.team3268.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class StandardDrive extends Command {

    public StandardDrive() {
        requires(Robot.drive);
    }

    protected void initialize() {
    }

    protected void execute() {
    	double driveAux = RobotMap.solenoid.get().equals(Value.kForward) ? Robot.oi.rStick.getY() : -Robot.oi.rStick.getY();
    	
    	double drive = Robot.oi.lStick.getY();
    	double rotate = (Robot.oi.lStick.getX() * 0.8) + (Robot.oi.rStick.getX() * 0.8);
    	
    	Robot.drive.driveHelper.arcadeDrive(-drive + (driveAux * 0.8), -rotate);
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
