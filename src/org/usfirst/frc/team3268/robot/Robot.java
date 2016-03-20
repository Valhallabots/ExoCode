
package org.usfirst.frc.team3268.robot;

import org.usfirst.frc.team3268.robot.commands.auton.FullAutoHighGoalCommand;
import org.usfirst.frc.team3268.robot.subsystems.DriveSystem;
import org.usfirst.frc.team3268.robot.subsystems.FiringServoSystem;
import org.usfirst.frc.team3268.robot.subsystems.FiringWheelsSystem;
import org.usfirst.frc.team3268.robot.subsystems.PickupPneumaticsSystem;
import org.usfirst.frc.team3268.robot.subsystems.PickupSystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static DriveSystem drive;
	public static PickupSystem pickup;
	public static PickupPneumaticsSystem pickupPneumatics;
	public static FiringWheelsSystem firingWheels;
	public static FiringServoSystem firingServo;
	
	public static OI oi;

	private static SendableChooser autoChooser;
	
	private static PowerDistributionPanel pdp;
	
    Command autonomousCommand;
    
    public void robotInit() {
    	pdp = new PowerDistributionPanel();
    	
		drive = new DriveSystem();
		pickup = new PickupSystem();
		pickupPneumatics = new PickupPneumaticsSystem();
		firingWheels = new FiringWheelsSystem();
		firingServo = new FiringServoSystem();
		
		oi = new OI();
		
		SmartDashboard.putBoolean("Auto Traverse Defense?", true);
		
//		autonomousCommand = new DriveToDefenseCommand();
		autonomousCommand = new FullAutoHighGoalCommand();
		
//		autoChooser = new SendableChooser();
//		autoChooser.addDefault("Drive to Defense", new DriveToDefenseCommand());
//		autoChooser.addObject("Drive to and Traverse", new SimpleTraverseGroup());
		
//		SmartDashboard.putData("Autonomous Command", autoChooser);
    }
	
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}
	
    public void autonomousInit() {
//    	autonomousCommand = (Command) autoChooser.getSelected();
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
//       	Alliance alliance = DriverStation.getInstance().getAlliance();
//		
//       	int r = 0;
//		int b = 0;
//		
//		if (alliance.equals(Alliance.Red)) {
//			r = 255;
//		} else if (alliance.equals(Alliance.Blue)) {
//			b = 255;
//		}
//		
//		RobotMap.ledR.setRaw(r);
//		RobotMap.ledB.setRaw(b);
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        updateSDElectricity();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
//        Alliance alliance = DriverStation.getInstance().getAlliance();
//		
//		int r = 0;
//		int b = 0;
//		
////		if (alliance.equals(Alliance.Red)) {
////			r = 255;
////		} else if (alliance.equals(Alliance.Blue)) {
////			b = 255;
////		}
//		
//		r = 0;
//		
//		RobotMap.ledR.setPeriodMultiplier(PWM.PeriodMultiplier.k4X);
//		RobotMap.ledB.setPeriodMultiplier(PWM.PeriodMultiplier.k4X);
//		RobotMap.ledR.setRaw(0);
//		RobotMap.ledB.setRaw(255);
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        updateSDElectricity();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public void updateSDElectricity() {
    	for (int i = 0; i < 16; i++) {
        	SmartDashboard.putNumber("Current " + i, pdp.getCurrent(i));
        }
    }
}
