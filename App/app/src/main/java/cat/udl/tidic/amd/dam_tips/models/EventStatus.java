package cat.udl.tidic.amd.dam_tips.models;

import cat.udl.tidic.amd.dam_tips.R;

public enum EventStatus{
    O("O","open"),C("C","closed"),G("G","ongoing"), U("U", "undefined");

    String name;
    String id;

    EventStatus(String _id, String _name){
        id = _id;
        name = _name;
    }

    public String getName(){
        return name;
    }

    public static int getColourResource(EventStatus e){

        switch(e){
            case O:
                return R.color.green;
            case C:
                return R.color.red;
            case G:
                return R.color.blue;
            default:
                return -1;
        }

    }
}
