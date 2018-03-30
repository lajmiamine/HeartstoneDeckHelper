package wormapp.net.heartstonedeckhelper.Adapter;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import wormapp.net.heartstonedeckhelper.Model.CardClass;
import wormapp.net.heartstonedeckhelper.R;


/**
 * Created by hamdi on 12/07/15.
 */
public class CardClassAdapter extends RecyclerView.Adapter<CardClassAdapter.cardClassViewHolder>{

    ArrayList<CardClass> cardClasses ;

    public CardClassAdapter (ArrayList<CardClass> cardClasses){
        this.cardClasses = cardClasses;
    }
    @Override
    public cardClassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardclass,parent,false);
        return new cardClassViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardClassAdapter.cardClassViewHolder holder, int position) {
        CardClass cardClass = cardClasses.get(position);
        holder.label.setText(cardClass.getLib());
        holder.classIcon.setImageResource(R.drawable.hunter);

    }

    @Override
    public int getItemCount() {
        return cardClasses.size();
    }

    public static class cardClassViewHolder extends RecyclerView.ViewHolder{

        TextView label;
        ImageView classIcon;

        public cardClassViewHolder(View itemView) {
            super(itemView);
            label = (TextView) itemView.findViewById(R.id.label);
            classIcon =(ImageView) itemView.findViewById(R.id.classIcon);
        }


    }


}
