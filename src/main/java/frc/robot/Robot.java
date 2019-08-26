package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import frc.robot.command_status.DriveCommand;
import frc.robot.lib.joystick.DualThrustmasterJoysticks;
import frc.robot.lib.joystick.JoystickControlsBase;
import frc.robot.lib.util.DataLogController;

public class Robot extends IterativeRobot {
    
    JoystickControlsBase joystick;    
	DataLogController robotLogger;
	
	public Robot()
	{
    }
    
    
	@Override
	public void robotInit() {
		try
    	{
            joystick = new DualThrustmasterJoysticks();

    		robotLogger = DataLogController.getRobotLogController();
    		robotLogger.register(joystick.getLogger());

            boolean logToFile = false;
            boolean logToSmartDashboard = true;
            robotLogger.setOutputMode(logToFile, logToSmartDashboard);
    
    	}
    	catch(Throwable t)
    	{
    		throw t;
    	}
	}
	


	/****************************************************************
	 * DISABLED MODE
	 ****************************************************************/

	@Override
	public void disabledInit()
	{
		try
		{
		}
		catch (Throwable t)
		{
			throw t;
		}
	}

	@Override
	public void disabledPeriodic()
	{
		try
		{
			System.gc(); // runs garbage collector
		}
		catch (Throwable t)
		{
			throw t;
		}
	}



	/****************************************************************
	 * AUTONOMOUS MODE
	 ****************************************************************/

	@Override
	public void autonomousInit() {
 	}

	@Override
	public void autonomousPeriodic() 
	{
 	}
	
	
	/****************************************************************
	 * TELEOP MODE
	 ****************************************************************/

	@Override
	public void teleopInit()
	{
	}
	
	
	@Override
	public void teleopPeriodic() 
	{
	}



	/****************************************************************
	 * TEST MODE
	 ****************************************************************/

	@Override
	public void testInit() 
	{
	}

	@Override
	public void testPeriodic()
	{
	}
	
	
	// called after disabledPeriodic, autoPeriodic, and teleopPeriodic 
	@Override
	public void robotPeriodic()
	{
        if (joystick != null)
        {
            DriveCommand driveCmd = joystick.getDriveCommand();
        }
		robotLogger.log();
	}


}

