package nstu.bba.firstbatch;

import android.app.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.*;

public class cl7 extends Activity
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
