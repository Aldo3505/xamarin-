package md5814dbad97d7dc722682a191278992a63;


public class NMININFO
	extends android.app.Activity
	implements
		mono.android.IGCUserPeer
{
/** @hide */
	public static final String __md_methods;
	static {
		__md_methods = 
			"n_onCreate:(Landroid/os/Bundle;)V:GetOnCreate_Landroid_os_Bundle_Handler\n" +
			"";
		mono.android.Runtime.register ("PhilAPPines.NMININFO, PhilAPPines, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", NMININFO.class, __md_methods);
	}


	public NMININFO ()
	{
		super ();
		if (getClass () == NMININFO.class)
			mono.android.TypeManager.Activate ("PhilAPPines.NMININFO, PhilAPPines, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null", "", this, new java.lang.Object[] {  });
	}


	public void onCreate (android.os.Bundle p0)
	{
		n_onCreate (p0);
	}

	private native void n_onCreate (android.os.Bundle p0);

	private java.util.ArrayList refList;
	public void monodroidAddReference (java.lang.Object obj)
	{
		if (refList == null)
			refList = new java.util.ArrayList ();
		refList.add (obj);
	}

	public void monodroidClearReferences ()
	{
		if (refList != null)
			refList.clear ();
	}
}