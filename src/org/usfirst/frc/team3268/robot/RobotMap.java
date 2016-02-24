package org.usfirst.frc.team3268.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;

public class RobotMap {
    public static final CANTalon leftDrive = new CANTalon(1), rightDrive = new CANTalon(2);
    
    public static final DoubleSolenoid solenoid = new DoubleSolenoid(7, 6);
    
    public static final Talon intake = new Talon(2);
    public static final Talon firingRight = new Talon(0), firingLeft = new Talon(1);
}
