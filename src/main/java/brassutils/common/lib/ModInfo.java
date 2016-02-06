
package brassutils.common.lib;

import boilerplate.common.IModInfo;

/**
 * @author Surseance
 *
 */
public class ModInfo implements IModInfo
{
	public static final String ID = "brassutils";
	public static final String NAME = "BrassUtils";
	public static final String NAME_SPACED = "Brass Utils";
	public static final String VERSION = "1.0.1";

	public static final String CLIENT_PROXY = "brassutils.client.ClientProxy";
	public static final String COMMON_PROXY = "brassutils.common.CommonProxy";

	public static final String PREFIX = ID + ":";

	@Override
	public String getID()
	{
		return ID;
	}

	@Override
	public String getName()
	{
		return NAME;
	}

	@Override
	public String getVersion()
	{
		return VERSION;
	}

	@Override
	public String getPrefix()
	{
		return PREFIX;
	}

	@Override
	public String getClientProxyPath()
	{
		return CLIENT_PROXY;
	}

	@Override
	public String getCommonProxyPath()
	{
		return COMMON_PROXY;
	}
}
