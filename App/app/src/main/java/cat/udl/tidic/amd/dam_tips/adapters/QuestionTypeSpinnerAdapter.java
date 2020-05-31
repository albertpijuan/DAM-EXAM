package cat.udl.tidic.amd.dam_tips.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class QuestionTypeSpinnerAdapter {
    private final String TAG ="QuestionTypeSpinnerAdapter";

    Context mContext;
    int mLayoutResourceId;

    public QuestionTypeSpinnerAdapter(Context context, int layoutResourceId) {
        super(context, layoutResourceId, data);
        this.mLayoutResourceId = layoutResourceId;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        Holder holder;

        if (row == null) {

            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
            holder = new Holder();

            row.setTag(holder);
        } else {
            holder = (Holder) row.getTag();
        }

    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    static class Holder {

        TextView QuestionTypeName;
    }
}
