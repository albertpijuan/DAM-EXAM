package cat.udl.tidic.amd.dam_tips.models;

import cat.udl.tidic.amd.dam_tips.R;

public enum EventType{
    H("H","hackathon"),LP("LP","lanparty"),LC("LC","livecoding");

    String name;
    String id;

    EventType(String _id, String _name){
        id = _id;
        name = _name;
    }

    public static int getImageResource(EventType e){

        switch(e){
            case H:
                return R.drawable.hackaton;
            case LP:
                return R.drawable.lanparty;
            case LC:
                return R.drawable.livecoding;
            default:
                return -1;
        }

    }


}
