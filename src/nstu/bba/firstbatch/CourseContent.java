package nstu.bba.firstbatch;
import android.app.*;
import android.os.*;
import android.graphics.*;
import android.graphics.drawable.*;
import java.util.*;
import android.widget.*;
import android.view.*;
import android.content.*;
import com.google.android.gms.ads.*;
import nstu.bba.firstbatch.MainActivity;
import android.net.*;
public class CourseContent extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cc01);
		
		ArrayList<String> itemList = new ArrayList<String>();
		itemList.add(getString(R.string.cC01));
		itemList.add(getString(R.string.cC03));
		itemList.add(getString(R.string.cC05));
		itemList.add(getString(R.string.cC07));
		itemList.add(getString(R.string.cC09));
		itemList.add(getString(R.string.cC11));
		ArrayAdapter<String> aAdpt = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, itemList);
		// Set up the action bar to show a dropdown list.
		ActionBar ab=getActionBar();
	//	ab.setBackgroundDrawable(getResources().getDrawable(R.drawable.cccolor));
		ab.setBackgroundDrawable( new ColorDrawable(Color.parseColor("#cedefe")));
		ab.setIcon(R.drawable.course_content);
		ab.setSubtitle("First Batch");
		ab.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		ab.setListNavigationCallbacks(aAdpt,new ActionBar.OnNavigationListener()
		{
				@Override
				public boolean onNavigationItemSelected(int p1, long p2)
				{
					// TODO: Implement this method
					switch(p1)
					{
						case 0:
							setContentView(R.layout.cc01);
							getAd();
							break;
						case 1:
							setContentView(R.layout.cc03);
							getAd();
							break;
						case 2:
							setContentView(R.layout.cc05);
							getAd();
							break;
						case 3:
							setContentView(R.layout.cc07);
							getAd();
							break;
						case 4:
							setContentView(R.layout.cc09);
							getAd();
							break;
						case 5:
							setContentView(R.layout.cc11);
							getAd();
					}
					return false;
				}

				private void getAd()
				{
					// TODO: Implement this method
					AdView av=(AdView)findViewById(R.id.adViewcc);
					AdRequest ar=new AdRequest.Builder().addTestDevice("F59A4ABF15A40E22038CCFC11D986B06").build();
					av.loadAd(ar);
				}
				
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		menu.add("Routine").setIcon(R.drawable.class_routine);
	//	menu.add("Class Lecture").setIcon(R.drawable.class_lecture);
		menu.add("CT Question").setIcon(R.drawable.ct_question);
		menu.add("Booklist").setIcon(R.drawable.booklists);
		// TODO: Implement this method
		getMenuInflater().inflate(R.menu.of_pup,menu);
		
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO: Implement this method
			final View v=findViewById(R.id.overflow);
			
						switch(item.getTitle().toString())
						{
							case "Booklist":
								startActivity(new Intent(CourseContent.this,Booklist.class));
								break;
							case "Routine":
								startActivity(new Intent(CourseContent.this,RoutineTab.class));
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
								startActivity(new Intent(CourseContent.this,MainActivity.class));
						}
						switch(item.getItemId())
						{
							case R.id.ofAboutDev:
								{
									AlertDialog.Builder ab=new AlertDialog.Builder(CourseContent.this);
									ab.setView(getLayoutInflater().inflate(R.layout.ad,null));
									ab.setPositiveButton("Dismiss",null);
									ab.show();	
								}
								break;
							case R.id.ofAboutApp:
								{
									View av = getLayoutInflater().inflate(R.layout.about,null);
									new AlertDialog.Builder(CourseContent.this).setMessage(R.string.AboutApp).setCustomTitle(av).setCancelable(true).create().show();
									
								}	break;
							case R.id.ofHelp:
								{
									new AlertDialog.Builder(CourseContent.this).setMessage("Click Course Code on the top to view Course Content").setCancelable(true).create().show();
								}
								break;
							case R.id.ofExt:
								{
									new AlertDialog.Builder(CourseContent.this).setIcon(R.drawable.dialog_exit_main_icon).setTitle("Exit?").setMessage(R.string.exit_msg).setCancelable(true).setNegativeButton("No",null).setPositiveButton("Yes",new DialogInterface.OnClickListener()
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
