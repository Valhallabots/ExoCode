package org.usfirst.frc.team3268.robot.subsystems;

import org.usfirst.frc.team3268.robot.RobotMap;
import org.usfirst.frc.team3268.robot.commands.drive.StandardDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem {
    
    public final RobotDrive driveHelper;
    public final RobotDrive driveHelper2;
	
    public DriveSystem() {
    	driveHelper = new RobotDrive(RobotMap.leftDrive, RobotMap.rightDrive);
    	driveHelper2 = new RobotDrive(RobotMap.leftDrive2, RobotMap.rightDrive2);
    	RobotMap.rightDrive2.setInverted(true);
    }
    
	public void initDefaultCommand() {
    	setDefaultCommand(new StandardDrive());
	}
	
	public void arcadeDrive(double forwards, double turn) {
		driveHelper.arcadeDrive(forwards, turn);
		driveHelper2.arcadeDrive(forwards, -turn);
	}
	
	public void drive(double forwards, double turn) {
		driveHelper.drive(forwards, turn);
		driveHelper2.drive(forwards, -turn);
	}
}

