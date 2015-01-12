package nstu.bba.firstbatch;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.drawable.*;
import android.graphics.*;
import android.widget.AdapterView.*;
import android.content.*;
import com.google.android.gms.ads.*;
import android.net.*;
import com.winsontan520.wversionmanager.library.WVersionManager;

public class MainActivity extends Activity
{
	int ccjr;
	String putCcJr="ccjr";
    @Override
    public void onCreate(Bundle savedInstanceState)
	{			
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		ActionBar ab=getActionBar();
		ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2DA1F2")));
		ab.setIcon(R.drawable.actionicon);
	// Bellow line will be deleted after final version
	Toast.makeText(MainActivity.this,"This is a test version",Toast.LENGTH_LONG).show();
	// above line will be deleted after final version
		getExta();
		String[] mainlistText={"Routine","Course Content",
	//"Class Lecture",
		"CT-Question","Booklist"};
		ListView mainlistview=(ListView)findViewById(R.id.mainListView1);
		ListAdapter mainlistadapter=new Textlistadapter(getApplicationContext(),mainlistText);
		mainlistview.setAdapter(mainlistadapter);
		mainlistview.setOnItemClickListener(new OnItemClickListener()
			{	
				@Override
				public void onItemClick(AdapterView<?> p1, final View p2, int p3, long p4)
				{
					switch(p3)
					{	//CT questions
						case 2:
						{
						AlertDialog.Builder ab=	new	AlertDialog.Builder(MainActivity.this);
						ab.setTitle("No Resources found");
						ab.setIcon(android.R.drawable.ic_dialog_alert);
						//ab.show(); missing					
						ab.create().show();
						}
						break;
						case 0:
						{
							Intent i=new Intent(MainActivity.this,RoutineTab.class);
							startActivity(i);
						}
						break;
						// Course content
						case 1:
							{
								final Intent cc=new Intent(MainActivity.this,CourseContent.class);
								
							PopupMenu pum=new PopupMenu(MainActivity.this,p2);
								pum.getMenu().add("First Batch");
								pum.getMenu().add("Second Batch");
								pum.getMenu().add("Third Batch");
							
							pum.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
									{

										@Override
										public boolean onMenuItemClick(MenuItem p1)
										{
											if(p1.getTitle().toString().startsWith("First"))
											{ startActivity(cc);	}
											
										else	if(p1.getTitle().toString().startsWith("Third"))
											{ccjr=3;
											Intent intent=new Intent(getApplicationContext(),ccjr.class);
											intent.putExtra(putCcJr,ccjr);
											startActivity(intent);
											}
											else
											{
												ccjr=2;
												Intent intent=new Intent(getApplicationContext(),ccjr.class);
												intent.putExtra(putCcJr,ccjr);
												startActivity(intent);
											}
											return false;
										}
										
								
							});
							
							pum.show();
						}
						break;
						// Clss lecture
				/*		case 2:
						{
							ConnectionDetector	cd=new ConnectionDetector(getApplicationContext());
							Boolean	intrntprsnt=cd.isConnectingToInternet();
							if(intrntprsnt)
							{
								Intent cl1,cl3,cl5,cl7,cl9,cl11;
								cl1=new Intent(getApplicationContext(),cl1.class);
								cl3=new Intent(getApplicationContext(),cl3.class);
								cl5=new Intent(getApplicationContext(),cl5.class);
								cl7=new Intent(getApplicationContext(),cl7.class);
								cl9=new Intent(getApplicationContext(),cl9.class);
								cl11=new Intent(getApplicationContext(),cl11.class);
								
								PopupMenu pm=new PopupMenu(MainActivity.this,p2);
								pm.getMenu().add(R.string.cC01).setIntent(cl1);
								pm.getMenu().add(R.string.cC03).setIntent(cl3);
								pm.getMenu().add(R.string.cC05).setIntent(cl5);
								pm.getMenu().add(R.string.cC07).setIntent(cl7);
								pm.getMenu().add(R.string.cC09).setIntent(cl9);
								pm.getMenu().add(R.string.cC11).setIntent(cl11);
								pm.show();
							}
							else
							{
								AlertDialog.Builder ab=new AlertDialog.Builder(MainActivity. this);
								ab.setCancelable(true).setTitle("No! Internet Connection").setIcon(R.drawable.fail).setMessage("Please turn on your internet connection and try again.");
								ab.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

										@Override
										public void onClick(DialogInterface p1, int position)
										{
											// TODO: finish affinity
										
										
										}


									}).create().show();
								
							}
						}
						break;
						// Booklists
						
				*/
						
						case 3:
						{
							startActivity(new Intent(MainActivity.this,Booklist.class));
						}
					}
				
				}
				
			
			}															);

    }

	private void getExta()
	{
		WVersionManager vm=new WVersionManager(this);
		vm.setVersionContentUrl("http://nstubba.cf/nstubba/nstubba_version.txt");
		vm.setUpdateNowLabel("Download");
		vm.setIgnoreThisVersionLabel("Don't ask");
		vm.setReminderTimer(10);
		vm.setRemindMeLaterLabel("Remind later");
		vm.setUpdateUrl("http://nstubba.cf/nstubba/nstubba.apk");
		vm.checkVersion();
		
		AdView adView = (AdView)findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().addTestDevice("F59A4ABF15A40E22038CCFC11D986B06").addTestDevice("f9ddfcd17af5d6e1").build();
		adView.loadAd(adRequest);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if(keyCode==KeyEvent.KEYCODE_BACK)
		{
			AlertDialog.Builder adb=new AlertDialog.Builder(MainActivity.this);
			adb.setTitle("EXIT");

			adb.setMessage(R.string.exit_msg);
			adb.setIcon(R.drawable.dialog_exit_main_icon);
			adb.setNegativeButton("No",null);
			adb.setPositiveButton("Yes",new DialogInterface.OnClickListener()
				{
					@Override
					public void onClick(DialogInterface p1, int p2)
					{	//finish application
						finishAffinity(); 

					}
				});
			adb.create().show();
		}
		return super.onKeyDown(keyCode, event);
	}
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.menu,menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
			case R.id.help:
				View v=findViewById(R.id.help);
				PopupMenu popMenu=new PopupMenu(getApplicationContext(),v);
				popMenu.getMenuInflater().inflate(R.menu.help_popup,popMenu.getMenu());
				popMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
					{
						@Override
						public boolean onMenuItemClick(MenuItem p1)
						{
							switch(p1.getItemId())
							{
								case R.id.aboutDev:
								{
								//	new AlertDialog.Builder(MainActivity.this).setIcon(R.drawable.roaim).setTitle("Developer info").setCancelable(true).setMessage(R.string.AboutDeveloper).create().show();
		
									AlertDialog.Builder ab=new AlertDialog.Builder(MainActivity.this);
									ab.setView(getLayoutInflater().inflate(R.layout.ad,null));
									ab.setPositiveButton("Dismiss",null);
									ab.show();								
								}
								break;
								case R.id.aboutApp:								
									View av = getLayoutInflater().inflate(R.layout.about,null);
									new AlertDialog.Builder(MainActivity.this).setMessage(R.string.AboutApp).setCustomTitle(av).setCancelable(true).create().show();
									break;
								case R.id.popHelp:
									new AlertDialog.Builder(MainActivity.this).setMessage(R.string.helpMain).setCancelable(true).create().show();
									break;
					
							}
							return false;
						}
				});
				popMenu.show();
				
				break;
				
			case R.id.Exit:
			{
				AlertDialog.Builder adb=new AlertDialog.Builder(MainActivity.this);
				adb.setTitle("EXIT");

				adb.setMessage(R.string.exit_msg);
				adb.setIcon(R.drawable.dialog_exit_main_icon);
				adb.setNegativeButton("No",null);
				adb.setPositiveButton("Yes",new DialogInterface.OnClickListener()
					{
						@Override
						public void onClick(DialogInterface p1, int p2)
						{	//finish application
							finishAffinity();

						}
					});
				adb.create().show();
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
