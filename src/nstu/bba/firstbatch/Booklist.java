package nstu.bba.firstbatch;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import com.google.android.gms.ads.*;
import android.net.*;

public class Booklist extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.booklist01);
		
		ArrayList<String> itemList = new ArrayList<String>();
		itemList.add(getString(R.string.cC01));
		itemList.add(getString(R.string.cC03));
		itemList.add(getString(R.string.cC05));
		itemList.add(getString(R.string.cC07));
		itemList.add(getString(R.string.cC09));
		itemList.add(getString(R.string.cC11));
		ArrayAdapter<String> aAdpt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, itemList);
		// Set up the action bar to show a dropdown list.
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(true);
		
		actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#2DA1F2")));
		actionBar.setIcon(R.drawable.booklists);
		actionBar.setTitle("Booklist:");
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		actionBar.setListNavigationCallbacks(aAdpt,new ActionBar.OnNavigationListener()
			{

				@Override
				public boolean onNavigationItemSelected(int p1, long p2)
				{
					// TODO: Implement this method
					if(p1==0)
					{//BBA-3101
						setContentView(R.layout.booklist01);
						getAd();
						
					}
					else if(p1==1)
					{//BVA-3103
						setContentView(R.layout.booklist03);
						getAd();
					}
					else if(p1==2)
					{//BBA-3105
					setContentView(R.layout.booklist05);
						getAd();
					}
					else if(p1==3)
					{//BBA-3107
						setContentView(R.layout.booklist07);
						getAd();
					}
					else if(p1==4)
					{//BBA-3109
						setContentView(R.layout.booklist09);
						getAd();
					}
					else if(p1==5)
					{//BBA-3111
						setContentView(R.layout.booklist11);
						getAd();
					}
					return false;
				}

				private void getAd()
				{
					// TODO: Implement this method
					AdView av=(AdView)findViewById(R.id.adViewbl);
					AdRequest ar=new AdRequest.Builder().addTestDevice("F59A4ABF15A40E22038CCFC11D986B06").addTestDevice("f9ddfcd17af5d6e1").build();
					av.loadAd(ar);
				}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// TODO: Implement this method
		getMenuInflater().inflate(R.menu.overflow,menu);
	
	
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO: Implement this method
		if(item.getItemId()==R.id.overflow)
		{
			final View v=findViewById(R.id.overflow);
			PopupMenu pm=new PopupMenu(getApplicationContext(),v);
			pm.getMenu().add("Routine");
			pm.getMenu().add("Course Content");
		//	pm.getMenu().add("Class Lecture");
			pm.getMenu().add("CT Question");
			pm.getMenuInflater().inflate(R.menu.help_popup,pm.getMenu());
			pm.getMenu().add("Exit");
			pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
				{

					@Override
					public boolean onMenuItemClick(MenuItem p1)
					{
						if(p1.getTitle().toString().equalsIgnoreCase("exit"))
						{
							AlertDialog.Builder adb=new AlertDialog.Builder(Booklist.this);
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
						else if(p1.getTitle().toString().equalsIgnoreCase("routine"))
						{
							Intent routine=new Intent(Booklist.this,RoutineTab.class);
							finish();
							startActivity(routine);
						}
						else if(p1.getTitle().toString().equals("Course Content"))
						{
							startActivity(new Intent(Booklist.this,CourseContent.class));
						}
				/*		else if(p1.getTitle().toString().equals("Class Lecture"))
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
								AlertDialog.Builder ab=new AlertDialog.Builder(Booklist. this);
								ab.setCancelable(true).setTitle("No! Internet Connection").setIcon(R.drawable.fail).setMessage("Please turn on your internet connection and try again.");
								ab.setPositiveButton("Ok", null).create().show();

							}
						}
						
				*/
						
						else if (p1.getTitle().toString().equals("CT Question"))
						{
					
						}
						
						else switch(p1.getItemId())
								// TODO: Implement this method
								{
									case R.id.aboutDev:
										{
											//	new AlertDialog.Builder(MainActivity.this).setIcon(R.drawable.roaim).setTitle("Developer info").setCancelable(true).setMessage(R.string.AboutDeveloper).create().show();

											AlertDialog.Builder ab=new AlertDialog.Builder(Booklist.this);
											ab.setView(getLayoutInflater().inflate(R.layout.ad,null));
											ab.setPositiveButton("Dismiss",null);
											ab.show();								
										}
										break;
									case R.id.aboutApp:								
										View av = getLayoutInflater().inflate(R.layout.about,null);
										new AlertDialog.Builder(Booklist.this).setMessage(R.string.AboutApp).setCustomTitle(av).setCancelable(true).create().show();
										break;
									case R.id.popHelp:
										new AlertDialog.Builder(Booklist.this).setMessage("Click Course Code on the top to view Boolkist").setCancelable(true).create().show();
										break;
														}
						return false;
					}
					
				
			});
			pm.show();
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
