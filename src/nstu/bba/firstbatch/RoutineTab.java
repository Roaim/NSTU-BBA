package nstu.bba.firstbatch;

import android.*;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import nstu.bba.firstbatch.*;
import android.graphics.*;
import com.google.android.gms.ads.*;
import android.net.*;

public class RoutineTab extends TabActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		ActionBar ab=getActionBar();
		ab.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
		ab.setIcon(R.drawable.class_routine);
		ab.setDisplayHomeAsUpEnabled(true);
		TabHost th=getTabHost();
		LayoutInflater.from(this).inflate(R.layout.routine_tab,th.getTabContentView(),true);
		th.addTab(th.newTabSpec("fb")
			.setIndicator("1st Batch").setContent(new Intent(getApplicationContext(),routine.class)));
		th.addTab(th.newTabSpec("sb")
			.setIndicator("2nd Batch").setContent(new Intent(getApplicationContext(),routine2.class)));
		th.addTab(th.newTabSpec("tb")
				  .setIndicator("3rd Batch").setContent(new Intent(getApplicationContext(),routine3.class)));
		th.setBackgroundResource(R.drawable.red);
			
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.overflow,menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		if(item.getItemId()==R.id.overflow)
		{
			final View v=findViewById(R.id.overflow);
			PopupMenu pm=new PopupMenu(getApplicationContext(),v);
			pm.getMenu().add("Course Content").setIcon(R.drawable.course_content);
		//	pm.getMenu().add("Class Lecture").setIcon(R.drawable.class_lecture);
			pm.getMenu().add("CT Question").setIcon(R.drawable.ct_question);
			pm.getMenu().add("Booklist").setIcon(R.drawable.booklists);

			pm.getMenuInflater().inflate(R.menu.of_pup,pm.getMenu());

			pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener()
				{

					@Override
					public boolean onMenuItemClick(MenuItem p1)
					{
						switch(p1.getTitle().toString())
						{
							case "Course Content":
								startActivity(new Intent(getApplicationContext(),CourseContent.class));
								break;
						/*	case "Class Lecture":
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
										AlertDialog.Builder ab=new AlertDialog.Builder(RoutineTab. this);
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
							
						*/
							
							case "CT Question":
								startActivity(new Intent(RoutineTab.this,MainActivity.class));
								break;
							case "Booklist":
								startActivity(new Intent(RoutineTab.this,Booklist.class));
						}
						switch(p1.getItemId())
						{
							case R.id.ofAboutDev:
								{
									AlertDialog.Builder ab=new AlertDialog.Builder(RoutineTab.this);
									ab.setView(getLayoutInflater().inflate(R.layout.ad,null));
									ab.setPositiveButton("Dismiss",null);
									ab.show();		}
								break;
							case R.id.ofAboutApp:
								{
									View av = getLayoutInflater().inflate(R.layout.about,null);
									new AlertDialog.Builder(RoutineTab.this).setMessage(R.string.AboutApp).setCustomTitle(av).setCancelable(true).create().show();
									
								}	break;
							case R.id.ofHelp:
								{
									new AlertDialog.Builder(RoutineTab.this).setMessage(R.string.helpRoutine).setCancelable(true).create().show();
								}
								break;
							case R.id.ofExt:
								{
									new AlertDialog.Builder(RoutineTab.this).setIcon(R.drawable.dialog_exit_main_icon).setTitle("Exit?").setMessage(R.string.exit_msg).setCancelable(true).setNegativeButton("No",null).setPositiveButton("Yes",new DialogInterface.OnClickListener()
										{	@Override
											public void onClick(DialogInterface p1, int p2)
											{
												finishAffinity();
											}
										}).create().show();
								}
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
