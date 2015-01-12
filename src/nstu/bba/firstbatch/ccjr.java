package nstu.bba.firstbatch;
import android.app.*;
import android.os.*;
import android.webkit.*;
import android.widget.*;
import android.graphics.drawable.*;
import android.graphics.*;
import java.util.*;
import android.view.*;
import android.content.*;
import com.google.android.gms.ads.*;
import android.net.*;

public class ccjr extends Activity
{
	WebView wv;
	TextView tv;
	ActionBar ab;
	int a=0;
	List<String> cct,cnt,ccs,cns;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ccjr);
		
		AdView av=(AdView)findViewById(R.id.adViewccjr);
		AdRequest ar=new AdRequest.Builder().addTestDevice("F59A4ABF15A40E22038CCFC11D986B06").addTestDevice("f9ddfcd17af5d6e1").build();
					av.loadAd(ar);
		
		ab=getActionBar();
		ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#cedefe")));
		int intent=getIntent().getIntExtra("ccjr",0);
		if(intent==3)
		{
			getArrayT();
			ab.setSubtitle("Third Batch");
			ArrayAdapter<String> aAdpt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, cct);
			ab.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
			ab.setListNavigationCallbacks(aAdpt,new ActionBar.OnNavigationListener()
				{
					
					@Override
					public boolean onNavigationItemSelected(int p1, long p2)
					{
						String url="file:///android_asset/cct"+p1+".html";
							tv=(TextView)findViewById(R.id.ccjrTextView1);
							wv=(WebView)findViewById(R.id.ccjrWebView);
							tv.setText(cnt.get(p1));
							wv.loadUrl(url);
						return false;
					}				
			});
			
			
			
		}
		else if(intent==2)
		{
			getArrayS();
			ab.setSubtitle("Second Batch");
			ArrayAdapter<String> aAdpt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, ccs);
			ab.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
			ab.setListNavigationCallbacks(aAdpt,new ActionBar.OnNavigationListener()
				{

					@Override
					public boolean onNavigationItemSelected(int p1, long p2)
					{
					//	a=p1;
						String url="file:///android_asset/ccs"+p1+".html";
					//	if(p1==a)
					//	{
							tv=(TextView)findViewById(R.id.ccjrTextView1);
							wv=(WebView)findViewById(R.id.ccjrWebView);
							tv.setText(cns.get(p1));
							wv.loadUrl(url);
					//	}
						return false;
					}
					
				
			});
		}
	}

	private void getArrayS()
	{
		ccs=new ArrayList<String>();
		cns=new ArrayList<String>();		
		
		ccs.add(getResources().getString(R.string.js01));
		ccs.add(getResources().getString(R.string.js03));
		ccs.add(getResources().getString(R.string.js05));
		ccs.add(getResources().getString(R.string.js07));
		ccs.add(getResources().getString(R.string.js09));
		ccs.add(getResources().getString(R.string.js11));
		
		cns.add("No Resources");
		cns.add("No Resources");
		cns.add("No Resources");
		cns.add("No Resources");
		cns.add("No Resources");
		cns.add("No Resources");
	}

	private void getArrayT()
	{
		cct=new ArrayList<String>();
		cnt=new ArrayList<String>();
		
		cnt.add("Business Mathematics");
		cnt.add("Business Statistics-1");
		cnt.add("Micro Economics");
		cnt.add("General Science");
		cnt.add("Business Communication");
		
		cct.add(getResources().getString(R.string.jt01));
		cct.add(getResources().getString(R.string.jt03));
		cct.add(getResources().getString(R.string.jt05));
		cct.add(getResources().getString(R.string.jt07));
		cct.add(getResources().getString(R.string.jt09));
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		menu.add("Routine").setIcon(R.drawable.class_routine);
		//	menu.add("Class Lecture").setIcon(R.drawable.class_lecture);
		menu.add("CT Question").setIcon(R.drawable.ct_question);
		menu.add("Booklist").setIcon(R.drawable.booklists);
		getMenuInflater().inflate(R.menu.of_pup,menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO: Implement this method
	//	final View v=findViewById(R.id.overflow);

		switch(item.getTitle().toString())
		{
			case "Booklist":
				startActivity(new Intent(ccjr.this,Booklist.class));
				break;
			case "Routine":
				startActivity(new Intent(ccjr.this,RoutineTab.class));
				break;
				/*		case "Class Lecture":
				 {
				 ConnectionDetector	cd=new ConnectionDetector(getApplicationContext());
				 Boolean	intrntprsnt=cd.isConnectingToInternet();
				 if(intrntprsnt)
				 {
				 PopupMenu pop=new PopupMenu(getApplicationContext(),v);
				 pop.getMenu().add(R.string.cC01);
				 pop.getMenu().add(R.string.cC03);
				 pop.getMenu().add(R.string.cC05);
				 pop.getMenu().add(R.string.cC07);
				 pop.getMenu().add(R.string.cC09);
				 pop.getMenu().add(R.string.cC11);

				 pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
				 {

				 @Override
				 public boolean onMenuItemClick(MenuItem pcl)
				 {
				 if(pcl.getTitle().toString()==getString(R.string.cC01))
				 startActivity(new Intent(getApplicationContext(),cl1.class));
				 else if(pcl.getTitle().toString()==getString(R.string.cC03))
				 startActivity(new Intent(getApplicationContext(),cl3.class));
				 else if(pcl.getTitle().toString()==getString(R.string.cC05))
				 startActivity(new Intent(getApplicationContext(),cl5.class));
				 else if(pcl.getTitle().toString()==getString(R.string.cC07))
				 startActivity(new Intent(getApplicationContext(),cl7.class));
				 else if(pcl.getTitle().toString()==getString(R.string.cC09))
				 startActivity(new Intent(getApplicationContext(),cl9.class));
				 else if(pcl.getTitle().toString()==getString(R.string.cC11))
				 startActivity(new Intent(getApplicationContext(),cl11.class));
				 return false;
				 }
				 });
				 pop.show(); }
				 else
				 {
				 AlertDialog.Builder ab=new AlertDialog.Builder(CourseContent. this);
				 ab.setCancelable(true).setTitle("No! Internet Connection").setIcon(R.drawable.fail).setMessage("Please turn on your internet connection and try again.");
				 ab.setPositiveButton("Ok", null).create().show();

				 }
				 }
				 break;

				 */

			case "CT Question":
				startActivity(new Intent(ccjr.this,MainActivity.class));
		}
		switch(item.getItemId())
		{
			case R.id.ofAboutDev:
				{
					AlertDialog.Builder ab=new AlertDialog.Builder(ccjr.this);
					ab.setView(getLayoutInflater().inflate(R.layout.ad,null));
					ab.setPositiveButton("Dismiss",null);
					ab.show();	
				}
				break;
			case R.id.ofAboutApp:
				{
					View av = getLayoutInflater().inflate(R.layout.about,null);
					new AlertDialog.Builder(ccjr.this).setMessage(R.string.AboutApp).setCustomTitle(av).setCancelable(true).create().show();
					
				}
				break;
			case R.id.ofHelp:
				{
					new AlertDialog.Builder(ccjr.this).setMessage("Click Course Code on the top to view Course Content").setCancelable(true).create().show();
				}
				break;
			case R.id.ofExt:
				{
					new AlertDialog.Builder(ccjr.this).setIcon(R.drawable.dialog_exit_main_icon).setTitle("Exit?").setMessage(R.string.exit_msg).setCancelable(true).setNegativeButton("No",null).setPositiveButton("Yes",new DialogInterface.OnClickListener()
						{	@Override
							public void onClick(DialogInterface p1, int p2)
							{
								// TODO: Implement this method
								finishAffinity();
							}
						}).create().show();
				}
		}

		return super.onOptionsItemSelected(item);
	}
	public void fb(View v)
	{
		startActivity(new Intent("android.intent.action.VIEW",Uri.parse("http://www.facebook.com/roaim.ahmed")));
	}
	public void dial(View v)
	{
		Intent callIntent = new Intent(Intent.ACTION_DIAL);
		String phone = "tel:"+"01673976064";
		callIntent.setData(Uri.parse(phone));
		startActivity(callIntent);
	}
}
