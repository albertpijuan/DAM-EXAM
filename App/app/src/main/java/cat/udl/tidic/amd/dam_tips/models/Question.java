package cat.udl.tidic.amd.dam_tips.models;

import com.google.gson.annotations.SerializedName;

public class Question {
    @SerializedName("id")
    private int id;
    @SerializedName("category")
    private CategoryEnum category;
    @SerializedName("question")
    private QuestionTypeEnum type;

}
