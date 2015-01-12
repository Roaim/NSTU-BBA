package nstu.bba.firstbatch;

import android.app.*;
import android.os.*;
import android.widget.*;
import java.util.*;
import android.view.*;
import android.content.*;
import com.google.android.gms.ads.*;

public class routine3 extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		ExpandableListAdapter ela;
		ExpandableListView elv;
		List<String> grpLst;
		HashMap<String,List<String>> chldLst;
		grpLst=new ArrayList<String>();
		chldLst=new HashMap<String,List<String>>();
		//grp list
		grpLst.add("Sunday");
		grpLst.add("Monday");
		grpLst.add("Tuesday");
		grpLst.add("Wednesday");
		grpLst.add("Thursday");
		//child list
		List<String> sun=new ArrayList<String>();
		List<String> mon=new ArrayList<String>();
		List<String> tue=new ArrayList<String>();
		List<String> wed=new ArrayList<String>();
		List<String> thu=new ArrayList<String>();
		//sunday
		sun.add(getString(R.string.routineTime02));
		sun.add(getString(R.string.routineTime03));
		sun.add(getString(R.string.routineTime04));
		//mon
		mon.add(getString(R.string.routineTime9));
		mon.add(getString(R.string.routineTime10));
		mon.add(getString(R.string.routineTime11));
		mon.add(getString(R.string.routineTime12));
		//tue
		tue.add(getString(R.string.routineTime02));
		tue.add(getString(R.string.routineTime03));
		tue.add(getString(R.string.routineTime04));
		//wed
		wed.add(getString(R.string.routineTime8));
		wed.add(getString(R.string.routineTime9));
		wed.add(getString(R.string.routineTime10));
		//thu
		thu.add(getString(R.string.routineTime11));
		thu.add(getString(R.string.routineTime12));
		//prep child
		chldLst.put(grpLst.get(0),sun);
		chldLst.put(grpLst.get(1),mon);
		chldLst.put(grpLst.get(2),tue);
		chldLst.put(grpLst.get(3),wed);
		chldLst.put(grpLst.get(4),thu);
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.routine_main);
		
		AdView av=(AdView)findViewById(R.id.adViewR);
		AdRequest ar=new AdRequest.Builder().addTestDevice("F59A4ABF15A40E22038CCFC11D986B06").build();
		av.loadAd(ar);
	
		elv=(ExpandableListView)findViewById(R.id.routinemainExpandableListView1);
		
		
		ela=new routSecAdpt(this,grpLst,chldLst);
		elv.setAdapter(ela);
	}

	
	class routSecAdpt extends BaseExpandableListAdapter
	{
		private Context cntx;
		private List<String> lstgrp;
		private HashMap<String,List<String>> lstchld;
		public routSecAdpt(Context cntx,List<String> lstGrp,HashMap<String,List<String>> lstChld)
		{
			this.cntx=cntx;
			this.lstgrp=lstGrp;
			this.lstchld=lstChld;
		}

		@Override
		public int getGroupCount()
		{
			// TODO: Implement this method
			return this.lstgrp.size();
		}

		@Override
		public int getChildrenCount(int p1)
		{
			// TODO: Implement this method
			return this.lstchld.get(this.lstgrp.get(p1)).size();
		}

		@Override
		public Object getGroup(int p1)
		{
			// TODO: Implement this method
			return this.lstgrp.get(p1);
		}

		@Override
		public Object getChild(int p1, int p2)
		{
			// TODO: Implement this method
			return this.lstchld.get(this.lstgrp.get(p1)).get(p2);
		}

		@Override
		public long getGroupId(int p1)
		{
			// TODO: Implement this method
			return p1;
		}

		@Override
		public long getChildId(int p1, int p2)
		{
			// TODO: Implement this method
			return p2;
		}

		@Override
		public boolean hasStableIds()
		{
			// TODO: Implement this method
			return false;
		}

		@Override
		public View getGroupView(int p1, boolean p2, View p3, ViewGroup p4)
		{
			String grp=(String)getGroup(p1);
			if(p3==null)
			{
				LayoutInflater li=(LayoutInflater)this.cntx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				p3=li.inflate(R.layout.routine_group,null);
				}
			// TODO: Implement this method
		TextView tv=	(TextView)p3.findViewById(R.id.routinegroupDay);
		tv.setText(grp);
			return p3;
		}

		@Override
		public View getChildView(int p1, int p2, boolean p3, View p4, ViewGroup p5)
		{
			String chld=(String)getChild(p1,p2);
			if(p4==null)
			{LayoutInflater li=(LayoutInflater)this.cntx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			p4=	li.inflate(R.layout.routine_child_jr,null);
				}
			// TODO: Implement this method
			TextView tv=(TextView)p4.findViewById(R.id.routinechildTime);
			tv.setText(chld);
			
			TextView room=(TextView)p4.findViewById(R.id.routinechildRoomNo);
			if(p1==1)
			{room.setText(R.string.routineRoom2);}
			else
			{room.setText(R.string.routineRoom1);}

			TextView sir=(TextView)p4.findViewById(R.id.routinechildjrSir);
			TextView cc=(TextView)p4.findViewById(R.id.routinechildCourseCode);

			switch(p1)
			{
				case 0://sundayz 
					{
						switch(p2)
						{
							case 0: 
								{
									cc.setText(R.string.jt07);
									sir.setText(R.string.TeacherMMH);
								}
								break;
							case 1:
								{
									cc.setText(R.string.jt05);
									sir.setText(R.string.TeacherMM);
								}
								break;
							case 2:
								{
									cc.setText(R.string.jt05);
									sir.setText(R.string.TeacherMM);
								}
								
						}	
					}
					break;
				case 1: //mon
					{
						switch(p2)
						{
							case 0:
								cc.setText(R.string.jt01);
								sir.setText(R.string.TeacherSA);
								break;
							case 1:
								cc.setText(R.string.jt01);
								sir.setText(R.string.TeacherSA);
								break;
							case 2:
								cc.setText(R.string.jt07);
								sir.setText(R.string.TeacherMMH);
								break;
							case 3:
								cc.setText(R.string.jt05);
								sir.setText(R.string.TeacherMM);
						}
					}
					break;
				case 2: //tue
					{
						switch(p2)
						{
							case 0:
								cc.setText(R.string.jt03);
								sir.setText(R.string.TeacherMM);
								break;
							case 1:
								cc.setText(R.string.jt09);
								sir.setText(R.string.TeacherAKM);
								break;
							case 2:
								cc.setText(R.string.jt09);
								sir.setText(R.string.TeacherAKM);
						}
					}
					break;
				case 3: //wed
					{
						switch(p2)
						{
							case 0:
								cc.setText(R.string.jt03);
								sir.setText(R.string.TeacherMM);
								break;
							case 1:
								cc.setText(R.string.jt03);
								sir.setText(R.string.TeacherMM);
								break;
							case 2:
								cc.setText(R.string.jt01);
								sir.setText(R.string.TeacherSA);
						}
					}
					break;
				case 4: // thu
					{
						switch(p2)
						{
							case 0:
								cc.setText(R.string.jt09);
								sir.setText(R.string.TeacherAKM);
								break;
							case 1:
								cc.setText(R.string.jt07);
								sir.setText(R.string.TeacherMMH);
						}
					}

			}
			return p4;
		}

		@Override
		public boolean isChildSelectable(int p1, int p2)
		{
			// TODO: Implement this method
			return false;
		}
		
		
	}

	//pppppprrrrreeeepppaaarrrrreee
	
	
}
