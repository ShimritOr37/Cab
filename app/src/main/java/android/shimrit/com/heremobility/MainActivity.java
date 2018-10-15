package android.shimrit.com.heremobility;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    private ArrayList<DataModel> mDataModels;
    private ListView mListView;
    private CustomAdapter mAdapter;


    private Spinner mPickUpSpinner = null;
    private Spinner mDesSpinner = null;
    private boolean isDesChosen;
    private boolean isPickUpChosen;

    private Timer mTimer1;
    private TimerTask mTt1;
    private Handler mTimerHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user_choise);


        mPickUpSpinner = (Spinner) findViewById(R.id.pickup_selection);
        ArrayList<String> spinnerArray = new ArrayList<>();
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<>(MainActivity.this, R.layout.spinner_item, spinnerArray);
        mPickUpSpinner.setAdapter(spinnerArrayAdapter);
        spinnerArrayAdapter.add("choose your pick up place");

        //for this home homework i will limit the number of pickups
        spinnerArrayAdapter.add("habima");
        spinnerArrayAdapter.add("castle");
        spinnerArrayAdapter.add("habima");
        spinnerArrayAdapter.add("Eilat");
        spinnerArrayAdapter.add("Ashdod");
        spinnerArrayAdapter.add("BeerSheva");
        spinnerArrayAdapter.add("BetShean");
        spinnerArrayAdapter.add("Haifa");
        spinnerArrayAdapter.add("tiberias");
        spinnerArrayAdapter.add("Jerusalem");
        spinnerArrayAdapter.add("Lod");
        spinnerArrayAdapter.add("MizpeRamon");
        spinnerArrayAdapter.add("nazereth");
        spinnerArrayAdapter.add("Sedom");
        spinnerArrayAdapter.add("Afula");
        spinnerArrayAdapter.add("zefat");
        spinnerArrayAdapter.add("Qazrin");
        spinnerArrayAdapter.add("TelAviv");


        mPickUpSpinner.setSelection(0);

        mPickUpSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    isPickUpChosen = true;
                    if (isDesChosen){
                        createCabsList();
                        stopTimer();
                        startTimer();
                    }
                } else {
                    isPickUpChosen = false;
                    stopTimer();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mDesSpinner = (Spinner) findViewById(R.id.des_selection);
        ArrayList<String> spinnerArrayDes = new ArrayList<>();
        ArrayAdapter<String> spinnerArrayAdapterDes = new ArrayAdapter<>(MainActivity.this, R.layout.spinner_item, spinnerArrayDes);
        mDesSpinner.setAdapter(spinnerArrayAdapterDes);

        //for this home homework i will limit the number of pickups
        spinnerArrayAdapterDes.add("choose your destination");
        spinnerArrayAdapterDes.add("habima");
        spinnerArrayAdapterDes.add("castle");
        spinnerArrayAdapterDes.add("habima");
        spinnerArrayAdapterDes.add("Eilat");
        spinnerArrayAdapterDes.add("Ashdod");
        spinnerArrayAdapterDes.add("BeerSheva");
        spinnerArrayAdapterDes.add("BetShean");
        spinnerArrayAdapterDes.add("Haifa");
        spinnerArrayAdapterDes.add("tiberias");
        spinnerArrayAdapterDes.add("Jerusalem");
        spinnerArrayAdapterDes.add("Lod");
        spinnerArrayAdapterDes.add("MizpeRamon");
        spinnerArrayAdapterDes.add("nazereth");
        spinnerArrayAdapterDes.add("Sedom");
        spinnerArrayAdapterDes.add("Afula");
        spinnerArrayAdapterDes.add("zefat");
        spinnerArrayAdapterDes.add("Qazrin");
        spinnerArrayAdapterDes.add("TelAviv");

        mDesSpinner.setSelection(0);
        mDesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    isDesChosen = true;
                    if (isPickUpChosen){
                        createCabsList();
                        stopTimer();
                        startTimer();
                    }
                } else {
                    isDesChosen = false;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    public static int getRandomEtaInMinutes() {
        Random rand = new Random();
        return rand.nextInt(150) + 1;

    }

    private  void createCabsList(){
        mListView = (ListView) findViewById(R.id.list);
        mDataModels = new ArrayList<>();
        mDataModels.add(new DataModel("TelAviv", "TelAviv Cab Station", getRandomEtaInMinutes(), "http://pngimg.com/uploads/taxi/taxi_PNG79.png"));
        mDataModels.add(new DataModel("Qazrin", "TelAviv Cab Station", getRandomEtaInMinutes(), "http://pngimg.com/uploads/taxi/taxi_PNG71.png"));
        mDataModels.add(new DataModel("Cupcake", "TelAviv Cab Station", getRandomEtaInMinutes(), "http://pngimg.com/uploads/taxi/taxi_PNG45.png"));
        mDataModels.add(new DataModel("Donut", "TelAviv Cab Station", getRandomEtaInMinutes(), "http://pngimg.com/uploads/taxi/taxi_PNG46.png"));
        mDataModels.add(new DataModel("Eclair", "TelAviv Cab Station", getRandomEtaInMinutes(), "http://pngimg.com/uploads/taxi/taxi_PNG47.png"));
        mDataModels.add(new DataModel("Froyo", "Haifa Cab Station", getRandomEtaInMinutes(), "http://pngimg.com/uploads/taxi/taxi_PNG48.png"));
        mDataModels.add(new DataModel("Gingerbread", "Haifa Cab Station", getRandomEtaInMinutes(), "http://pngimg.com/uploads/taxi/taxi_PNG49.png"));
        mDataModels.add(new DataModel("Honeycomb", "Haifa Cab Station", getRandomEtaInMinutes(), "http://pngimg.com/uploads/taxi/taxi_PNG50.png"));
        mDataModels.add(new DataModel("Ice Cream Sandwich", "Haifa Cab Station", getRandomEtaInMinutes(), "http://pngimg.com/uploads/taxi/taxi_PNG51.png"));
        mDataModels.add(new DataModel("Jelly Bean", "Hadera Cab Station", getRandomEtaInMinutes(), "http://pngimg.com/uploads/taxi/taxi_PNG52.png"));
        mDataModels.add(new DataModel("Kitkat", "Hadera Cab Station", getRandomEtaInMinutes(), "http://pngimg.com/uploads/taxi/taxi_PNG53.png"));
        mDataModels.add(new DataModel("Lollipop", "Hadera Cab Station", getRandomEtaInMinutes(), "http://pngimg.com/uploads/taxi/taxi_PNG54.png"));
        mDataModels.add(new DataModel("Marshmallow", "Hadera Cab Station", getRandomEtaInMinutes(), "http://pngimg.com/uploads/taxi/taxi_PNG55.png"));

        mAdapter = new CustomAdapter(mDataModels, getApplicationContext());

        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DataModel dataModel= mDataModels.get(position);

                Snackbar.make(view, "Cabs " +dataModel.getName() + " is Order! Thank you", Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();

            }
        });
        Collections.sort(mDataModels);
    }




    private void stopTimer(){
        if(mTimer1 != null){
            mTimer1.cancel();
            mTimer1.purge();
        }
    }

    private void startTimer(){
        mTimer1 = new Timer();
        mTt1 = new TimerTask() {
            public void run() {
                mTimerHandler.post(new Runnable() {
                    public void run(){
                        for(DataModel dataModel: mDataModels) {
                            dataModel.setEtaInMinutes(getRandomEtaInMinutes());
                        }
                        Collections.sort(mDataModels);
                        mAdapter.notifyDataSetChanged();
                    }
                });
            }
        };

        mTimer1.schedule(mTt1, 5000, 5000);
    }
}


