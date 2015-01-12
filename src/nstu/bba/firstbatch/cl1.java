package nstu.bba.firstbatch;

import android.app.*;
import android.os.*;
import android.graphics.*;
import android.graphics.drawable.*;
import nstu.bba.firstbatch.MainActivity;

public class cl1 extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		ActionBar ab=getActionBar();
		ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00a1ef")));
	}
	
}
