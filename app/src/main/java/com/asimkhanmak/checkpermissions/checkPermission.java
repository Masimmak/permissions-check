package com.asimkhanmak.checkpermissions;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;


public class checkPermission {

    String[] permissionSet;
    Context context;
    Activity activity;

    public checkPermission(Activity activity, Context context) {
        this.context = context;
        this.activity = activity;

    }


    public boolean ReadStorage(){

        if (Build.VERSION.SDK_INT >= 23) {
            permissionSet = new String[1];
            permissionSet[0] = android.Manifest.permission.READ_EXTERNAL_STORAGE;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                permissionSet[0] = android.Manifest.permission.READ_MEDIA_IMAGES;
            }
            if (activity.checkSelfPermission(permissionSet[0]) != PackageManager.PERMISSION_GRANTED) {
                activity.requestPermissions(permissionSet, 7);
                return false;
            }
        }
        return true;
    }

    public boolean WriteStorage(){

        if (Build.VERSION.SDK_INT >= 23) {
            permissionSet = new String[1];
            permissionSet[0] = android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                permissionSet[0] = android.Manifest.permission.ACCESS_MEDIA_LOCATION;
            }

            if (activity.checkSelfPermission(permissionSet[0]) != PackageManager.PERMISSION_GRANTED) {
                activity.requestPermissions(permissionSet, 7);
                return false;
            }

        }
        return true;
    }

    public boolean ReadContacts(){
        if (Build.VERSION.SDK_INT >= 23) {
            permissionSet = new String[1];
            permissionSet[0] = android.Manifest.permission.READ_CONTACTS;
            if (activity.checkSelfPermission(permissionSet[0]) != PackageManager.PERMISSION_GRANTED) {
                activity.requestPermissions(permissionSet, 7);
                return false;
            }
        }
        return true;
    }

    public boolean RecordAudio(){
        if (Build.VERSION.SDK_INT >= 23) {
            permissionSet = new String[1];
            permissionSet[0] = android.Manifest.permission.RECORD_AUDIO;
            if (activity.checkSelfPermission(permissionSet[0]) != PackageManager.PERMISSION_GRANTED) {
                activity.requestPermissions(permissionSet, 7);
                return false;
            }
        }
        return true;
    }


    public boolean checkAll(){

        if (Build.VERSION.SDK_INT >= 23) {
            permissionSet = new String[4];
            permissionSet[0] = android.Manifest.permission.READ_EXTERNAL_STORAGE;
            permissionSet[1] = android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
            permissionSet[2] = android.Manifest.permission.READ_CONTACTS;
            permissionSet[3] = android.Manifest.permission.RECORD_AUDIO;


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {

                permissionSet[1] = android.Manifest.permission.ACCESS_MEDIA_LOCATION;

            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){

                permissionSet[0] = android.Manifest.permission.READ_MEDIA_IMAGES;
                permissionSet[1] = android.Manifest.permission.ACCESS_MEDIA_LOCATION;
            }

            if (context.checkSelfPermission(permissionSet[0]) != PackageManager.PERMISSION_GRANTED
                    || context.checkSelfPermission(permissionSet[1]) != PackageManager.PERMISSION_GRANTED
                    || context.checkSelfPermission(permissionSet[2]) != PackageManager.PERMISSION_GRANTED
                    || context.checkSelfPermission(permissionSet[3]) != PackageManager.PERMISSION_GRANTED) {
                activity.requestPermissions(permissionSet, 7);
                return false;
            }

        }

        return true;
    }
}