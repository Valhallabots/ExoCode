package org.usfirst.frc.team3268.robot.commands.drive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.usfirst.frc.team3268.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoAlignDrive extends Command {

    public AutoAlignDrive() {
        requires(Robot.drive);
    }

    protected void initialize() {
    }

    protected void execute() {
    	if (Robot.oi.grip == null) return;
    	
    	double[] targetCXs = Robot.oi.grip.getNumberArray("targets/centerX", new double[0]);

		if (targetCXs == null || targetCXs.length == 0)
			return;

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
		
		if (offMag < closeEnough) {
			Robot.drive.driveHelper.arcadeDrive(0, 0);
		} else {			
			double turning = 0;
			
			SmartDashboard.putNumber("Offset", offset);
			
			if (offset < -closeEnough) {
				turning = 0.75;
			}
			if (offset > closeEnough) {
				turning = -0.75;
			}
			
			double forward = 0;
			
			int minY = 100, maxY = 110;
			
			boolean yGood = targetCYs[index] < minY || targetCYs[index] > maxY;
			
			if (!yGood || targetAreas[index] <= 250) {
				if (targetCYs[index] < minY) {
					forward = -0.6;
				} else if (targetCYs[index] > maxY) {
					forward = 0.6;
				}
			}
			
			Robot.drive.arcadeDrive(forward, turning);
		}
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
