package cat.udl.tidic.amd.dam_tips.models;

public class CategoryEnum {
    private static final android.R.attr R = ;


    db("db","db"),
    os("os","os"),
    patterns("patterns","patterns"),
    net("net","net"),


    String question;
    String id;

    CategoryEnum(String _id, String _question){
        id = _id;
        question = _question;
    }

    public String getQuestion(){
        return question;
    }
}
