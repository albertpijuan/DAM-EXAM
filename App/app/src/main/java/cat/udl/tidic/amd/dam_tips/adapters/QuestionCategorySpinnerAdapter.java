package cat.udl.tidic.amd.dam_tips.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import cat.udl.tidic.amd.dam_tips.models.CategoryEnum;

public class QuestionCategorySpinnerAdapter extends ArrayAdapter<CategoryEnum> {

    private final String TAG ="QuestionTypeSpinnerAdapter";

    Context mContext;
    int mLayoutResourceId;
    CategoryEnum[] mItems;

    public QuestionCategorySpinnerAdapter(Context context, int layoutResourceId,
                                        CategoryEnum[] data) {
        super(context, layoutResourceId, data);
        this.mLayoutResourceId = layoutResourceId;
        this.mItems = data;
        this.mContext = context;
    }

    public QuestionCategorySpinnerAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public <CategoryEnum> View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        Holder holder;

        //Log.d(TAG, "Row: " + row);
        if (row == null) {

            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(mLayoutResourceId, parent, false);
            holder = new Holder();
            holder.favourNameCategory = row.findViewById(R.id.favourCategoryName);

            row.setTag(holder);
        } else {
            holder = (Holder) row.getTag();
        }

        CategoryEnum item = (CategoryEnum) mItems[position];

        holder.favourNameCategory.setText(item.getQuestion());
        return row;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    static class Holder {
        TextView favourNameCategory;
    }


}
