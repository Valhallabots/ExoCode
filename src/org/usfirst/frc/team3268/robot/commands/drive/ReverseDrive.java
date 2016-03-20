package org.usfirst.frc.team3268.robot.commands.drive;

import org.usfirst.frc.team3268.robot.Robot;
import org.usfirst.frc.team3268.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ReverseDrive extends Command {

    public ReverseDrive() {
        requires(Robot.drive);
    }

    protected void initialize() {
    }

    protected void execute() {
    	SmartDashboard.putBoolean("Inverted Drive", true);
    	
    	double driveAux = RobotMap.solenoid.get().equals(Value.kForward) ? Robot.oi.rStick.getY() : -Robot.oi.rStick.getY();
    	
    	double drive = Robot.oi.lStick.getY() * (Robot.oi.lStick.getRawButton(1) ? 1.0 : 0.8);
    	double rotate = (Robot.oi.lStick.getX() * 0.75) + (Robot.oi.rStick.getX() * 0.8);
    	
    	Robot.drive.arcadeDrive(drive + (driveAux * 0.6), -rotate);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.drive.arcadeDrive(0, 0);
    }

    protected void interrupted() {
    	Robot.drive.arcadeDrive(0, 0);
    }
}
