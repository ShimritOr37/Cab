package android.shimrit.com.heremobility;


import android.support.annotation.NonNull;

public class DataModel implements Comparable<DataModel> {

    String name;
    String type;
    Integer etaInMinutes;
    String url;


    public DataModel(String name, String type, Integer etaInMinutes, String url ) {
        this.name=name;
        this.type=type;
        this.etaInMinutes=etaInMinutes;
        this.url =url;
    }


    public String getName() {
        return name;
    }


    public String getType() {
        return type;
    }


    public Integer getEtaInMinutes() {
        return etaInMinutes;
    }


    public String getUrl() {
        return url;
    }

    public void setEtaInMinutes(int etaInMinutes){
        this.etaInMinutes = etaInMinutes;
    }


    @Override
    public int compareTo(@NonNull DataModel o) {
        if (etaInMinutes>o.getEtaInMinutes())
        return 1;
        if (etaInMinutes<o.getEtaInMinutes())
        return -1;
        return 0;
    }
}
