package nstu.bba.firstbatch;

import android.app.*;
import android.widget.*;
import java.util.*;
import android.os.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.view.*;
import android.content.*;
import android.transition.*;
import com.google.android.gms.ads.*;

public class routine extends Activity
{
	ExpandableListAdapter explstAdpt;
	ExpandableListView explstVW;
	List<String> grouplst;
	HashMap<String,List<String>> childlst;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.routine_main);
		AdView av=(AdView)findViewById(R.id.adViewR);
		AdRequest ar=new AdRequest.Builder().addTestDevice("F59A4ABF15A40E22038CCFC11D986B06").build();
		av.loadAd(ar);
		explstVW=(ExpandableListView)findViewById(R.id.routinemainExpandableListView1);
		prepareData();
		
		explstAdpt=new RoutineExpListAdptr(this,grouplst,childlst);
		explstVW.setAdapter(explstAdpt);
		explstVW.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
			{

				@Override
				public boolean onChildClick(ExpandableListView p1, View p2, int gp3, int cp4, long p5)
				{
					AlertDialog.Builder adb=new AlertDialog.Builder(routine.this);
					adb.setPositiveButton("OK",null);
					
					// TODO: Implement this method
					switch(gp3)
					{
						case 0:
							//group sun
						{
							switch(cp4)
							{
								//child sun
								case 0:
									adb.setTitle(R.string.bba03);
									adb.setMessage(R.string.TeacherMMH);
									break;
								case 1:
									adb.setTitle(R.string.bba03);
									adb.setMessage(R.string.TeacherMMH);
									break;
								case 2:
									adb.setTitle(R.string.bba07);
									adb.setMessage(R.string.TeacherSA);
									break;
								case 3:
									adb.setTitle(R.string.bba07);
									adb.setMessage(R.string.TeacherSA);
							}
						}
						break;
						//group mon
						case 1:
						{
							switch(cp4)
							{
								//child mon
								case 0:
									adb.setTitle(R.string.bba11).setMessage(R.string.TeacherMMH);
									break;
								case 1:
									adb.setTitle(R.string.bba01).setMessage(R.string.TeacherAKM);
									break;
								case 2:
									adb.setTitle(R.string.bba01).setMessage(R.string.TeacherAKM);
								
							}
						}
						break;
						//group tue
						case 2:
						{
							switch(cp4)
							{
								//child tue
								case 0:
									adb.setTitle(R.string.bba05).setMessage(R.string.TeacherMM);
									break;
								case 1:
									adb.setTitle(R.string.bba05).setMessage(R.string.TeacherMM);
									break;
								case 2:
									adb.setTitle(R.string.bba05).setMessage(R.string.TeacherMM);
									break;
								case 3:
									adb.setTitle(R.string.bba09).setMessage(R.string.TeacherAKM);
									break;
								case 4:
									adb.setTitle(R.string.bba07).setMessage(R.string.TeacherSA);
							}
							
						}
						break;
						//group wed
						case 3:
						{
							switch(cp4)
							{
								//child wed
								case 0:
									adb.setTitle(R.string.bba01).setMessage(R.string.TeacherAKM);
									break;
								case 1:
									adb.setTitle(R.string.bba03).setMessage(R.string.TeacherMMH);
								
							}
							
						}
						break;
						//group thu
						case 4:
						{
							switch(cp4)
							{
								//child thu
								case 0:
									adb.setTitle(R.string.bba09).setMessage(R.string.TeacherAKM);
									break;
								case 1:
									adb.setTitle(R.string.bba09).setMessage(R.string.TeacherAKM);
									break;
								case 2:
									adb.setTitle(R.string.bba11).setMessage(R.string.TeacherIMT);
							}
							
						}
					}
					adb.create().show();
					return false;
				}
				
			
		});
	}

	
	
	
	

	private void prepareData()
	{
		grouplst=new ArrayList<String>();
		childlst=new HashMap<String,List<String>>();
		// prepare group
		grouplst.add("Sunday");
		grouplst.add("Monday");
		grouplst.add("Tuesday");
		grouplst.add("Wednesday");
		grouplst.add("Thursday");
		// prepare child
		List<String> sun=new ArrayList<String>();
		List<String> mon=new ArrayList<String>();
		List<String> tue=new ArrayList<String>();
		List<String> wed=new ArrayList<String>();
		List<String> thu=new ArrayList<String>();
		//child items
		sun.add(getString(R.string.routineTime9));
		sun.add(getString(R.string.routineTime10));
		sun.add(getString(R.string.routineTime11));
		sun.add(getString(R.string.routineTime12));
		
		mon.add(getString(R.string.routineTime02));
		mon.add(getString(R.string.routineTime03));
		mon.add(getString(R.string.routineTime04));
		
		tue.add(getString(R.string.routineTime8));
		tue.add(getString(R.string.routineTime9));
		tue.add(getString(R.string.routineTime10));
		tue.add(getString(R.string.routineTime11));
		tue.add(getString(R.string.routineTime12));
		
		wed.add(getString(R.string.routineTime11));
		wed.add(getString(R.string.routineTime12));
		
		thu.add(getString(R.string.routineTime8));
		thu.add(getString(R.string.routineTime9));
		thu.add(getString(R.string.routineTime10));
		
		// put child items
		childlst.put(grouplst.get(0),sun);
		childlst.put(grouplst.get(1),mon);
		childlst.put(grouplst.get(2),tue);
		childlst.put(grouplst.get(3),wed);
		childlst.put(grouplst.get(4),thu);
	}
	
	
}
