package brassutils.common.commands;

import net.minecraft.command.CommandException;

public class NotFoundException extends CommandException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1018671632502477344L;

	public NotFoundException()
	{
		this("Not found", new Object[0]);
	}

	public NotFoundException(String par1Str, Object[] par2ArrayOfObj)
	{
		super(par1Str, par2ArrayOfObj);
		// TODO Auto-generated constructor stub
	}

}
