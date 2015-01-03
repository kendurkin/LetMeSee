package photoLib;
 
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.android.beefnky.R;

/* The adapter is used to bind data to a view 
 * The BaseAdapter class is one which you extend in 
 * order to override the methods which tell the AdapterView 
 * (your GridView) what to display. The most important method 
 * to override is the getView() method, in which you return the View 
 * to display at a particular position on the grid.
 * 
 * BaseAdapter is an abstract base class for the Adaptor 
 * interface to simplify implementing adapters. You could implement 
 * your own, but the framework provides some pretty 
 * flexible adapters already. Some popular adapters are:*/

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
 
    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.pic1, R.drawable.pic2,          
            R.drawable.pic3, R.drawable.pic4,
            R.drawable.pic5, R.drawable.pic6,
            R.drawable.pic7, R.drawable.pic8,
            R.drawable.pic9, R.drawable.pic10,
            R.drawable.pic11
    };
 
    // Constructor
    public ImageAdapter(Context mContext){
        this.mContext = mContext;
    }
 
    public int getCount() {
        return mThumbIds.length;
    }
 
    public Object getItem(int position) {
        return mThumbIds[position];
    }
 
    public long getItemId(int position) {
        return 0;
    }
 
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        /* view screen */
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER); //CENTER_CROP
        imageView.setLayoutParams(new GridView.LayoutParams(250, 250));
        return imageView;
    }
 
}
