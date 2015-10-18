package net.iessanclemente.u4_coches;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FramentoDialogo extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
        adb.setCancelable(false);
        adb.setTitle("proba");
        final String[] arr = new String[]{
                "ListView", "Spiner"
        };

        adb.setSingleChoiceItems(arr, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    Intent envia = new Intent();
                    File f = getActivity().getExternalFilesDir(null);
                    File f2 = new File(f.getAbsolutePath(),"hola");
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f2)));

                        String s = null;
                        boolean flag = true;
                        StringBuffer sb = new StringBuffer();
                        while(flag){

                            s=br.readLine();
                            sb.append(s).append("\n");
                            if(s==null) {
                                flag = false;
                                continue;
                            }
                        };
                        Toast.makeText(getActivity(),sb.toString(),Toast.LENGTH_SHORT).show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (which == 1) {

                }
            }
        });
        return adb.create();
    }
}
