package cn.edu.gdpt.a3dalbum171032ywj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class AlbumAdapter extends BaseAdapter {
    private List<AlbumBean> dataList=new ArrayList<>();
    private Context context;

    public AlbumAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<AlbumBean> dataList){
        this.dataList=dataList;
    }
    public class ViewHolder{
        public ImageView iv_img;
    }
    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.item_album,null);
            ViewHolder viewHolder=new ViewHolder();
            viewHolder.iv_img=view.findViewById(R.id.iv_img);
            view.setTag(viewHolder);
        }
        ViewHolder holder=(ViewHolder)view.getTag();
        holder.iv_img.setImageResource(dataList.get(i).imgResld);
        return null;
    }
}
