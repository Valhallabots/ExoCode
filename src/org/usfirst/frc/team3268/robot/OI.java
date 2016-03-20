package org.usfirst.frc.team3268.robot;

import org.usfirst.frc.team3268.robot.commands.auton.AutoHighGoalAlignSpam;
import org.usfirst.frc.team3268.robot.commands.auton.FullAutoHighGoalCommand;
import org.usfirst.frc.team3268.robot.commands.drive.AutoAlignDrive;
import org.usfirst.frc.team3268.robot.commands.drive.ReverseDrive;
import org.usfirst.frc.team3268.robot.commands.firing.FireCommand;
import org.usfirst.frc.team3268.robot.commands.firing.ReleaseBallCommand;
import org.usfirst.frc.team3268.robot.commands.pickup.PneumaticDownCommand;
import org.usfirst.frc.team3268.robot.commands.pickup.PneumaticUpCommand;
import org.usfirst.frc.team3268.robot.commands.pickup.SpitCommand;
import org.usfirst.frc.team3268.robot.commands.pickup.SuckCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class OI {
	public final Joystick lStick = new Joystick(0), rStick = new Joystick(1);
	
    private final JoystickButton toggleDriveButton = new JoystickButton(lStick, 3);
    private final JoystickButton suckButton = new JoystickButton(rStick, 5), spitButton = new JoystickButton(rStick, 3);
    private final JoystickButton lifterUp = new JoystickButton(rStick, 6), lifterDown = new JoystickButton(rStick, 4);
    
    private final JoystickButton firingZero = new JoystickButton(rStick, 12), firingLow = new JoystickButton(rStick, 10), firingHigh = new JoystickButton(rStick, 8);
    
    private final JoystickButton firingServo = new JoystickButton(rStick, 1);
    
    private final JoystickButton autoAlign = new JoystickButton(rStick, 2);
    
    public final NetworkTable grip = NetworkTable.getTable("GRIP");
    
    public OI() {
    	toggleDriveButton.toggleWhenPressed(new ReverseDrive());
    	
    	suckButton.whileHeld(new SuckCommand());
    	spitButton.whileHeld(new SpitCommand());
    	lifterUp.whenPressed(new PneumaticUpCommand());
    	lifterDown.whenPressed(new PneumaticDownCommand());
    	firingZero.whenPressed(new FireCommand(0.0));
    	firingLow.whenPressed(new FireCommand(0.5));
    	firingHigh.whenPressed(new FireCommand(0.8));
    	
    	firingServo.whenPressed(new ReleaseBallCommand());
//    	autoAlign.whileHeld(new AutoAlignDrive());
    	autoAlign.whenPressed(new FullAutoHighGoalCommand());
    }
}

