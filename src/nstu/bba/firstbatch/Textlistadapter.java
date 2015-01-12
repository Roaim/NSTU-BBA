package nstu.bba.firstbatch;

import android.*;
import android.content.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;
import nstu.bba.firstbatch.*;
public class Textlistadapter extends ArrayAdapter<String>
{
		public Textlistadapter (Context contex, String[] string)
		{
			super(contex,R.layout.main_list_view,string);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
		/*	if(position==2)
			{
				LayoutInflater li=LayoutInflater.from(getContext());
				convertView=li.inflate(R.layout.main_list_cl_view,parent,false);
				TextView	tv=(TextView)convertView.findViewById(R.id.mainlistviewTextView1);
				tv.setTypeface(Typeface.create(Typeface.SERIF,Typeface.BOLD_ITALIC));
				tv.setText(getItem(position));
			}
		*/
		//	else
			if(position==2)
			{
				LayoutInflater li=LayoutInflater.from(getContext());
				convertView=li.inflate(R.layout.main_list_cl_view,parent,false);
				TextView	tv=(TextView)convertView.findViewById(R.id.mainlistviewTextView1);
				tv.setText(getItem(position));
				tv.setTypeface(Typeface.create(Typeface.SERIF,Typeface.BOLD_ITALIC));
				ImageView iv=(ImageView)convertView.findViewById(R.id.mainlistviewImageView1);
				iv.setImageResource(R.drawable.ct_question);
				
			}
			else if(position==3)
			{
				LayoutInflater li=LayoutInflater.from(getContext());
				convertView=li.inflate(R.layout.main_list_cl_view,parent,false);
				TextView	tv=(TextView)convertView.findViewById(R.id.mainlistviewTextView1);
				tv.setText(getItem(position));
				tv.setTypeface(Typeface.create(Typeface.SERIF,Typeface.BOLD_ITALIC));
				ImageView iv=(ImageView)convertView.findViewById(R.id.mainlistviewImageView1);
				iv.setImageResource(R.drawable.booklists);

			}
			else
			{
			LayoutInflater layinf=LayoutInflater.from(getContext());
			convertView=layinf.inflate(R.layout.main_list_view,parent,false);
			String text=getItem(position);
			TextView tv=(TextView)convertView.findViewById(R.id.mainlistviewTextView1);
			ImageView iv=(ImageView)convertView.findViewById(R.id.mainlistviewImageView1);
			tv.setTypeface(Typeface.create(Typeface.SERIF,Typeface.BOLD_ITALIC));
			tv.setText(text);
			switch(position)
			{
				case 0:
					iv.setImageResource(R.drawable.class_routine);
					break;
				case 1:
					iv.setImageResource(R.drawable.course_content);
					break;
				
			}
			}
			return convertView;
		}
	
}
