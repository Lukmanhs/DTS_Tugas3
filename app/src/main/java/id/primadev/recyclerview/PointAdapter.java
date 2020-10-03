package id.primadev.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PointAdapter extends RecyclerView.Adapter<PointAdapter.ContactViewHolder>{
    private List<Point> listPoint = new ArrayList<>();
    private OnContactClickListener listener;

    public PointAdapter(List<Point> listPoint) {
        this.listPoint = listPoint;
    }

    public interface OnContactClickListener{
        public void onClick(View view, int position);
    }

    public void setListener(OnContactClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public PointAdapter.ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vh = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_point,viewGroup,false);
        ContactViewHolder viewHolder = new ContactViewHolder(vh);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PointAdapter.ContactViewHolder contactViewHolder, int i) {
        Point item = listPoint.get(i);
        contactViewHolder.txtPhone.setText(item.getPhone());
        contactViewHolder.txtName.setText(item.getName());
        Picasso.get().load(item.getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .into(contactViewHolder.imageContact);
    }

    @Override
    public int getItemCount() {
        return listPoint.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageContact;
        public TextView txtName, txtPhone;

        public ContactViewHolder(View vh) {
            super(vh);
            imageContact = vh.findViewById(R.id.imageclub);
            txtName = vh.findViewById(R.id.txtName);
            txtPhone = vh.findViewById(R.id.txtPoint);
            vh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(v,getAdapterPosition());
                }
            });

        }
    }
}
