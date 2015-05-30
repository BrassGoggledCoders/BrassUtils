package brassutils.common.commands;

import net.minecraft.command.CommandException;

public class PermissionsException extends CommandException
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public PermissionsException()
	{
		this("Unable to perform command:", new Object[0]);
	}

	public PermissionsException(String par1Str, Object... par2ArrayOfObj)
	{
		super(par1Str, par2ArrayOfObj);
	}
}
