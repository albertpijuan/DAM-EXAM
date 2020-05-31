package cat.udl.tidic.amd.dam_tips.models;

public enum QuestionTypeEnum {

    String question;
    String id;

    FavourTypeEnum(String _id, String _category){
        id = _id;
        String question = _category;
    }

    public String getQuestion {
        return question;
    }


}
