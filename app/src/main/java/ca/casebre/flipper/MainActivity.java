package ca.casebre.flipper;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {


    private TextView txtInfo;
    private ListView listViewDevice;
    private Button btnSearch;
    private List<String> listDevices = new ArrayList<>();
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PresentationActivity.class);
                startActivity(i);
            }
        });

        //txtInfo = (TextView) findViewById(R.id.txtInfo);
        //listViewDevice = (ListView) findViewById(R.id.lstDevices);
        //btnSearch = (Button) findViewById(R.id.btnSearch);

        // https://developer.android.com/guide/components/processes-and-threads.html

        /*
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            // Device does not support Bluetooth
            txtInfo.setText("Fudeu");
        } else {
            txtInfo.setText("Blu Tuh!");
        }

        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, 100);
        }


        new Thread(new Runnable() {
            public void run() {

            }
        }).start();

        Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
        // If there are paired devices
        if (pairedDevices.size() > 0) {
            // Loop through paired devices
            for (BluetoothDevice device : pairedDevices) {
                // Add the name and address to an array adapter to show in a ListView
                //mArrayAdapter.add(device.getName() + "\n" + device.getAddress());
                Log.d("DEBUG ", device.getName());
                listDevices.add(device.getName());
            }
        }

        //mBluetoothAdapter.get

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listDevices);
        listViewDevice.setAdapter(adapter);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        */
    }



    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            // When discovery finds a device
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Get the BluetoothDevice object from the Intent
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                // Add the name and address to an array adapter to show in a ListView
                listDevices.add(device.getName() + "\n" + device.getAddress());
            }
        }
    };
}
