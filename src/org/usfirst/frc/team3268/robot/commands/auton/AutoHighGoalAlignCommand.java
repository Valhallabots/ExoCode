package org.usfirst.frc.team3268.robot.commands.auton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.usfirst.frc.team3268.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoHighGoalAlignCommand extends Command {

    boolean done = false;
    
    public AutoHighGoalAlignCommand() {
        requires(Robot.drive);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// 167, 178
    	if (Robot.oi.grip == null) {
    		done = false;
    		return;
    	}
    	
    	double[] targetCXs = Robot.oi.grip.getNumberArray("targets/centerX", new double[0]);

		if (targetCXs == null || targetCXs.length == 0) {
			done = false;
			return;
		}

		List<Double> sorted = new ArrayList<Double>(targetCXs.length);

		for (double cx : targetCXs) {
			sorted.add(cx);
		}

		Collections.sort(sorted, new Comparator<Double>() {

			@Override
			public int compare(Double arg0, Double arg1) {
				return Double.compare(Math.abs(arg0 - 320), Math.abs(arg1 - 320));
			}
		});

		double cX = sorted.get(0);
		
		int index = -1;
		
		for (int i = 0; i < targetCXs.length; i++) {
			if (targetCXs[i] == cX) {
				index = i;
				break;
			}
		}
		
		double[] targetAreas = Robot.oi.grip.getNumberArray("targets/area", new double[0]);
		double[] targetCYs = Robot.oi.grip.getNumberArray("targets/centerY", new double[0]);

		double offset = cX - 160;
		double offMag = Math.abs(offset);
		
		SmartDashboard.putNumber("Area", targetAreas.length == 0 ? -1 : targetAreas[index]);
		SmartDashboard.putNumber("CenterY", targetCYs.length == 0 ? -1 : targetCYs[index]);
			
		int closeEnough = 5;
		
		boolean xGood = false;
		
		double turning = 0;
		
		if (offMag < closeEnough) {
			Robot.drive.driveHelper.arcadeDrive(0, 0);
			xGood = true;
		} else {
			
			double magnitude = Math.abs(offset) < 100 ? 0.5 : 0.7;
			
			if (offset < -closeEnough) {
				turning = -magnitude;
			}
			if (offset > closeEnough) {
				turning = magnitude;
			}
		}
		
		double forward = 0;
		
		int minY = 160, maxY = 180;
		
		boolean yGood = targetCYs[index] > minY && targetCYs[index] < maxY;
		
		double vertOffset = 0;
		
		if (targetCYs[index] < minY) {
			vertOffset = targetCYs[index] - minY;
		} else if (targetCYs[index] > maxY) {
			vertOffset = targetCYs[index] - maxY;
		}
		
		if (!yGood) {
			if (targetCYs[index] < minY) {
				forward = Math.abs(vertOffset) < 30 ? 0.55 : 0.6;
			} else if (targetCYs[index] > maxY) {
				forward = Math.abs(vertOffset) < 30 ? -0.55 : -0.6;
			}
		}

		if (xGood && yGood) {
			done = true;
			Robot.drive.arcadeDrive(0, 0);
			return;
		}
		
		Robot.drive.arcadeDrive(forward, turning);
		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.arcadeDrive(0, 0);
    	done = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive.arcadeDrive(0, 0);
    	done = false;
    }
}
