package org.usfirst.frc.team3268.robot.commands.pickup;

import org.usfirst.frc.team3268.robot.Robot;
import org.usfirst.frc.team3268.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class PneumaticDownCommand extends Command {

    public PneumaticDownCommand() {
    	requires(Robot.pickupPneumatics);
    	setTimeout(0.5);
    }

    protected void initialize() {
    }

    protected void execute() {
    	RobotMap.solenoid.set(Value.kForward);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
