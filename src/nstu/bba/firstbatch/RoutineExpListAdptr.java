package nstu.bba.firstbatch;

import android.widget.*;
import android.view.*;
import android.content.*;
import java.util.*;

public class RoutineExpListAdptr extends BaseExpandableListAdapter
{
	private Context cntx;
	private List<String> listgroup;
	private HashMap<String, List<String>> listchild;

public RoutineExpListAdptr(Context contx, List<String> lstgroup, HashMap<String,List<String>> lstchild)
{
	this.cntx=contx;
	this.listgroup=lstgroup;
	this.listchild=lstchild;
}
	
	@Override
	public int getGroupCount()
	{
		// TODO: Implement this method
		return this.listgroup.size();
	}

	@Override
	public int getChildrenCount(int p1)
	{
		// TODO: Implement this method
		return this.listchild.get(this.listgroup.get(p1)).size();
	}

	@Override
	public Object getGroup(int p1)
	{
		// TODO: Implement this method
		return this.listgroup.get(p1);
	}

	@Override
	public Object getChild(int p1, int p2)
	{
		// TODO: Implement this method
		return this.listchild.get(this.listgroup.get(p1)).get(p2);
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
		String groupday=(String)getGroup(p1);
		if(p3==null)
		{
			LayoutInflater linf=(LayoutInflater)this.cntx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			p3=linf.inflate(R.layout.routine_group,null);
		}
		// TODO: Implement this method
		TextView tv=(TextView)p3.findViewById(R.id.routinegroupDay);
		tv.setText(groupday);
		return p3;
	}

	@Override
	public View getChildView(int p1, int p2, boolean p3, View p4, ViewGroup p5)
	{
		String childtxt=(String)getChild(p1,p2);
		if(p4==null)
		{
			LayoutInflater layinf=(LayoutInflater)this.cntx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			p4=layinf.inflate(R.layout.routine_child,null);
		}
		// TODO: Implement this method
		TextView time=(TextView)p4.findViewById(R.id.routinechildTime);
		time.setText(childtxt);
		
		TextView ccode=(TextView)p4.findViewById(R.id.routinechildCourseCode);
		TextView room=(TextView)p4.findViewById(R.id.routinechildRoomNo);
		room.setText(R.string.routineRoom1);
		if(p1==0)
		{
			room.setText(R.string.routineRoom2);
		}
		
		
		switch(p1)
		{
			//group sunday
			case 0:
			{	
			//starting child sunday
				switch(p2)
				{	//child sunday 9am
					case 0:
					{
						ccode.setText(R.string.cC03);
					}
					break;
					//child sunday 10am
					case 1:
					{
						ccode.setText(R.string.cC03);
					}
					break;
					//child sunday 11am
					case 2:
					{
						ccode.setText(R.string.cC07);
					}
					break;
					//child sunday 12am
					case 3:
					{
						ccode.setText(R.string.cC07);
					}
				}
				
			}
			break;
			
			//Group monday
			case 1:
			{	
		//starting child monday
				switch(p2)
				{
					//child monday 2pm
					case 0:
					{
						ccode.setText(R.string.cC11);
					}
					break;
					//child mon 3pm
					case 1:
					{
						ccode.setText(R.string.cC01);
					}
					break;
					//child mon 4pm
					case 2:
					{
						ccode.setText(R.string.cC01);
					}
				}
			}
			break;
			
			//group tuesday
			case 2:
			{
			//starting child tue
				switch(p2)
				{
					//child tue 8am
					case 0:
					{
						ccode.setText(R.string.cC05);
					}
					break;
					//child tue 9am
					case 1:
					{
						ccode.setText(R.string.cC05);
					}
					break;
					//child tue 10am
					case 2:
					{
						ccode.setText(R.string.cC05);
					}
					break;
					//child tue 11am
					case 3:
					{
						ccode.setText(R.string.cC09);
					}
					break;
					//child tue 12am
					case 4:
					{
						ccode.setText(R.string.cC07);
					}
				}
				
			}
			break;
			
			//group wednessday
			case 3:
			{
			//starting child wed
				switch(p2)
				{
					//child wed 11am
					case 0:
					{
						ccode.setText(R.string.cC01);
					}
					break;
					//child wed 12am
					case 1:
					{
						ccode.setText(R.string.cC03);
					}
				}
				
			}
			break;
			
			//group thursday
			case 4:
			{
			//starting child thu
				switch(p2)
				{
					//child thu 8am
					case 0:
					{
						ccode.setText(R.string.cC09);
					}
					break;
					//child thu 9am
					case 1:
					{
						ccode.setText(R.string.cC09);
					}
					break;
					//child thu 10am
					case 2:
					{
						ccode.setText(R.string.cC11);
					}
				}
				
			}
		}
		return p4;
	}

	@Override
	public boolean isChildSelectable(int p1, int p2)
	{
		// TODO: Implement this method
		return true;
	}
	
}
