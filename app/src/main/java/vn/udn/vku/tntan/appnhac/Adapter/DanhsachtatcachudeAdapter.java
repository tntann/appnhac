package vn.udn.vku.tntan.appnhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vn.udn.vku.tntan.appnhac.Activity.DanhsachtheloaitheochudeActivity;
import vn.udn.vku.tntan.appnhac.Model.ChuDe;
import vn.udn.vku.tntan.appnhac.R;

public class DanhsachtatcachudeAdapter extends RecyclerView.Adapter<DanhsachtatcachudeAdapter.ViewHolder> {

    Context context;
    ArrayList<ChuDe> mangchude;

    public DanhsachtatcachudeAdapter(Context context, ArrayList<ChuDe> mangchude) {
        this.context = context;
        this.mangchude = mangchude;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_cacchude,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhsachtatcachudeAdapter.ViewHolder holder, int position) {
        ChuDe chude = mangchude.get(position);
        Picasso.with(context).load(chude.getHinhChuDe()).into(holder.imgchude);
    }

    @Override
    public int getItemCount() {
        return mangchude.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgchude;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgchude =itemView.findViewById(R.id.imvdongcacchude);
            imgchude.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhsachtheloaitheochudeActivity.class);
                    intent.putExtra("chude",mangchude.get(getPosition()));
                    context.startActivity(intent);
                }
            });

        }
    }
}
